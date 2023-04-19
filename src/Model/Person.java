package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Person implements Serializable {
private static int Nextid = 1;
private int Id;
private String Name;
private LocalDate Birth;
private String Address;
private int Height;
private double Weight;

    public Person() {
        super();
    }

    public Person(String name, LocalDate birth, String address, int height, double weight) {
        super();
        this.Id = Nextid;
        Nextid++;
        this.Name = name;
        this.Birth = birth;
        this.Address = address;
        this.Height = height;
        this.Weight = weight;
    }

    public static int getNextid() {
        return Nextid;
    }

    public static void setNextid(int nextid) {
        Nextid = nextid;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getBirth() {
        return Birth;
    }

    public void setBirth(LocalDate birth) {
        Birth = birth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" + "Id=" + Id + ", Name='" + Name + ", Birth=" + Birth + ", Address='" + Address + ", Height=" + Height + ", Weight=" + Weight + '}';
    }
}
