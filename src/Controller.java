import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controller {
	private ArrayList<HinhTron> listHinhTron;
	private PrintWriter print;

	public Controller() {
		this.listHinhTron = new ArrayList<HinhTron>();
	}

	public ArrayList<HinhTron> getListHinhTron() {
		return listHinhTron;
	}

	public void setListHinhTron(ArrayList<HinhTron> listHinhTron) {
		this.listHinhTron = listHinhTron;
	}
	
	public void themHinhTron(HinhTron ht) {
		this.listHinhTron.add(ht);
	}
	public void hienThiDanhSach() {
		for (int i = 0; i < this.listHinhTron.size(); i++) {
			System.out.println(this.listHinhTron.get(i).toString());
		}
	}
	public void delete(int index) {
		this.listHinhTron.remove(index);
	}
	public void locHinhTron() {
		ArrayList<HinhTron> listNewHinh = new ArrayList<HinhTron>();
		for (int i = 0; i < this.listHinhTron.size(); i++) {
			if (this.listHinhTron.get(i).getDienTich() > 100) {
				listNewHinh.add(this.listHinhTron.get(i));
			}
		}
		try {
			print = new PrintWriter("dscachinh.txt");
			for (int i = 0; i < listNewHinh.size(); i++) {
				print.println(listNewHinh.get(i).toString());
			}
			print.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
