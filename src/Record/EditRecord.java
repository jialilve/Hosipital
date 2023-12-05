package Record;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.RecordDao;
import model.Doctor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditRecord extends JFrame {

	private JPanel contentPane;
	private JTextField Pid;
	private JTextField date;
    private String doid;
    private String pid;
    private String date1;
    private String Disease;
    private JTextArea disease;
	/**
	 * Launch the application.
	 */
	 
	/**
	 * Create the frame.
	 */
	public EditRecord(String Doid,String Pid1,String Date,String Disease) 
	{
		this.doid=Doid;
		this.pid=Pid1;
		this.date1=Date;
		this.Disease=Disease;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 359, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u75C5\u4EBA\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 21));
		lblNewLabel.setBounds(30, 59, 91, 35);
		contentPane.add(lblNewLabel);
		
		Pid = new JTextField();
		Pid.setBounds(149, 69, 121, 21);
		contentPane.add(Pid);
		Pid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BCA\u65AD\u65E5\u671F");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(30, 149, 91, 21);
		contentPane.add(lblNewLabel_1);
		
		date = new JTextField();
		date.setBounds(149, 152, 121, 21);
		contentPane.add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BCA\u75BE\u75C5");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(30, 216, 91, 35);
		contentPane.add(lblNewLabel_2);
		
		disease = new JTextArea();
		disease.setBounds(149, 224, 146, 106);
		contentPane.add(disease);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addButton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 21));
		btnNewButton.setBounds(30, 361, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				resetButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(215, 361, 93, 23);
		contentPane.add(btnNewButton_1);
		this.Pid.setText(Pid1);
		this.date.setText(Date);
		this.disease.setText(Disease);
	}
    protected void resetButton(ActionEvent e) {
		// TODO Auto-generated method stub
    	this.Pid.setText(this.pid);
		this.date.setText(this.date1);
		this.disease.setText(this.Disease);
	}
	protected void addButton(ActionEvent e)
    {
    	RecordDao rd=new RecordDao();
    	String dt=this.date.getText();
    	String di=this.disease.getText();
    	JOptionPane.showMessageDialog(this,rd.editRecord(this.doid, this.pid,di,dt));	 
    }
}
