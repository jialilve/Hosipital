package rx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.MedicineDao;
import medicine.addMedicine;
import model.Medicine;

public class SetRXList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField firm;
	private JTextField type;
	private DefaultTableModel dtm=null;
	private String Doid;

	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public SetRXList(String Doid) {
		this.Doid=Doid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 858, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 824, 398);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(200,210,210));
		table.getTableHeader().setReorderingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				selectRow(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u836F\u54C1\u7F16\u53F7", "\u836F\u54C1\u540D\u79F0", "\u552E\u4EF7", "\u751F\u4EA7\u5382\u5BB6", "\u836F\u54C1\u7C7B\u578B", "\u5B58\u653E\u4ED3\u5E93", "\u8FDB\u4EF7", "\u5E93\u5B58\u6570\u91CF"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u540D\u79F0");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 435, 77, 22);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(106, 439, 77, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u751F\u4EA7\u5382\u5BB6");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(10, 493, 77, 22);
		contentPane.add(lblNewLabel_1);
		
		firm = new JTextField();
		firm.setBounds(106, 497, 77, 21);
		contentPane.add(firm);
		firm.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7C7B\u578B");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(214, 435, 54, 25);
		contentPane.add(lblNewLabel_2);
		
		type = new JTextField();
		type.setBounds(278, 439, 88, 21);
		contentPane.add(type);
		type.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				querysome();
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 19));
		btnNewButton.setBounds(456, 438, 109, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u5904\u65B9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(456, 493, 109, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("\u91CD\u7F6E");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});
		btnNewButton_3.setFont(new Font("华文楷体", Font.PLAIN, 19));
		btnNewButton_3.setBounds(631, 438, 100, 22);
		contentPane.add(btnNewButton_3);
		
        this.dtm=(DefaultTableModel) table.getModel();
		
		QueryAll();
	}
    protected void addButton(ActionEvent e) {
		// TODO Auto-generated method stub
		AddRx ax=new AddRx(this.Doid);
		ax.setVisible(true);
	}

	protected void resetButton(ActionEvent e) {
		// TODO Auto-generated method stub
		this.firm.setText("");
		this.name.setText("");
		this.type.setText("");
	}

	public void QueryAll()
    {
    	this.dtm.setRowCount(0);
		MedicineDao me=new MedicineDao();
		List<Medicine> allList=me.queryAllmedicine();
		for(Medicine st:allList)
		{
			Vector v=new Vector();
			v.add(st.getMeid());
			v.add(st.getMename());
			v.add(st.getPrice());
			v.add(st.getFirm());
			v.add(st.getType());
			v.add(st.getWaid());
			v.add(st.getPrice1());
			v.add(st.getSnumber());
			dtm.addRow(v);
		}
    }
	protected void querysome() {
		// TODO Auto-generated method stub
		String name=this.name.getText();
		String firm=this.firm.getText();
		String type=this.type.getText();
		
		this.dtm.setRowCount(0);
	    MedicineDao me=new MedicineDao();
		List<Medicine> allList=me.querysomeMedicine(name,firm,type);
		for(Medicine st:allList)
		{
			Vector v=new Vector();
			v.add(st.getMeid());
			v.add(st.getMename());
			v.add(st.getPrice());
			v.add(st.getFirm());
			v.add(st.getType());
			v.add(st.getWaid());
			v.add(st.getPrice1());
			v.add(st.getSnumber());
			dtm.addRow(v);
		}
	}

	protected void selectRow(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	}

