package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DeparstDao;
import dao.MedicineDao;
import model.Doctor;
import model.dest1;
import model.mest1;

import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.data.category.DefaultCategoryDataset;

public class destframe extends JFrame {

	private JPanel contentPane;
	private JTextField date1;
	private JTextField date2;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel dtm=null;
	private DefaultTableModel dtm1=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					destframe frame = new destframe();
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
	public destframe() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F00\u59CB\u65E5\u671F");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(29, 31, 108, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\u7ED3\u675F\u65E5\u671F");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(282, 39, 113, 23);
		contentPane.add(lblNewLabel);
		
		date1 = new JTextField();
		date1.setBounds(133, 43, 133, 21);
		contentPane.add(date1);
		date1.setColumns(10);
		
		date2 = new JTextField();
		date2.setBounds(379, 43, 141, 21);
		contentPane.add(date2);
		date2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				querybutton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.setBounds(560, 43, 93, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(143, 79, 367, 152);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(200,210,210));
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u79D1\u5BA4", "\u5C31\u8BCA\u4EBA\u6570"
			}
		));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(133, 304, 385, 162);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(200,210,210));
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u836F\u7269\u540D\u79F0", "\u6570\u91CF"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u836F\u7269\u6570\u91CF\u8868");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(274, 260, 236, 23);
		contentPane.add(lblNewLabel_2);
		
		 this.dtm=(DefaultTableModel) table.getModel();
		 this.dtm1=(DefaultTableModel) table_1.getModel();
		 
		 queryall();
	}

	protected void querybutton(ActionEvent e) {
		// TODO Auto-generated method stub
		DeparstDao dd=new DeparstDao();
	    List<dest1> allList=dd.queryAlldest1(this.date1.getText(),this.date2.getText());
		for(dest1 st:allList)
		{
			Vector v=new Vector();
			v.add(st.getName());
			v.add(st.getSum());
			dtm.addRow(v);
		}
	}
	protected void queryall()
	{
		MedicineDao md=new MedicineDao();
		List<mest1> allList=md.queryAllMedicine();
		for(mest1 st:allList)
		{
			Vector v=new Vector();
			v.add(st.getName());
			v.add(st.getSum());
			dtm1.addRow(v);
		}
	}
}
