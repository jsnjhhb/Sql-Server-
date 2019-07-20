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
				JOptionPane.showMessageDialog(null, "该订单已存在,不能添加!","错误",JOptionPane.ERROR_MESSAGE);
			return -1;
			}
			if(spsl<=0){
				JOptionPane.showMessageDialog(null, "订单数量输入错误!","错误",JOptionPane.ERROR_MESSAGE);
			return -1;
			}
			else{
				String sql = "insert into XSB(图书号,销售日期,数量,会员号)values(?,?,?,?)";
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
	public List<XSBModel>selectXSY(Date time){ //查询月销售账单
		List<XSBModel>list=new ArrayList<XSBModel>();
		conn = connection.getConnection();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("select XSB.图书号,XSB.销售日期,XSB.会员号,数量,价格,折扣,书名 from KHB,TSB,XSB Where year(销售日期)=year('" );
			sql.append(DateFormat.utilToSql(time)).append("')and MONTH(销售日期) = MONTH('");
			sql.append(DateFormat.utilToSql(time)).append("')and KHB.会员号=XSB.会员号 AND XSB.图书号=TSB.图书号");
			pstm=conn.prepareStatement(sql.toString());
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("图书号");
				int sl = rs.getInt("数量");
				String sj = rs.getString("销售日期");
				String hyh = rs.getString("会员号");
				float jg = rs.getFloat("价格");
		        int zk = rs.getInt("折扣");
		        String sm = rs.getString("书名");
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
	public List<XSBModel>selectCX(Date time){ //查询月畅销
		List<XSBModel>list=new ArrayList<XSBModel>();
		conn = connection.getConnection();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" select top 10 XSB.图书号,TSB.书名,sum(数量) AS'月销量'from XSB,TSB where YEAR(销售日期)=year('" );
			sql.append(DateFormat.utilToSql(time)).append("')and MONTH(销售日期) = MONTH('");
			sql.append(DateFormat.utilToSql(time)).append("')AND XSB.图书号=TSB.图书号").append(" ");
			sql.append("group BY XSB.图书号,TSB.书名  order by 月销量 DESC");
			pstm=conn.prepareStatement(sql.toString());
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("图书号");
		        String sm = rs.getString("书名");
		        int yx = rs.getInt("月销量");
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
			String sql = "Select 图书号,会员号,销售日期 FROM XSB WHERE 图书号=? And 会员号=? AND 销售日期=? ";
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
			
			String sql = "update XSB set 数量=? where 图书号=? And 销售日期=? and 会员号=?";
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
			String sql = "delete from XSB where 图书号=? and 销售日期=? and 会员号=?";
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
	public List<XSBModel>selectDD(){ //查询用户方法
		List<XSBModel>list=new ArrayList<XSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from XSB ";
			pstm=conn.prepareStatement(sql);
		    rs = pstm.executeQuery();
			while(rs.next()){
				String tsbh = rs.getString("图书号");
				String rq = rs.getString("销售日期");
				int sl = (int) rs.getFloat("数量");
				String hyh = rs.getString("会员号");
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
