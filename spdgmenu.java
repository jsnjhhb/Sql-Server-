package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class spdgmenu extends JFrame{

	private JMenuBar jmb = new JMenuBar();
	private JMenu spdgManage = new JMenu("�û�����");
	private JMenu khsjManage = new JMenu("�ͻ���Ϣ");
	private JMenu spsjManage = new JMenu("ͼ����Ϣ");
	private JMenu ddManage = new JMenu("������Ϣ");
	private JMenu sys = new JMenu("ϵͳ");
	private  AbstractAction userLoginAction = new AbstractAction("�û���½"){
		public void actionPerformed(ActionEvent arg0){
		LoginPage log = new LoginPage();	//���û���½����
		}
	};
	private AbstractAction updatepassAction = new AbstractAction("�޸�����"){
		public void actionPerformed(ActionEvent arg0){
			updatePwdFrame pwd = new updatePwdFrame();	//���޸��������
		}	
	};	
	private AbstractAction customerUpdateAction = new AbstractAction("��Ա����ά��"){
		public void actionPerformed(ActionEvent arg0){
			customerUpdateFrame cUpdt = new customerUpdateFrame(); //�򿪿ͻ�����ά������
		}
	};
	private AbstractAction goodsInputAction = new AbstractAction("ͼ������¼��"){
		public void actionPerformed(ActionEvent arg0){
			goodsInputFrame gInput = new goodsInputFrame(); //����Ʒ¼�����
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
	
	private AbstractAction updateBillAction = new AbstractAction("��������ά��"){
		public void actionPerformed(ActionEvent arg0){
			billUpdateFrame bUpdt = new billUpdateFrame(); //�򿪶�������ά������
		}
	};
	private AbstractAction quitAction = new AbstractAction("�˳�"){
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
		this.setTitle("�������ϵͳ(����Ա)");
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
