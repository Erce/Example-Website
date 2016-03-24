package newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ulakbim
 */
public class logout extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet logout</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet logout at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
                PrintWriter out = response.getWriter();
        
        try {
        
            HttpSession session = request.getSession(false);
            if (request.isRequestedSessionIdValid() && session != null) {
		session.invalidate();
            }
            
            Cookie[] cookies = request.getCookies();
            
            for (Cookie cookie : cookies) {
                String value = cookie.getValue();
                String name = cookie.getName();
		cookie.setMaxAge(0);
		cookie.setValue(null);
		cookie.setPath("/");               
                response.addCookie(cookie);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");    
            response.setContentType(("text/html"));
            rd.forward(request, response);
            
        }catch(Exception e) {
            out.println("logout catch");
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
        
        try {
        
            HttpSession session = request.getSession(false);
            if (request.isRequestedSessionIdValid() && session != null) {
		session.invalidate();
            }
            
            Cookie[] cookies = request.getCookies();
            
            for (Cookie cookie : cookies) {
                String value = cookie.getValue();
                String name = cookie.getName();
		cookie.setMaxAge(0);
		cookie.setValue(null);
		cookie.setPath("/");               
                response.addCookie(cookie);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");    
            response.setContentType(("text/html"));
            rd.forward(request, response);
            
        }catch(Exception e) {
            out.println("logout catch");
        }
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

}