package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class spdgmenu extends JFrame{

	private JMenuBar jmb = new JMenuBar();
	private JMenu spdgManage = new JMenu("用户管理");
	private JMenu khsjManage = new JMenu("客户信息");
	private JMenu spsjManage = new JMenu("图书信息");
	private JMenu ddManage = new JMenu("订单信息");
	private JMenu sys = new JMenu("系统");
	private  AbstractAction userLoginAction = new AbstractAction("用户登陆"){
		public void actionPerformed(ActionEvent arg0){
		LoginPage log = new LoginPage();	//打开用户登陆界面
		}
	};
	private AbstractAction updatepassAction = new AbstractAction("修改密码"){
		public void actionPerformed(ActionEvent arg0){
			updatePwdFrame pwd = new updatePwdFrame();	//打开修改密码界面
		}	
	};	
	private AbstractAction customerUpdateAction = new AbstractAction("会员数据维护"){
		public void actionPerformed(ActionEvent arg0){
			customerUpdateFrame cUpdt = new customerUpdateFrame(); //打开客户数据维护界面
		}
	};
	private AbstractAction goodsInputAction = new AbstractAction("图书数据录入"){
		public void actionPerformed(ActionEvent arg0){
			goodsInputFrame gInput = new goodsInputFrame(); //打开商品录入界面
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
	
	private AbstractAction updateBillAction = new AbstractAction("订单数据维护"){
		public void actionPerformed(ActionEvent arg0){
			billUpdateFrame bUpdt = new billUpdateFrame(); //打开订单数据维护界面
		}
	};
	private AbstractAction quitAction = new AbstractAction("退出"){
		public void actionPerformed(ActionEvent arg0){
			System.exit(0);
		}	
	};
	public static void main(String[] args){
		spdgmenu sp =new spdgmenu();
		
	}
	public spdgmenu(){
		init();
		
	}
	void init(){
		this.setTitle("书店销售系统(管理员)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img =new ImageIcon(".\\src\\img.jpg");
		JLabel imgLabel = new JLabel(img);
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		JPanel cp = new JPanel();
		cp = (JPanel) this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.setOpaque(false);
		spdgManage.add(userLoginAction);
		spdgManage.add(updatepassAction);
		khsjManage.add(customerUpdateAction);
		spsjManage.add(goodsQueryAction);
		spsjManage.add(goodsInputAction);
		spsjManage.add(goodsUpdateAction);
		ddManage.add(updateBillAction);
		sys.add(quitAction);
		jmb.add(spdgManage);
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
