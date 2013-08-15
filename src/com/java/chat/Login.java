package com.java.chat;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	public String title = "JChat Login";
	
	private JTextField usernameLogin, ipLogin, portLogin;
	private JButton loginButton;
	private boolean canUsernameLogin, canIPLogin, canPortLogin = false;
	String name;
	String ip; 
	int port;
	
	Font msserif;
	Font error;
	
	public Login(){
		try {
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) {
		    	 e.printStackTrace();
		    }
		msserif = new Font("Impact", 0, 60);
		error = new Font("Tahoma", 0, 11);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 320);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle(title);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameLogin = new JTextField();
		usernameLogin.setBounds(100, 100, 165, 25);
		contentPane.add(usernameLogin);
		usernameLogin.setColumns(10);
		
		final Pattern badChar = Pattern.compile("[^0-9]");
		
		final JLabel labelName = new JLabel("Username:");
		labelName.setBounds(30, 105, 65, 16);
		contentPane.add(labelName);
		
		JLabel logo = new JLabel("JChat");
		logo.setFont(msserif);
		logo.setBounds(80, 5, 250, 80);
		contentPane.add(logo);
		
		ipLogin = new JTextField();
		ipLogin.setBounds(100, 150, 165, 25);
		contentPane.add(ipLogin);
		ipLogin.setColumns(10);
		
		final JLabel labelIP = new JLabel("IP Address:");
		labelIP.setBounds(30, 155, 65, 16);
		contentPane.add(labelIP);
		
		portLogin = new JTextField();
		portLogin.setBounds(100, 200, 165, 25);
		contentPane.add(portLogin);
		portLogin.setColumns(10);
		
		final JLabel labelPort = new JLabel("Port:");
		labelPort.setBounds(30, 205, 65, 16);
		contentPane.add(labelPort);
		
		loginButton = new JButton("Connect");
		loginButton.setBounds(100, 250, 100, 25);
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//checks to see if fields are filled out
				if(usernameLogin.getText().length() == 0){
					System.out.println("ERROR: Username field is empty");
					labelName.setForeground(Color.RED);
					canUsernameLogin = false;
				}else{
					labelName.setForeground(Color.BLACK);
					name = usernameLogin.getText();
					canUsernameLogin = true;
				}
				
				if(ipLogin.getText().length() == 0){
					System.out.println("ERROR: IP field is empty");
					labelIP.setForeground(Color.RED);
					canIPLogin = false;
				}else{
					labelIP.setForeground(Color.BLACK);
					ip = ipLogin.getText();
					canIPLogin = true;
				}
				
				if(portLogin.getText().length() == 0){
					System.out.println("ERROR: Port field is empty");
					labelPort.setForeground(Color.RED);
					canPortLogin = false;
				}else if(badChar.matcher(portLogin.getText()).find()){
					System.out.println("Error: Port Invalid");
					labelPort.setForeground(Color.RED);
					canPortLogin = false;
				}else{
					labelPort.setForeground(Color.BLACK);
					port = Integer.parseInt(portLogin.getText());
					canPortLogin = true;
				} 
				
				if(canUsernameLogin && canIPLogin && canPortLogin){
					login(name, ip, port);
				}
			}

			private void login(String name, String ip, int port) {
				dispose();
				System.out.println("Username: " + name + ", IP: " + ip + ", Port: " + port);
				new Client(name, ip, port);
			}	
		});
		contentPane.add(loginButton);
	}

	public static void main(String[] args){
		//set look and feel to that of the system's
	    try {
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	    	 e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	    
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					Login frame = new Login();
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
