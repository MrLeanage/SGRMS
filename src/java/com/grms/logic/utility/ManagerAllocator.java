/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.logic.utility;

import com.grms.data.model.Grievance;
import com.grms.data.model.GrievanceManagerStatistics;
import com.grms.data.model.User;
import com.grms.data.services.GrievanceService;
import com.grms.data.services.UserService;
import java.util.ArrayList;

public class ManagerAllocator {

    private static ArrayList<GrievanceManagerStatistics> getMangerGrievanceStat() {
        ArrayList<GrievanceManagerStatistics> managerStatList = new ArrayList<>();

        GrievanceService grievanceService = new GrievanceService();
        ArrayList<Grievance> grievanceList = grievanceService.getAllGrievanceList();

        for (Grievance grievance : grievanceList) {
            GrievanceManagerStatistics grievanceManagerStatistics = new GrievanceManagerStatistics();
            ArrayList<String> userArrayList = new ArrayList<String>();
            managerStatList.forEach((managerData) -> {
                userArrayList.add(managerData.getgMID());
            });
            if (!userArrayList.contains(grievance.getgL3Manager())) {
                grievanceManagerStatistics.setgMID(grievance.getgL3Manager());
                if (grievance.getgStatus().equals("Pending")) {
                    grievanceManagerStatistics.setgMPendingCount(grievanceManagerStatistics.getgMPendingCount() + 1);
                } else if (grievance.getgStatus().equals("Processing")) {
                    grievanceManagerStatistics.setgMProcessingCount(grievanceManagerStatistics.getgMProcessingCount() + 1);
                } else if (grievance.getgStatus().equals("Finished")) {
                    grievanceManagerStatistics.setgMFinishedCount(grievanceManagerStatistics.getgMFinishedCount() + 1);
                }
                managerStatList.add(grievanceManagerStatistics);
            } else {
                for (int i = 0; i < managerStatList.size(); i++) {
                    if (managerStatList.get(i).getgMID().equals(grievance.getgL3Manager())) {
                        if (grievance.getgStatus().equals("Pending")) {
                            managerStatList.get(i).setgMPendingCount(managerStatList.get(i).getgMPendingCount() + 1);
                        } else if (grievance.getgStatus().equals("Processing")) {
                            managerStatList.get(i).setgMProcessingCount(managerStatList.get(i).getgMProcessingCount() + 1);
                        } else if (grievance.getgStatus().equals("Finished")) {
                            managerStatList.get(i).setgMFinishedCount(managerStatList.get(i).getgMFinishedCount() + 1);
                        }
                    }
                }
            }
        }
        return managerStatList;
    }

    /**
     * gives free level 3 manager
     * @return level 3 manager
     */
    public static String getFreeGrievanceManager(String specialization) {
        UserService userService = new UserService();
        ArrayList<User> userArrayList = userService.loadAllUser();
        String freeManagerID = null;
        boolean availability = true;

        ArrayList<String> l3Managers = new ArrayList();
        ArrayList<String> l3GrievanceManagers = new ArrayList();
        for (GrievanceManagerStatistics grievanceManagerStatistics : getMangerGrievanceStat()) {
            l3GrievanceManagers.add(grievanceManagerStatistics.getgMID());
        }

        for (User user : userArrayList) {
            if (user.getuType().equals("Manager - Level 3") && user.getuSpecialization().equals(specialization)) {
                l3Managers.add(user.getuID());
            }
        }
        for (String userID : l3Managers) {
            if (!l3GrievanceManagers.contains(userID)) {
                freeManagerID = userID;
                availability = false;
                break;
            }
        }

        if (availability) {
            GrievanceManagerStatistics grievanceManagerStat = getMangerGrievanceStat().get(0);
            int processCount = grievanceManagerStat.getgMPendingCount() + grievanceManagerStat.getgMProcessingCount();

            for (int i = 1; i < getMangerGrievanceStat().size(); i++) {
                int pendingCount = getMangerGrievanceStat().get(i).getgMPendingCount();
                int processingCount = getMangerGrievanceStat().get(i).getgMProcessingCount();

                if (pendingCount + processingCount < processCount) {
                    grievanceManagerStat = getMangerGrievanceStat().get(i);
                    processCount = pendingCount + processingCount;
                }
            }
            freeManagerID = grievanceManagerStat.getgMID();
        }
        return freeManagerID;

    }
    public static String getFreeHighLevelManager(String grivanceID, String type, String specialization){
        GrievanceService grievanceService = new GrievanceService();
        UserService userService = new UserService();
        ArrayList<GrievanceManagerStatistics> grievanceManagerStatisticsList  = new ArrayList();
        ArrayList<String> processingGrievanceChatUsers = new ArrayList<>();
        
        //getting requested grievance's Managers
        ArrayList<User> existingGrievanceManagers = grievanceService.getGrievanceChatParticipants(grivanceID);
       
        //getting all Processing Grievances
        ArrayList<Grievance> processingGrievances = grievanceService.getGrievanceListByStatus("Processing");
        for(Grievance grievance :processingGrievances){
          for(User user : grievanceService.getGrievanceChatParticipants(grievance.getgID())){
              if(user.getuType().equals(type) && user.getuSpecialization().equals(specialization)){
                  processingGrievanceChatUsers.add(user.getuID());
              }
          }
        }
        
        
        
        //getting all Active users by requested Position and setting GrievanceStatistics to Zero
        for(User user :userService.loadAllUserByPosition(type, "Active")){
            if(user.getuSpecialization().equals(specialization))
                grievanceManagerStatisticsList.add(new GrievanceManagerStatistics(user.getuID(), 0, 0, 0, 0) );
            
        }
        
        // Updating GrievanceStatistics with their processing records
        for(int i = 0; i < grievanceManagerStatisticsList.size(); i++){
            for(String userID :processingGrievanceChatUsers){
                if(userID.equals(grievanceManagerStatisticsList.get(i).getgMID())){
                    grievanceManagerStatisticsList.get(i).setgMProcessingCount(grievanceManagerStatisticsList.get(i).getgMProcessingCount() + 1);
                }
            }
        }
        
        //removing current users on the list
        for(User user : existingGrievanceManagers){
            processingGrievanceChatUsers.removeIf(element -> element.equals(user.getuID()));
        }
        
        //setting the free User by Lowest Process Count
        GrievanceManagerStatistics freeGrievanceManagerStatistics = new GrievanceManagerStatistics();
        for(GrievanceManagerStatistics GrievanceManagerStatisticData :grievanceManagerStatisticsList){
            if(GrievanceManagerStatisticData.getgMProcessingCount() == 0){
                freeGrievanceManagerStatistics.setgMID(GrievanceManagerStatisticData.getgMID());
                freeGrievanceManagerStatistics.setgMProcessingCount(0);
                break;
            }else if(freeGrievanceManagerStatistics.getgMID() == null){
                freeGrievanceManagerStatistics.setgMID(GrievanceManagerStatisticData.getgMID());
                freeGrievanceManagerStatistics.setgMProcessingCount(GrievanceManagerStatisticData.getgMProcessingCount());
            }else if(freeGrievanceManagerStatistics.getgMProcessingCount() > GrievanceManagerStatisticData.getgMProcessingCount()){
                freeGrievanceManagerStatistics = GrievanceManagerStatisticData;
            }
        }
        
        
        
        return freeGrievanceManagerStatistics.getgMID();
    }

}
