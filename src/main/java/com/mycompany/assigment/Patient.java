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

public class Patient implements Serializable {
    private String id;
    private String name;
    private ArrayList<Observation> observations;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
        this.observations = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addObservation(Observation observation) throws Exception {
        // Ensure no duplicate observation types
        for (Observation obs : observations) {
            if (obs.getObservationType().getCode().equals(observation.getObservationType().getCode())) {
                throw new Exception("Observation of this type already exists for this patient.");
            }
        }
        observations.add(observation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patient [id=" + id + ", name=" + name + ", observations=");

        for (Observation obs : observations) {
            sb.append("\n\t" + obs.toString());
        }

        sb.append("]");
        return sb.toString();
    }
}

