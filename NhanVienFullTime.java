package QuanLyNhanVien;

import QuanLyNhanVien.NhanVien;

public class NhanVienFullTime extends NhanVien {
   private int heSo;
    private  int thamNien;


    public NhanVienFullTime(int id, String tenNv, int tuoi, String ngaySinh, String gioiTinh, int luongCoBan, int heSo, int thamNien) {
        super(id, tenNv, tuoi, ngaySinh, gioiTinh, luongCoBan);
        this.heSo = heSo;
        this.thamNien = thamNien;
    }

    public int getHeSo() {
        return heSo;
    }

    public void setHeSo(int heSo) {
        this.heSo = heSo;
    }

    public int getThamNien() {
        return thamNien;
    }

    public void setThamNien(int thamNien) {
        this.thamNien = thamNien;
    }

    @Override
    public String toString() {
        return
                "Nhân viên  FullTime: " + getTenNv() + ", có ID là: " + getId() + "\n"+
                        "Ngày sinh: " + getNgaySinh() + ", tuổi: " + getTuoi() + "\n"+
                        "giới tính: " + getGioiTinh()+ ", có lương là: " + (getHeSo()*getLuongCoBan() + getThamNien()*300000) + "\n"
                       ;
    }
}
