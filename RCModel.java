package com.nuist.sql;

public class RCModel {

	private String tsbh;
	private int rksl;
	private String rksj;
	public RCModel() {
		super();
	}
	public RCModel(String tsbh, int rksl, String rksj) {
		super();
		this.tsbh = tsbh;
		this.rksl = rksl;
		this.rksj = rksj;
	}
	public String getTsbh() {
		return tsbh;
	}
	public void setTsbh(String tsbh) {
		this.tsbh = tsbh;
	}
	public int getRksl() {
		return rksl;
	}
	public void setRksl(int rksl) {
		this.rksl = rksl;
	}
	public String getRksj() {
		return rksj;
	}
	public void setRksj(String rksj) {
		this.rksj = rksj;
	}
	
	
	
}
