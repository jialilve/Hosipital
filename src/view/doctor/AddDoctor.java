package view.doctor;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DoctorDao;
import model.Doctor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField doctor_id;
	private JTextField doctor_name;
	private JTextField doctor_sex;
	private JTextField doctor_age;
	private JTextField doctor_department;
	private JTextField doctor_level;
	private JTextField doctor_tel;
    private Doctor doctor=null;
	/**
	 * Launch the application.
	 */
 

	/**
	 * Create the frame.
	 */
	public AddDoctor() {
		setTitle("\u6B63\u5728\u6DFB\u52A0\u533B\u5E08");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 396, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u533B\u5E08\u7F16\u53F7");
		lblNewLabel.setEnabled(true);
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(22, 31, 72, 29);
		contentPane.add(lblNewLabel);
		
		doctor_id = new JTextField();
		doctor_id.setBounds(104, 35, 66, 25);
		contentPane.add(doctor_id);
		doctor_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u533B\u5E08\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(193, 31, 93, 29);
		contentPane.add(lblNewLabel_1);
		
		doctor_name = new JTextField();
		doctor_name.setBounds(275, 35, 80, 25);
		contentPane.add(doctor_name);
		doctor_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027 \u522B");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(22, 90, 72, 24);
		contentPane.add(lblNewLabel_2);
		
		doctor_sex = new JTextField();
		doctor_sex.setBounds(104, 89, 66, 25);
		contentPane.add(doctor_sex);
		doctor_sex.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74 \u9F84");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(193, 85, 54, 29);
		contentPane.add(lblNewLabel_3);
		
		doctor_age = new JTextField();
		doctor_age.setBounds(275, 89, 66, 25);
		contentPane.add(doctor_age);
		doctor_age.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u79D1 \u5BA4");
		lblNewLabel_4.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(22, 141, 41, 25);
		contentPane.add(lblNewLabel_4);
		
		doctor_department = new JTextField();
		doctor_department.setBounds(104, 141, 66, 25);
		contentPane.add(doctor_department);
		doctor_department.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u804C \u79F0");
		lblNewLabel_5.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(22, 201, 54, 21);
		contentPane.add(lblNewLabel_5);
		
		doctor_level = new JTextField();
		doctor_level.setBounds(104, 201, 119, 25);
		contentPane.add(doctor_level);
		doctor_level.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u7535 \u8BDD");
		lblNewLabel_6.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(22, 271, 54, 15);
		contentPane.add(lblNewLabel_6);
		
		doctor_tel = new JTextField();
		doctor_tel.setBounds(104, 266, 119, 25);
		contentPane.add(doctor_tel);
		doctor_tel.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent se) 
			{
				 addButton(se);
			}
		});
		btnNewButton.setBounds(59, 363, 93, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent se) {
				resetButton(se);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(216, 363, 93, 29);
		contentPane.add(btnNewButton_1);
	}
    public void editDoctor(Doctor doctor)
    {
          setTitle("正在编辑医师信息");
          this.doctor=doctor;
          this.doctor_id.setText(doctor.getId());
          this.doctor_name.setText(doctor.getName());
          this.doctor_sex.setText(doctor.getSex());
          this.doctor_age.setText(String.valueOf(doctor.getAge()));
          this.doctor_level.setText(doctor.getLevel());
          this.doctor_tel.setText(doctor.getTel());
          this.doctor_department.setText(doctor.getDeparment());
    }
	protected void addButton(ActionEvent se) {
		// TODO Auto-generated method stub
		String id=this.doctor_id.getText();
		String name=this.doctor_name.getText();
		String sex=this.doctor_sex.getText();
		int age=Integer.parseInt(this.doctor_age.getText());
		String level=this.doctor_level.getText();
		String tel=this.doctor_tel.getText();
		String  de=this.doctor_department.getText();
		Doctor doctor=new Doctor(id,name,sex,age,level ,tel, de);
		DoctorDao doctordao=new DoctorDao();
		if(this.doctor==null)
		{
			JOptionPane.showMessageDialog(this,doctordao.addDoctor(doctor));
		}
		else
		{
			JOptionPane.showMessageDialog(this,doctordao.editDoctor(doctor));
		}
		this.doctor=null;
	}
	protected void resetButton(ActionEvent se) 
	{
		// TODO Auto-generated method stub
		this.doctor_department.setText("");
		this.doctor_name.setText("");
		this.doctor_level.setText("");
		this.doctor_age.setText("");
		this.doctor_id.setText("");
		this.doctor_sex.setText("");
		this.doctor_tel.setText("");
		this.doctor=null;
	}
}
