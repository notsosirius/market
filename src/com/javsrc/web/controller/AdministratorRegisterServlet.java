package com.javsrc.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javsrc.entity.Administrator;
import com.javsrc.service.AdministratorService;

/**
 * 处理注册管理员的Servlet
 */
@WebServlet("/administrator_register")
public class AdministratorRegisterServlet extends HttpServlet {
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
		String mobile = request.getParameter("mobile");
		String real_name = request.getParameter("real_name");
		String pwd = request.getParameter("pwd");
		
		Administrator mbr = new Administrator();
		mbr.setEmail(email);
		mbr.setMobile(mobile);
		mbr.setReal_name(real_name);
		mbr.setPwd(pwd);
		mbr.setRegister_time(new Date());
		
		//step2: 业务逻辑处理
		AdministratorService service = new AdministratorService();
		//根据邮箱查询会员对象
		Administrator temp = service.findByEmail(email);
		if(temp != null){ //手机号已经存在 
			request.setAttribute("msg", "注册失败，邮箱已经被注册了！");
			
			request.getRequestDispatcher("/administrator_register.jsp").forward(request, response);
		}else{
			service.save(mbr);
			
			//跳转到登录页面
			response.sendRedirect(request.getContextPath() + "/administrator_login.jsp");
		}
	}

}
