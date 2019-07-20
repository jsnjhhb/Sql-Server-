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
	
	public List<TSBModel>selectTSC(String sbm){ //查询书本出版社
		List<TSBModel>list=new ArrayList<TSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from TSB Where 出版社 like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+sbm+"%");
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("图书号");
				String sm = rs.getString("书名");
				String zz = rs.getString("作者");
				float jg = rs.getFloat("价格");
				String fl = rs.getString("图书分类");
				String cbs = rs.getString("出版社");
				int kc = rs.getInt("库存");
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
	public List<TSBModel>selectTSF(String sbm){ //查询书本分类
		List<TSBModel>list=new ArrayList<TSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from TSB Where 图书分类 like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+sbm+"%");
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("图书号");
				String sm = rs.getString("书名");
				String zz = rs.getString("作者");
				float jg = rs.getFloat("价格");
				String fl = rs.getString("图书分类");
				String cbs = rs.getString("出版社");
				int kc = rs.getInt("库存");
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
	public List<TSBModel>selectTSZ(String sbm){ //查询书本作者
		List<TSBModel>list=new ArrayList<TSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from TSB Where 作者 like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+sbm+"%");
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("图书号");
				String sm = rs.getString("书名");
				String zz = rs.getString("作者");
				float jg = rs.getFloat("价格");
				String fl = rs.getString("图书分类");
				String cbs = rs.getString("出版社");
				int kc = rs.getInt("库存");
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
	public List<TSBModel>selectTSM(String sbm){ //查询书本名
		List<TSBModel>list=new ArrayList<TSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from TSB Where 书名 Like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+sbm+"%");
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("图书号");
				String sm = rs.getString("书名");
				String zz = rs.getString("作者");
				float jg = rs.getFloat("价格");
				String fl = rs.getString("图书分类");
				String cbs = rs.getString("出版社");
				int kc = rs.getInt("库存");
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
	public List<TSBModel>selectTSH(String sbm){ //查询书本号
		List<TSBModel>list=new ArrayList<TSBModel>();
		conn = connection.getConnection();
		try{
			String sql = "select*from TSB Where 图书号=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,sbm);
		    rs = pstm.executeQuery();
			while(rs.next()){
				String bh = rs.getString("图书号");
				String sm = rs.getString("书名");
				String zz = rs.getString("作者");
				float jg = rs.getFloat("价格");
				String fl = rs.getString("图书分类");
				String cbs = rs.getString("出版社");
				int kc = rs.getInt("库存");
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
					JOptionPane.showMessageDialog(null, "该图书号已存在，不能添加!","错误",JOptionPane.ERROR_MESSAGE);
				    return -1;
					}
			else if(jg<=0){
				JOptionPane.showMessageDialog(null, "价格输入不正确，不能添加!","错误",JOptionPane.ERROR_MESSAGE);
			    return -1;
				}
			else if(kc<0){
				JOptionPane.showMessageDialog(null, "库存输入不正确，不能添加!","错误",JOptionPane.ERROR_MESSAGE);
			    return -1;
			}
			else{
				String sql="INSERT INTO TSB(图书号,书名,作者,价格,图书分类,出版社,库存) VALUES (?,?,?,?,?,?,?)";
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
			String sql = "Select 图书号 FROM TSB WHERE 图书号=?";
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
	public int updateBook(String spbh,int spsl){
		conn = connection.getConnection();
		int n=0;
		try{
			String sql1 = "Select 库存 from TSB where 图书号=?";
			pstm = conn.prepareStatement(sql1);
			pstm.setString(1, spbh);
			rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()){
				count=rs.getInt("库存");
			}
			count = count-spsl;
			if(count<0){
				return -1;
			}
			else{
			String sql = "update TSB set 库存=? where 图书号=?";
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
