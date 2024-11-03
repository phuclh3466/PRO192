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
public class CategoryObservationType extends ObservationType implements Serializable {
    private String[] categories;

    public CategoryObservationType(String code, String name, String[] categories) {
        super(code, name);
        this.categories = categories;
    }

    public String[] getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "CategoryObservationType [code=" + getCode() + ", name=" + getName() + ", categories=" + String.join(", ", categories) + "]";
    }
}
