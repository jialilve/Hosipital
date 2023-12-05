package warehouse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.WareDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addStore extends JFrame 
{
	private JPanel contentPane;
	private JTextField waid;
	private JTextField mid;
	private JTextField sum;
	public int lid;
	public addStore(int lid) 
	{
		this.lid=lid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 406, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4ED3\u5E93\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(21, 38, 85, 34);
		getContentPane().add(lblNewLabel);
		
		waid = new JTextField();
		waid.setBounds(163, 38, 95, 24);
		getContentPane().add(waid);
		waid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u836F\u54C1\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(21, 123, 85, 21);
		getContentPane().add(lblNewLabel_1);
		
		mid = new JTextField();
		mid.setBounds(163, 123, 95, 21);
		getContentPane().add(mid);
		mid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("  \u6570  \u91CF");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(21, 202, 85, 24);
		getContentPane().add(lblNewLabel_2);
		
		sum = new JTextField();
		sum.setBounds(163, 204, 95, 22);
		getContentPane().add(sum);
		sum.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addButton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 19));
		btnNewButton.setBounds(58, 308, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 19));
		btnNewButton_1.setBounds(202, 308, 93, 23);
		getContentPane().add(btnNewButton_1);
	}

	protected void addButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	    String 	waid=this.waid.getText();
	    String  meid=this.mid.getText();
	    int sum=Integer.parseInt(this.sum.getText());
	    WareDao wd=new WareDao();
	    JOptionPane.showMessageDialog(this,wd.addWare(waid, meid, sum,this.lid));
	}

	 

}
