package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.Container;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class billInputFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtsl;
	private JTextField txtrq;
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
					billInputFrame frame = new billInputFrame();
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
	public billInputFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel label = new JLabel("\u4F1A\u5458\u53F7");
		label.setBounds(0, 13, 67, 18);
		contentPane.add(label);
		
		
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u53F7");
		label_1.setBounds(166, 13, 45, 18);
		contentPane.add(label_1);
		
		
		
		JLabel lblsl = new JLabel("\u6570\u91CF");
		lblsl.setBounds(319, 13, 55, 18);
		contentPane.add(lblsl);
		
		txtsl = new JTextField();
		txtsl.setBounds(351, 10, 67, 24);
		contentPane.add(txtsl);
		txtsl.setColumns(10);
		
		JLabel lblxsrq = new JLabel("\u9500\u552E\u65E5\u671F");
		lblxsrq.setBounds(0, 46, 72, 18);
		contentPane.add(lblxsrq);
		
		txtrq = new JTextField();
		txtrq.setBounds(70, 44, 180, 24);
		contentPane.add(txtrq);
		txtrq.setColumns(10);
		getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		
		btnAdd.setBounds(277, 44, 113, 27);
		contentPane.add(btnAdd);
		
		KHDao d1 = new KHDao();
		List<String>list1 = d1.QueryKHBH();
		int n=list1.size();
		String[] khbh = new String[n];
		int j=0;
		for(String s:list1){
			khbh[j]=s.toString();
			j++;
		}
		JComboBox cbhyh = new JComboBox(khbh);
		cbhyh.setBounds(50, 10, 113, 24);
		contentPane.add(cbhyh);
		
		BookDao d2 = new BookDao();
		List<String>list2 = d2.QueryTSBH();
		int m = list2.size();
		String[] tsbh = new String[m];
		int i=0;
		for(String s:list2){
			tsbh[i]=s.toString();
			i++;
		}
		JComboBox cbtsh = new JComboBox(tsbh);
		cbtsh.setBounds(214, 10, 102, 24);
		contentPane.add(cbtsh);
		
		
		scrollPane.setViewportView(XSBTable);
		scrollPane.setBounds(0, 77, 432, 176);
		contentPane.add(scrollPane);
		
		this.setVisible(true);
		this.setTitle("订单录入");
		this.add(scrollPane);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n;
				if(arg0.getSource()==btnAdd){
					String khbh = (String) cbhyh.getSelectedItem();
					String tsbh = (String) cbtsh.getSelectedItem();
					int sl = Integer.parseInt(txtsl.getText());
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date rq = null;
					try {
						rq = df.parse(txtrq.getText());
						
					} catch (ParseException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "请按格式输入日期","错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
				    if(khbh.length()==0){
				    	JOptionPane.showMessageDialog(null, "图书编号不能为空!","错误",JOptionPane.ERROR_MESSAGE);
				    	return;
				    }
				    else{
				    	BookDao dao1 = new BookDao();
				    	int n1 = dao1.updateBook(tsbh, sl);
				    	if(n1==-1){
				    	JOptionPane.showMessageDialog(null, "库存不足!","错误",JOptionPane.ERROR_MESSAGE);
				    	return;
				    	}
				    else{
				    	XSBDao dao = new XSBDao();
				    	n = dao.insertXSB(tsbh, rq, sl, khbh);
				    	if(n==1){JOptionPane.showMessageDialog(null, "订单信息添加成功!","提示",JOptionPane.INFORMATION_MESSAGE);
				    	return;
				    }
					XSBTable = getJTable();
				    }
				    
					
					}
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
}
