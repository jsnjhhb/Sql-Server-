package com.nuist.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class RCDao {



	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private GetConnection connection = new GetConnection();
	public List<RCModel>selectRC(String tsh){ //��ѯ��ⷽ��
		List<RCModel>list=new ArrayList<RCModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from RKB Where ͼ���=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,tsh);
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("ͼ���");
				int sl = rs.getInt("����");
				String sj = rs.getString("���ʱ��");
				RCModel RC = new RCModel(bh,sl,sj);
				list.add(RC);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	public List<RCModel>selectRC(Date time){ //��ѯ��ⷽ��
		List<RCModel>list=new ArrayList<RCModel>();
		conn = connection.getConnection();
		
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("select*from RKB Where year(���ʱ��)=year('" );
			sql.append(DateFormat.utilToSql(time)).append("')and MONTH(���ʱ��) = MONTH('");
			sql.append(DateFormat.utilToSql(time)).append("')");
			pstm=conn.prepareStatement(sql.toString());
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("ͼ���");
				int sl = rs.getInt("����");
				String sj = rs.getString("���ʱ��");
				RCModel RC = new RCModel(bh,sl,sj);
				list.add(RC);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	
	public List<RCModel> selectRC(){ //��ѯ��ⷽ��
		List<RCModel>list=new ArrayList<RCModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from RKB";
			pstm=conn.prepareStatement(sql);
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("ͼ���");
				int sl = rs.getInt("����");
				String sj = rs.getString("���ʱ��");
				RCModel RC = new RCModel(bh,sl,sj);
				list.add(RC);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	
	
	
	public int insertRC(String bh,int sl ,Date sj){
		conn = connection.getConnection();
		int n=0;
		try{
			if(sl<=0){
				JOptionPane.showMessageDialog(null, "��������������!","����",JOptionPane.ERROR_MESSAGE);
			return -1;
			}
			else{
				String sql="INSERT INTO RKB(ͼ���,����,���ʱ��)VALUES(?,?,?)";
		    pstm = conn.prepareStatement(sql);
		    pstm.setString(1,bh);
		    pstm.setInt(2, sl);
			pstm.setDate(3, DateFormat.utilToSql(sj));
			n=pstm.executeUpdate();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return n;
	}
	
		
	
	public List<String>QueryTSBH(){
		List<String>list = new ArrayList<String>();
		conn = connection.getConnection();
		CallableStatement proc = null ;
		try{
			String sql = "{call GetTSBH()}";
			proc = conn.prepareCall(sql);
			if(proc.execute()){
				rs = proc.getResultSet();
				while(rs.next()){
					list.add(rs.getString("ͼ���"));
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			connection.closed(rs, proc, conn);
		}
		return list;
		
	 }
	
		
	
	
	
	
	
	
	
}
