 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.presentation.feedbackManagement;

import com.grms.presentation.guidelineManagement.*;
import com.grms.data.model.ChatMessage;
import com.grms.data.model.Feedback;
import com.grms.data.model.Grievance;
import com.grms.data.model.Guideline;
import com.grms.data.model.User;
import com.grms.data.model.UserValidation;
import com.grms.logic.controller.FeedbackController;
import com.grms.logic.controller.GrievanceController;
import com.grms.logic.controller.GuidelineController;
import com.grms.logic.utility.UtilityMethod;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
public class FeedbackControllerServlet extends HttpServlet {

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
                case "/Feedback":
                    loadGiveFeedback(request, response);
                    break;
                case "/ViewGivenFeedback":
                    viewGivenFeedback(request, response);
                    break;
                case "/SubmitFeedback":
                    submitFeedback(request, response);
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
   

    private void loadCurrentGuideline(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        downloadGuideline(request, response, "default");
//      request.getRequestDispatcher("/Dashboard").forward(request, response);

    }

 

    private void loadGiveFeedback(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        Grievance grievance = new Grievance();
        
        grievance.setgID(request.getParameter("gID"));
        grievance.setgTitle(request.getParameter("gTitle"));
        request.setAttribute("grievance", grievance);
        request.getRequestDispatcher("/client/feedbackManagement/createFeedback.jsp").forward(request, response);

    }
    private void viewGivenFeedback(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        getGivenFeedbacks(request, response);

    }
    private void getGivenFeedbacks(HttpServletRequest request,
            HttpServletResponse response ) throws IOException, ServletException {
        User user = (User) session.getAttribute("authUser");
        ArrayList<Feedback> feedbackList = FeedbackController.getManager3Feedbacks(user.getuID());
        request.setAttribute("feedbackList", feedbackList);
        request.getRequestDispatcher("/admin/feedbackManagement/managerFeeback.jsp").forward(request, response);

    }
    
    private void getAllGuidelines(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        
        ArrayList<Guideline> guidelineList = GuidelineController.getAllGuidelines();
        request.setAttribute("guidelineList", guidelineList);
        request.getRequestDispatcher("/admin/guidelineManagement/all_Guidelines.jsp").forward(request, response);

    }
    
    private void submitFeedback(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        
        
       Feedback feedback = new Feedback();
        
        feedback.setfTitle(request.getParameter("fTitle"));
        feedback.setfNote(request.getParameter("fNote"));
        feedback.setfGID(request.getParameter("gID"));
        feedback.setfDate(LocalDate.now().toString());
        feedback.setfTime(UtilityMethod.currentTime());
        
      
        if (FeedbackController.giveFeedback(feedback)) {
            session.setAttribute("actionStatus", "success");
            session.setAttribute("actionMsg", "Your Feedback Submitted Successfully!");
            refreshGrievanceChat(request, response, feedback.getfGID(), "Finished");
        } else {
            session.setAttribute("actionStatus", "failed");
            session.setAttribute("actionMsg", "Failed to Your Feedback, Try Again");
            request.setAttribute("feedbackData", feedback);
            request.getRequestDispatcher("/client/feedbackManagement/createFeedback.jsp").forward(request, response);
        }

//        request.setAttribute("userID", user.getuEmpID());
//        request.getRequestDispatcher("/client/grievanceManagement/createGrievance.jsp").forward(request, response);

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
        if (user.getuType().equals("Student")) {
            request.getRequestDispatcher("/client/grievanceManagement/message.jsp").forward(request, response);
        } else {
            ArrayList<Grievance> grievanceList = GrievanceController.getProcessingManagerGrievanceList(user.getuID(), gStatus);
            request.setAttribute("grievanceList", grievanceList);
            request.getRequestDispatcher("/admin/grievanceManagement/message.jsp").forward(request, response);
        }
    }
    
    private void downloadGuideline(HttpServletRequest request,
            HttpServletResponse response, String type) throws IOException, ServletException {
        
        
        // get upload id from URL's parameters
        
        
        // size of byte buffer to send file
        final int BUFFER_SIZE = 4096; 
        
        Guideline guideline = new Guideline();
        if(type.equals("specific")){
//            guideline = GuidelineController.getLatestGuideline();
            int gLVersionID = Integer.parseInt(request.getParameter("gLVersionID"));
            guideline = GuidelineController.getSpecificGuideline(gLVersionID);
        }else{
            guideline = GuidelineController.getLatestGuideline();
        }
        log("data out : "+guideline.getgLTitle());
        
        log("Excuted else of download failure : "+ guideline.getgLVersionID());
        
        if(guideline.getgLVersionID() != null){
            int fileLength = guideline.getgLFile().available();
        
        ServletContext context = request.getServletContext();
        
        // sets MIME type for the file download
        String fileName = guideline.getgLTitle() + guideline.getgLVersionID();
        String mimeType =  URLConnection.guessContentTypeFromStream(guideline.getgLFile());
         log("Content type 1 : "+context.getMimeType(fileName+".pdf"));
            if (mimeType == null) {        
                mimeType = "application/PDF";
            }  
            log("Content type 2 : "+mimeType);
            // set content properties and header attributes for the response
                response.setContentType(mimeType);
                response.setContentLength(fileLength);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                response.setHeader(headerKey, headerValue);
 
                // writes the file to the client
                OutputStream outStream = response.getOutputStream();
                 
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                 
                while ((bytesRead = guideline.getgLFile().read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
                 
                guideline.getgLFile().close();
                outStream.close();    
        }else {
            session.setAttribute("actionStatus", "failed");
            session.setAttribute("actionMsg", "Failed to Download the Guideline Document");
            if(type.equals("specific")){
                getGivenFeedbacks(request, response);
            }else{
                request.getRequestDispatcher("/Dashboard").forward(request, response);
            }
        }
        
    }
    private void getGuideline(HttpServletRequest request,
            HttpServletResponse response, int gLVersionID)throws IOException, ServletException {
        
        
    }
    
    private void resetSession(HttpServletRequest request,
            HttpServletResponse response) {

        session = request.getSession();
        session.setAttribute("actionStatus", "default");
        session.setAttribute("actionMsg", "default");
        request.setAttribute("validationMsg", new UserValidation());

    }

}
