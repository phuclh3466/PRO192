/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment;
import java.io.*;
/**
 *
 * @author PC
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryObservationType extends ObservationType {
    private List<String> categories;

    public CategoryObservationType(String code, String name, String[] categories) {
        super(code, name);
        this.categories = new ArrayList<>(Arrays.asList(categories));
    }

    public List<String> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "CategoryObservationType[code: " + code + ", name: " + name + ", categories: " + categories + "]";
    }
}
