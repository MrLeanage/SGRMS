/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.presentation.userManagement;

import com.grms.data.model.Guideline;
import com.grms.data.model.User;
import com.grms.data.model.UserValidation;
import com.grms.logic.controller.GuidelineController;
import com.grms.logic.controller.StatisticController;
import com.grms.logic.controller.UserController;
import com.grms.logic.utility.Authentication;
import java.io.IOException;
import java.io.PrintWriter; 
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginControllerServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);
        try {
            String action = request.getServletPath();
            log("called from" + action);
            switch (action) {
                case "/Login":
                    loadLogin(request, response);
                    break;
                case "/Login-Validate":
                    userValidate(request, response);
                    break;
                case "/Student-Dashboard":
                    studentDashboard(request, response);
                    break;
                case "/Dashboard":
                    adminDashboard(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/Admin/login.jsp");
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log("Exception Occured" + ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void loadLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = new User();
        user.setuID("");
        user.setuPassword("");
        user.setuStatus("");
        request.getSession().removeAttribute("authUser");
        request.getSession().setAttribute("authUser",user);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    private void userValidate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        UserController userController = new UserController();
        User user = new User();
        user.setuID(request.getParameter("uEmpID"));
        user.setuPassword(request.getParameter("uPassword"));
        
        
        User validatedUser = userController.authenticateUserInfo(user);
        log("Exception Occured : "+user.getuID()+"\n");
        log("User Status : "+validatedUser.getuStatus()+"\n");
        if (validatedUser.getuStatus().equals("Active")) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("authUser", validatedUser);
            if (!validatedUser.getuType().equals("Student")) {
                response.sendRedirect(request.getContextPath() + "/Dashboard");
                
            } else {
                response.sendRedirect(request.getContextPath() + "/Student-Dashboard");
            }
        } else {
            validatedUser.setuID(user.getuID());
            validatedUser.setuPassword(user.getuPassword());
            request.getSession().setAttribute("authUser", validatedUser);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private void adminDashboard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        loadAllGuidelines(request, response);
    }

    private void studentDashboard(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/client/index.jsp").forward(request, response);
    }

    private void loadAllGuidelines(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        getAllGuidelines(request, response);

    }
    
    private void getAllGuidelines(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        
        ArrayList<Guideline> guidelineList = GuidelineController.getAllGuidelines();
        ArrayList<User> userList = new ArrayList();
        UserController userController = new UserController();
        userList = userController.loadAllStudentUsers();
        request.setAttribute("feedbackPerformanceList", StatisticController.getFeedbackPerformancePercentages());
        request.setAttribute("userList", userList);
        request.setAttribute("guidelineList", guidelineList);
         request.setAttribute("pendingCount", StatisticController.getTotalGrievanceCountByStatus("Pending"));
        request.setAttribute("processingCount", StatisticController.getTotalGrievanceCountByStatus("Processing"));
        request.setAttribute("FinishedCount", StatisticController.getTotalGrievanceCountByStatus("Finished"));
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);

    }
    private void resetSession(HttpServletRequest request,
            HttpServletResponse response) {

        session = request.getSession();
        session.setAttribute("actionStatus", "default");
        session.setAttribute("actionMsg", "default");
        request.setAttribute("validationMsg", new UserValidation());

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
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
