package Controller;
import Model.Student;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static final String NUMBER = "\\d+";
    public static String student = "^(?=([a-z0-9])(?!.*\\1)){10}$";
    public static String dateFormart = "dd/MM/yyyy";

    public static boolean validateName(String name) {
        return name.length() < 100 && !name.equals("");
    }

    public static boolean validateDate(String dateFormart) {
        DateFormat df = new SimpleDateFormat(dateFormart);
        df.setLenient(false);
        try {
            df.parse(dateFormart);
        } catch (Exception e) {
            return false;
        }
        int year = Integer.parseInt(dateFormart.substring(dateFormart.length() - 4));
        return year > 1900;
    }

    public static boolean validate(String data, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public static boolean validateHeight(String data) {
        if (validate(data, NUMBER)) {
            int numner = Integer.parseInt(data);
            return numner >= 50 && numner <= 300;
        }
        return false;
    }

    public static boolean validateWeight(String data) {
        if (validate(data, NUMBER)) {
            Double number = Double.parseDouble(data);
            return number >= 5.0 && number <= 1000.0;
        }
        return false;
    }

    public static boolean validateAddress(String address) {
        return address.length() < 300;
    }

    public static boolean validateSchool(String School) {
        if (School == null || School.length() == 0 || School.length() > 200) {
            System.err.println("Trường không hợp lệ");
            return false;
        }
        System.err.println("Trường hợp lệ");
        return true;
    }

    public static boolean validateStudent(String data) {
        Manager manager = new Manager();
        List<Student> students = manager.students;
        boolean isDuplicate = false;
        for (Student student : students) {
            if (student.getStudent().equals(data)) {
                isDuplicate = true;
                break;
            }
        }
        if (data.length() != 10) {
            return false;
        }
        return !isDuplicate;
    }

        public static boolean validateYearbegins(String data){
            boolean check = false;
            if(validate(data,NUMBER)){
             if (data == null && data.length() != 4){
                check = true;
        }
                int number = Integer.parseInt(data);
                return number > 1900;
            }
            return false;
        }

        public static boolean validateMediumscore(String data){
            if (validate(data,NUMBER)){
                Double aDouble =Double.parseDouble(data);
                    return aDouble >= 0.0 && aDouble <= 10.0;
    }
            return false;
        }
    }