package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class spdgmenu1 extends JFrame{

	private JMenuBar jmb = new JMenuBar();
	private JMenu khsjManage = new JMenu("�ͻ���Ϣ");
	private JMenu spsjManage = new JMenu("ͼ����Ϣ");
	private JMenu ddManage = new JMenu("������Ϣ");
	private JMenu sys = new JMenu("ϵͳ");
	
	private AbstractAction customerQueryAction = new AbstractAction("��Ա��ѯ"){
		public void actionPerformed(ActionEvent arg0){
			customerQryFrame cQry = new customerQryFrame(); //�򿪿ͻ���ѯ����
		}
	};
	
	private AbstractAction customerInputAction = new AbstractAction("��Ա����¼��"){
		public void actionPerformed(ActionEvent arg0){
			customerInputFrame cInput = new customerInputFrame(); //�򿪿ͻ����ӽ���
		}
	};
	
	
	private AbstractAction goodsQueryAction = new AbstractAction("ͼ�����ݲ�ѯ"){
		public void actionPerformed(ActionEvent arg0){
			goodsQryFrame gQry = new goodsQryFrame();	//����Ʒ��ѯ����
		}
	};
	private AbstractAction goodsUpdateAction = new AbstractAction("ͼ��������"){
		public void actionPerformed(ActionEvent arg0){
			goodsUpdateFrame gUpdt = new goodsUpdateFrame(); //��ͼ������ά������
		}
		
	};
	
	private AbstractAction inputBillAction = new AbstractAction("��������¼��"){
		public void actionPerformed(ActionEvent arg0){
			billInputFrame bInput = new billInputFrame();	//�򿪶���¼�����
		}	
	};

	private AbstractAction queryBillAction = new AbstractAction("�������ݲ�ѯ"){
		public void actionPerformed(ActionEvent arg0){
			billQryFrame bQry = new billQryFrame(); 
		}
	};
	private AbstractAction quitAction = new AbstractAction("�˳�"){
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
		this.setTitle("�������ϵͳ(������Ա)");
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
