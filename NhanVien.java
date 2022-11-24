package QuanLyNhanVien;

public class NhanVien implements Comparable<NhanVien> {

    private int id;
    private String tenNv;
    private int tuoi;
    private String ngaySinh;
    private String gioiTinh;
    private int luongCoBan;

    public NhanVien() {}

    public NhanVien(int id, String tenNv, int tuoi, String ngaySinh, String gioiTinh, int luongCoBan) {
        this.id = id;
        this.tenNv = tenNv;
        this.tuoi = tuoi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.luongCoBan = luongCoBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(int luongCoBan) {
        this.luongCoBan = luongCoBan;
    }


    @Override
    public int compareTo(NhanVien o) {
        if (this.tuoi > o.getTuoi()){
            return 1;
        }
        else if (this.tuoi < o.getTuoi()) {
            return  -1;
        }
        else {
            return 0;
        }
    }

//    public double compareToLuong(NhanVien o){
//        if ((NhanVienFullTime.getHeSo()*getLuongCoBan() + NhanVienFullTime.getThamNien()*300000))
//    }

}
