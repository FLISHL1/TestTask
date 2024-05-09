package com.testtask.repository;

import com.testtask.service.TypeFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilterCriteria {
    private TypeFilter key;
    private String operation;
    private String value;

    public String getDoubleValue(){
        Double d = Double.parseDouble(value);
        return String.valueOf(d);
    }
}
