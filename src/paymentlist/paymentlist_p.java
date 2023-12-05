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

public class paymentlist_p extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm=null;
	private String id;
	/**
	 * Launch the application.
	 */
	 
	/**
	 * Create the frame.
	 */
	public paymentlist_p(String id) 
	{
		this.id=id;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 696, 504);
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
		
		this.dtm=(DefaultTableModel) table.getModel();
		
		queryall();
	}

	
	public void queryall()
	{
		this.dtm.setRowCount(0);
		PaymentDao pydao=new PaymentDao();
		List<Payment> allList=pydao.queryAllpayment_p(this.id);
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
