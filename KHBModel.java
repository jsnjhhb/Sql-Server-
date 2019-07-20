package com.nuist.sql;

public class KHBModel {

	private String KHBH;//客户编号
	private String KHXM;//客户姓名
 	private int KHDJ;//客户等级
 	private int ZK;
 	public KHBModel(){
 		
 	}
 	public KHBModel(String bh,String xm,int dj,int zk){
 		this.KHBH=bh;
 		this.KHXM=xm;
 		this.KHDJ=dj;
 		this.ZK=zk;	
 	}
	public String getKHBH() {
		return KHBH;
	}
	public void setKHBH(String kHBH) {
		KHBH = kHBH;
	}
	public String getKHXM() {
		return KHXM;
	}
	public void setKHXM(String kHXM) {
		KHXM = kHXM;
	}
	public int getKHDJ() {
		return KHDJ;
	}
	public void setKHDJ(int kHDJ) {
		KHDJ = kHDJ;
	}
	public int getZK() {
		return ZK;
	}
	public void setZK(int zK) {
		ZK = zK;
	}
 	
 	
}
