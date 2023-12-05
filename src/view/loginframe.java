package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdminDao;
import model.Admin;
import model.UserType;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginframe extends JFrame {

	private JPanel contentPane;
	private JTextField adminName;
	private JTextField adminPd;
    private JComboBox adminType;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginframe frame = new loginframe();
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
	public loginframe() {
		setTitle("\u767B\u5F55\u9875\u9762");
		setIconImage(Toolkit.getDefaultToolkit().getImage(loginframe.class.getResource("/image/\u516C\u53F8 (1).png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Image img=new ImageIcon("D:\\eclipse1\\医院信息管理系统\\src\\image\\首页.jpeg").getImage();
		
		JLabel lblNewLabel = new JLabel("\u533B\u9662\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 42));
		lblNewLabel.setBounds(94, 27, 377, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setIcon(new ImageIcon(loginframe.class.getResource("/image/\u7528\u6237\u540D.png")));
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(70, 115, 92, 39);
		contentPane.add(lblNewLabel_1);
		
		adminName = new JTextField();
		adminName.setBounds(202, 122, 234, 31);
		contentPane.add(adminName);
		adminName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6    \u7801");
		lblNewLabel_2.setIcon(new ImageIcon(loginframe.class.getResource("/image/\u5BC6\u7801.png")));
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(70, 186, 92, 28);
		contentPane.add(lblNewLabel_2);
		
		adminPd = new JTextField();
		adminPd.setBounds(202, 183, 234, 31);
		contentPane.add(adminPd);
		adminPd.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u7C7B\u578B");
		lblNewLabel_3.setIcon(new ImageIcon(loginframe.class.getResource("/image/\u6392\u8BFE.png")));
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(70, 240, 106, 36);
		contentPane.add(lblNewLabel_3);
		
		adminType = new JComboBox();
		adminType.setFont(new Font("华文楷体", Font.PLAIN, 17));
		adminType.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN,UserType.DOCTOR,UserType.PATIENT}));
		adminType.setBackground(SystemColor.controlHighlight);
		adminType.setBounds(202, 246, 151, 31);
		contentPane.add(adminType);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				resetButton(ae);
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.setBounds(333, 340, 92, 23);
		contentPane.add(btnNewButton_1);
		//登录
		JButton btnNewButton_1_1 = new JButton("\u767B\u5F55");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) 
			{
				confirmButton(ae);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1_1.setBounds(136, 340, 92, 23);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1_1.setFocusable(false);
		adminType.setFocusable(false);
		setLocationRelativeTo(null);
	}

	protected void resetButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		this.adminName.setText("");
		this.adminPd.setText("");
	}

	protected void confirmButton(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		String name1=this.adminName.getText();
		String password=this.adminPd.getText();
		UserType usertype=(UserType)this.adminType.getSelectedItem();
		if("管理员".equals(usertype.getName()))
		{
			AdminDao admindao=new AdminDao();
			Admin admin=(Admin) admindao.selectAdmin(name1, password,0);
			if(admin==null)
			{
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
				return;
			}
			else
			{
				JOptionPane.showMessageDialog(this,"登录成功");
			}
			Indexframe indexframe =new Indexframe(usertype,admin);
			indexframe.setVisible(true);
			this.dispose();
		}
		else if("医生".equals(usertype.getName()))
		{
			AdminDao admindao=new AdminDao();
			Admin admin=(Admin) admindao.selectAdmin(name1, password,1);
			if(admin==null)
			{
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
				return;
			}
			else
			{
				JOptionPane.showMessageDialog(this,"登录成功");
			}
			Indexframe_d indexframe_d =new Indexframe_d(usertype,admin);
			indexframe_d.setVisible(true);
			this.dispose();
		}
		else
		{
			AdminDao admindao=new AdminDao();
			Admin admin=(Admin) admindao.selectAdmin(name1, password,2);
			if(admin==null)
			{
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
				return;
			}
			else
			{
				JOptionPane.showMessageDialog(this,"登录成功");
			}
			Indexframe_p indexframe_p =new Indexframe_p(usertype,admin);
			indexframe_p.setVisible(true);
			this.dispose();
		}
	}
}
