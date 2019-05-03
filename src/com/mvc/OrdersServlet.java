package com.mvc;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/Park_Jungah_MVCApp/HomePage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		String orderIds[] = request.getParameterValues("orderIds[]");
		
		OrdersDAO orderDao = new OrdersDAO();
		
		System.out.println(operation);
		System.out.println(Arrays.toString(orderIds));
		
		if("confirmOrders".equalsIgnoreCase(operation)) {
			try {
				orderDao.updateOrderStatus(orderIds, "In Progress");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("cancelOrders".equalsIgnoreCase(operation)) {
			try {
				orderDao.deleteOrders(orderIds);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("/Park_Jungah_MVCApp/HomePage.jsp");
	}

}
