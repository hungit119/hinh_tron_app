public class Hinh {
	private String ten;
	private String mausac;

	public Hinh() {
		super();
	}
	public Hinh(String ten, String mausac) {
		super();
		this.ten = ten;
		this.mausac = mausac;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMausac() {
		return mausac;
	}
	public void setMausac(String mausac) {
		this.mausac = mausac;
	}
	@Override
	public String toString() {
		return "Hinh [ten=" + ten + ", mausac=" + mausac + "]";
	}
	
}
