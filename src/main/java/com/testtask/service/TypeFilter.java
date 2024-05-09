package com.testtask.service;

import lombok.Getter;

@Getter
public enum TypeFilter {
    Price ("price"),
    Name ("name"),
    Available ("available");
    private final String title;

    TypeFilter(String title){
        this.title = title;
    }
    public static TypeFilter getEnum(String title){
        for(TypeFilter typeFilter : TypeFilter.values()){
            if(typeFilter.title.equals(title)){
                return typeFilter;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return title;
    }
}
