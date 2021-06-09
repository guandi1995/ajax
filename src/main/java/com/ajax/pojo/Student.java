package com.ajax.pojo;

/**
 * @author Di Guan on 6/5/2021 11:25 PM
 */

public class Student {
    private Integer stuid;
    private String stuname;
    private Integer age;
    private String gender;
    private Integer major_id;

    public Student() {
    }

    public Student(Integer stuid, String stuname, Integer age, String gender, Integer major_id) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.age = age;
        this.gender = gender;
        this.major_id = major_id;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getMajor_id() {
        return major_id;
    }

    public void setMajor_id(Integer major_id) {
        this.major_id = major_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", major_id=" + major_id +
                '}';
    }
}
