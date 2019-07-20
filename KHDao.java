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

public class KHDao {

	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private GetConnection connection = new GetConnection();
	public List<KHBModel>selectKH(String khxm){ //��ѯ�û�����
		List<KHBModel>list=new ArrayList<KHBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from KHB Where ���� Like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+khxm+"%");
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("��Ա��");
				String xm = rs.getString("����");
				int dj = rs.getInt("��Ա�ȼ�");
				int zk = rs.getInt("�ۿ�");
				KHBModel KH = new KHBModel(bh,xm,dj,zk);
				list.add(KH);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	public List<KHBModel>selectKH(){ //��ѯ�û�����
		List<KHBModel>list=new ArrayList<KHBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from KHB ";
			pstm=conn.prepareStatement(sql);
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("��Ա��");
				String xm = rs.getString("����");
				int dj = rs.getInt("��Ա�ȼ�");
				int zk = rs.getInt("�ۿ�");
				KHBModel KH = new KHBModel(bh,xm,dj,zk);
				list.add(KH);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	
	
	
	public int insertKH(String bh,String xm,int dj ,int zk){
		conn = connection.getConnection();
		int n=0;
		try{
			if(checkKH(bh)){
					JOptionPane.showMessageDialog(null, "�ÿͻ�����Ѵ��ڣ��������!","����",JOptionPane.ERROR_MESSAGE);
				    return -1;
					}
			else if(dj<0){
				JOptionPane.showMessageDialog(null, "�ͻ��ȼ�������󣬲������!","����",JOptionPane.ERROR_MESSAGE);
			    return -1;
			}
			else{
				String sql="INSERT INTO KHB(��Ա��,����,��Ա�ȼ�,�ۿ�)VALUES(?,?,?,?)";
		    pstm = conn.prepareStatement(sql);
		    pstm.setString(1,bh);
		    pstm.setString(2,xm);
			pstm.setInt(3, dj);;
			pstm.setInt(4,zk);
			n=pstm.executeUpdate();
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
			
		}
		return n;
	}
	public boolean checkKH(String bh){
		conn = connection.getConnection();
		boolean exists = false;
		try{
			String sql = "Select ��Ա�� FROM KHB WHERE ��Ա��=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bh);
			rs=pstm.executeQuery();
			if(rs.next()) exists = true;	
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return exists;
		
	}
	public List<String>QueryKHBH(){
		List<String>list = new ArrayList<String>();
		conn = connection.getConnection();
		CallableStatement proc = null ;
		try{
			String sql = "{call GetKHBH()}";
			proc = conn.prepareCall(sql);
			if(proc.execute()){
				rs = proc.getResultSet();
				while(rs.next()){
					list.add(rs.getString("��Ա��"));
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			connection.closed(rs, proc, conn);
		}
		return list;
		
	 }
	public int updateKHB(String khbh,int khdj){
		conn = connection.getConnection();
		int n=0;
		try{
			String sql = "update KHB set ��Ա�ȼ�=?,�ۿ�=? where ��Ա��=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,khdj);
			pstm.setInt(2,(10-khdj));
			pstm.setString(3,khbh);
			n=pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return n;
		
	}
	public int deleteKHB(String khbh){
		conn = connection.getConnection();
		int n=0;
		try{
			String sql = "delete from KHB where ��Ա��=?";
		    pstm = conn.prepareStatement(sql);
			pstm.setString(1,khbh);
			n = pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return n;
		
	}
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

