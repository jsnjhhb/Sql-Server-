package com.nuist.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class XSBDao {

	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	private GetConnection connection = new GetConnection();
	public int insertXSB(String spbh, Date spda, int spsl, String sphyh){
		
		conn = connection.getConnection();
		int n=0;
		try{
			if(checkBill(spbh,sphyh,spda)){
				JOptionPane.showMessageDialog(null, "�ö����Ѵ���,�������!","����",JOptionPane.ERROR_MESSAGE);
			return -1;
			}
			if(spsl<=0){
				JOptionPane.showMessageDialog(null, "���������������!","����",JOptionPane.ERROR_MESSAGE);
			return -1;
			}
			else{
				String sql = "insert into XSB(ͼ���,��������,����,��Ա��)values(?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,spbh);
			pstm.setDate(2, DateFormat.utilToSql(spda));	
			pstm.setInt(3, spsl);
			pstm.setString(4, sphyh);
			n=pstm.executeUpdate();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return n;
		
	}
	public List<XSBModel>selectXSY(Date time){ //��ѯ�������˵�
		List<XSBModel>list=new ArrayList<XSBModel>();
		conn = connection.getConnection();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("select XSB.ͼ���,XSB.��������,XSB.��Ա��,����,�۸�,�ۿ�,���� from KHB,TSB,XSB Where year(��������)=year('" );
			sql.append(DateFormat.utilToSql(time)).append("')and MONTH(��������) = MONTH('");
			sql.append(DateFormat.utilToSql(time)).append("')and KHB.��Ա��=XSB.��Ա�� AND XSB.ͼ���=TSB.ͼ���");
			pstm=conn.prepareStatement(sql.toString());
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("ͼ���");
				int sl = rs.getInt("����");
				String sj = rs.getString("��������");
				String hyh = rs.getString("��Ա��");
				float jg = rs.getFloat("�۸�");
		        int zk = rs.getInt("�ۿ�");
		        String sm = rs.getString("����");
				XSBModel XS = new XSBModel(bh,sj,sl,hyh,sm,jg,zk);
				list.add(XS);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	public List<XSBModel>selectCX(Date time){ //��ѯ�³���
		List<XSBModel>list=new ArrayList<XSBModel>();
		conn = connection.getConnection();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" select top 10 XSB.ͼ���,TSB.����,sum(����) AS'������'from XSB,TSB where YEAR(��������)=year('" );
			sql.append(DateFormat.utilToSql(time)).append("')and MONTH(��������) = MONTH('");
			sql.append(DateFormat.utilToSql(time)).append("')AND XSB.ͼ���=TSB.ͼ���").append(" ");
			sql.append("group BY XSB.ͼ���,TSB.����  order by ������ DESC");
			pstm=conn.prepareStatement(sql.toString());
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("ͼ���");
		        String sm = rs.getString("����");
		        int yx = rs.getInt("������");
				XSBModel XS = new XSBModel(bh,sm,yx);
				list.add(XS);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
	
	
	
	public boolean checkBill(String spbh,String sphyh,Date spda){
		
		conn = connection.getConnection();
		boolean exists = false;
		try{
			String sql = "Select ͼ���,��Ա��,�������� FROM XSB WHERE ͼ���=? And ��Ա��=? AND ��������=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, spbh);
			pstm.setString(2, sphyh);
			pstm.setDate(3, DateFormat.utilToSql(spda));
			rs=pstm.executeQuery();
			if(rs.next()) exists = true;	
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return exists;
		
	}
	public int updateXSB(String spbh, Date spda, int spsl,String sphyh){
		conn = connection.getConnection();
		int n=0;
		try{
			
			String sql = "update XSB set ����=? where ͼ���=? And ��������=? and ��Ա��=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,spsl);
			pstm.setString(2,spbh);
			pstm.setDate(3,DateFormat.utilToSql(spda));
			pstm.setString(4,sphyh);
			n=pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return n;
		
	}
	
	
	
	
	
	public int deleteXSB(String spbh,String sphyh,Date spda){
		conn = connection.getConnection();
		int n=0;
		try{
			String sql = "delete from XSB where ͼ���=? and ��������=? and ��Ա��=?";
		    pstm = conn.prepareStatement(sql);
			pstm.setString(1,spbh );
			pstm.setDate(2,DateFormat.utilToSql(spda));
			pstm.setString(3,sphyh);
			n = pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return n;
		
	}
	public List<XSBModel>selectDD(){ //��ѯ�û�����
		List<XSBModel>list=new ArrayList<XSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from XSB ";
			pstm=conn.prepareStatement(sql);
		    rs = pstm.executeQuery();
			while(rs.next()){
				String tsbh = rs.getString("ͼ���");
				String rq = rs.getString("��������");
				int sl = (int) rs.getFloat("����");
				String hyh = rs.getString("��Ա��");
				XSBModel dingdan = new XSBModel(tsbh,rq,sl,hyh);
				list.add(dingdan);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.closed(rs, pstm, conn);
		}
		return list;
	}
}
