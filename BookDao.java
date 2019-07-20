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

public class BookDao {

	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private GetConnection connection = new GetConnection();
	
	public List<TSBModel>selectTSC(String sbm){ //��ѯ�鱾������
		List<TSBModel>list=new ArrayList<TSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from TSB Where ������ like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+sbm+"%");
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("ͼ���");
				String sm = rs.getString("����");
				String zz = rs.getString("����");
				float jg = rs.getFloat("�۸�");
				String fl = rs.getString("ͼ�����");
				String cbs = rs.getString("������");
				int kc = rs.getInt("���");
				TSBModel TS = new TSBModel(bh,sm,zz,jg,fl,cbs,kc);
				list.add(TS);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	public List<TSBModel>selectTSF(String sbm){ //��ѯ�鱾����
		List<TSBModel>list=new ArrayList<TSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from TSB Where ͼ����� like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+sbm+"%");
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("ͼ���");
				String sm = rs.getString("����");
				String zz = rs.getString("����");
				float jg = rs.getFloat("�۸�");
				String fl = rs.getString("ͼ�����");
				String cbs = rs.getString("������");
				int kc = rs.getInt("���");
				TSBModel TS = new TSBModel(bh,sm,zz,jg,fl,cbs,kc);
				list.add(TS);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	public List<TSBModel>selectTSZ(String sbm){ //��ѯ�鱾����
		List<TSBModel>list=new ArrayList<TSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from TSB Where ���� like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+sbm+"%");
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("ͼ���");
				String sm = rs.getString("����");
				String zz = rs.getString("����");
				float jg = rs.getFloat("�۸�");
				String fl = rs.getString("ͼ�����");
				String cbs = rs.getString("������");
				int kc = rs.getInt("���");
				TSBModel TS = new TSBModel(bh,sm,zz,jg,fl,cbs,kc);
				list.add(TS);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	public List<TSBModel>selectTSM(String sbm){ //��ѯ�鱾��
		List<TSBModel>list=new ArrayList<TSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from TSB Where ���� Like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+sbm+"%");
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("ͼ���");
				String sm = rs.getString("����");
				String zz = rs.getString("����");
				float jg = rs.getFloat("�۸�");
				String fl = rs.getString("ͼ�����");
				String cbs = rs.getString("������");
				int kc = rs.getInt("���");
				TSBModel TS = new TSBModel(bh,sm,zz,jg,fl,cbs,kc);
				list.add(TS);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	public List<TSBModel>selectTSH(String sbm){ //��ѯ�鱾��
		List<TSBModel>list=new ArrayList<TSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from TSB Where ͼ���=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,sbm);
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("ͼ���");
				String sm = rs.getString("����");
				String zz = rs.getString("����");
				float jg = rs.getFloat("�۸�");
				String fl = rs.getString("ͼ�����");
				String cbs = rs.getString("������");
				int kc = rs.getInt("���");
				TSBModel TS = new TSBModel(bh,sm,zz,jg,fl,cbs,kc);
				list.add(TS);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	
	
	public int insertTS(String bh,String sm,String zz ,float jg,String fl,String cbs,int kc){
		conn = connection.getConnection();
		int n=0;
		try{
			if(checkTS(bh)){
					JOptionPane.showMessageDialog(null, "��ͼ����Ѵ��ڣ��������!","����",JOptionPane.ERROR_MESSAGE);
				    return -1;
					}
			else if(jg<=0){
				JOptionPane.showMessageDialog(null, "�۸����벻��ȷ���������!","����",JOptionPane.ERROR_MESSAGE);
			    return -1;
				}
			else if(kc<0){
				JOptionPane.showMessageDialog(null, "������벻��ȷ���������!","����",JOptionPane.ERROR_MESSAGE);
			    return -1;
			}
			else{
				String sql="INSERT INTO TSB(ͼ���,����,����,�۸�,ͼ�����,������,���) VALUES (?,?,?,?,?,?,?)";
		    pstm = conn.prepareStatement(sql);
		    pstm.setString(1,bh);
		    pstm.setString(2,sm);
			pstm.setString(3,zz);
			pstm.setFloat(4,jg);
			pstm.setString(5,fl);
			pstm.setString(6, cbs);
			pstm.setInt(7, kc);
			n=pstm.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
			
		}
		return n;
	}
	public boolean checkTS(String bh){
		conn = connection.getConnection();
		boolean exists = false;
		try{
			String sql = "Select ͼ��� FROM TSB WHERE ͼ���=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bh);
			rs=pstm.executeQuery();
			if(rs.next()) exists = true;	
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return exists;

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
	public int updateBook(String spbh,int spsl){
		conn = connection.getConnection();
		int n=0;
		try{
			String sql1 = "Select ��� from TSB where ͼ���=?";
			pstm = conn.prepareStatement(sql1);
			pstm.setString(1, spbh);
			rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()){
				count=rs.getInt("���");
			}
			count = count-spsl;
			if(count<0){
				return -1;
			}
			else{
			String sql = "update TSB set ���=? where ͼ���=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,count);
			pstm.setString(2,spbh);
			n=pstm.executeUpdate();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return n;
		
	}	
	
	
	
	
	
	
	
	
	
}
