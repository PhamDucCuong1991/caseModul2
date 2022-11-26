package main;

import QuanLyNhanVien.NhanVien;
import account.Account;
import account.ManagerAcc;
import QuanLyNhanVien.QuanLyThemSuaXoa;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ManagerAcc managerAcc = new ManagerAcc();
        managerAcc.docTuFile();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Đăng nhập");
            System.out.println("2.Đăng kí");
            System.out.println("3.Đổi mật khẩu");
            System.out.println("4.Thoát chương trình");

            int choice;
            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số!");
                }
            } while (true);

            switch (choice) {
                case 1:
                    managerAcc.dangNhap();
                    break;
                case 2:
                    Account account1 = managerAcc.taoTaiKhoan();
                    managerAcc.dangki(account1);
                    break;
                case 3:
                    managerAcc.edit();
                    break;
                case 4:
                    managerAcc.xuatRaFile();
                    return;
                default:
                    System.out.println("Không có chức năng, hãy nhập lại");
            }
        }

    }

    public static void menuNhanVien() {
        Scanner scanner = new Scanner(System.in);
        QuanLyThemSuaXoa quanLyThemSuaXoa = new QuanLyThemSuaXoa();
        ManagerAcc managerAcc = new ManagerAcc();
        quanLyThemSuaXoa.docTuFileNhanVienFull();
        quanLyThemSuaXoa.docTuFileNhanVienPart();
        while (true) {
            int id;
            System.out.println("<<-------------MENU--------------->>");
            System.out.println("1. Tạo mới nhân viên: ");
            System.out.println("2. Hiển thị danh sách ");
            System.out.println("3. Sửa nhân viên: ");
            System.out.println("4. Xóa nhân viên: ");
            System.out.println("5. Tìm kiếm nv theo ID: ");
            System.out.println("6. Hiển thị nhân viên có lương cao nhất: ");
            System.out.println("7. Sắp xếp nhân viên theo thứ tự: ");
            System.out.println("8. Thoát trình quản lý nhân viên");
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
                    System.out.println("Nhập kiểm tra ID có tồn tại hay không?");
                    id = Integer.parseInt(scanner.nextLine());
                    if (quanLyThemSuaXoa.timKiem(id) != null) {
                        System.out.println("ID đã tồn tại");
                        break;
                    } else {
                        System.out.println("ID chưa tồn tại, bạn có thể tạo bằng ID này");
                        System.out.println("Nhập kiểu nhân viên: 1.FullTime; 2.PartTime");
                        int luaChon2;
                        do {
                            try {
                                luaChon2 = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (InputMismatchException | NumberFormatException e) {
                                System.out.println("Phải nhập bằng số!");
                            }
                        } while (true);

                        switch (luaChon2) {
                            case 1:
                                quanLyThemSuaXoa.add(quanLyThemSuaXoa.taoNhanVienFull());
                                quanLyThemSuaXoa.xuatRaFileNhanVien();
                                System.out.println("Tạo nhân viên fulltime thành công!");
                                break;
                            case 2:
                                quanLyThemSuaXoa.add(quanLyThemSuaXoa.taoNhanVienPart());
                                quanLyThemSuaXoa.xuatRaFileNhanVien();
                                System.out.println("Tạo nhân viên parttime thành công!");
                                break;
                            default:
                                System.out.println("Không có chức năng này");
                        }

                    }
                    break;

                case 2:
                    System.out.println("1. Danh sách toàn bộ nhân viên");
                    System.out.println("2. Danh sách nhân viên FullTime");
                    System.out.println("3. Danh sách nhân viên PartTime");
                    int luaChon3;
                    do {
                        try {
                            luaChon3 = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (InputMismatchException | NumberFormatException e) {
                            System.out.println("Phải nhập bằng số!");
                        }
                    } while (true);

                    switch (luaChon3) {
                        case 1:
                            quanLyThemSuaXoa.show();
                            break;
                        case 2:
                            quanLyThemSuaXoa.showNvFull();
                            break;
                        case 3:
                            quanLyThemSuaXoa.showNvPart();
                            break;
                        default:
                            System.out.println("Không có lựa chọn này");
                    }
                    break;

                case 3:
                    System.out.println("1. Sửa toàn bộ thông tin");
                    System.out.println("2. Sửa thuộc tính");
                    int chonSua = Integer.parseInt(scanner.nextLine());
                    switch (chonSua) {
                        case 1:
                            quanLyThemSuaXoa.edit();
                            quanLyThemSuaXoa.xuatRaFileNhanVien();
                            break;
                        case 2:
                            System.out.println("Nhập ID muốn sửa");
                            id = Integer.parseInt(scanner.nextLine());
                            if (quanLyThemSuaXoa.timKiem(id) == null) {
                                System.out.println("ID ko ton tai");
                                break;
                            } else {
                                System.out.println(quanLyThemSuaXoa.timKiem(id));
                                System.out.println("Mời nhập thuộc tính cần sửa: ");
                                System.out.println("1. Sửa ID");
                                System.out.println("2. Sửa tên");
                                System.out.println("3. Sửa tuổi");
                                System.out.println("4. Ngày sinh");
                                System.out.println("5. Giới tính");
                                System.out.println("6. Lương cơ bản");
                                int chonSuaThuocTinh;
                                do {
                                    try {
                                        chonSuaThuocTinh = Integer.parseInt(scanner.nextLine());
                                        break;
                                    } catch (InputMismatchException | NumberFormatException e) {
                                        System.out.println("Phải nhập bằng số!");
                                    }
                                } while (true);

                                switch (chonSuaThuocTinh) {
                                    case 1:
                                        System.out.println("Nhập ID mới");
                                        int idMoi = Integer.parseInt(scanner.nextLine());
                                        quanLyThemSuaXoa.timKiem(id).setId(idMoi);
                                        System.out.println("Thay đổi thành công, bạn cần thoát chương trình để lưu lại");
                                        break;
                                    case 2:
                                        System.out.println("Nhập tên mới");
                                        String tenMoi = scanner.nextLine();
                                        quanLyThemSuaXoa.timKiem(id).setTenNv(tenMoi);
                                        System.out.println("Thay đổi thành công, bạn cần thoát chương trình để lưu lại");
                                        break;
                                    case 3:
                                        System.out.println("Nhập tuổi");
                                        int tuoiMoi = Integer.parseInt(scanner.nextLine());
                                        quanLyThemSuaXoa.timKiem(id).setTuoi(tuoiMoi);
                                        System.out.println("Thay đổi thành công, bạn cần thoát chương trình để lưu lại");
                                        break;
                                    case 4:
                                        System.out.println("Nhập ngày sinh");
                                        String ngaySinhMoi = scanner.nextLine();
                                        quanLyThemSuaXoa.timKiem(id).setNgaySinh(ngaySinhMoi);
                                        System.out.println("Thay đổi thành công, bạn cần thoát chương trình để lưu lại");
                                        break;
                                    case 5:
                                        System.out.println("Nhập giới tính");
                                        String gioiTinhMoi = scanner.nextLine();
                                        quanLyThemSuaXoa.timKiem(id).setGioiTinh(gioiTinhMoi);
                                        System.out.println("Thay đổi thành công, bạn cần thoát chương trình để lưu lại");
                                        break;
                                    case 6:
                                        System.out.println("Nhập mức lương mới");
                                        int luongMoi = Integer.parseInt(scanner.nextLine());
                                        quanLyThemSuaXoa.timKiem(id).setLuongCoBan(luongMoi);
                                        System.out.println("Thay đổi thành công, bạn cần thoát chương trình để lưu lại");
                                        break;
                                    default:
                                        System.out.println("Không có chức năng này");
                                        break;
                                }
                                break;

                            }
                        default:
                            System.out.println("Không có chức năng này");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Để xóa bạn cần xác nhận: ");
                    System.out.println("1. Xác nhận xóa");
                    System.out.println("2. Hủy, trở về");
                    int choice;
                    do {
                        try {
                            choice = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (InputMismatchException | NumberFormatException e) {
                            System.out.println("Phải nhập bằng số!");
                        }
                    } while (true);
                    switch (choice) {
                        case 1:
                            System.out.println("Nhập ID cần xóa");
                            quanLyThemSuaXoa.delete(Integer.parseInt(scanner.nextLine()));
                            quanLyThemSuaXoa.xuatRaFileNhanVien();
                            System.out.println("Thao tác xóa thành công!");
                            break;
                        case 2:
                            System.out.println("Bạn đã hủy! Trở về");
                            break;
                        default:
                            System.out.println("Không có chức năng này");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("nhập ID cần tìm");
                    System.out.println(quanLyThemSuaXoa.timKiem(Integer.parseInt(scanner.nextLine())));
                    break;
                case 6:
                    System.out.println("Nhân viên FullTime có lương cao nhất là");
                    System.out.println(quanLyThemSuaXoa.nvFullLuongCaoNhat());
                    System.out.println("Nhân viên PartTime có lương cao nhất là");
                    System.out.println(quanLyThemSuaXoa.nvPartLuongCaoNhat());
                    break;
                case 7:
                    quanLyThemSuaXoa.sapXepTheoTuoi();
                    break;
                case 8:
                    quanLyThemSuaXoa.xuatRaFileNhanVien();
                    managerAcc.xuatRaFile();
                    System.exit(0);
                default:
                    System.out.println("Không có chức năng, hãy nhập lại");
                    break;
            }
        }
    }
}


