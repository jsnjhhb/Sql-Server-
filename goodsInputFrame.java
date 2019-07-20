package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class goodsInputFrame extends JFrame {

	private JPanel contentPane;
	private JTextField spbh;
	private JTextField spName;
	private JTextField spzz;
	private JTextField spjg;
	private JTextField spcbs;
	private JTextField spkc;
	DefaultTableModel dm = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					goodsInputFrame frame = new goodsInputFrame();
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
	public goodsInputFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("图书添加");
		this.setVisible(true);
		
		JLabel label = new JLabel("\u56FE\u4E66\u53F7");
		label.setBounds(14, 13, 50, 18);
		contentPane.add(label);
		
		spbh = new JTextField();
		spbh.setBounds(62, 10, 293, 24);
		contentPane.add(spbh);
		spbh.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4E66\u540D");
		label_1.setBounds(14, 44, 35, 18);
		contentPane.add(label_1);
		
		spName = new JTextField();
		spName.setBounds(62, 41, 293, 24);
		contentPane.add(spName);
		spName.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F5C\u8005");
		label_2.setBounds(14, 73, 35, 18);
		contentPane.add(label_2);
		
		spzz = new JTextField();
		spzz.setBounds(62, 70, 293, 24);
		contentPane.add(spzz);
		spzz.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4EF7\u683C");
		label_3.setBounds(125, 135, 35, 18);
		contentPane.add(label_3);
		
		spjg = new JTextField();
		spjg.setBounds(160, 132, 50, 24);
		contentPane.add(spjg);
		spjg.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5206\u7C7B");
		label_4.setBounds(224, 135, 35, 18);
		contentPane.add(label_4);
		
		
		String[] tsfl = new String[6];
		tsfl[0] = "数学";
		tsfl[1] = "语文";
		tsfl[2] = "英语";
		tsfl[3] = "计算机";
		tsfl[4] = "小说";
		tsfl[5] = "散文";
		
		
		JComboBox spfl = new JComboBox(tsfl);
		spfl.setBounds(257, 132, 98, 24);
		contentPane.add(spfl);
		
		JLabel label_5 = new JLabel("\u51FA\u7248\u793E");
		label_5.setBounds(14, 104, 50, 18);
		contentPane.add(label_5);
		
		spcbs = new JTextField();
		spcbs.setBounds(62, 101, 293, 24);
		contentPane.add(spcbs);
		spcbs.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5E93\u5B58");
		label_6.setBounds(14, 135, 35, 18);
		contentPane.add(label_6);
		
		spkc = new JTextField();
		spkc.setBounds(62, 132, 63, 24);
		contentPane.add(spkc);
		spkc.setColumns(10);
		
		JButton insertButton = new JButton("\u6DFB\u52A0");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int n;
				if(e.getSource()==insertButton){
					String bh = spbh.getText();
					String sm = spName.getText();
					String zz = spzz.getText();
					float jg = Float.parseFloat(spjg.getText()); 
					String fl = (String) spfl.getSelectedItem();
					String cbs = spcbs.getText();
					int kc = Integer.parseInt(spkc.getText());
				    if(bh.length()==0){
				    	JOptionPane.showMessageDialog(null, "图书编号不能为空!","错误",JOptionPane.ERROR_MESSAGE);
				    	return;
				    }
				    BookDao dao1 = new BookDao();
				    BookDao dao = new BookDao();
				    n = dao.insertTS(bh,sm,zz,jg,fl,cbs,kc);
				    if(n==1){JOptionPane.showMessageDialog(null, "图书信息添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
				    }
					
					
				}
				
		
			}

			private float string(String text) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		insertButton.setBounds(149, 178, 88, 27);
		contentPane.add(insertButton);
	}
}
