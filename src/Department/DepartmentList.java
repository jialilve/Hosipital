package Department;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DeparmentDao;
import dao.PatientDao;
import model.Deparment;
import model.Patient;
import patient.addPatient;
import view.Indexframe;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class DepartmentList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	protected Object ae;
	private DefaultTableModel dtm=null;
	private JButton editButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentList frame = new DepartmentList();
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
	public DepartmentList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 823, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 789, 392);
	 
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
				mouseclick(ae);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u79D1\u5BA4\u7F16\u53F7", "\u79D1\u5BA4\u540D", "\u79D1\u5BA4\u533B\u5E08\u6570\u91CF", "\u79D1\u5BA4\u63CF\u8FF0"
			}
		));
		table.setBackground(new Color(200,210,210));
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(181);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u79D1\u5BA4\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 434, 89, 27);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(121, 434, 82, 27);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton queryButton = new JButton("\u641C\u7D22");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				querysome(e);
			}
		});
		queryButton.setFont(new Font("华文楷体", Font.PLAIN, 21));
		queryButton.setBounds(274, 434, 93, 28);
		contentPane.add(queryButton);
		
		editButton = new JButton("\u7F16\u8F91");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editButton(e);
			}
		});
		editButton.setFont(new Font("华文楷体", Font.PLAIN, 21));
		editButton.setBounds(416, 434, 93, 28);
		contentPane.add(editButton);
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});
		resetButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		resetButton.setBounds(571, 434, 93, 27);
		contentPane.add(resetButton);
		
		this.dtm=(DefaultTableModel) table.getModel();
		QueryAlldepartment();
	}
    
	 
	protected void editButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		Deparment de=new Deparment();
		de.setId(dtm.getValueAt(this.table.getSelectedRow(), 0).toString());
		de.setName(dtm.getValueAt(this.table.getSelectedRow(), 1).toString());
		de.setSum((int) dtm.getValueAt(this.table.getSelectedRow(), 2));
		de.setText(dtm.getValueAt(this.table.getSelectedRow(), 3).toString());
		EditDepartment depar=new EditDepartment();
		//System.out.println(de.getSum());
		depar.editDe(de);
		depar.setVisible(true);
		QueryAlldepartment();
	}

	protected void resetButton(ActionEvent e) {
		// TODO Auto-generated method stub
		this.id.setText("");
	}

	protected void querysome(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=this.id.getText();
		this.dtm.setRowCount(0);
		DeparmentDao dedao=new DeparmentDao();
		List<Deparment> allList=dedao.querysomedeparment(id);
		for(Deparment st:allList)
		{
			Vector v=new Vector();
			v.add(st.getId());
			v.add(st.getName());
			v.add(st.getSum());
			v.add(st.getText());
			dtm.addRow(v);
		}
	 
	}

	protected void mouseclick(MouseEvent ae2) {
		// TODO Auto-generated method stub
		this.id.setText(dtm.getValueAt(this.table.getSelectedRow(), 0).toString());
		this.editButton.setEnabled(true);
	//	this.deleteButton.setEnabled(true);
	}

	public void QueryAlldepartment()
	{
			this.dtm.setRowCount(0);
			DeparmentDao dedao=new DeparmentDao();
			List<Deparment> allList=dedao.queryAlldeparment();
			for(Deparment st:allList)
			{
				Vector v=new Vector();
				v.add(st.getId());
				v.add(st.getName());
				v.add(st.getSum());
				v.add(st.getText());
				dtm.addRow(v);
			}
			this.editButton.setEnabled(false);
		//	this.deleteButton.setEnabled(false);
	}
	 
}
