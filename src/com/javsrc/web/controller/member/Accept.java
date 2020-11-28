package com.javsrc.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.javsrc.entity.Member;
//import com.javsrc.entity.Member;
//import com.javsrc.entity.Orders;
//import com.javsrc.entity.common.Page;
import com.javsrc.service.OrdersService;

@WebServlet("/member/orders/accept")
public class Accept extends HttpServlet{
	
	private static final long serialVersionUID = 2272481321539997243L;
	
	private OrdersService ordersService = new OrdersService();
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException{
		Integer oid=Integer.parseInt(req.getParameter("id"));
		ordersService.updateStatus(oid,5);	
		req.getRequestDispatcher("/administrator/sale/order.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
