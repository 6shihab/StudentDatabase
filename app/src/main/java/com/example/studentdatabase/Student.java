package com.example.studentdatabase;

public class Student {
    private String id;
    private String student_id ;
    private String fullname;
    private String degree_title;
    private String address;
    private String phone;

    public  Student(){}

    public Student(String id, String student_id, String fullname, String degree_title, String address, String phone) {
        this.id = id;
        this.student_id = student_id;
        this.fullname = fullname;
        this.degree_title = degree_title;
        this.address = address;
        this.phone = phone;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDegree_title() {
        return degree_title;
    }

    public void setDegree_title(String degree_title) {
        this.degree_title = degree_title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
