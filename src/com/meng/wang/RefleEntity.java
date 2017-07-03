package com.meng.wang;

/**
 * Created by meng on 17-7-3.
 */
public class RefleEntity {
    private String name;
    private String pwd;
    private int age;


    public RefleEntity() {
    }

    public RefleEntity(String name, String pwd, int age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }

    public void sing(String songname){
        System.out.println("I am singing:"+songname);
    }


}
