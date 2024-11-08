/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment;

/**
 *
 * @author PC
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Patient implements Serializable {
    private String id;
    private String name;
    private List<Observation> observations;

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

    public List<Observation> getObservations() {
        return observations;
    }

    public void addObservation(Observation observation) throws Exception {
        for (Observation obs : observations) {
            if (obs.getObservationType().getCode().equals(observation.getObservationType().getCode())) {
                throw new Exception("The patient already has an observation of this type");
            }
        }
        observations.add(observation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(">> Patient id: ").append(id).append(", name: ").append(name).append("\nObservations:\n");
        for (Observation obs : observations) {
            sb.append("- ").append(obs).append("\n");
        }
        return sb.toString();
    }
}
