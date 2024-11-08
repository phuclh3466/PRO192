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
public class CategoryObservation extends Observation {
    private String value;

    public CategoryObservation(CategoryObservationType observationType, String value) throws Exception {
        super(observationType);
        if (!observationType.getCategories().contains(value)) {
            throw new Exception("Invalid category value");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CategoryObservation[observationType: " + observationType + ", value: " + value + "]";
    }
}
