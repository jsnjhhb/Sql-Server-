package com.nuist.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class userDao {

	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private GetConnection connection = new GetConnection();
	public boolean checkUser(String bh,String pass){
		conn = connection.getConnection();
		boolean exists = false;
		try{
			String sql = "Select ���� FROM USERB WHERE �û���=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bh);
			rs=pstm.executeQuery();
			if(rs.next() && rs.getString("����").equals(pass)) exists = true;	
		}catch(SQLException e){
			
		}
		return exists;
		
	}
	public List<userModel>selectUser(){ //��ѯ�û�����
		List<userModel>list=new ArrayList<userModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from USERB ";
			pstm=conn.prepareStatement(sql);
		    rs = pstm.executeQuery();
			while(rs.next()){
				String userName = rs.getString("�û���");
				String Pass = rs.getString("����");
				userModel dingdan = new userModel(userName,Pass);
				list.add(dingdan);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	public int updateUSER(String userName,String newPass){
		conn = connection.getConnection();
		int n=0;
		try{
			
			String sql = "update USERB set ����=? where �û���=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,newPass);
			pstm.setString(2,userName);
			n=pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return n;	
	}
}
	
	

