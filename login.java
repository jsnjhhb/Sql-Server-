package com.nuist.sql;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login {

	public static void main(String[] args) {
		LoginPage loginFrame = new LoginPage();

	}

}
class LoginPage extends JFrame implements WindowListener,ActionListener{
		JButton loginBut = new JButton("登陆");
	    JButton exitBut = new JButton("退出");
	    JTextField userNameText = new JTextField(15);
	    JTextField userPassText = new JPasswordField(15);
	    JLabel l1=new JLabel("用户账号");
	    JLabel l2=new JLabel("登陆密码");
	    JPanel p1 = new JPanel();
	    JPanel p2 = new JPanel();
	    JPanel p3 = new JPanel();
	    JPanel p4 = new JPanel();
	    LoginPage(){
	    	this.addWindowListener(this);
	    	this.setSize(300, 200);
	    	Container container = this.getContentPane();
	    	FlowLayout fleft = new FlowLayout(FlowLayout.CENTER,10,10);
	    	FlowLayout fright = new FlowLayout(FlowLayout.RIGHT,10,10);
	    	BorderLayout borde = new BorderLayout(10,10);
	    	GridLayout g = new GridLayout(2,1);
	    	container.setLayout(borde);
	    	p1.setLayout(fleft);
	    	p2.setLayout(fleft);
	    	p3.setLayout(fright);
	    	p4.setLayout(g);
	    	p1.add(l1);
	    	p1.add(userNameText);
	    	p2.add(l2);
	    	p2.add(userPassText);
	    	p3.add(loginBut);
	    	p3.add(exitBut);
	    	p4.add(p1);
	    	p4.add(p2);
	    	container.add(p4,BorderLayout.CENTER);
	    	container.add(p3,BorderLayout.SOUTH);
	    	loginBut.addActionListener(this);
	    	exitBut.addActionListener(this);
	    	this.setTitle("用户登陆");
	    	this.setVisible(true);
	    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	this.setLocationRelativeTo(null);
	    	
	    }
	    public void windowClosing(WindowEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "确定要退出吗?","系统消息",JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.YES_NO_OPTION){
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			
		}
	    public void windowClosed(WindowEvent e){}
	    public void windowActivated(WindowEvent e){}
	    public void windowDeactivated(WindowEvent e){}
	    public void windowDeiconified(WindowEvent e){}
	    public void windowIconified(WindowEvent e){}
	    public void windowOpened(WindowEvent e){}

	    public void actionPerformed(ActionEvent e){
	    	if(e.getSource()==loginBut)
	    	{
	    		String userName=userNameText.getText();
	    		String userPass=userPassText.getText();
	    		userDao userquery = new userDao();
	    		if(userName.equals("hhb")&&userPass.equals("20171308084")){
	    			spdgmenu sp = new spdgmenu();
	    		}else{
	    			if(userquery.checkUser(userName,userPass)){
	    			spdgmenu1 sp = new spdgmenu1();
	    			LoginPage.this.setVisible(false);
	    			
	    		}else
	    			JOptionPane.showMessageDialog(null,"密码错误!","错误",JOptionPane.ERROR_MESSAGE);
	    		}
	    		
	    	}
	    	else if(e.getSource()==exitBut)
	    	{System.exit(0);}
	    }
	    public void keyTyped(KeyEvent argO){}
	    public void keyPressed(KeyEvent argO){}
	    public void keyReleased(KeyEvent argO){}

		
		

	
		
	    

}