package com.javsrc.web.controller;

import java.io.IOException;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.javsrc.entity.Product;
import com.javsrc.entity.Administrator;
//import com.javsrc.entity.Orders;
//import com.javsrc.service.AddressService;
import com.javsrc.service.AdministratorService;

/**
 * 处理会员登录的Servlet
 */
@WebServlet("/administrator_login")
public class AdministratorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step1： 获取客户端提交的数据
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		//step2: 业务逻辑处理
		
		
		AdministratorService service = new AdministratorService();
		Administrator mbr = service.findByEmail(email);
		
		//step3: 执行跳转
		if(mbr != null){
			if(mbr.getPwd().equals(pwd)){
				//登录成功
				//在会话中记录当前登录的会员信息
				request.getSession().setAttribute("curr_mbr", mbr);
				//显示商品列表
				response.sendRedirect(request.getContextPath() + "/administrator/products");
				
				
			}else{//密码有误
				request.setAttribute("msg", "密码不正确！");
				request.getRequestDispatcher("/administrator_login.jsp").forward(request, response);
			}
		}else{ //用户名不存在
			request.setAttribute("msg", "用户名不存在！");
			request.getRequestDispatcher("/administrator_login.jsp").forward(request, response);
		}
	}

}
