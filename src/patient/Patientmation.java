package patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DoctorDao;
import dao.PatientDao;
import model.Doctor;
import model.Patient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Patientmation extends JFrame {

	private JPanel contentPane;
	private JTextField Pid;
	private JTextField Pname;
	private JTextField age;
	private JTextField sex;
	private JTextField account;
    private String id;
    private JTextField place;
	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public Patientmation(String id) {
		this.id=id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 312, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 41, 54, 23);
		contentPane.add(lblNewLabel);
		
		Pid = new JTextField();
		Pid.setBounds(129, 43, 66, 21);
		contentPane.add(Pid);
		Pid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(31, 98, 54, 25);
		contentPane.add(lblNewLabel_1);
		
		Pname = new JTextField();
		Pname.setBounds(129, 102, 66, 23);
		contentPane.add(Pname);
		Pname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E74\u9F84");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(31, 157, 54, 25);
		contentPane.add(lblNewLabel_2);
		
		age = new JTextField();
		age.setBounds(129, 157, 66, 23);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(31, 212, 54, 23);
		contentPane.add(lblNewLabel_3);
		
		sex = new JTextField();
		sex.setBounds(129, 212, 66, 23);
		contentPane.add(sex);
		sex.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u4F59\u989D");
		lblNewLabel_4.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(31, 260, 54, 27);
		contentPane.add(lblNewLabel_4);
		
		account = new JTextField();
		account.setBounds(129, 260, 66, 23);
		contentPane.add(account);
		account.setColumns(10);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addButton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(28, 388, 80, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(183, 388, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("\u7C4D\u8D2F");
		lblNewLabel_5.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(31, 312, 54, 27);
		contentPane.add(lblNewLabel_5);
		
		place = new JTextField();
		place.setBounds(129, 312, 66, 27);
		contentPane.add(place);
		place.setColumns(10);
		
		editDoctor(this.id);
	}
	    public void editDoctor(String id)
	    {
	          setTitle("正在编辑个人信息");
	          PatientDao padao=new PatientDao();
	          Patient patient=new Patient();
	          patient=padao.queryAllpatient_p(this.id);
	          System.out.println(patient);
	          this.Pid.setText(patient.getId());
	          this.Pname.setText(patient.getName());
	          this.sex.setText(patient.getSex());
	          this.age.setText(String.valueOf(patient.getAge()));
	          this.account.setText(String.valueOf(patient.getAccount()));
	          this.place.setText(patient.getDisease());
 	    }
	    protected void addButton(ActionEvent e) 
		{
			// TODO Auto-generated method stub
		    String id=this.Pid.getText();
		    String name=this.Pname.getText();
		    String sex=this.sex.getText();
		    int age=Integer.parseInt(this.age.getText());
		    float account=Float.parseFloat(this.account.getText());
		    String disease=this.place.getText();
		    Patient patient =new Patient(id,name,sex,age,account,disease,"未缴费");
		    PatientDao patientdao=new PatientDao();
            JOptionPane.showMessageDialog(this,patientdao.editPatient(patient));
		 }
}
