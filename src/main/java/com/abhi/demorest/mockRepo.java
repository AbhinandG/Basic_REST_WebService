package com.abhi.demorest;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.*;


public class mockRepo {
	
	Connection con=null;
	
	
	public mockRepo()
	{
		String url="jdbc:mysql://192.168.64.2:3306/restdb";
		String us="abhi";
		String pas=" ";
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,us,pas);
		System.out.println("Database connection success!");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
        
		
	}
	
	public List<ali> getUsers()
	{
		
		List<ali> users=new ArrayList<>();
		String sql="select * from resttable";
		try {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			ali a=new ali();
			a.setUsername(rs.getString(1));
			a.setPassword(rs.getString(2));
			users.add(a);
		}
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return users;
	}
	
	
	
	public void create(ali a)
	{
		String sql="insert into resttable values(?,?)";
		
		try {
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1, a.getUsername());
			st.setString(2, a.getPassword());
			
			st.executeUpdate();
			
			}catch(Exception e)
			{
				System.out.println(e);
			}
	}
	
	public boolean checkUsers(String usname, String pasname)
	{
		int x=0;
		String sql="select * from resttable where username= '"+usname+"' and password= '"+pasname+"'";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				x=1;
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		if(x==0)
			return false;
		return true;
	}

}
