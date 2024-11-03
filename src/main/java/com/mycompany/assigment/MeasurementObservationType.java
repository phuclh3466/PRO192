/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment;
import java.io.*;
public class MeasurementObservationType extends ObservationType implements Serializable {
    private String unit;

    public MeasurementObservationType(String code, String name, String unit) {
        super(code, name);
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "MeasurementObservationType [code=" + getCode() + ", name=" + getName() + ", unit=" + unit + "]";
    }
}