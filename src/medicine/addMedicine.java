package medicine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.MedicineDao;
import model.Medicine;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addMedicine extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField price;
	private JTextField firm;
	private JTextField type;
	private JTextField waid;
	private JTextField price1;
	private JTextField sum;
    private Medicine mme=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMedicine frame = new addMedicine();
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
	public addMedicine() {
		setTitle("\u6B63\u5728\u6DFB\u52A0\u836F\u54C1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 458, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u7F16\u53F7");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 22, 98, 18);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(118, 19, 66, 21);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u836F\u54C1\u540D");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(246, 22, 73, 18);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(329, 19, 66, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u552E  \u4EF7");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(25, 73, 58, 24);
		contentPane.add(lblNewLabel_2);
		
		price = new JTextField();
		price.setBounds(118, 76, 66, 21);
		contentPane.add(price);
		price.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5382\u5546");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(246, 78, 73, 19);
		contentPane.add(lblNewLabel_3);
		
		firm = new JTextField();
		firm.setBounds(329, 78, 66, 21);
		contentPane.add(firm);
		firm.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7C7B  \u578B");
		lblNewLabel_4.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(25, 145, 54, 21);
		contentPane.add(lblNewLabel_4);
		
		type = new JTextField();
		type.setBounds(118, 145, 66, 21);
		contentPane.add(type);
		type.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u4ED3\u5E93\u7F16\u53F7");
		lblNewLabel_5.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(231, 145, 88, 18);
		contentPane.add(lblNewLabel_5);
		
		waid = new JTextField();
		waid.setBounds(329, 145, 66, 21);
		contentPane.add(waid);
		waid.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u8FDB  \u4EF7");
		lblNewLabel_6.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(25, 222, 58, 21);
		contentPane.add(lblNewLabel_6);
		
		price1 = new JTextField();
		price1.setBounds(118, 222, 66, 21);
		contentPane.add(price1);
		price1.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u5E93\u5B58\u6570\u91CF");
		lblNewLabel_7.setFont(new Font("华文楷体", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(231, 222, 88, 21);
		contentPane.add(lblNewLabel_7);
		
		sum = new JTextField();
		sum.setBounds(329, 222, 66, 21);
		contentPane.add(sum);
		sum.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton(e);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(84, 320, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(255, 320, 98, 23);
		contentPane.add(btnNewButton_1);
	}
    protected void resetButton(ActionEvent e) {
		// TODO Auto-generated method stub
    	this.id.setText("");
        this.name.setText("");
        this.firm.setText("");
        this.price.setText("");
        this.price1.setText("");
        this.sum.setText("");
        this.type.setText("");
        this.waid.setText("");
		this.mme=null;
	}

	public void editMedicne(Medicine me)
    {
    	setTitle("正在编辑药品信息");
        this.mme=me;
        this.id.setText(me.getMeid());
        this.name.setText(me.getMename());
        this.firm.setText(me.getFirm());
        this.price.setText(String.valueOf(me.getPrice()));
        this.price1.setText(String.valueOf(me.getPrice1()));
        this.sum.setText(String.valueOf(me.getSnumber()));
        this.type.setText(me.getType());
        this.waid.setText(me.getWaid());
    }
	protected void addButton(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String id=this.id.getText();
		String name=this.name.getText();
		float price=Float.parseFloat(this.price.getText());
		String firm=this.firm.getText();
		String type=this.type.getText();
		String waid=this.waid.getText();
		float price1=Float.parseFloat(this.price1.getText());
		int sum=Integer.parseInt(this.sum.getText());
		Medicine t=new Medicine(id,name,price,firm,type,waid,price1,sum);
		MedicineDao me=new MedicineDao();
		if(this.mme==null)
	    {
	    	JOptionPane.showMessageDialog(this,me.addMedicine(t));
	    }
	    else
	    {
	    	JOptionPane.showMessageDialog(this,me.editMedicine(t));
	    }
	}

}
