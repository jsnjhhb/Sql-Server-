package com.nuist.sql;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class goodsQryFrame extends JFrame {

	DefaultTableModel dm = new DefaultTableModel();
    JScrollPane scrollPane = new JScrollPane();
    private JTable TSBTable = new JTable(dm);
    JTextField tsXM = new JTextField(15);
    JButton btnQuery = new JButton("查询");
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					goodsQryFrame frame = new goodsQryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
    
    public goodsQryFrame(){
  	  this.setSize(720, 400);
  	  this.setTitle("查询图书");
  	  Container container = this.getContentPane();
  	  scrollPane.setViewportView(TSBTable);
  	  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  	  getContentPane().add(scrollPane);
  	  tsXM.setBounds(234, 32, 271, 30);
  	  btnQuery.setBounds(519, 32, 71, 30);
  	  scrollPane.setBounds(14,75,674,265);
  	  getContentPane().setLayout(null);
  	  container.add(tsXM);
  	  container.add(btnQuery);
  	  container.add(scrollPane);
  	  String[] csfl = new String[6];
		csfl[0] = "图书号";
		csfl[1] = "书名";
		csfl[2] = "作者";
		csfl[3] = "出版社";
		csfl[4] = "图书分类";
  	  JComboBox comboBox = new JComboBox(csfl);
  	  comboBox.setBounds(134, 35, 86, 24);
  	  
  	  getContentPane().add(comboBox);
  	  
  	  
	  	
  	  this.setVisible(true);
  	  btnQuery.addActionListener(new ActionListener(){
  		  public void actionPerformed(ActionEvent e){
  			  String choice = comboBox.getSelectedItem().toString().trim();
  			  switch(choice){
  			  	 case "图书号":TSBTable = getJTable0(tsXM.getText());
  			  	 break;
  			     case "书名": TSBTable = getJTable1(tsXM.getText());
  			     break;
  			     case "作者":TSBTable = getJTable2(tsXM.getText());
  			     break;
  			     case "出版社":TSBTable = getJTable4(tsXM.getText());
  			     break;
  			     case "图书分类":TSBTable = getJTable3(tsXM.getText());
  			     break;
  			  }
  			      
  			  
  			  
  			  		  
			}});
  	  
    }
    
    
    
	  public JTable getJTable1(String BookName){
		  BookDao dao = new BookDao();
		  List<TSBModel>list = dao.selectTSM(BookName);
		  int n = list.size();
		  Object[][]data=new Object[n][8];
		  String[] ColName={"图书号","书名","作者","价格","图书分类","出版社","库存"};
		  int i=0;
		  for(TSBModel TS:list){
			  data[i][0]=TS.getSBH();
			  data[i][1]=TS.getSM();
			  data[i][2]=TS.getZZ();
			  data[i][3]=TS.getJG();
			  data[i][4]=TS.getFL();
			  data[i][5]=TS.getCBS();
			  data[i][6]=TS.getKC();
			  i++;
		  }
		  TSBTable.setModel(new DefaultTableModel(data,ColName));
		  return TSBTable;
	  }
	  public JTable getJTable0(String BookName){
		  BookDao dao = new BookDao();
		  List<TSBModel>list = dao.selectTSH(BookName);
		  int n = list.size();
		  Object[][]data=new Object[n][8];
		  String[] ColName={"图书号","书名","作者","价格","图书分类","出版社","库存"};
		  int i=0;
		  for(TSBModel TS:list){
			  data[i][0]=TS.getSBH();
			  data[i][1]=TS.getSM();
			  data[i][2]=TS.getZZ();
			  data[i][3]=TS.getJG();
			  data[i][4]=TS.getFL();
			  data[i][5]=TS.getCBS();
			  data[i][6]=TS.getKC();
			  i++;
		  }
		  TSBTable.setModel(new DefaultTableModel(data,ColName));
		  return TSBTable;
	  }
	  public JTable getJTable2(String BookName){
		  BookDao dao = new BookDao();
		  List<TSBModel>list = dao.selectTSZ(BookName);
		  int n = list.size();
		  Object[][]data=new Object[n][8];
		  String[] ColName={"图书号","书名","作者","价格","图书分类","出版社","库存"};
		  int i=0;
		  for(TSBModel TS:list){
			  data[i][0]=TS.getSBH();
			  data[i][1]=TS.getSM();
			  data[i][2]=TS.getZZ();
			  data[i][3]=TS.getJG();
			  data[i][4]=TS.getFL();
			  data[i][5]=TS.getCBS();
			  data[i][6]=TS.getKC();
			  i++;
		  }
		  TSBTable.setModel(new DefaultTableModel(data,ColName));
		  return TSBTable;
	  }
	  public JTable getJTable3(String BookName){
		  BookDao dao = new BookDao();
		  List<TSBModel>list = dao.selectTSF(BookName);
		  int n = list.size();
		  Object[][]data=new Object[n][8];
		  String[] ColName={"图书号","书名","作者","价格","图书分类","出版社","库存"};
		  int i=0;
		  for(TSBModel TS:list){
			  data[i][0]=TS.getSBH();
			  data[i][1]=TS.getSM();
			  data[i][2]=TS.getZZ();
			  data[i][3]=TS.getJG();
			  data[i][4]=TS.getFL();
			  data[i][5]=TS.getCBS();
			  data[i][6]=TS.getKC();
			  i++;
		  }
		  TSBTable.setModel(new DefaultTableModel(data,ColName));
		  return TSBTable;
	  }
	  public JTable getJTable4(String BookName){
		  BookDao dao = new BookDao();
		  List<TSBModel>list = dao.selectTSC(BookName);
		  int n = list.size();
		  Object[][]data=new Object[n][8];
		  String[] ColName={"图书号","书名","作者","价格","图书分类","出版社","库存"};
		  int i=0;
		  for(TSBModel TS:list){
			  data[i][0]=TS.getSBH();
			  data[i][1]=TS.getSM();
			  data[i][2]=TS.getZZ();
			  data[i][3]=TS.getJG();
			  data[i][4]=TS.getFL();
			  data[i][5]=TS.getCBS();
			  data[i][6]=TS.getKC();
			  i++;
		  }
		  TSBTable.setModel(new DefaultTableModel(data,ColName));
		  return TSBTable;
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
