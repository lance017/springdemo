package com.lance.springdemo.po;

public class User {
    private Integer id;

    private String name;

    private Integer age;

    private String recommend;

    public User(Integer id, String name, Integer age, String recommend) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.recommend = recommend;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend == null ? null : recommend.trim();
    }
}