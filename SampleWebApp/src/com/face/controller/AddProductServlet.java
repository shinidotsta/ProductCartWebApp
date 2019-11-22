package com.face.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
 * Servlet implementation class AddProductServlet
 */

@WebServlet(urlPatterns = { "/AddProduct" })
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Add Product Servlet");
		HttpSession session = request.getSession();
	     UserAccount loginedUser = MyUtils.getLoginedUser(session);
	     if (loginedUser == null)
	     {
	    	 response.sendRedirect(request.getContextPath() + "/Login");
	           return;
	     }
	     request.setAttribute("user", loginedUser);
		  RequestDispatcher dispatcher //
          = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/AddProductView.jsp");
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
	     
		   String productname = request.getParameter("productname");
           String quantity = request.getParameter("quantity");
           String price = request.getParameter("price");
      
               ProductBO pdct = new ProductBO();
        	   pdct.setPdctNmae(productname);;
               pdct.setQuantity(quantity);
               pdct.setPrice(price);
               
               Connection conn=MyUtils.getStoredConnection(request);
               try {
				DBUtils.addProduct(conn,productname,quantity,price,loginedUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
        
               RequestDispatcher dispatcher //
                       = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/AddProductView.jsp");
               dispatcher.forward(request, response);
           
           // If no error
           // Store user information in Session
           // And redirect to userInfo page.
		/*
		 * else { HttpSession session = request.getSession();
		 * MyUtils.storeLoginedUser(session, user); // If user checked "Remember me". if
		 * (remember) { MyUtils.storeUserCookie(response, user); } // Else delete
		 * cookie. else { //MyUtils.deleteUserCookie(response); } // Redirect to
		 * userInfo page. response.sendRedirect(request.getContextPath() + "/userInfo");
		 * }
		 */
	}

}
