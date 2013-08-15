package com.java.chat;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame{
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private String name, ip;
	private int port;
	public String version = "v0.01 Alpha";
	
	JTextArea chatField;
	
	public Client(String name, String ip, int port){
		this.name = name;
		this.ip = ip;
		this.port = port;
		createWindow();
	}
	
	public void createWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 480);
		setLocationRelativeTo(null);
		setTitle("JChat " + version);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
	}
	
}
