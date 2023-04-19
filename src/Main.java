import Controller.Manager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        while (true) {
            System.out.println("=============Menu==========");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Exit");
            int next = 0;
            while (next < 1 || next > 8) {
                try {
                    next = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Sai định dạng mời nhập lại!");

                }
            }
            switch (next) {

                case 1: {
                    manager.show();
                    break;
                }
                case 2: {
                    manager.create();
                    break;
                }
                case 3: {
                    manager.update();
                    break;
                }
                case 4: {
                    manager.delete();
                    break;
                }
                case 5: {
                    manager.search();
                    break;
                }
                case 6: {
                    break;
                }
            }
        }
    }
}