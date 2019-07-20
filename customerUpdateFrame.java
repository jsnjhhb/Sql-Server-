package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class customerUpdateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField khbh;
	private JTextField khxm;
	private JTextField khdj;
	private JTextField khzk;
	DefaultTableModel dm = new DefaultTableModel();
	JScrollPane scrollPane = new JScrollPane();
	private JTable KHBTable = new JTable(dm);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerUpdateFrame frame = new customerUpdateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JTable getJTable(){
		  KHDao dao = new KHDao();
		  List<KHBModel>list = dao.selectKH();
		  int m = list.size();
		  Object[][]data=new Object[m][4];
		  String[] ColName={"会员号","姓名","客户等级","折扣"};
		  int i=0;
		  for(KHBModel KH:list){
			  data[i][0]=KH.getKHBH();
			  data[i][1]=KH.getKHXM();
			  data[i][2]=KH.getKHDJ();
			  data[i][3]=KH.getZK();
			  i++;
			  
		  }
		  KHBTable.setModel(new DefaultTableModel(data,ColName));
		  return KHBTable;
	  }
	/**
	 * Create the frame.
	 */
	public customerUpdateFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setVisible(true);
		this.setTitle("会员数据维护");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		KHBTable = getJTable();
		
		JLabel label = new JLabel("\u4F1A\u5458\u53F7");
		label.setBounds(14, 13, 45, 18);
		contentPane.add(label);
		
		khbh = new JTextField();
		khbh.setEnabled(false);
		khbh.setBounds(59, 10, 112, 24);
		contentPane.add(khbh);
		khbh.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(177, 13, 38, 18);
		contentPane.add(label_1);
		
		khxm = new JTextField();
		khxm.setEnabled(false);
		khxm.setBounds(215, 10, 86, 24);
		contentPane.add(khxm);
		khxm.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F1A\u5458\u7B49\u7EA7");
		label_2.setBounds(14, 44, 72, 18);
		contentPane.add(label_2);
		
		khdj = new JTextField();
		khdj.setBounds(106, 41, 23, 24);
		contentPane.add(khdj);
		khdj.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6298\u6263");
		label_3.setBounds(143, 44, 30, 18);
		contentPane.add(label_3);
		
		khzk = new JTextField();
		khzk.setEnabled(false);
		khzk.setBounds(187, 41, 38, 24);
		contentPane.add(khzk);
		khzk.setColumns(10);
		
		JButton updateButton = new JButton("\u4FEE\u6539");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n;
				if(arg0.getSource()==updateButton){
					String bh = khbh.getText();
					String xm = khxm.getText();
					int dj = Integer.parseInt(khdj.getText());
					int zk = Integer.parseInt(khzk.getText());
					KHDao dao = new KHDao();
					n = dao.updateKHB(bh,dj);
					if(n==1){JOptionPane.showMessageDialog(null, "客户信息修改成功!","提示",JOptionPane.INFORMATION_MESSAGE);
					KHBTable = getJTable();
					}
				}
			
			}
		});
		updateButton.setBounds(269, 40, 63, 27);
		contentPane.add(updateButton);
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n;
				if(e.getSource()==deleteButton){
					String bh1 = khbh.getText();
					KHDao dao1 = new KHDao();
					n = dao1.deleteKHB(bh1);
					if(n==1){
					JOptionPane.showMessageDialog(null, "客户信息删除成功!","提示",JOptionPane.INFORMATION_MESSAGE);
					KHBTable = getJTable();
					}
				}
				
		
			
			}
		});
		deleteButton.setBounds(346, 40, 72, 27);
		contentPane.add(deleteButton);
		
		scrollPane.setViewportView(KHBTable);
		scrollPane.setBounds(14, 75, 404, 165);
		contentPane.add(scrollPane);
		
		JLabel label_4 = new JLabel("\u6298");
		label_4.setBounds(232, 44, 23, 18);
		contentPane.add(label_4);
		
		JLabel lblVip = new JLabel("VIP");
		lblVip.setBounds(81, 44, 49, 18);
		contentPane.add(lblVip);
		
		
		KHBTable.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) { 
				Object o = e.getSource(); 
				if(o instanceof JTable){ 
				JTable t = (JTable) o; 
				DefaultTableModel tb = (DefaultTableModel) t.getModel(); 
				//获取选中的单元格值 
				
				khbh.setText(tb.getValueAt(t.getSelectedRow(),0).toString());
				khxm.setText(tb.getValueAt(t.getSelectedRow(),1).toString());
				khdj.setText(tb.getValueAt(t.getSelectedRow(),2).toString());
				khzk.setText(tb.getValueAt(t.getSelectedRow(),3).toString());
				} 
				} 
					
		});
	}

}
