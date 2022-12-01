/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.presentation.guidelineManagement;

import com.grms.data.model.Guideline;
import com.grms.data.model.User;
import com.grms.data.model.UserValidation;
import com.grms.logic.controller.GuidelineController;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
public class GuidelineControllerServlet extends HttpServlet {

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
                case "/CurrentGuideline":
                    log("My Grievances");
                    loadCurrentGuideline(request, response);
                    break;
                case "/AllGuidelines":
                    loadAllGuidelines(request, response);
                    break;
                case "/ManageGuidelines":
                    loadManageGuidelines(request, response);
                    break;
                case "/AddGuideline":
                    addNewGuideline(request, response);
                    break;
                case "/DownloadGuideline":
                    downloadGuideline(request, response, "specific");
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

 

    private void loadAllGuidelines(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        getAllGuidelines(request, response);

    }
    
    private void getAllGuidelines(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        
        ArrayList<Guideline> guidelineList = GuidelineController.getAllGuidelines();
        request.setAttribute("guidelineList", guidelineList);
        request.getRequestDispatcher("/admin/guidelineManagement/all_Guidelines.jsp").forward(request, response);

    }

    private void getGuidelines(HttpServletRequest request,
            HttpServletResponse response ) throws IOException, ServletException {
        
        ArrayList<Guideline> guidelineList = GuidelineController.getAllGuidelines();
        request.setAttribute("guidelineList", guidelineList);
        request.getRequestDispatcher("/admin/guidelineManagement/manage_Guidelines.jsp").forward(request, response);

    }
    
    

    

    private void loadManageGuidelines(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        getGuidelines(request, response);

    }
    
    private void addNewGuideline(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        
        
        Part filePart = request.getPart("gLFile");
        
        InputStream inputStream = filePart.getInputStream();
        Guideline guideline = new Guideline();
        
        guideline.setgLTitle(request.getParameter("gLTitle"));
        guideline.setgLDescription(request.getParameter("gLDescription"));
        guideline.setgLFile(inputStream);
        guideline.setgLUploadDate(LocalDate.now().toString());
        guideline.setgLModifyDate(LocalDate.now().toString());
        
      
        if (GuidelineController.addNewGuideline(guideline)) {
            session.setAttribute("actionStatus", "success");
            session.setAttribute("actionMsg", "New Guideline Added Successfully!");
            getGuidelines(request, response);
        } else {
            session.setAttribute("actionStatus", "failed");
            session.setAttribute("actionMsg", "Failed to Add New Guideline");
            request.setAttribute("grievanceData", guideline);
            request.getRequestDispatcher("/admin/guidelineManagement/manage_Guidelines.jsp").forward(request, response);
        }

//        request.setAttribute("userID", user.getuEmpID());
//        request.getRequestDispatcher("/client/grievanceManagement/createGrievance.jsp").forward(request, response);

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
                getGuidelines(request, response);
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