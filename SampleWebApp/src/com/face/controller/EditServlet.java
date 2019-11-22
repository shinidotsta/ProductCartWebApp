package com.face.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.face.BO.ProductBO;
import com.face.BO.UserAccount;
import com.face.dao.DBUtils;
import com.face.dao.MyUtils;

/**
 * Servlet implementation class EditServlet
 */

@WebServlet(urlPatterns = {"/Edit"})
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
	     UserAccount loginedUser = MyUtils.getLoginedUser(session);
	     if (loginedUser == null)
	     {
	    	 response.sendRedirect(request.getContextPath() + "/Login");
	           return;
	     }
	     request.setAttribute("user", loginedUser);
	     RequestDispatcher dispatcher //
         = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/productView.jsp");
 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
	     UserAccount loginedUser = MyUtils.getLoginedUser(session);
	     if (loginedUser == null)
	     {
	    	 response.sendRedirect(request.getContextPath() + "/Login");
	           return;
	     }
	     request.setAttribute("user", loginedUser);
	     
		 String name=request.getParameter("name");
		 int id=Integer.parseInt(request.getParameter("id"));
		  System.out.println(name);
		   Connection conn=MyUtils.getStoredConnection(request);
		   
			try {
				DBUtils.Edit_product_name(conn,name,id);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
			ArrayList<ProductBO> pdlist = null;
			try {
				pdlist = DBUtils.List_Product(conn,loginedUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 request.setAttribute("listpdct", pdlist);
		   
		   
		   RequestDispatcher dispatcher //
	         = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/productView.jsp");
	        dispatcher.forward(request, response);
	}

}
