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
public abstract class Observation implements Serializable {
    private ObservationType observationType;

    public Observation(ObservationType observationType) {
        this.observationType = observationType;
    }

    public ObservationType getObservationType() {
        return observationType;
    }

    public abstract String toString();
}
