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
	public List<RCModel>selectRC(String tsh){ //查询入库方法
		List<RCModel>list=new ArrayList<RCModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from RKB Where 图书号=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,tsh);
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("图书号");
				int sl = rs.getInt("数量");
				String sj = rs.getString("入库时间");
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
	public List<RCModel>selectRC(Date time){ //查询入库方法
		List<RCModel>list=new ArrayList<RCModel>();
		conn = connection.getConnection();
		
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("select*from RKB Where year(入库时间)=year('" );
			sql.append(DateFormat.utilToSql(time)).append("')and MONTH(入库时间) = MONTH('");
			sql.append(DateFormat.utilToSql(time)).append("')");
			pstm=conn.prepareStatement(sql.toString());
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("图书号");
				int sl = rs.getInt("数量");
				String sj = rs.getString("入库时间");
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
	
	public List<RCModel> selectRC(){ //查询入库方法
		List<RCModel>list=new ArrayList<RCModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from RKB";
			pstm=conn.prepareStatement(sql);
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("图书号");
				int sl = rs.getInt("数量");
				String sj = rs.getString("入库时间");
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
				JOptionPane.showMessageDialog(null, "入库数量输入错误!","错误",JOptionPane.ERROR_MESSAGE);
			return -1;
			}
			else{
				String sql="INSERT INTO RKB(图书号,数量,入库时间)VALUES(?,?,?)";
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
					list.add(rs.getString("图书号"));
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
