package com.nuist.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class GetConnection {
	private String classname="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL���ݿ�����
    private String url="jdbc:sqlserver://localhost:1433;DatabaseName=BOOKSTORE";//����Դ  ��������ע�������ּ��ػ����������ݿ�ʧ��һ���������������
    private String Name="sa";
    String Pwd="123456";
    public Connection getConnection(){
    	Connection conn = null;
    	try
    	{
    		Class.forName(classname);
    		conn=DriverManager.getConnection(url,Name,Pwd);
    		System.out.println("�������ݿ�ɹ�");
    	}catch(Exception e){
    		e.printStackTrace();
    		System.out.println("����ʧ��");
    		}
    		return conn;
    }
   public void closed(ResultSet rs,PreparedStatement pstm,Connection conn){
	   try{
		   if(pstm!=null) pstm.close();
	   }catch(SQLException e){
		   System.out.println("�ر� pstm����ʧ��");
		   e.printStackTrace();
	   }
	   try{
		   if(conn!=null) conn.close();
	   }catch(SQLException e){
		   System.out.println("�ر� conn����ʧ��");
		   e.printStackTrace();
	   }
	   
   }
	
	
}
