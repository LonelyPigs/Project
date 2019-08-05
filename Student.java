package com.train.day18;

/**
 *与student表映射的实体类
 */
public class Student {

    private String sNo;
    private String sName;
    private String sSex;
    private int sAge;
    private String sDepart;

    public String getsNo() {
        return sNo;
    }
    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }
    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public int getsAge() {
        return sAge;
    }
    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public String getsDepart() {
        return sDepart;
    }
    public void setsDepart(String sDepart) {
        this.sDepart = sDepart;
    }


}
