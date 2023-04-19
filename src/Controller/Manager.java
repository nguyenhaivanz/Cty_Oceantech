package Controller;

import IO.IOWirteVsRead;
import Model.Academic;
import Model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Manager {
    Student student = new Student();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> students = IOWirteVsRead.read();

    public String inputName(Scanner scanner) {
        boolean check = true;
        String result = null;
        while (check) {
            System.out.println("Nhập tên của sinh viên: ");
            String name = scanner.next();
            scanner.nextLine();
            if (Validate.validateName(name)) {
                check = false;
                result = name;
            } else {
                System.err.println("Tên không hợp lệ.");
            }
        }
        return result;
    }


    public LocalDate inputDate(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Validate.dateFormart);
        LocalDate dateOfBirth = null;
        boolean isValid = false;
        String input = "";
        while (!isValid) {
            System.out.println("Nhập ngày sinh (" + Validate.dateFormart + "): ");
            input = scanner.nextLine();
            if (Validate.validateDate(input)) {
                try {
                    dateOfBirth = LocalDate.parse(input, formatter);
                    isValid = true;
                } catch (DateTimeParseException e) {
                    System.err.println("Lỗi: " + e.getMessage());
                }
            } else {
                System.err.println("Sai định dạng.");
            }
        }
        return dateOfBirth;
    }


    public String inputAddress(Scanner scanner) {
        boolean check = true;
        String result = null;
        while (check) {
            System.out.println("Nhập địa chỉ của sinh viên: ");
            String address = scanner.next();
            scanner.nextLine();
            if (Validate.validateAddress(address)) {
                check = false;
                result = address;
            } else {
                System.err.println("Nhập sai định dạng địa chỉ!");
            }
        }
        return result;
    }

    public int inputHeight(Scanner scanner) {
        boolean check = true;
        int result = 0;
        while (check) {
            System.out.println("Nhập chiều cao của sinh viên (đơn vị cm): ");
            String input = scanner.nextLine();
            if (Validate.validateHeight(input)) {
                result = Integer.parseInt(input);
                check = false;
            } else {
                System.err.println("Chiều cao không hợp lệ.");
            }
        }
        return result;
    }

    public Double inputWeight(Scanner scanner) {
        boolean check = true;
        Double result = 0.0;
        while (check) {
            System.out.println("Nhập cân nặng của sinh viên (đơn vị kg): ");
            String input = scanner.nextLine();
            if (Validate.validateWeight(input)) {
                result = Double.parseDouble(input);
                check = false;
            } else {
                System.err.println("Cân nặng không hợp lệ!");
            }
        }
        return result;
    }

    public String inputStudent(Scanner scanner) {
        String result;
        do {
            System.out.println("Nhập mã sinh viên: ");
            result = scanner.nextLine();
            if (!Validate.validateStudent(result)) {
                System.err.println("Mã sinh viên không hợp lệ.");
            }
        } while (!Validate.validateStudent(result));
        return result;
    }

    public String inputSchool(Scanner scanner) {
        boolean check = true;
        String result = null;
        while(check) {
            System.out.println("nhập trường đang theo học");
            String School = scanner.nextLine();
            if (Validate.validateSchool(School)) {
                check = false;
                result = School;
            } else {
                System.err.println("nhập sai điều kiện");
            }
        }
        return result;
    }

    public int inputYearBegins(Scanner scanner) {
        int year;
        String input;
        do {
            System.out.println("Nhập năm học của sinh viên: ");
            input = scanner.nextLine();
            if (!Validate.validateYearbegins(input)) {
                System.err.println("Năm học không hợp lệ.");
            }
        } while (!Validate.validateYearbegins(input));
        try {
            year = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            year = 0;
        }
        return year;
    }

    public Double inputMediumScore(Scanner scanner) {
        Double score;
        String input;
        do {
            System.out.println("Nhập điểm trung bình: ");
            input = scanner.nextLine();
            if (!Validate.validateMediumscore(input)) {
                System.err.println("Điểm trung bình không hợp lệ.");
            }
        } while (!Validate.validateMediumscore(input));
        score = Double.parseDouble(input);
        return score;
    }

    public Student inputHN(Scanner scanner) {
        String name = inputName(scanner);
        LocalDate birth = inputDate(scanner);
        String address = inputAddress(scanner);
        int height = inputHeight(scanner);
        double weight = inputWeight(scanner);
        String Student = inputStudent(scanner);
        String school = inputSchool(scanner);
        int Yearbegins = inputYearBegins(scanner);
        double Mediumscore = inputMediumScore(scanner);
        Student st = new Student(name, birth, address, height, weight, Student, school, Yearbegins,Mediumscore);
        return st;
    }

    public void show() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
    }

    public void create() {
        Student student = inputHN(scanner);
        student.setId(students.size() + 1);
        students.add(student);
        IOWirteVsRead.write(students);
    }

    public void delete() {
        System.out.println("Nhập id cần xóa:");
        int idToDelete = scanner.nextInt();
        boolean check = false;
        scanner.nextLine();

        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if (student.getId() == idToDelete) {
                System.out.println("Bạn có muốn xóa sinh viên này? Nhập Y để xác nhận.");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("Y")) {
                    studentIterator.remove();
                    check = true;
                    break;
                } else {
                    System.err.println("Sinh viên không bị xóa.");
                }
            }
        }
        if (!check) {
            System.err.println("id sinh viên không tồn tại");
        } else {
            System.out.println("đã xóa sinh viên có id " + idToDelete);
            for (Student student : students) {
                if (student.getId() > idToDelete) {
                    student.setId(student.getId() - 1);
                    IOWirteVsRead.write(students);
                }
            }
        }

    }

    public void update() {
        System.out.println("Nhập id sinh viên muốn sửa:");
        int idToEdit = scanner.nextInt();
        scanner.nextLine();

        int count = 0;
        for (Student student : students) {
            if (student.getId() == idToEdit) {
                count++;
                System.out.println("Thông tin cũ của sinh viên có mã " + idToEdit + ":");
                System.out.println(student.toString());

                System.err.println("Nhập thông tin mới của sinh viên:");
                Student newStudent = inputHN(scanner);
                newStudent.setId(student.getId());
                students.set(students.indexOf(student), newStudent);

                System.out.println("Thông tin sau khi sửa:");
                System.out.println(newStudent.toString());
                IOWirteVsRead.write(students);

                break;
            }
        }

        if (count == 0) {
            System.err.println("Không tìm thấy sinh viên với id " + idToEdit);
        }
    }

    public void search() {
        System.out.println("Nhập học lực bạn muốn tìm kiếm:");
        String searchRank = scanner.nextLine();
        Academic rank = Academic.valueOf(searchRank);
        for (Student student : students) {
            if (student.getRank() == rank) {
                System.out.println(student.toString());
            }

        }
        }
}