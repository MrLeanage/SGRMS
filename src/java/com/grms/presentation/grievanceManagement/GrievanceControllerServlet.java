/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.presentation.grievanceManagement;

import com.grms.data.constant.Constant;
import com.grms.presentation.guidelineManagement.*;
import com.grms.data.model.ChatMessage;
import com.grms.data.model.Grievance;
import com.grms.data.model.User;
import com.grms.data.model.UserValidation;
import com.grms.logic.controller.GrievanceController;
import com.grms.logic.utility.UtilityMethod;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GrievanceControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public HttpSession session;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);
        try {
            String action = request.getServletPath();
            log("called Grievance Servlet from" + action);
            switch (action) {
                //Admin Cases    
                case "/MyGrievances":
                    log("My Grievances");
                    loadStudentGrievances(request, response);
                    break;
                case "/CreateNewGrievance":
                    loadCreateNewGrievance(request, response);
                    break;
                case "/PostNewGrievance":
                    loadPostNewGrievance(request, response);
                    break;
                case "/PendingGrievance":
                    log("My Grievances");
                    loadManagerL3PendingGrievances(request, response);
                    break;
                case "/AcceptGrievance":
                    acceptManagerL3Grievance(request, response);
                    break;
                case "/ProcessingGrievance":
                    loadProcessingGrievance(request, response);
                    break;
                case "/GrievanceChat":
                    loadGrievanceChat(request, response);
                    break;
                case "/AssignChatMember":
                    assignChatMember(request, response);
                    break;
                case "/GrievanceChatAction":
                    manageGrievanceChatActions(request, response);
                    break;
                case "/FinishedGrievance":
                    loadFinishedGrievance(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/admin/userManagement/add-user-account.jsp");
                    break;
            }
        } catch (Exception ex) {
            log("Exception Occured" + ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    //Administrator Management

    //Employee management 
    private void loadCreateNewGrievance(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/client/grievanceManagement/createGrievance.jsp").forward(request, response);
    }

    private void loadPostNewGrievance(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        log("Hello Called");
        User user = (User) session.getAttribute("authUser");
        log("User :" + user.getuID());
        Grievance grievance = new Grievance();
        grievance.setgUID(user.getuID());
        grievance.setgType(request.getParameter("gType"));
        grievance.setgTitle(request.getParameter("gTitle"));
        grievance.setgDescription(request.getParameter("gDescription"));
        grievance.setgStartDate(String.valueOf(LocalDate.now()));
        grievance.setgStartTime(UtilityMethod.currentTime());

        if (GrievanceController.postNewGrievance(grievance)) {
            session.setAttribute("actionStatus", "success");
            session.setAttribute("actionMsg", "Your Grievaance Posted Successfully!");
            request.getRequestDispatcher("/client/index.jsp").forward(request, response);
        } else {
            session.setAttribute("actionStatus", "failed");
            session.setAttribute("actionMsg", "Failed to Post Your Grievance");
            request.setAttribute("grievanceData", grievance);
            request.getRequestDispatcher("/client/grievanceManagement/createGrievance.jsp").forward(request, response);
        }

        request.setAttribute("userID", user.getuID());
        request.getRequestDispatcher("/client/grievanceManagement/createGrievance.jsp").forward(request, response);

    }

    private void loadStudentGrievances(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        
        User user = (User) session.getAttribute("authUser");

        ArrayList<Grievance> grievanceList = GrievanceController.getStudentGrievanceList(user.getuID());
        Collections.reverse(grievanceList);
        request.setAttribute("grievanceList", grievanceList);
        request.getRequestDispatcher("/client/grievanceManagement/studentGrievance.jsp").forward(request, response);

    }

    private void loadManagerL3PendingGrievances(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        getManagerL3PendingGrievances(request, response);

    }

    private void getManagerL3PendingGrievances(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        User user = (User) session.getAttribute("authUser");
        ArrayList<Grievance> grievanceList = GrievanceController.getManagerL3GrievanceList(user.getuID());
        request.setAttribute("grievanceList", grievanceList);
        request.getRequestDispatcher("/admin/grievanceManagement/managerL3Grievance.jsp").forward(request, response);

    }

    private void acceptManagerL3Grievance(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        String gID = (String) request.getParameter("gID");
        log("Grievance ID :" + gID);
        if (GrievanceController.acceptManagerL3Grievance(gID)) {
            if ((GrievanceController.registerGrievanceUserChat(gID))) {
                session.setAttribute("actionStatus", "success");
                session.setAttribute("actionMsg", "Grievance Accepted Successfully!");
                getManagerL3PendingGrievances(request, response);
            } else {
                session.setAttribute("actionStatus", "failed");
                session.setAttribute("actionMsg", "Error Occured! Failed to Assign Manager to Grievance");
                getManagerL3PendingGrievances(request, response);
            }

        } else {
            session.setAttribute("actionStatus", "failed");
            session.setAttribute("actionMsg", "Error Occured! Failed to Accept Grievance");
            getManagerL3PendingGrievances(request, response);
        }

    }

    private void loadProcessingGrievance(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        getProcessingGrievance(request, response);

    }

    private void getProcessingGrievance(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        User user = (User) session.getAttribute("authUser");
        ArrayList<Grievance> grievanceList = GrievanceController.getProcessingManagerGrievanceList(user.getuID(), "Processing");
        request.setAttribute("grievanceList", grievanceList);
        request.getRequestDispatcher("/admin/grievanceManagement/managerProcessingGrievance.jsp").forward(request, response);

    }

    private void loadGrievanceChat(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        
        String gStatus = request.getParameter("gStatus");
        String gID = request.getParameter("gID");
        refreshGrievanceChat(request, response, gID, gStatus);
    }

    private void refreshGrievanceChat(HttpServletRequest request,
            HttpServletResponse response,
            String grievanceID, String gStatus) throws IOException, ServletException {
        

        session.setAttribute("chatTokenID", grievanceID);
        User user = (User) session.getAttribute("authUser");

        Grievance specificGrievanceData = GrievanceController.getSpecificGrievance(grievanceID);
        ArrayList<ChatMessage> chatMessageList = GrievanceController.loadGroupChatMessages(grievanceID);
        ArrayList<User> chatParticipants = GrievanceController.loadGroupChatParticipants(grievanceID);

        request.setAttribute("chatData", chatMessageList);
        request.setAttribute("specificGrievanceData", specificGrievanceData);
        request.setAttribute("chatParticipants", chatParticipants);

        log("Chat data start count:" + chatMessageList.size());
        for (ChatMessage chatMessage : chatMessageList) {
            log("Chat Data" + chatMessage.getcMsgSenderID());
        }
        log("Chat data End");

        log("User from chat:" + user.getuID());
        if (user.getuType().equals(Constant.USER_TYPE_STUDENT)) {
            resetSession(request, response);
            request.getRequestDispatcher("/client/grievanceManagement/message.jsp").forward(request, response);
        } else {
            ArrayList<Grievance> grievanceList = GrievanceController.getProcessingManagerGrievanceList(user.getuID(), gStatus);
            request.setAttribute("grievanceList", grievanceList);
            request.getRequestDispatcher("/admin/grievanceManagement/message.jsp").forward(request, response);
        }

    }

    private void assignChatMember(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        String grievanceID = request.getParameter("grievanceID");
        String gStatus = request.getParameter("gStatus");
        String type = null;
        if (request.getParameter("type").equals("director")) {
            type = Constant.USER_TYPE_ADMINISTRATOR;
        } else if (request.getParameter("type").equals("l1Manager")) {
            type = Constant.USER_TYPE_MANAGER_LEVEL_1;
        } else if (request.getParameter("type").equals("l2Manager")) {
            type = Constant.USER_TYPE_MANAGER_LEVEL_2;
        } else if (request.getParameter("type").equals("l3Manager")) {
            type = Constant.USER_TYPE_MANAGER_LEVEL_3;
        }

        if (GrievanceController.assignChatMember(grievanceID, type)) {
            session.setAttribute("actionStatus", "success");
            session.setAttribute("actionMsg", type + " for Grievance " + grievanceID + " Assigned Successfully!");
            refreshGrievanceChat(request, response, grievanceID, gStatus);
        } else {
            session.setAttribute("actionStatus", "failed");
            session.setAttribute("actionMsg", "Failed to assign " + type + " to " + grievanceID + " Grievance");
            refreshGrievanceChat(request, response, grievanceID, gStatus);
        }
    }

    private void manageGrievanceChatActions(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        String grievanceID = request.getParameter("grievanceID");
        String gStatus = request.getParameter("gStatus");
        String action = null;
        if (request.getParameter("action").equals("start")) {
            action = "Processing";
        } else if (request.getParameter("action").equals("finish")) {
            action = "Finished";
        }
        
        if(GrievanceController.updateGrievanceStatus(grievanceID, action)){
            session.setAttribute("actionStatus", "success");
            session.setAttribute("actionMsg", "The Grievance "+grievanceID + "Marked as " + action + " Successfully!");
             refreshGrievanceChat(request, response, grievanceID, gStatus);
        }else{
            session.setAttribute("actionStatus", "failed");
            session.setAttribute("actionMsg", "Failed to mark as " + action + " the Grievance " + grievanceID);
             refreshGrievanceChat(request, response, grievanceID, gStatus);
        }

    }

    private void loadFinishedGrievance(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        getFinishedGrievance(request, response);

    }
    private void getFinishedGrievance(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        User user = (User) session.getAttribute("authUser");
        ArrayList<Grievance> grievanceList = GrievanceController.getProcessingManagerGrievanceList(user.getuID(), "Finished");
        request.setAttribute("grievanceList", grievanceList);
        request.getRequestDispatcher("/admin/grievanceManagement/managerFinishedGrievance.jsp").forward(request, response);

    }
    private void resetSession(HttpServletRequest request,
            HttpServletResponse response) {

        session = request.getSession();
        session.setAttribute("actionStatus", "default");
        session.setAttribute("actionMsg", "default");
        request.setAttribute("validationMsg", new UserValidation());

    }

}
