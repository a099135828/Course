package com.example.course.entity;


import java.sql.Date;

public class Student {
    private String Sno;
    private String Sname;
    private Date Sbirthdate;
    private String Smajor;

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        this.Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        this.Sname = sname;
    }

    public Date getSbirthdate() {
        return Sbirthdate;
    }

    public void setSbirthdate(Date sbirthdate) {
        this.Sbirthdate = sbirthdate;
    }

    public String getSmajor() {
        return Smajor;
    }

    public void setSmajor(String smajor) {
        this.Smajor = smajor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Sno=" + Sno +
                ", Sname=" + Sname +
                ", Sbirthdate='" + Sbirthdate + '\'' +
                ", Smajor=" + Smajor +
                '}';
    }


}
