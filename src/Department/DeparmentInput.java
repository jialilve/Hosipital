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

public class DeparmentInput extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField time1;
	private JTextField time2;
	private DefaultTableModel dtm=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeparmentInput frame = new DeparmentInput();
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
	public DeparmentInput() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 540);
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
		
		JLabel lblNewLabel = new JLabel("\u65F6\u95F4\u4E00");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 447, 77, 15);
		contentPane.add(lblNewLabel);
		
		time1 = new JTextField();
		time1.setBounds(107, 444, 66, 21);
		contentPane.add(time1);
		time1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u65F6\u95F4\u4E8C");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(211, 447, 66, 18);
		contentPane.add(lblNewLabel_1);
		
		time2 = new JTextField();
		time2.setBounds(298, 447, 66, 21);
		contentPane.add(time2);
		time2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				querysome(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(580, 446, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(716, 446, 93, 23);
		contentPane.add(btnNewButton_1);
		this.dtm=(DefaultTableModel) table.getModel();
		Queryall();

	}
	protected void resetButton(ActionEvent e) {
		// TODO Auto-generated method stub
		this.time1.setText("");
		this.time2.setText("");
		Queryall();
	}

	public void querysome(ActionEvent e) {
		// TODO Auto-generated method stub
		String time1=this.time1.getText();
		String time2=this.time2.getText();
		
		
		this.dtm.setRowCount(0);
		DeparstDao dedao=new DeparstDao();
		List<Deparst> allList=dedao.querysomedest(time1, time2);
		for(Deparst st:allList)
		{
			Vector v=new Vector();
			v.add(st.getTime());
			v.add(st.getDename());
			v.add(st.getPid());
			v.add(st.getPname());
			v.add(st.getDoname());
          //  System.out.println(v);
			dtm.addRow(v); 
		}
	}

	public void Queryall()
	{
		this.dtm.setRowCount(0);
		DeparstDao dedao=new DeparstDao();
		List<Deparst> allList=dedao.queryAlldest();
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
