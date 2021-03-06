package train;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;


public class SignUp {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	Connection con = null;
	ResultSet rs= null;
	PreparedStatement ps = null;
	public JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		con = sqlConnection.connectorDB();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Image img = new ImageIcon(this.getClass().getResource("/homelogo.png")).getImage();
		
		JPanel panel_1 = new JPanel();
		panel_1.setVisible(false);
		panel_1.setBounds(343, 62, 528, 592);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textArea = new JTextArea("This page explains about the information we collect when you use Train Reservation system. it consists of how we use, \r\n" + 
				"transfer and delete information. We not only aim to fulfil the criteria for privacy laws but also build a community based on trust.\r\n\n\n" + 
				"We do not collect any information in order to advertise it. The information we collect is to make the software better\r\n" +  
				"by increasing personalization features for the users to use it smoothly. Some of this information which you trustfully tell\r\n" + 
				"us like your email address we use it to personally\r\n" + 
				"communicate with you by sending you ticket confirmation or cancellation emails. We use this information to- provide, \r\n" + 
				"improve, promoteand personalize the services for you.\r\n\n"+
				"Our software won't disclose your information to third parties for any purpose. We won't sell information regarding to you\r\n" + 
				"to any third party.If we are going to present your information\r\n" + 
				"due to a legal process we would send you a notice so that you \r\n" + 
				"can challenge it or take any legal course.\r\n\n"+
				"Reservation system may periodically update this policy. We'll notify you about the significant changes to the policy. \r\n" + 
				"The most current version of this policy will always be and we'll archive the former versions.\r\n");
		textArea.setBounds(12, 0, 504, 504);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		panel_1.add(textArea);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
			}
		});
		btnOk.setBounds(213, 539, 97, 25);
		panel_1.add(btnOk);
		
		JLabel label = new JLabel("");
		label.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 225, 225);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
		label_1.setIcon(new ImageIcon(img));
		label_1.setBounds(957, 0, 225, 225);
		frame.getContentPane().add(label_1);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.requestFocus();
			}
		});
		panel.setLayout(null);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "SIGNUP", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 69, 0)));
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(389, 298, 476, 319);
		frame.getContentPane().add(panel);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equalsIgnoreCase("Enter Your Username")) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
		        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().isEmpty()) {
					textField.setText("Enter Your Username");
					textField.setForeground(Color.GRAY);
		        }
			}
		});
		textField.setText("Enter Your Username");
		textField.setForeground(Color.GRAY);
		textField.setFont(new Font("SimSun", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(137, 35, 188, 42);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField.getText().equalsIgnoreCase("Enter Your Password")) {
					passwordField.setText("");
					passwordField.setEchoChar('*');
					passwordField.setForeground(Color.BLACK);
		        }
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().isEmpty()) {
					passwordField.setText("Enter Your Password");
					passwordField.setEchoChar('\u0000');
					passwordField.setForeground(Color.GRAY);
		        }
			}
		});
		passwordField.setText("Enter Your Password");
		passwordField.setForeground(Color.GRAY);
		passwordField.setFont(new Font("SimSun", Font.PLAIN, 16));
		passwordField.setEchoChar(' ');
		passwordField.setBounds(137, 148, 188, 42);
		panel.add(passwordField);
		
		
		
		JButton button_1 = new JButton("Sign Up");
		button_1.setEnabled(false);
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().compareTo("Enter Your Username") != 0 && textField_2.getText().compareTo("Enter Your Email") !=0
							&& passwordField.getText().compareTo("Enter Your Password") !=0) {
					String query = "INSERT INTO login VALUES (?,?,?)";
					ps = con.prepareStatement(query);
					String s = passwordField.getText().toString();
					ps.setString(1, textField.getText());
					ps.setString(2, encrypt(s));
					ps.setString(3, textField_2.getText());
					int n = ps.executeUpdate();
					if(n==1) {
						sendmail(textField_2.getText(),0,0);
						JOptionPane.showMessageDialog(null, "Successfully Registered","Congrats",JOptionPane.INFORMATION_MESSAGE);
						
					}
					SignUp sp = new SignUp();
					sp.frame.setLocationRelativeTo(null);
					sp.frame.setVisible(true);
					frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Fill in all the fields","ERROR",JOptionPane.ERROR_MESSAGE);
						SignUp sp = new SignUp();
						sp.frame.setLocationRelativeTo(null);
						sp.frame.setVisible(true);
						frame.dispose();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Username already exists","ERROR",JOptionPane.ERROR_MESSAGE);
					SignUp sp = new SignUp();
					sp.frame.setLocationRelativeTo(null);
					sp.frame.setVisible(true);
					frame.dispose();
					
				} finally {
					try { rs.close(); } catch (Exception ex) { /* ignored */ }
					try { ps.close(); } catch (Exception ex) { /* ignored */ }
					try { con.close(); } catch (Exception ex) { /* ignored */ }
				}
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		button_1.setBackground(SystemColor.menu);
		button_1.setBounds(137, 271, 188, 35);
		panel.add(button_1);
		
		textField_2 = new JTextField();
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_2.getText().equalsIgnoreCase("Enter Your Email")) {
					textField_2.setText("");
					textField_2.setForeground(Color.BLACK);
		        }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textField_2.getText().isEmpty()) {
					textField_2.setText("Enter Your Email");
					textField_2.setForeground(Color.GRAY);
		        }
			}
		});
		textField_2.setText("Enter Your Email");
		textField_2.setForeground(Color.GRAY);
		textField_2.setFont(new Font("SimSun", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(137, 93, 188, 42);
		panel.add(textField_2);
		
		JCheckBox chkBox = new JCheckBox("I have read and accept the Privacy policy");
		chkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chkBox.isSelected()) {
					button_1.setEnabled(true);
				}
				else {
					button_1.setEnabled(false);
				}
					
			}
		});
		chkBox.setBounds(100, 238, 261, 25);
		panel.add(chkBox);
		
		
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setBackground(SystemColor.textHighlight);
		textField_1.setBounds(400, 131, -7, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\uF0E7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage hp = new HomePage();
				hp.frame.setLocationRelativeTo(null);
				hp.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("Wingdings", Font.PLAIN, 13));
		button.setBounds(80, 320, 81, 32);
		frame.getContentPane().add(button);
		
		JButton btnViewPolicy = new JButton("View Policy");
		btnViewPolicy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
			}
		});
		btnViewPolicy.setForeground(Color.BLACK);
		btnViewPolicy.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		btnViewPolicy.setBackground(SystemColor.menu);
		btnViewPolicy.setBounds(137, 203, 188, 26);
		panel.add(btnViewPolicy);
		
		
	}
	
	public  String encrypt(String pass) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			
			messageDigest.update(pass.getBytes());
			byte[] res = messageDigest.digest();
			StringBuilder sb = new StringBuilder();
			for(byte b : res)
				sb.append(String.format("%02x",b));
			return sb.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
		
	}
	
	
	public void sendmail(String to,int n,int pnr) {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		  //Get a Properties object
		     Properties props = System.getProperties();
		     props.setProperty("mail.smtp.host", "smtp.gmail.com");
		     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		    props.setProperty("mail.smtp.socketFactory.fallback", "false");
		     props.setProperty("mail.smtp.port", "465");
		     props.setProperty("mail.smtp.socketFactory.port", "465");
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.debug", "true");
		     props.put("mail.store.protocol", "pop3");
		    props.put("mail.transport.protocol", "smtp");
		     final String username = "trainticketreservation2020@gmail.com";//
		     final String password = "trainticketReservation@java";
		     try{
		    
		     Session session = Session.getDefaultInstance(props, 
		                          new Authenticator(){
		                             protected PasswordAuthentication getPasswordAuthentication() {
		                                return new PasswordAuthentication(username, password);
		                             }});
		     
		     String send=null;
		     if (n==0)
		    	 send = "Thanks for signing up \nregards, \nTrain Tickect Reservation";
		     if(n==1)
		    	 send = "Congrats, your ticket has been successfully booked\nPNR NO: " +pnr+ "\nregards, \nTrain Tickect Reservation";
		     if(n==2)
		    	 send = "your ticket with PNR NO:" +pnr+ " has been successfully deleted" + "\nregards, \nTrain Tickect Reservation";
		     
		     
		   // -- Create a new message --
		     Message msg = new MimeMessage(session);
		     ;
		  // -- Set the FROM and TO fields --
		     msg.setFrom(new InternetAddress("trainticketreservation2020@gmail.com"));
		     msg.setRecipients(Message.RecipientType.TO, 
		                      InternetAddress.parse(to,false));
		     msg.setSubject("Hello");
		     msg.setText(send);
		     msg.setSentDate(new Date());
		     Transport.send(msg);
		  }catch (MessagingException e){ }
		  
	}
}
