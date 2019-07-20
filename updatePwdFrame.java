package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updatePwdFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JTextField userPass;
	DefaultTableModel dm = new DefaultTableModel();
	JScrollPane scrollPane = new JScrollPane();
	private JTable USERTable = new JTable(dm);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatePwdFrame frame = new updatePwdFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JTable getJTable(){
		  userDao dao = new userDao();
		  List<userModel>list = dao.selectUser();
		  int m = list.size();
		  Object[][]data=new Object[m][2];
		  String[] ColName={"用户名","密码"};
		  int i=0;
		  for(userModel user:list){
			  data[i][0]=user.getName();
			  data[i][1]=user.getPass();
			  
			  i++;
			  
		  }
		  USERTable.setModel(new DefaultTableModel(data,ColName));
		  return USERTable;
	  }
	/**
	 * Create the frame.
	 */
	public updatePwdFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setTitle("修改密码");
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labal1 = new JLabel("\u7528\u6237\u540D");
		labal1.setBounds(14, 13, 72, 18);
		contentPane.add(labal1);
		
		userName = new JTextField();
		userName.setEnabled(false);
		userName.setBounds(73, 10, 99, 24);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801");
		lblNewLabel.setBounds(186, 13, 72, 18);
		contentPane.add(lblNewLabel);
		
		userPass = new JTextField();
		userPass.setBounds(223, 10, 99, 24);
		contentPane.add(userPass);
		userPass.setColumns(10);
		
		USERTable = getJTable();
		scrollPane.setEnabled(false);
		scrollPane.setViewportView(USERTable);
		scrollPane.setBounds(14, 44, 393, 196);
		contentPane.add(scrollPane);
		
		JButton updataButton = new JButton("\u4FEE\u6539");
		updataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int n;
				if(arg0.getSource()==updataButton){
					String uN = userName.getText();
					String uP = userPass.getText();
					userDao dao = new userDao();
					n = dao.updateUSER(uN, uP);
					if(n==1){JOptionPane.showMessageDialog(null, "用户信息修改成功!","提示",JOptionPane.INFORMATION_MESSAGE);
					USERTable = getJTable();
					}
				}
				
		
			
				
			}
		});
		updataButton.setBounds(336, 9, 82, 27);
		contentPane.add(updataButton);
		
		
		
		
		
		USERTable.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) { 
				Object o = e.getSource(); 
				if(o instanceof JTable){ 
				JTable t = (JTable) o; 
				DefaultTableModel tb = (DefaultTableModel) t.getModel(); 
				//获取选中的单元格值 
				
				userName.setText(tb.getValueAt(t.getSelectedRow(),0).toString());
				userPass.setText(tb.getValueAt(t.getSelectedRow(),1).toString());
				
				
				} 
				} 
					
		});
		
		
	}
	
	
}
