package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class customerInputFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtBH;
	private JTextField txtXM;
	private JTextField txtDJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerInputFrame frame = new customerInputFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public customerInputFrame() {
		this.setVisible(true);
		this.setTitle("会员添加");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("\u4F1A\u5458\u53F7");
		label_1.setBounds(20, 38, 45, 18);
		contentPane.add(label_1);
		
		txtBH = new JTextField();
		txtBH.setBounds(70, 35, 357, 24);
		contentPane.add(txtBH);
		txtBH.setColumns(10);
		
		JLabel label_2 = new JLabel("\u59D3\u540D");
		label_2.setBounds(35, 67, 30, 18);
		contentPane.add(label_2);
		
		txtXM = new JTextField();
		txtXM.setBounds(70, 64, 357, 24);
		contentPane.add(txtXM);
		txtXM.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4F1A\u5458\u7B49\u7EA7");
		label_3.setBounds(5, 96, 60, 18);
		contentPane.add(label_3);
		
		txtDJ = new JTextField();
		txtDJ.setBounds(70, 93, 357, 24);
		contentPane.add(txtDJ);
		txtDJ.setColumns(10);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n;
				if(arg0.getSource()==btnAdd){
					String bh = txtBH.getText();
					String xm = txtXM.getText();
					int dj = Integer.parseInt(txtDJ.getText());
					int zk = 10-dj;
				    if(bh.length()==0){
				    	JOptionPane.showMessageDialog(null, "客户编号不能为空!","错误",JOptionPane.ERROR_MESSAGE);
				    	return;
				    }
				    else if(dj<0){
				    	JOptionPane.showMessageDialog(null, "会员等级输入有误","错误",JOptionPane.ERROR_MESSAGE);
				    	return;
				    }
				    else{
				    	KHDao dao = new KHDao();
					n = dao.insertKH(bh, xm, dj, zk);
					if(n==1)JOptionPane.showMessageDialog(null, "客户信息添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				    }
					
				}
				
			}
		});
		btnAdd.setBounds(173, 130, 94, 27);
		contentPane.add(btnAdd);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u4F1A\u5458");
		label.setBounds(195, 4, 72, 18);
		contentPane.add(label);
	}
}
