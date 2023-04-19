package IO;

import Model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOWirteVsRead {
    public static File file =new File("C:/Users/Admin/Desktop/Bai_demo/Student_Management/src/Student.txt");

    public static void write(ArrayList<Student> sinhViens){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(sinhViens);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Student> read(){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Student> sinhViens = (ArrayList<Student>) objectInputStream.readObject();
            return sinhViens;
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}