package com.example.project_.markerhub.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class PageData<T> implements Serializable {
    private int total;
    private List<T> result;

    public PageData(int total, List<T> records) {
        this.total=total;
        this.result= records;
    }
}
