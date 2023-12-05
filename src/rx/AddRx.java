package rx;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.RxDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRx extends JFrame {

	private JPanel contentPane;
	private JTextField RXid;
	private JTextField Pid;
	private JTextField Meid;
	private JTextField sum;
    private String Doid;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRx frame = new AddRx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AddRx(String Doid) {
		this.Doid=Doid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5904\u65B9\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 23));
		lblNewLabel.setBounds(30, 37, 98, 28);
		contentPane.add(lblNewLabel);
		
		RXid = new JTextField();
		RXid.setBounds(178, 37, 85, 28);
		contentPane.add(RXid);
		RXid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u75C5\u4EBA\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(30, 101, 98, 28);
		contentPane.add(lblNewLabel_1);
		
		Pid = new JTextField();
		Pid.setBounds(178, 102, 85, 28);
		contentPane.add(Pid);
		Pid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u836F\u7269\u7F16\u53F7");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(30, 170, 98, 28);
		contentPane.add(lblNewLabel_2);
		
		Meid = new JTextField();
		Meid.setBounds(178, 171, 85, 28);
		contentPane.add(Meid);
		Meid.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u836F\u7269\u6570\u91CF");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 23));
		lblNewLabel_3.setBounds(30, 247, 98, 28);
		contentPane.add(lblNewLabel_3);
		
		sum = new JTextField();
		sum.setBounds(178, 247, 85, 29);
		contentPane.add(sum);
		sum.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addbutton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton.setBounds(30, 321, 85, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				resetButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 17));
		btnNewButton_1.setBounds(211, 321, 85, 31);
		contentPane.add(btnNewButton_1);
	}

	protected void resetButton(ActionEvent e) {
		// TODO Auto-generated method stub
		this.Meid.setText("");
		this.Pid.setText("");
		this.RXid.setText("");
		this.sum.setText("");
	}

	protected void addbutton(ActionEvent e) {
		// TODO Auto-generated method stub
		RxDao rd=new RxDao();
		int sum=Integer.parseInt(this.sum.getText());
		String RXid=this.RXid.getText();
		String Doid=this.Doid;
		String Pid=this.Pid.getText();
		String Meid=this.Meid.getText();
		JOptionPane.showMessageDialog(this,rd.addRX(RXid,Doid,Meid,sum,Pid));
	}
}
