package com.example.vidyawani_v2;

public class University_Programs {
    String pno,pname,ptime,pdesc,pdate;

    public University_Programs() {
    }

    public University_Programs(String pno, String pname, String ptime, String pdate, String pdesc) {
        this.pno = pno;
        this.pname = pname;
        this.ptime = ptime;
        this.pdesc = pdesc;
        this.pdate=pdate;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }
}
