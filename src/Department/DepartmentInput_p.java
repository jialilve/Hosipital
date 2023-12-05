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
import dao.DeparstDao;
import model.Deparment;
import model.Deparst;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepartmentInput_p extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm=null;
	private String Pid;
	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the frame.
	 */
	public DepartmentInput_p(String Pid)
	{
		this.Pid=Pid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 818, 393);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				 
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5C31\u8BCA\u65F6\u95F4", "\u79D1\u5BA4", "\u75C5\u4EBA\u7F16\u53F7", "\u75C5\u4EBA\u59D3\u540D", "\u63A5\u8BCA\u533B\u5E08"
			}
		));
		table.setBackground(new Color(200,210,210));
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		this.dtm=(DefaultTableModel) table.getModel();
		Queryall();

	}

	public void Queryall()
	{
		this.dtm.setRowCount(0);
		DeparstDao dedao=new DeparstDao();
		List<Deparst> allList=dedao.queryAlldest_p(this.Pid);
		for(Deparst st:allList)
		{
			Vector v=new Vector();
			v.add(st.getTime());
			v.add(st.getDename());
			v.add(st.getPid());
			v.add(st.getPname());
			v.add(st.getDoname());
			dtm.addRow(v);
		}
	}
	
}
