package warehouse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.PatientDao;
import dao.WareDao;
import model.Patient;
import model.Store;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public int lid;
	private DefaultTableModel dtm=null;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public StoreList(int lid) 
	{
		this.lid=lid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 766, 310);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(200,210,210));
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4ED3\u5E93\u7F16\u53F7", "\u836F\u54C1\u7F16\u53F7", "\u836F\u54C1\u540D", "\u6570\u91CF", "\u4ED3\u5E93\u8D1F\u8D23\u4EBA"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(98);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				querybutton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 19));
		btnNewButton.setBounds(348, 362, 93, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				addButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(497, 362, 93, 26);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(638, 365, 93, 23);
		contentPane.add(btnNewButton_2);
		
		this.dtm=(DefaultTableModel) table.getModel();
		QueryAll(this.lid);
	}
	protected void querybutton(ActionEvent e) {
		// TODO Auto-generated method stub
		QueryAll(this.lid);
	}
	protected void addButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	    addStore as=new addStore(this.lid);
	    as.setVisible(true);
	}
    
	public void QueryAll(int lid)
	{
		    
			this.dtm.setRowCount(0);
			WareDao waredao=new WareDao();
			System.out.println(lid+"List");
			List<Store> allList=waredao.queryAll(lid);
			for(Store st:allList)
			{
				Vector v=new Vector();
				v.add(st.getWaid());
				v.add(st.getMeid());
				v.add(st.getName());
				v.add(st.getSum());
				v.add(st.getPerson());
				dtm.addRow(v);
			}
			//this.editButton.setEnabled(false);
			//this.deleteButton.setEnabled(false);
	}

	public int getLid() 
	{
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}
	
}
