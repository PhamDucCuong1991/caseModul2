package QuanLyNhanVien;

import account.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QuanLyThemSuaXoa {
    static Scanner scanner = new Scanner(System.in);
    static List<NhanVien> arrNhanvien = new ArrayList<>();

    public void xuatRaFileNhanVien() {
        File luuNhanVienFull = new File("nhanVienFull.txt");
        File luuNhanVienPart = new File("nhanVienPart.txt");

        try (BufferedWriter full = new BufferedWriter(new FileWriter(luuNhanVienFull));
             BufferedWriter part = new BufferedWriter(new FileWriter(luuNhanVienPart))) {
            for (int i = 0; i < arrNhanvien.size(); i++) {
                if (arrNhanvien.get(i) instanceof NhanVienFullTime) {
                    full.write(arrNhanvien.get(i).getId() + "\n");
                    full.write(arrNhanvien.get(i).getTenNv() + "\n");
                    full.write(arrNhanvien.get(i).getTuoi() + "\n");
                    full.write(arrNhanvien.get(i).getNgaySinh() + "\n");
                    full.write(arrNhanvien.get(i).getGioiTinh() + "\n");
                    full.write(arrNhanvien.get(i).getLuongCoBan() + "\n");
                    full.write(((NhanVienFullTime) arrNhanvien.get(i)).getHeSo() + "\n");
                    full.write(((NhanVienFullTime) arrNhanvien.get(i)).getThamNien() + "\n");
                } else {
                    part.write(arrNhanvien.get(i).getId() + "\n");
                    part.write(arrNhanvien.get(i).getTenNv() + "\n");
                    part.write(arrNhanvien.get(i).getTuoi() + "\n");
                    part.write(arrNhanvien.get(i).getNgaySinh() + "\n");
                    part.write(arrNhanvien.get(i).getGioiTinh() + "\n");
                    part.write(arrNhanvien.get(i).getLuongCoBan() + "\n");
                    part.write(((NhanVienPartTime) arrNhanvien.get(i)).getSoGioLam() + "\n");
                    part.write(((NhanVienPartTime) arrNhanvien.get(i)).getSoTangCa() + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Có lỗi lúc xuất file!");
            e.printStackTrace();
        }
    }

    public void docTuFileNhanVienFull() {
        File luuNhanVien = new File("nhanVienFull.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(luuNhanVien))) {
            while (true) {
                int id;
                try {
                    id = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    break;
                }

                String tenNv = reader.readLine();
                int tuoi = Integer.parseInt(reader.readLine());
                String ngaySinh = reader.readLine();
                String gioiTinh = reader.readLine();
                int luongCoBan = Integer.parseInt(reader.readLine());
                int heSo = Integer.parseInt(reader.readLine());
                int thamNien = Integer.parseInt(reader.readLine());
                NhanVienFullTime nhanVienFullTime =
                        new NhanVienFullTime(id, tenNv, tuoi, ngaySinh, gioiTinh, luongCoBan, heSo, thamNien);
                arrNhanvien.add(nhanVienFullTime);
            }

        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra lúc đọc file!");
            e.printStackTrace();
        }
    }

    public void docTuFileNhanVienPart() {
        File luuNhanVien = new File("nhanVienPart.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(luuNhanVien))) {

            while (true) {
                int id;
                try {
                    id = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    break;
                }
                String tenNv = reader.readLine();
                int tuoi = Integer.parseInt(reader.readLine());
                String ngaySinh = reader.readLine();
                String gioiTinh = reader.readLine();
                int luongCoBan = Integer.parseInt(reader.readLine());

                int soGioLam = Integer.parseInt(reader.readLine());
                int soTangCa = Integer.parseInt(reader.readLine());
                NhanVienPartTime nhanVienPartTime =
                        new NhanVienPartTime(id, tenNv, tuoi, ngaySinh, gioiTinh, luongCoBan, soGioLam, soTangCa);
                arrNhanvien.add(nhanVienPartTime);
            }
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra lúc đọc file!");
            e.printStackTrace();
        }
    }

    public void edit() {
        System.out.println("Nhập ID nhân viên");

        int id;
        do {
            try {
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Phải nhập số!");
            }
        } while (true);

        NhanVien nhanVien = timKiem(id);
        if (nhanVien == null) {
            System.out.println("Không tìm thấy ID");
        } else {
            System.out.println("Sửa lại thành??? 1.FullTime? 2.PartTime?");

            int luaChon1;
            do {
                try {
                    luaChon1 = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập bằng số!");
                }
            } while (true);

            switch (luaChon1) {
                case 1:
                    arrNhanvien.set(arrNhanvien.indexOf(nhanVien), taoNhanVienFull());
                    break;
                case 2:
                    arrNhanvien.set(arrNhanvien.indexOf(nhanVien), taoNhanVienPart());
            }
        }
    }

    public NhanVien timKiem(int id) {

        for (int i = 0; i < arrNhanvien.size(); i++) {
            NhanVien nhanVien = arrNhanvien.get(i);
            if (id == nhanVien.getId()) {
                return nhanVien;
            }
        }
        return null;
    }

    public void add(NhanVien nhanVien) {
        arrNhanvien.add(nhanVien);
    }

    public void delete(int id) {
        arrNhanvien.remove(timKiem(id));
    }

    public NhanVienFullTime taoNhanVienFull() {


        System.out.println(" nhap ID(Dạng 1***)");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên nhân viên FullTime");
        String tenNv = scanner.nextLine();

        System.out.println("nhập tuổi");
        int tuoi = Integer.parseInt(scanner.nextLine());

        System.out.println("nhập ngày sinh");
        String ngaySinh = scanner.nextLine();

        System.out.println("nhập giới tính");
        String gioiTinh = scanner.nextLine();

        System.out.println("nhập mức lương");
        int luongCoBan = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập hệ số lương");
        int heSo = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập số năm kinh nghiệm");
        int thamNien = Integer.parseInt(scanner.nextLine());

        NhanVienFullTime nvFull = new NhanVienFullTime(id, tenNv, tuoi, ngaySinh, gioiTinh, luongCoBan, heSo, thamNien);
        return nvFull;

    }

    public NhanVienPartTime taoNhanVienPart() {

        System.out.println(" nhap ID(Dạng 2***)");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("nhap ten nhan vien part");
        String tenNv = scanner.nextLine();

        System.out.println("nhap tuoi");
        int tuoi = Integer.parseInt(scanner.nextLine());

        System.out.println("nhap ngay sinh");
        String ngaySinh = scanner.nextLine();

        System.out.println("nhap gioi tinh");
        String gioiTinh = scanner.nextLine();

        System.out.println("nhap muc luong ngay");
        int luongCoBan = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhap so gio lam");
        int soGioLam = Integer.parseInt(scanner.nextLine());

        System.out.println("So gio tang ca");
        int soTangCa = Integer.parseInt(scanner.nextLine());

        NhanVienPartTime nvPart = new NhanVienPartTime(id, tenNv, tuoi, ngaySinh, gioiTinh, luongCoBan, soGioLam, soTangCa);
        return nvPart;
    }

    public void show() {
        for (int i = 0; i < arrNhanvien.size(); i++) {
            System.out.println(arrNhanvien.get(i).toString());
        }
    }


//    public QuanLyNhanVien.NhanVien timNvLuongCaoNhat() {
//        ArrayList<QuanLyNhanVien.NhanVienFullTime> listFull = new ArrayList<>();
//        ArrayList<QuanLyNhanVien.NhanVienPartTime> listPart = new ArrayList<>();
//        for (int i = 0; i < arrNhanvien.size(); i++) {
//            if (arrNhanvien.get(i) instanceof QuanLyNhanVien.NhanVienFullTime){
//                listFull.add((QuanLyNhanVien.NhanVienFullTime) arrNhanvien.get(i));
//            }
//            else {
//                listPart.add((QuanLyNhanVien.NhanVienPartTime) arrNhanvien.get(i));
//            }
//
//        }
//        return timNvLuongCaoNhat();
//    }

    public void sapXepTheoTuoi() {
        arrNhanvien.sort(NhanVien::compareTo);
        System.out.println("Nhân viên có tuổi lớn nhất là: ");
        System.out.println(arrNhanvien.get(arrNhanvien.size() - 1).toString());
        System.out.println("Nhân viên có tuổi nhỏ nhất là: ");
        System.out.println(arrNhanvien.get(0).toString());
    }

}
