package com.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerLoginservlet
 */
@WebServlet("/CustomerLoginservlet")
public class CustomerLoginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TO-DO
		// redirect to home 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDAO cdao = new CustomerDAO();
		HttpSession session = request.getSession(true); 
		
		try {
			     // getParameter from database
			if(cdao.validateUser(request.getParameter("userName"), request.getParameter("password"))) {
				// change loginStatus  session variable to true
				session.setAttribute("loginStatus", Boolean.valueOf(true));
				session.setAttribute("userName", request.getParameter("userName"));
				
				// redirect to SelectOrderShoeType.jsp
				response.sendRedirect("/Park_Jungah_MVCApp/SelectShoeType.jsp");
				
			} else {
				// change loginStatus  session variable to false
				session.setAttribute("loginStatus", Boolean.valueOf(false));
				
				// redirect to Home
				response.sendRedirect("/Park_Jungah_MVCApp/HomePage.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
