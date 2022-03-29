package com.example.EmployeeSystem.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Contestants")
public class Contestant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String city;
    private String phoneNum;
    private String department;
    private String position;
    private int salary;
    private String gender;
    private int experience ;

    public  Contestant(){
        super();
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Contestant(int id, String name, String email, String city, String phoneNum, String department, String position, int salary, String gender , int experience) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.phoneNum = phoneNum;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.gender = gender;
        this.experience = experience ;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }


}
