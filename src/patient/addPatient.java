package patient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PatientDao;
import model.Doctor;
import model.Patient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addPatient extends JFrame 
{

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField sex;
	private JTextField age;
	private JTextField account;
    private Patient patient;
    private JTextField state;
    private JTextField place;
	/**
	 * Launch the application.
	 */
 
	/**
	 * Create the frame.
	 */
	public addPatient() {
		setTitle("\u6B63\u5728\u6DFB\u52A0\u75C5\u4EBA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 543, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u75C5\u4EBA\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 36, 87, 32);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(140, 36, 79, 32);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u75C5\u4EBA\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(269, 36, 83, 32);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(384, 36, 79, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("  \u6027   \u522B");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(24, 116, 72, 27);
		contentPane.add(lblNewLabel_2);
		
		sex = new JTextField();
		sex.setBounds(139, 116, 80, 27);
		contentPane.add(sex);
		sex.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("  \u5E74  \u9F84");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(269, 116, 83, 24);
		contentPane.add(lblNewLabel_3);
		
		age = new JTextField();
		age.setBounds(384, 116, 79, 27);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u8D26\u6237\u4F59\u989D");
		lblNewLabel_4.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(24, 185, 87, 24);
		contentPane.add(lblNewLabel_4);
		
		account = new JTextField();
		account.setBounds(140, 185, 79, 26);
		contentPane.add(account);
		account.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("   \u7C4D  \u8D2F");
		lblNewLabel_5.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(24, 246, 87, 24);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addButton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 26));
		btnNewButton.setBounds(67, 336, 98, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 26));
		btnNewButton_1.setBounds(330, 336, 92, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("\u5907\u6CE8");
		lblNewLabel_6.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(281, 185, 57, 24);
		contentPane.add(lblNewLabel_6);
		
		state = new JTextField();
		state.setBounds(384, 187, 79, 24);
		contentPane.add(state);
		state.setColumns(10);
		
		place = new JTextField();
		place.setBounds(140, 251, 87, 24);
		contentPane.add(place);
		place.setColumns(10);
	}
	public void editPatient(Patient patient)
    {
          setTitle("正在编辑病人信息");
          this.patient=patient;
          this.id.setText(patient.getId());
          this.name.setText(patient.getName());
          this.sex.setText(patient.getSex());
          this.age.setText(String.valueOf(patient.getAge()));
          this.account.setText(String.valueOf(patient.getAccount()));
          this.place.setText(patient.getDisease());
          this.state.setText(patient.getState());
    }
	protected void addButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	    String id=this.id.getText();
	    String name=this.name.getText();
	    String sex=this.sex.getText();
	    int age=Integer.parseInt(this.age.getText());
	    float account=Float.parseFloat(this.account.getText());
	    String disease=this.place.getText();
	    Patient patient =new Patient(id,name,sex,age,account,disease,"无");
	    PatientDao patientdao=new PatientDao();
	    if(this.patient==null)
	    {
	    	JOptionPane.showMessageDialog(this,patientdao.addPatient(patient));
	    }
	    else
	    {
	    	JOptionPane.showMessageDialog(this,patientdao.editPatient(patient));
	    }
	 }
	 
}
