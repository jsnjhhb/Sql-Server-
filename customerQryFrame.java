package com.nuist.sql;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class customerQryFrame extends JFrame{
      DefaultTableModel dm = new DefaultTableModel();
      JScrollPane scrollPane = new JScrollPane();
      private JTable KHBTable = new JTable(dm);
      JLabel lblXM = new JLabel("客户姓名");
      JTextField txtXM = new JTextField(15);
      JButton btnQuery = new JButton("查询");
      public customerQryFrame(){
    	  this.setSize(720, 400);
    	  this.setTitle("查询会员");
    	  Container container = this.getContentPane();
    	  scrollPane.setViewportView(KHBTable);
    	  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	  this.add(scrollPane);
    	  lblXM.setBounds(230,30,150,30);
    	  txtXM.setBounds(300, 30, 150, 30);
    	  btnQuery.setBounds(500, 30, 60, 30);
    	  scrollPane.setBounds(0,80,700,400);
    	  this.setLayout(null);
    	  container.add(lblXM);
    	  container.add(txtXM);
    	  container.add(btnQuery);
    	  container.add(scrollPane);
    	  this.setVisible(true);
    	  btnQuery.addActionListener(new ActionListener(){
    		  public void actionPerformed(ActionEvent e){
    			  KHBTable = getJTable(txtXM.getText());		  
			}});
    	  
      }
	  public JTable getJTable(String khxm){
		  KHDao dao = new KHDao();
		  List<KHBModel>list = dao.selectKH(khxm);
		  int n = list.size();
		  Object[][]data=new Object[n][8];
		  String[] ColName={"会员号","姓名","会员等级","折扣"};
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
	  	
	
	
	
}
