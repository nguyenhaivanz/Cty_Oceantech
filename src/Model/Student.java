package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Student extends Person{
private String Student;
private String School;
private int Yearbegins;
private double Mediumscore;
private Academic rank;

    public Student() {
    }

    public Student(String name, LocalDate birth, String address, int height, double weight, String student, String school, int yearbegins, double mediumscore) {
        super(name, birth, address, height, weight);
        this.Student = student;
        this.School = school;
        this.Yearbegins = yearbegins;
        this.Mediumscore = mediumscore;
        setGpa();

  }

    public String getStudent() {
        return Student;
    }

    public void setStudent(String student) {
        Student = student;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public double getYearbegins() {
        return Yearbegins;
    }

    public void setYearbegins(int yearbegins) {
        Yearbegins = yearbegins;
    }

    public double getMediumscore() {
        return Mediumscore;
    }

    public void setMediumscore(double mediumscore) {
        Mediumscore = mediumscore;
    }

    public Academic getRank() {
        return rank;
    }

    public void setRank(Academic rank) {
        this.rank = rank;
    }

    private void setGpa() {
        if ( Mediumscore < 3) {
            rank = rank.Kem;
        } else if (Mediumscore < 5) {
            rank = rank.Yeu;
        } else if (Mediumscore < 6.5) {
            rank = rank.TrungBinh;
        } else if (Mediumscore < 7.5) {
            rank = rank.Kha;
        } else if (Mediumscore < 9) {
            rank = rank.Gioi;
        } else {
            rank = rank.XuatXac;
        }
    }

    public String conVerDateToString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(getBirth());
    }

    @Override
    public String toString() {
        return ", getId()=" + getId() + ", getName()=" + getName() + ", getBirday()=" + getBirth() + ", getAddress()=" + getAddress() + ", getHeight()="
                + getHeight() + ", getKg()=" + getWeight()  + "MaSinhVien=" + Student+ ", School=" + School + ", yearbegins=" + Yearbegins
                + ", diemTrungBinh=" + Mediumscore + ", hocLuc=" + rank ;
    }

}
