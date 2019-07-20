package com.nuist.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class GetConnection {
	private String classname="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
    private String url="jdbc:sqlserver://localhost:1433;DatabaseName=BOOKSTORE";//数据源  ！！！！注意若出现加载或者连接数据库失败一般是这里出现问题
    private String Name="sa";
    String Pwd="123456";
    public Connection getConnection(){
    	Connection conn = null;
    	try
    	{
    		Class.forName(classname);
    		conn=DriverManager.getConnection(url,Name,Pwd);
    		System.out.println("连接数据库成功");
    	}catch(Exception e){
    		e.printStackTrace();
    		System.out.println("连接失败");
    		}
    		return conn;
    }
   public void closed(ResultSet rs,PreparedStatement pstm,Connection conn){
	   try{
		   if(pstm!=null) pstm.close();
	   }catch(SQLException e){
		   System.out.println("关闭 pstm对象失败");
		   e.printStackTrace();
	   }
	   try{
		   if(conn!=null) conn.close();
	   }catch(SQLException e){
		   System.out.println("关闭 conn对象失败");
		   e.printStackTrace();
	   }
	   
   }
	
	
}
