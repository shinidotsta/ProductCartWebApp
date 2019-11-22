package com.face.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.face.BO.ProductBO;
import com.face.BO.UserAccount;


public class DBUtils
{
	public static UserAccount findUser(Connection conn, //
	           String userName, String password) throws SQLException {
	       String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
	               + " where a.User_Name = ? and a.password= ?";
	       PreparedStatement pstm = conn.prepareStatement(sql);
	       pstm.setString(1, userName);
	       pstm.setString(2, password);
	       ResultSet rs = pstm.executeQuery();
	       if (rs.next()) {
	           String gender = rs.getString("Gender");
	           UserAccount user = new UserAccount();
	           user.setUsername(userName);
	           user.setPassword(password);
	           user.setGender(gender);
	           return user;
	       }
	       return null;
	   }

	public static void addProduct(Connection conn, String productname, String quantity, String price, UserAccount loginedUser) throws SQLException
	{
		String userid = null;
		Statement st=conn.createStatement();
		String sql1="Select USER_NAME from user_account where USER_NAME='"+loginedUser.getUserName()+"'";
		ResultSet result=st.executeQuery(sql1);
		while(result.next())
		{
			userid=result.getString(1);
			System.out.println(result.getString(1));
		}
		
		String sql="INSERT INTO Product(productname,quantity,price,user_id) values ('"+productname+"','"+quantity+"','"+price+"','"+userid+"')";
		int rs=st.executeUpdate(sql);
		if(rs==1)
			System.out.println("inserted");
		else
			System.out.println("not inserted");
		
	}

	public static ArrayList List_Product(Connection conn, UserAccount loginedUser) throws SQLException
	{
		ArrayList<ProductBO>pdlist=new ArrayList<ProductBO>();
		
		
		Statement st=conn.createStatement();
		String sql="SELECT *FROM Product where user_id='"+loginedUser.getUserName()+"'";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			
			ProductBO pbo=new ProductBO();
			pbo.setId(rs.getInt("id"));
			pbo.setPdctNmae(rs.getString("productname"));
			pbo.setQuantity(rs.getString("quantity"));
			pbo.setPrice(rs.getString("price"));
			
			pdlist.add(pbo);
			//System.out.println(ID);System.out.println(pd_name);System.out.println(quantity);System.out.println(price);
		}
		
		return pdlist;
		

	}

	public static void Delete_product(Connection conn, int id) throws SQLException
	{
		Statement st=conn.createStatement();
		String sql="DELETE FROM Product where id="+id+"";
		System.out.println(sql);
		int rs=st.executeUpdate(sql);
		if(rs==1)
		System.out.println("sucess");
		
	}

	public static void Edit_product_name(Connection conn, String name, int id) throws SQLException
	{
		
		Statement st=conn.createStatement();
		String sql="UPDATE Product  set productname='"+name+"' WHERE ID='"+id+"'";
		System.out.println(sql);
		int rs=st.executeUpdate(sql);
		if(rs==1)
		System.out.println("sucess");
	}


}
