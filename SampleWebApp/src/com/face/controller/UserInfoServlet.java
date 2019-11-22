package com.face.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.face.BO.UserAccount;
import com.face.dao.MyUtils;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet(urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
	       // Check User has logged on
	       UserAccount loginedUser = MyUtils.getLoginedUser(session);
	       // Not logged in
	       if (loginedUser == null) {
	           // Redirect to login page.
	           response.sendRedirect(request.getContextPath() + "/Login");
	           return;
	       }
	       // Store info to the request attribute before forwarding.
	       request.setAttribute("user", loginedUser);
	       // If the user has logged in, then forward to the page
	       // /WEB-INF/views/userInfoView.jsp
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/userInfoView.jsp");
	       dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  
	       // If the user has logged in, then forward to the page
	       // /WEB-INF/views/userInfoView.jsp
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/LoginView.jsp");
	       dispatcher.forward(request, response);
	}

}
