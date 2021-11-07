
public class HinhTron extends Hinh {
	private float banKinh;
	private float dienTich;
	public HinhTron() {
		super();
	}
	public HinhTron(float banKinh, float dienTich) {
		super();
		this.banKinh = banKinh;
		this.dienTich = dienTich;
	}
	public float getBanKinh() {
		return banKinh;
	}
	public void setBanKinh(float banKinh) {
		this.banKinh = banKinh;
	}
	public float getDienTich() {
		return dienTich;
	}
	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}
	@Override
	public String toString() {
		return "HinhTron [banKinh=" + banKinh + ", dienTich=" + dienTich + "]";
	}
	
	
}
