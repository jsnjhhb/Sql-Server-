package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class goodsUpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField number;
	private JTextField rksj;
	DefaultTableModel dm = new DefaultTableModel();
	JScrollPane scrollPane = new JScrollPane();
	private JTable RCTable = new JTable(dm);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					goodsUpdateFrame frame = new goodsUpdateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JTable getJTable(){
		  RCDao dao = new RCDao();
		  List<RCModel>list = dao.selectRC();
		  int m = list.size();
		  Object[][]data=new Object[m][4];
		  String[] ColName={"图书号","数量","入库日期"};
		  int i=0;
		  for(RCModel RC:list){
			  data[i][0]=RC.getTsbh();
			  data[i][1]=RC.getRksl();
			  data[i][2]=RC.getRksj();
			  i++; 
		  }
		  RCTable.setModel(new DefaultTableModel(data,ColName));
		  return RCTable;
	  }
	public JTable getJTable1(String bh){
		  RCDao dao = new RCDao();
		  List<RCModel>list = dao.selectRC(bh);
		  int m = list.size();
		  Object[][]data=new Object[m][4];
		  String[] ColName={"图书号","数量","入库日期"};
		  int i=0;
		  for(RCModel RC:list){
			  data[i][0]=RC.getTsbh();
			  data[i][1]=RC.getRksl();
			  data[i][2]=RC.getRksj();
			  i++; 
		  }
		  RCTable.setModel(new DefaultTableModel(data,ColName));
		  return RCTable;
	  }
	
	/**
	 * Create the frame.
	 */
	public goodsUpdateFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setVisible(true);
		this.setTitle("图书入库");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7F16\u53F7");
		label.setBounds(14, 13, 72, 18);
		contentPane.add(label);
		
		
		BookDao d2 = new BookDao();
		List<String>list2 = d2.QueryTSBH();
		int m = list2.size();
		String[] spbh = new String[m];
		int i=0;
		for(String s:list2){
			spbh[i]=s.toString();
			i++;
		}
		JComboBox tsbh = new JComboBox(spbh);
		tsbh.setBounds(81, 10, 84, 24);
		contentPane.add(tsbh);
		
		JLabel label_1 = new JLabel("\u6570\u91CF");
		label_1.setBounds(176, 13, 30, 18);
		contentPane.add(label_1);
		
		number = new JTextField();
		number.setBounds(207, 10, 38, 24);
		contentPane.add(number);
		number.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5165\u5E93\u65F6\u95F4");
		label_2.setBounds(250, 13, 72, 18);
		contentPane.add(label_2);
		
		rksj = new JTextField();
		rksj.setBounds(315, 10, 91, 24);
		contentPane.add(rksj);
		rksj.setColumns(10);
		
		JButton insertButton = new JButton("\u6DFB\u52A0");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int n;
				if(e.getSource()==insertButton){
					String bh = (String) tsbh.getSelectedItem();
					int sl = Integer.parseInt(number.getText());
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date rq = null;
					try {
						rq = df.parse(rksj.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "请按格式输入日期","错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
				    	RCDao dao = new RCDao();
				    	n = dao.insertRC(bh, sl, rq);
				    	if(n==1){JOptionPane.showMessageDialog(null, "订单信息添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
					
				    
					RCTable = getJTable();
					}
				    BookDao book = new BookDao();
					book.updateBook(bh, -sl);	
				}
			}
		});
		insertButton.setBounds(52, 44, 113, 27);
		contentPane.add(insertButton);
		
		JButton csButton = new JButton("\u67E5\u8BE2");
		csButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RCTable = getJTable1(tsbh.getSelectedItem().toString());
				
			}
		});
		csButton.setBounds(240, 44, 113, 27);
		contentPane.add(csButton);
		
		scrollPane.setViewportView(RCTable);
		scrollPane.setBounds(14, 74, 404, 166);
		contentPane.add(scrollPane);
		
	}

}
