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
public class MeasurementObservation extends Observation implements Serializable {
    private double value;

    public MeasurementObservation(MeasurementObservationType observationType, double value) {
        super(observationType);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MeasurementObservation [type=" + getObservationType().getName() + ", value=" + value + "]";
    }
}
