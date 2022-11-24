package QuanLyNhanVien;

import QuanLyNhanVien.NhanVien;

public class NhanVienPartTime extends NhanVien {
    private int soGioLam;
    private int soTangCa;


    public NhanVienPartTime(int id, String tenNv, int tuoi, String ngaySinh, String gioiTinh, int luongCoBan, int soGioLam, int soTangCa) {
        super(id, tenNv, tuoi, ngaySinh, gioiTinh, luongCoBan);
        this.soGioLam = soGioLam;
        this.soTangCa = soTangCa;
    }

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public int getSoTangCa() {
        return soTangCa;
    }

    public void setSoTangCa(int soTangCa) {
        this.soTangCa = soTangCa;
    }


    @Override
    public String toString() {
        return
                "Nhân viên part time: " + getTenNv() + ", có ID là: " + getId() + "\n" +
                        "Ngày sinh: " + getNgaySinh() + ", tuổi: " + getTuoi() + "\n" +
                        "giới tính: " + getGioiTinh() + ", có lương là: " +
                        (getSoGioLam() * getLuongCoBan() + (getSoTangCa() * 125 / 100)) + "\n"
                ;
    }
}
