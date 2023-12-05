package Department;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DeparmentDao;
import dao.PatientDao;
import model.Deparment;
import model.Patient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditDepartment extends JFrame {

	private JPanel contentPane;
	private  JTextField id;
	private JTextField name;
	private  JTextField sum;
	private JTextArea text;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDepartment frame = new EditDepartment();
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
	public EditDepartment() {
		setTitle("\u6B63\u5728\u7F16\u8F91\u5B66\u751F\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 477, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u79D1\u5BA4\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 39, 98, 20);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(157, 39, 82, 24);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("  \u79D1\u5BA4\u540D");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(24, 102, 75, 20);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(157, 102, 82, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u79D1\u5BA4\u4EBA\u6570");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(24, 170, 98, 20);
		contentPane.add(lblNewLabel_2);
		
		sum = new JTextField();
		sum.setBounds(157, 170, 82, 24);
		contentPane.add(sum);
		sum.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u79D1\u5BA4\u63CF\u8FF0");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(24, 233, 82, 20);
		contentPane.add(lblNewLabel_3);
		
		text = new JTextArea();
		text.setBounds(157, 234, 254, 129);
		contentPane.add(text);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(90, 389, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(259, 392, 93, 23);
		contentPane.add(btnNewButton_1);
	}
	protected void resetButton(ActionEvent e) {
		// TODO Auto-generated method stub
		this.id.setText("");
		this.name.setText("");
		this.sum.setText("");
		this.text.setText("");
	}

	protected void addButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String id=this.id.getText();
	    String name=this.name.getText();
	    int sum=Integer.parseInt(this.sum.getText() );
	    String text =this.text.getText();
	    Deparment de=new Deparment(id,name,sum,text);
 	    DeparmentDao dedao=new DeparmentDao();
	    JOptionPane.showMessageDialog(this,dedao.editDeparment(de));
	}

	public void editDe(Deparment de)
	{
		this.id.setText(de.getId());
		this.name.setText(de.getName());
		this.sum.setText(String.valueOf(de.getSum()));
		this.text.setText(de.getText());
	}
    
}
