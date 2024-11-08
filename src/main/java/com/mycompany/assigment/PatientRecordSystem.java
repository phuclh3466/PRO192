/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment;
/**
 *
 * @author PC
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRecordSystem implements Serializable {
    private List<ObservationType> observationTypes;
    private List<Patient> patients;

    public PatientRecordSystem() {
        observationTypes = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addMeasurementObservationType(String code, String name, String unit) throws Exception {
        for (ObservationType type : observationTypes) {
            if (type.getCode().equals(code)) {
                throw new Exception("Observation type with this code already exists");
            }
        }
        observationTypes.add(new MeasurementObservationType(code, name, unit));
    }

    public void addCategoryObservationType(String code, String name, String[] categories) throws Exception {
        for (ObservationType type : observationTypes) {
            if (type.getCode().equals(code)) {
                throw new Exception("Observation type with this code already exists");
            }
        }
        observationTypes.add(new CategoryObservationType(code, name, categories));
    }

    public void addPatient(String id, String name) throws Exception {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                throw new Exception("Patient with this ID already exists");
            }
        }
        patients.add(new Patient(id, name));
    }

    public void addMeasurementObservation(String patientId, String observationTypeCode, double value) throws Exception {
        Patient patient = findPatientById(patientId);
        MeasurementObservationType type = (MeasurementObservationType) findObservationTypeByCode(observationTypeCode);
        MeasurementObservation observation = new MeasurementObservation(type, value);
        patient.addObservation(observation);
    }

    public void addCategoryObservation(String patientId, String observationTypeCode, String categoryValue) throws Exception {
        Patient patient = findPatientById(patientId);
        CategoryObservationType type = (CategoryObservationType) findObservationTypeByCode(observationTypeCode);
        CategoryObservation observation = new CategoryObservation(type, categoryValue);
        patient.addObservation(observation);
    }

    private Patient findPatientById(String id) throws Exception {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        throw new Exception("No patient with this ID");
    }

    private ObservationType findObservationTypeByCode(String code) throws Exception {
        for (ObservationType type : observationTypes) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new Exception("No observation type with this code");
    }

    public void saveData() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("patient_data.ser"))) {
            oos.writeObject(observationTypes);
            oos.writeObject(patients);
        }
    }

    public void loadData() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("patient_data.ser"))) {
            observationTypes = (ArrayList<ObservationType>) ois.readObject();
            patients = (ArrayList<Patient>) ois.readObject();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== PATIENT RECORD SYSTEM =====\n");
        sb.append("OBSERVATION TYPES:\n");
        for (ObservationType type : observationTypes) {
            sb.append(">> ").append(type).append("\n");
        }
        sb.append("\nPATIENTS:\n");
        for (Patient patient : patients) {
            sb.append(">> ").append(patient).append("\n");
        }
        return sb.toString();
    }
}
