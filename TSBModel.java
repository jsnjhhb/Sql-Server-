package com.nuist.sql;

public class TSBModel {

	private String SBH;
	private String SM;
 	private String ZZ;
 	private float JG;
 	private String FL;
 	private String CBS;
 	private int KC;
 	TSBModel(){
 		
 	}
	public TSBModel(String sBH, String sM, String zZ, float jG, String fL, String cBS, int kC) {
		super();
		SBH = sBH;
		SM = sM;
		ZZ = zZ;
		JG = jG;
		FL = fL;
		CBS = cBS;
		KC = kC;
	}
	public String getSBH() {
		return SBH;
	}
	public void setSBH(String sBH) {
		SBH = sBH;
	}
	public String getSM() {
		return SM;
	}
	public void setSM(String sM) {
		SM = sM;
	}
	public String getZZ() {
		return ZZ;
	}
	public void setZZ(String zZ) {
		ZZ = zZ;
	}
	public float getJG() {
		return JG;
	}
	public void setJG(float jG) {
		JG = jG;
	}
	public String getFL() {
		return FL;
	}
	public void setFL(String fL) {
		FL = fL;
	}
	public String getCBS() {
		return CBS;
	}
	public void setCBS(String cBS) {
		CBS = cBS;
	}
	public int getKC() {
		return KC;
	}
	public void setKC(int kC) {
		KC = kC;
	}
	
}
