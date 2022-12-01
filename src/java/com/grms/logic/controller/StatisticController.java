/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.logic.controller;

import com.grms.data.model.Feedback;
import com.grms.data.model.FeedbackPerformance;
import com.grms.data.model.Grievance;
import com.grms.data.model.Performance;
import com.grms.data.model.User;
import com.grms.data.services.FeedbackService;
import com.grms.data.services.GrievanceService;
import com.grms.logic.utility.UtilityMethod;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparing;

public class StatisticController {

    public static ArrayList<Performance> getPerformanceData(String period) {
        ArrayList<Performance> performanceData = new ArrayList<>();
        UserController userController = new UserController();

        ArrayList<User> managerList = userController.loadAllManagerUsers();
        for (User user : managerList) {

            Performance performanceStat = getUserPerformance(user.getuID(), "All");

            Performance performance = new Performance();
            performance.setEmployeeID(user.getuID());
            performance.setEmployeeName(user.getuFName() + " " + user.getuLName());
            performance.setEmployeePosition(user.getuType());
            performance.setPendingCount(performanceStat.getPendingCount());
            performance.setProcessingCount(performanceStat.getProcessingCount());
            performance.setFinishedCount(performanceStat.getFinishedCount());
            performanceData.add(performance);
        }
        Collections.sort(performanceData, comparing(Performance::getRank).reversed());
        return performanceData;
    }

    public static ArrayList<FeedbackPerformance> getFeedbackAnalysis() {
        //retrieving data
        FeedbackService feedbackService = new FeedbackService();
        GrievanceService grievanceService = new GrievanceService();

        ArrayList<Feedback> feedbackList = new ArrayList<>();
        feedbackList = feedbackService.loadAllFeedbacks();

        //removing Grievance ID duplicates in Feedback 
        ArrayList<String> idList = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            idList.add(feedback.getfGID());
        }

        //retrieving all grievances under feedbacks
        ArrayList<Grievance> grievanceList = new ArrayList<>();
        for (String id : UtilityMethod.removeStringDuplicates(idList)) {
            Grievance grievance = new Grievance();
            grievance = grievanceService.loadSpecificGrievance(id);
            grievanceList.add(grievance);
        }

        //setting feedbacks under grievances
        for (Grievance grievance : grievanceList) {
            for (Feedback feedback : feedbackList) {
                if (grievance.getgID().equals(feedback.getfGID())) {
                    ArrayList<Feedback> oldFeedbackList = new ArrayList<>();
                    oldFeedbackList = grievance.getFeedbackList();
                    oldFeedbackList.add(feedback);
                    grievance.setFeedbackList(oldFeedbackList);
                }
            }
        }
        return null;
    }

    public static ArrayList<FeedbackPerformance> getFeedbackPerformance() {
        //retrieving data
        FeedbackService feedbackService = new FeedbackService();

        ArrayList<Feedback> feedbackList = new ArrayList<>();
        feedbackList = feedbackService.loadAllFeedbacks();

        ArrayList<String> feedbackTypes = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            feedbackTypes.add(feedback.getfTitle());
        }

        //setting counts and category to feedback performance list
        ArrayList<FeedbackPerformance> feedbackPerformanceList = new ArrayList<>();
        for (String type : UtilityMethod.removeStringDuplicates(feedbackTypes)) {
            FeedbackPerformance feedbackPerformance = new FeedbackPerformance();
            for (Feedback feedback : feedbackList) {
                if (feedback.getfTitle().equals(type)) {
                    feedbackPerformance.setCategory(type);
                    feedbackPerformance.setCount(feedbackPerformance.getCount() + 1);
                    
                }
            }
            feedbackPerformanceList.add(feedbackPerformance);

        }

        return feedbackPerformanceList;
    }

    public static ArrayList<FeedbackPerformance> getFeedbackPerformancePercentages() {
        ArrayList<FeedbackPerformance> feedbackPerformanceList = getFeedbackPerformance();
        ArrayList<FeedbackPerformance> feedbackPerformancePercentageList = new ArrayList<>();

        int total = 0;
        
        //finding total
        for (FeedbackPerformance feedbackPerformance : getFeedbackPerformance()) {
            total = total + feedbackPerformance.getCount();
        }
        
        //getting percentage
        if (total != 0) {
            for (FeedbackPerformance feedbackPerformance : getFeedbackPerformance()) {
                double percentage = 0.0;
                if(feedbackPerformance.getCount() > 0){
                   percentage = UtilityMethod.formatNumberToTwoDecimalPlaces(((double) feedbackPerformance.getCount()/total) * 100);
                    
                }
                
                
                feedbackPerformancePercentageList.add(new FeedbackPerformance(feedbackPerformance.getCategory(), percentage));
            }
        }
        return feedbackPerformancePercentageList;
    }
    
    public static int getTotalGrievanceCountByStatus(String status){
        GrievanceService grievanceService = new GrievanceService();
        return grievanceService.getGrievanceListByStatus(status).size();
    }

    private static Performance getUserPerformance(String userID,
            String type) {
        Performance performance = new Performance();
        ArrayList<Grievance> grievanceList = GrievanceController.getProcessingManagerGrievanceList(userID, type);

        for (Grievance grievance : grievanceList) {
            if (grievance.getgStatus().equals("Pending")) {
                performance.setPendingCount(performance.getPendingCount() + 1);
            }
            if (grievance.getgStatus().equals("Processing")) {
                performance.setProcessingCount(performance.getProcessingCount() + 1);
            }
            if (grievance.getgStatus().equals("Finished")) {
                performance.setFinishedCount(performance.getFinishedCount() + 1);
            }
        }
        return performance;
    }

}
