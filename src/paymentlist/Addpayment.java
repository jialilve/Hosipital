package paymentlist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PaymentDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addpayment extends JFrame {

	private JPanel contentPane;
	private JTextField Rxid;
	private JTextField Doid;
	private JTextField Pid;
    private String id;
	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public Addpayment(String id) {
		this.id=id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5904\u65B9\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 22));
		lblNewLabel.setBounds(54, 62, 93, 27);
		contentPane.add(lblNewLabel);
		
		Rxid = new JTextField();
		Rxid.setBounds(202, 62, 102, 27);
		contentPane.add(Rxid);
		Rxid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u533B\u5E08\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(54, 157, 93, 19);
		contentPane.add(lblNewLabel_1);
		
		Doid = new JTextField();
		Doid.setBounds(202, 157, 102, 27);
		contentPane.add(Doid);
		Doid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u75C5\u4EBA\u7F16\u53F7");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(54, 233, 93, 38);
		contentPane.add(lblNewLabel_2);
		
		Pid = new JTextField();
		Pid.setBounds(202, 239, 102, 27);
		contentPane.add(Pid);
		Pid.setColumns(10);
		
		JButton AddButton = new JButton("\u786E\u8BA4");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addButton(e);
			}
		});
		AddButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		AddButton.setBounds(54, 362, 83, 23);
		contentPane.add(AddButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(245, 362, 93, 23);
		contentPane.add(btnNewButton_1);
		
		this.Pid.setText(this.id);
	}

	protected void addButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String Doid=this.Doid.getText();
		String rxid=this.Rxid.getText();
		PaymentDao pd=new PaymentDao();
		JOptionPane.showMessageDialog(this,pd.addPayment(this.id, Doid, rxid));
	}

}
