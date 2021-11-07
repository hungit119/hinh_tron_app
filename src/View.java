import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class View extends JFrame {
	private JPanel topPanel;
	private JPanel botPanel;
	
	private JPanel pnTopLeft ;
	private JPanel pnTopRight;
	
	private JTextField txtTen;
	private JTextField txtMau;
	private JTextField txtr;
	private JTextField txtHienThiDienTich;
	
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnLoc;
	
	private Controller listHinh;

	private JList<String> jlist;
	private DefaultListModel<String> listModel;
	public View(){
		listHinh = new Controller();
		setTitle("Quan Li Hinh Tron");
		setSize(700, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		buildTop();
		buildBot();
		add(topPanel);
		add(botPanel);
		setVisible(true);
	}
	
	private void buildBot() {
		// TODO Auto-generated method stub
		botPanel =  new JPanel();
		JPanel pnList = new JPanel();
		listModel = new DefaultListModel<>();
		jlist = new JList<String>(listModel);
		jlist.setFixedCellHeight(13);
		jlist.setFixedCellWidth(600);
		jlist.setVisibleRowCount(15);
		
		JScrollPane scroll = new JScrollPane(jlist);
		
		pnList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red),"Danh sách hình tròn"));
		pnList.add(scroll);
		
		botPanel.add(pnList);
	}

	private void buildTop() {
		// TODO Auto-generated method stub
		topPanel = new JPanel(new BorderLayout());
		
		buildTopLeft();
		buildTopRight();
		topPanel.add(pnTopLeft,BorderLayout.CENTER);
		topPanel.add(pnTopRight,BorderLayout.EAST);
	}

	private void buildTopRight() {
		// TODO Auto-generated method stub
		pnTopRight = new JPanel();
		pnTopRight.setLayout(new FlowLayout());
		pnTopRight.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		JPanel pnBtnThem = new JPanel();
		JPanel pnBtnXoa = new JPanel();
		JPanel pnBtnLoc = new JPanel();
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new BtnThemClick());
		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new BtnXoaClick());
		btnLoc = new JButton("Lọc");
		btnLoc.addActionListener(new BtnLocClick());
		
		pnBtnThem.add(btnThem);
		pnBtnXoa.add(btnXoa);
		pnBtnLoc.add(btnLoc);
		
		pnTopRight.add(pnBtnThem);
		pnTopRight.add(pnBtnXoa);
		pnTopRight.add(pnBtnLoc);
	}

	private void buildTopLeft() {
		// TODO Auto-generated method stub
		pnTopLeft = new JPanel(new GridLayout(4,1));
		pnTopLeft.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		JPanel pnTen = new JPanel(new BorderLayout());
		JPanel pnlbTen = new JPanel();
		JPanel pntxtTen = new JPanel();
		
		JLabel lbTen = new JLabel("Tên:");
		txtTen = new JTextField(30);
		
		pnlbTen.add(lbTen);
		pntxtTen.add(txtTen);
		
		pnTen.add(pnlbTen,BorderLayout.WEST);
		pnTen.add(pntxtTen,BorderLayout.EAST);
		
		JPanel pnMau= new JPanel(new BorderLayout());
		
		JPanel pnlbMau = new JPanel();
		JPanel pntxtMau = new JPanel();
		
		JLabel lbMau = new JLabel("Màu:");
		txtMau = new JTextField(30);
		
		pnlbMau.add(lbMau);
		pntxtMau.add(txtMau);
		
		pnMau.add(pnlbMau,BorderLayout.WEST);
		pnMau.add(pntxtMau,BorderLayout.EAST);
		
		JPanel pnR = new JPanel(new BorderLayout());
		JPanel pnlbR = new JPanel();
		JPanel pntxtR = new JPanel();
		
		JLabel lbR = new JLabel("Bán kính:");
		txtr = new JTextField(30);
		
		pnlbR.add(lbR);
		pntxtR.add(txtr);
		
		pnR.add(pnlbR,BorderLayout.WEST);
		pnR.add(pntxtR,BorderLayout.EAST);
		
		JPanel pnDienTich =new JPanel(new BorderLayout());
		JPanel pnLbDienTich = new JPanel();
		JPanel pntxtDienTich =new JPanel();
		
		JLabel lbDienTich=new JLabel("Diện tích:");
		txtHienThiDienTich = new JTextField(15);
		txtHienThiDienTich.setEditable(false);
		
		pnDienTich.add(pnLbDienTich.add(lbDienTich),BorderLayout.WEST);
		pnDienTich.add(pntxtDienTich.add(txtHienThiDienTich),BorderLayout.EAST);
		
		pnTopLeft.add(pnTen);
		pnTopLeft.add(pnMau);
		pnTopLeft.add(pnR);
		pnTopLeft.add(pnDienTich);
	}

	public class BtnThemClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			if (txtTen.getText() == "" || txtMau.getText() == "" || txtr.getText() == "") {
				JOptionPane.showMessageDialog(null, "Phải nhập đủ các trường");
			}
			else {
				HinhTron ht = new HinhTron();
				ht.setTen(txtTen.getText());
				ht.setMausac(txtMau.getText());
				ht.setBanKinh(Float.parseFloat(txtr.getText()));
				ht.setDienTich((float)(Math.PI * Math.pow(ht.getBanKinh(), 2)));
				
				listHinh.themHinhTron(ht);
				listModel.addElement(ht.toString());
				txtHienThiDienTich.setText(Float.toString(ht.getDienTich()));
				
				txtTen.setText("");
				txtMau.setText("");
				txtr.setText("");
			}
		}
		
	}
	public class BtnXoaClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int index = Integer.parseInt(JOptionPane.showInputDialog(null,"Nhập vị trị cần xóa trên danh sách:"));
			listHinh.delete(index);
			listModel.remove(index);
		}
		
	}
	public class BtnLocClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			listHinh.locHinhTron();
			JOptionPane.showMessageDialog(null, "Đã lưu danh sách các hình có diện tích lớn hơn 100");
		}
		
	}
	public static void main(String[] args) {
		new View();
	}
	
}
