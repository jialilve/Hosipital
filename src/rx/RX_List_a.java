package rx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.PatientDao;
import dao.PaymentDao;
import dao.RxDao;
import model.Patient;
import model.Payment;
import model.R_X;
 

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class RX_List_a extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField rxid;
	private JTextField pid;
	private DefaultTableModel dtm=null;
 
	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public RX_List_a() {
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 669, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 10, 605, 355);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5904\u65B9\u7F16\u53F7", "\u75C5\u4EBA\u59D3\u540D", "\u533B\u751F\u540D", "\u836F\u54C1\u540D\u79F0", "\u836F\u54C1\u6570\u91CF"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(112);
		table.setBackground(new Color(200,210,210));
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u5904\u65B9\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 393, 80, 33);
		contentPane.add(lblNewLabel);
		
		rxid = new JTextField();
		rxid.setBounds(104, 399, 66, 27);
		contentPane.add(rxid);
		rxid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u75C5\u4EBA\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(202, 393, 80, 33);
		contentPane.add(lblNewLabel_1);
		
		pid = new JTextField();
		pid.setBounds(316, 399, 66, 27);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				querysome(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(433, 401, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				resetButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(552, 401, 93, 23);
		contentPane.add(btnNewButton_1);
		
		this.dtm=(DefaultTableModel) table.getModel();
		
		QueryAllRX();
	}

	protected void resetButton(ActionEvent e) {
		// TODO Auto-generated method stub
		this.pid.setText("");
		this.rxid.setText("");
	}

	protected void querysome(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String Pid=this.pid.getText();
		String Rxid=this.rxid.getText();
		this.dtm.setRowCount(0);
		RxDao rxdao= new RxDao();
		List<R_X> at =rxdao.querysomeRX_a(Pid,Rxid);
		for(R_X st:at)
		{
			Vector v=new Vector();
			v.add(st.getRxid());
			v.add(st.getPid());
			v.add(st.getPname());
			v.add(st.getMename());
			v.add(st.getSum());
			dtm.addRow(v);
		}
	}
	public void QueryAllRX()
	{
			this.dtm.setRowCount(0);
			RxDao rxdao= new RxDao();
			List<R_X> at =rxdao.queryAllRX_a();
			for(R_X st:at)
			{
				Vector v=new Vector();
				v.add(st.getRxid());
				v.add(st.getPid());
				v.add(st.getPname());
				v.add(st.getMename());
				v.add(st.getSum());
				dtm.addRow(v);
			}
	}
}