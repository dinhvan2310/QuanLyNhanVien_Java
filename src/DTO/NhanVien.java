package DTO;

import java.sql.Date;

public class NhanVien 
{
    private int id;
    private String name;
    private String gender;
    private Date starDate;
    private String position;
    private String address;
    private String phoneNumber;
    private double salary;
    private String workShift;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getStarDate() {
        return starDate;
    }
    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getWorkShift() {
        return workShift;
    }
    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }
}