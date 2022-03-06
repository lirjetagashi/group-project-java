package com.example.groupproject.bean;

public class GeographicArea {

    //defining GeographicArea attributes
    private int code;
    private int level;
    private String name;
    private int alternativeCode;

    //getter and setters for GeographicArea attributes
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAlternativeCode() {
        return alternativeCode;
    }
    public void setAlternativeCode(int alternativeCode) {
        this.alternativeCode = alternativeCode;
    }
}
