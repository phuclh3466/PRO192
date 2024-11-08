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
import java.io.Serializable;

public abstract class Observation implements Serializable {
    protected ObservationType observationType;

    public Observation(ObservationType observationType) {
        this.observationType = observationType;
    }

    public ObservationType getObservationType() {
        return observationType;
    }

    @Override
    public abstract String toString();
}
