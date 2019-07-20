package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class spdgmenu1 extends JFrame{

	private JMenuBar jmb = new JMenuBar();
	private JMenu khsjManage = new JMenu("客户信息");
	private JMenu spsjManage = new JMenu("图书信息");
	private JMenu ddManage = new JMenu("订单信息");
	private JMenu sys = new JMenu("系统");
	
	private AbstractAction customerQueryAction = new AbstractAction("会员查询"){
		public void actionPerformed(ActionEvent arg0){
			customerQryFrame cQry = new customerQryFrame(); //打开客户查询界面
		}
	};
	
	private AbstractAction customerInputAction = new AbstractAction("会员数据录入"){
		public void actionPerformed(ActionEvent arg0){
			customerInputFrame cInput = new customerInputFrame(); //打开客户增加界面
		}
	};
	
	
	private AbstractAction goodsQueryAction = new AbstractAction("图书数据查询"){
		public void actionPerformed(ActionEvent arg0){
			goodsQryFrame gQry = new goodsQryFrame();	//打开商品查询界面
		}
	};
	private AbstractAction goodsUpdateAction = new AbstractAction("图书入库情况"){
		public void actionPerformed(ActionEvent arg0){
			goodsUpdateFrame gUpdt = new goodsUpdateFrame(); //打开图书数据维护界面
		}
		
	};
	
	private AbstractAction inputBillAction = new AbstractAction("订单数据录入"){
		public void actionPerformed(ActionEvent arg0){
			billInputFrame bInput = new billInputFrame();	//打开订单录入界面
		}	
	};

	private AbstractAction queryBillAction = new AbstractAction("订单数据查询"){
		public void actionPerformed(ActionEvent arg0){
			billQryFrame bQry = new billQryFrame(); 
		}
	};
	private AbstractAction quitAction = new AbstractAction("退出"){
		public void actionPerformed(ActionEvent arg0){
			System.exit(0);
		}	
	};
	public static void main(String[] args){
		spdgmenu1 sp =new spdgmenu1();
		
	}
	public spdgmenu1(){
		init();
		
	}
	void init(){
		this.setTitle("书店销售系统(销售人员)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img =new ImageIcon(".\\src\\img.jpg");
		JLabel imgLabel = new JLabel(img);
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		JPanel cp = new JPanel();
		cp = (JPanel) this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.setOpaque(false);
		khsjManage.add(customerQueryAction);
		khsjManage.add(customerInputAction);
		spsjManage.add(goodsQueryAction);
		spsjManage.add(goodsUpdateAction);
		ddManage.add(inputBillAction);
		ddManage.add(queryBillAction);
		sys.add(quitAction);
		jmb.add(khsjManage);
		jmb.add(spsjManage);
		jmb.add(ddManage);
		jmb.add(sys);
		this.setJMenuBar(jmb);
		this.setSize(430, 370);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	
}	
