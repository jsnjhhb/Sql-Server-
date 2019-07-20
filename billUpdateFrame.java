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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class billUpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField hyh;
	private JTextField spbh;
	private JTextField sl;
	private JTextField time;
	DefaultTableModel dm = new DefaultTableModel();
	JScrollPane scrollPane = new JScrollPane();
	private JTable XSBTable = new JTable(dm);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billUpdateFrame frame = new billUpdateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JTable getJTable(){
		  XSBDao dao = new XSBDao();
		  List<XSBModel>list = dao.selectDD();
		  int m = list.size();
		  Object[][]data=new Object[m][4];
		  String[] ColName={"图书号","销售日期","数量","会员号"};
		  int i=0;
		  for(XSBModel XS:list){
			  data[i][0]=XS.getBh();
			  data[i][1]=XS.getDa();
			  data[i][2]=XS.getSl();
			  data[i][3]=XS.getHyh();
			  i++;
			  
		  }
		  XSBTable.setModel(new DefaultTableModel(data,ColName));
		  return XSBTable;
	  }
	/**
	 * Create the frame.
	 */
	public billUpdateFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setVisible(true);
		this.setTitle("订单数据更新");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		XSBTable = getJTable();
		
		
		
		scrollPane.setViewportView(XSBTable);
		scrollPane.setBounds(0, 75, 432, 178);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("\u4F1A\u5458\u53F7");
		label.setBounds(0, 13, 72, 18);
		contentPane.add(label);
		
		hyh = new JTextField();
		hyh.setEnabled(false);
		hyh.setBounds(48, 10, 94, 24);
		contentPane.add(hyh);
		hyh.setColumns(15);
		
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u7F16\u53F7");
		label_1.setBounds(146, 13, 72, 18);
		contentPane.add(label_1);
		
		spbh = new JTextField();
		spbh.setEnabled(false);
		spbh.setBounds(209, 10, 127, 24);
		contentPane.add(spbh);
		spbh.setColumns(20);
		
		JLabel lblNewLabel = new JLabel("\u6570\u91CF");
		lblNewLabel.setBounds(339, 13, 35, 18);
		contentPane.add(lblNewLabel);
		
		sl = new JTextField();
		sl.setBounds(367, 10, 51, 24);
		contentPane.add(sl);
		sl.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BA2\u8D2D\u65F6\u95F4");
		label_2.setBounds(0, 44, 72, 18);
		contentPane.add(label_2);
		
		time = new JTextField();
		time.setEnabled(false);
		time.setBounds(68, 41, 200, 24);
		contentPane.add(time);
		time.setColumns(10);
		
		JButton XGButton = new JButton("\u4FEE\u6539");
		XGButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n;
				if(arg0.getSource()==XGButton){
					String khbh = hyh.getText();
					String tsbh = spbh.getText();
					int spsl = Integer.parseInt(sl.getText());
					String rq = time.getText();
					Date sprq = DateFormat.format_(rq);
					XSBDao dao = new XSBDao();
					n = dao.updateXSB(tsbh, sprq, spsl, khbh);
					if(n==1){JOptionPane.showMessageDialog(null, "订单信息修改成功!","提示",JOptionPane.INFORMATION_MESSAGE);
					XSBTable = getJTable();
					}
				}
				
			}
		});
		XGButton.setBounds(282, 40, 66, 27);
		contentPane.add(XGButton);
		
		JButton DeleteButton = new JButton("\u5220\u9664");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n;
				if(arg0.getSource()==DeleteButton){
					String khbh = hyh.getText();
					String tsbh = spbh.getText();
					String rq = time.getText();
					Date sprq = DateFormat.format_(rq);
					XSBDao dao = new XSBDao();
					n = dao.deleteXSB(tsbh, khbh,sprq);
					if(n==1){JOptionPane.showMessageDialog(null, "订单信息删除成功!","提示",JOptionPane.INFORMATION_MESSAGE);
					XSBTable = getJTable();
					}
				}
				
		
			}
		});
		DeleteButton.setBounds(352, 40, 66, 27);
		contentPane.add(DeleteButton);
		
		XSBTable.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) { 
				Object o = e.getSource(); 
				if(o instanceof JTable){ 
				JTable t = (JTable) o; 
				DefaultTableModel tb = (DefaultTableModel) t.getModel(); 
				//获取选中的单元格值 
				hyh.setText(tb.getValueAt(t.getSelectedRow(),3).toString());
				spbh.setText(tb.getValueAt(t.getSelectedRow(),0).toString());
				sl.setText(tb.getValueAt(t.getSelectedRow(),2).toString());
				time.setText(tb.getValueAt(t.getSelectedRow(),1).toString()); 
				
				} 
				} 
					
		});
		
		
		
		
		
		
	}
	
	
	
}
