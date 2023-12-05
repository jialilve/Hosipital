package paymentlist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DoctorDao;
import dao.PaymentDao;
import model.Doctor;
import model.Payment;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class paymentlist extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField pid;
	private JTextField state;
	private DefaultTableModel dtm=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paymentlist frame = new paymentlist();
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
	public paymentlist() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 696, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 662, 415);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(200,210,210));
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5904\u65B9\u7F16\u53F7", "\u75C5\u4EBA\u7F16\u53F7", "\u75C5\u4EBA\u59D3\u540D", "\u533B\u5E08\u59D3\u540D", "\u8BCA\u65AD\u8D39", "\u836F\u7269\u8D39\u7528", "\u603B\u8D39\u7528", "\u7F34\u8D39\u72B6\u6001"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(1).setPreferredWidth(59);
		table.getColumnModel().getColumn(2).setPreferredWidth(68);
		table.getColumnModel().getColumn(3).setPreferredWidth(65);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(64);
		table.getColumnModel().getColumn(6).setPreferredWidth(49);
		table.getColumnModel().getColumn(7).setPreferredWidth(101);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u75C5\u4EBA\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 435, 74, 32);
		contentPane.add(lblNewLabel);
		
		pid = new JTextField();
		pid.setBounds(106, 438, 74, 29);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("  \u72B6  \u6001");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 492, 74, 28);
		contentPane.add(lblNewLabel_1);
		
		state = new JTextField();
		state.setBounds(106, 491, 74, 29);
		contentPane.add(state);
		state.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C  \u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				querysome(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.setBounds(350, 442, 93, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6536  \u8D39");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				charge(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(350, 497, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u91CD  \u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});
		btnNewButton_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(518, 445, 93, 23);
		contentPane.add(btnNewButton_2);
		
		this.dtm=(DefaultTableModel) table.getModel();
		
		queryall();
	}
	protected void resetButton(ActionEvent e) {
		// TODO Auto-generated method stub
		this.pid.setText("");
		this.state.setText("");
		queryall();
	}

	protected void querysome(ActionEvent e) {
		// TODO Auto-generated method stub
		String pid=this.pid.getText();
		String state=this.state.getText();
		PaymentDao pdao=new PaymentDao();
		
		this.dtm.setRowCount(0);
		List<Payment> allList= pdao.querysomePayment(pid, state);
		for(Payment st:allList)
		{
			Vector v=new Vector();
			v.add(st.getRxid());
			v.add(st.getPid());
			v.add(st.getDename());
			v.add(st.getDoname());
			v.add(st.getPrice1());
			v.add(st.getPrice2());
			v.add(st.getPrice());
			v.add(st.getState());
			dtm.addRow(v);
		}
		//JOptionPane.showConfirmDialog(this,pdao.querysomePayment(pid, state));
	}

	protected void charge(ActionEvent e) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "是否收费？","正在对用户扣费",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
		{
			String rxid=dtm.getValueAt(this.table.getSelectedRow(), 0).toString();
			String Pid=dtm.getValueAt(this.table.getSelectedRow(), 1).toString();
			float sum=(float)dtm.getValueAt(this.table.getSelectedRow(), 6);
			PaymentDao pdao=new PaymentDao();
			JOptionPane.showConfirmDialog(this,pdao.getMoney(sum,Pid,rxid));
			queryall();
		}
	}

	public void queryall()
	{
		this.dtm.setRowCount(0);
		PaymentDao pydao=new PaymentDao();
		List<Payment> allList=pydao.queryAllpayment();
		for(Payment st:allList)
		{
			Vector v=new Vector();
			v.add(st.getRxid());
			v.add(st.getPid());
			v.add(st.getDename());
			v.add(st.getDoname());
			v.add(st.getPrice1());
			v.add(st.getPrice2());
			v.add(st.getPrice());
			v.add(st.getState());
			dtm.addRow(v);
		}
	}
	 
}
