package com.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerBean cbean = new CustomerBean();
		cbean.setUsrname(request.getParameter("userName"));
		cbean.setPasswd(request.getParameter("password"));
		cbean.setFirstname(request.getParameter("firstname"));
		cbean.setLastname(request.getParameter("lastname"));
		cbean.setAddress(request.getParameter("address"));
		cbean.setCity(request.getParameter("city"));
		cbean.setPostalcd(request.getParameter("postalCode"));
		
		CustomerDAO cdao = new CustomerDAO();
		try {
			cdao.addData(cbean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
