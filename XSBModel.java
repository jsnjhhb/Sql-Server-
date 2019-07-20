package com.nuist.sql;

import java.util.Date;

public class XSBModel {

	
	private String bh;
	private String da;
	private int sl;
	private String hyh;
	private String sm;
	private float jg;
	private int zk;
	private float sum;
	private int yx;
	public XSBModel(String bh, String sm, int yx) {
		super();
		this.bh = bh;
		this.sm = sm;
		this.yx = yx;
	}
	public int getYx() {
		return yx;
	}
	public void setYx(int yx) {
		this.yx = yx;
	}
	public XSBModel(){
		
	}
	public XSBModel(String bh, String da, int sl, String hyh) {
		super();
		this.bh = bh;
		this.da = da;
		this.sl = sl;
		this.hyh = hyh;
	}
	
	public String getSm() {
		return sm;
	}
	public void setSm(String sm) {
		this.sm = sm;
	}
	public float getJg() {
		return jg;
	}
	public void setJg(float jg) {
		this.jg = jg;
	}
	public int getZk() {
		return zk;
	}
	public void setZk(int zk) {
		this.zk = zk;
	}
	public XSBModel(String bh, String da, int sl, String hyh,String sm, float jg, int zk) {
		super();
		this.bh = bh;
		this.da = da;
		this.sl = sl;
		this.hyh = hyh;
		this.sm = sm;
		this.jg = jg;
		this.zk = zk;
		this.sum = sl*jg*zk/10;
	}
	public float getSum() {
		return sum;
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public String getDa() {
		return da;
	}
	public void setDa(String da) {
		this.da = da;
	}
	public float getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public String getHyh() {
		return hyh;
	}
	public void setHyh(String hyh) {
		this.hyh = hyh;
	}
	
	
}
