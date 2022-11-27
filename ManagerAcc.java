package account;

import main.Main;

import java.io.*;
import java.util.*;

public class ManagerAcc {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Account> danhSach = new HashMap<>();

    public void xuatRaFile() {
        File luuAccount = new File("account.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(luuAccount))) {
            for (Account account : danhSach.values()) {
                writer.write(account.getUsername());
                writer.write('\n');
                writer.write(account.getPassword());
                writer.write('\n');
            }
        } catch (IOException e) {
            System.out.println("Có lỗi lúc xuất file!");
            e.printStackTrace();
        }
    }

    public void docTuFile() {
        File luuAccount = new File("account.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(luuAccount))) {
            while (true) {
                String username = reader.readLine();
                String password = reader.readLine();
                if (username == null || password == null) break;
                Account account = new Account(username, password);
                danhSach.put(username, account);
            }
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra lúc đọc file!");
            e.printStackTrace();
        }
    }

    public void dangki(Account account1) {
        danhSach.put(account1.getUsername(), account1);
    }


    public Account taoTaiKhoan() {
        Account account1 = new Account();
        System.out.println("nhâp tài khoản");
        String username = scanner.nextLine();

        System.out.println("nhập mật khẩu");
        String password = scanner.nextLine();

        System.out.println("nhập lai mật khẩu");
        String password2 = scanner.nextLine();

        if (!password2.equals(password)) {
            System.out.println("Nhập sai mật khẩu");
        } else {

            if (danhSach.containsKey(username)) {
                System.out.println("tài khoản đã tồn tại");
            } else {
                account1 = new Account(username, password);
                System.out.println("Đăng ký thành công!");
            }
        }
        return account1;
    }

    public void edit() {
        int count = 0;

        System.out.println("Xin nhập username");
        String taiKhoan = scanner.nextLine();

        if (!danhSach.containsKey(taiKhoan)) {
            System.out.println("Nhập sai tên tài khoản rồi, dỗi! Dừng chương trình");
            System.exit(0);
        } else {

            while (true) {

                System.out.println("Nhập mật khẩu cũ");
                String matKhauCu = scanner.nextLine();

                if (matKhauCu.equals(danhSach.get(taiKhoan).getPassword())) {
                    System.out.println("Nhập mật khẩu moi");
                    String matKhauMoi = scanner.nextLine();
                    danhSach.get(taiKhoan).setPassword(matKhauMoi);
                    System.out.println("Đổi mật khẩu thành công");
                    return;
                } else {
                    System.out.println("Sai mật khẩu");
                    count++;
                }

                if (count == 3) {
                    System.out.println("Bạn đã nhập sai 3 lần, hệ thống tự động đóng.");
                    System.exit(0);
                }
            }
        }
    }

    public void dangNhap() {
        int count = 0;
        while (true) {

            System.out.println("Nhập vào tài khoản");
            String username = scanner.nextLine();
            System.out.println("nhập mật khẩu");
            String password = scanner.nextLine();
            Account bienPhu = danhSach.get(username);

            if (danhSach.containsKey(username)) {
                int count1 = 0;
                while (!password.equals(bienPhu.getPassword())) {
                    count1++;
                    System.out.println("sai mật khẩu, vui lòng nhập lại");
                    password = scanner.nextLine();
                    if (count1 == 3) {
                        System.out.println("Bạn đã nhập sai 3 lần, hệ thống tự động đóng");
                        System.exit(0);
                    }
                }
                System.out.println("Đăng nhập hệ thống thành công");
                Main.menuNhanVien();
            } else {
                System.out.println("tài khoản không tồn tại");
                count++;
                if (count == 3) {
                    System.out.println("Bạn đã nhập sai 3 lần, hệ thống tự động đóng");
                    System.exit(0);
                }
            }
        }
    }
}






