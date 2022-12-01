/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grms.presentation.statisticManagement;


import com.grms.data.local.LocalData;
import com.grms.data.model.FeedbackPerformance;
import com.grms.data.model.Guideline;
import com.grms.data.model.Performance;
import com.grms.data.model.UserValidation;
import com.grms.logic.controller.GuidelineController;
import com.grms.logic.controller.StatisticController;
import com.grms.logic.utility.UtilityMethod;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@MultipartConfig(maxFileSize = 16177215)
public class StatisticControllerServlet extends HttpServlet {

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
                case "/Statistics":
                    viewStatistics(request, response);
                    break;
                case "/ManagerPerformance":
                    getManagerPerformance(request, response);
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
    private void getManagerPerformance(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        downloadManagerPerformance(request, response, "default");

    }

    private void downloadManagerPerformance(HttpServletRequest request,
            HttpServletResponse response,
            String type) throws IOException, ServletException {

        if (true) {
            JasperReport jasperReport = null;
            JasperDesign jasperDesign = null;
            ArrayList<Performance> performanceList = new ArrayList<>();
            performanceList = StatisticController.getPerformanceData("All");
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(performanceList);
            
            Performance bestPerformance = new Performance();
            bestPerformance = performanceList.get(0);
            Map parameter = new HashMap();
            String path = getServletContext().getRealPath("/WEB-INF/resources/");
            parameter.put("imageName", "\\logo-Without-Text.png");
            parameter.put("context",  path);
            parameter.put("performanceData", jrBeanCollectionDataSource);
            parameter.put("reportHeader", LocalData.MONTHLY_MANAGER_PERFORMANCE_HEADER.toUpperCase());
            parameter.put("reportDetail", LocalData.MONTHLY_MANAGER_PERFORMANCE_DETAIL);
            parameter.put("reportSummary", LocalData.MONTHLY_MANAGER_PERFORMANCE_SUMMARY);
            parameter.put("bestPerformer", bestPerformance.getEmployeeName() + "(" + bestPerformance.getEmployeeID() + ") with " + (bestPerformance.getFinishedCount() + bestPerformance.getProcessingCount()) + " Total Handlings") ;
            parameter.put("period", UtilityMethod.getYearMonth(String.valueOf(LocalDate.now())).toUpperCase());
            

            log(path);
            try {
                jasperDesign = JRXmlLoader.load(path + "/monthly-report.jrxml");
                jasperReport = JasperCompileManager.compileReport(jasperDesign);
                byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, parameter, new JREmptyDataSource());
                OutputStream outStream = response.getOutputStream();
                response.setContentType("application/pdf");
                response.setContentLength(byteStream.length);
                outStream.write(byteStream, 0, byteStream.length);

                outStream.close();
            } catch (JRException ex) {
                Logger.getLogger(StatisticControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            session.setAttribute("actionStatus", "failed");
            session.setAttribute("actionMsg", "Failed to Download the Manager Performance Report");
            if (type.equals("specific")) {
                loadStatistics(request, response);
            } else {
                request.getRequestDispatcher("/Dashboard").forward(request, response);
            }
        }

    }

    private void viewStatistics(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        resetSession(request, response);
        loadStatistics(request, response);

    }

    private void loadStatistics(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        ArrayList<Guideline> guidelineList = GuidelineController.getAllGuidelines();
        request.setAttribute("feedbackPerformanceList", StatisticController.getFeedbackPerformancePercentages());
        request.setAttribute("managerPerformanceList", StatisticController.getPerformanceData("All"));
        request.setAttribute("guidelineList", guidelineList);
        request.setAttribute("pendingCount", StatisticController.getTotalGrievanceCountByStatus("Pending"));
        request.setAttribute("processingCount", StatisticController.getTotalGrievanceCountByStatus("Processing"));
        request.setAttribute("FinishedCount", StatisticController.getTotalGrievanceCountByStatus("Finished"));
        request.getRequestDispatcher("/admin/statisticManagement/statistics.jsp").forward(request, response);

    }

    

    private void resetSession(HttpServletRequest request,
            HttpServletResponse response) {

        session = request.getSession();
        session.setAttribute("actionStatus", "default");
        session.setAttribute("actionMsg", "default");
        request.setAttribute("validationMsg", new UserValidation());

    }

}
