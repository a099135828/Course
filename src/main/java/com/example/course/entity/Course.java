package com.example.course.entity;

import lombok.Data;

@Data
public class Course {
    private String Cno;
    private String Cname;
    private int Ccredit;
    private String Cpno;

    @Override
    public String toString() {
        return "Course{" +
                "Ccredit=" + Ccredit +
                ", Cno='" + Cno + '\'' +
                ", Cname='" + Cname + '\'' +
                ", Cpno='" + Cpno + '\'' +
                '}';
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        this.Cname = cname;
    }

    public int getCcredit() {
        return Ccredit;
    }

    public void setCcredit(int ccredit) {
        this.Ccredit = ccredit;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        this.Cno = cno;
    }

    public String getCpno() {
        return Cpno;
    }

    public void setCpno(String cpno) {
        this.Cpno = cpno;
    }

}