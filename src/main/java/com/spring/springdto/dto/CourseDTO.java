package com.spring.springdto.dto;

public class CourseDTO {
    private Long id;
    private String name;
    private String cost;
    public String getName(){
        return this.name;
    }
    public void setName(String s){
        this.name=s;
    }
    public Long getId(){
        return this.id;
    }
    public void setId(Long l){
        this.id=l;
    }
    public String getCost(){
        return this.cost;
    }
    public void setCost(String c){
        this.cost=c;
    }

}
