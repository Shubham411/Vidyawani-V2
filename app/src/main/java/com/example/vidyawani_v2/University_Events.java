package com.example.vidyawani_v2;

public class University_Events {
    String no,name,date,time,loc,desc;

    public University_Events() {
    }

    public University_Events(String no, String name, String date, String time, String loc, String desc) {
        this.no = no;
        this.name = name;
        this.date = date;
        this.time = time;
        this.loc = loc;
        this.desc = desc;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
