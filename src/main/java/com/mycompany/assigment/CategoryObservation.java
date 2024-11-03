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
public class CategoryObservation extends Observation implements Serializable {
    private String value;

    public CategoryObservation(CategoryObservationType observationType, String value) throws Exception {
        super(observationType);

        // Validate that the value is within the allowed categories
        boolean valid = false;
        for (String category : observationType.getCategories()) {
            if (category.equals(value)) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            throw new Exception("Invalid category value for this observation type.");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CategoryObservation [type=" + getObservationType().getName() + ", value=" + value + "]";
    }
}
