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
public class PatientRecordSystem implements Serializable {
    private static final long serialVersionUID = 1L; // Added for serialization
    private Patient[] patients;
    private ObservationType[] observationTypes;
    private int patientCount;
    private int observationTypeCount;

    public PatientRecordSystem() {
        patients = new Patient[100];
        observationTypes = new ObservationType[50];
        patientCount = 0;
        observationTypeCount = 0;
    }

    // Method to save all the data to a file
    public void saveData(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this); // Save the entire system state
        }
    }

    // Method to load data from a file
    public static PatientRecordSystem loadData(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (PatientRecordSystem) in.readObject();
        }
    }
    
    // Add a new measurement observation type
    public void addMeasurementObservationType(String code, String name, String unit) throws Exception {
        validateUniqueObservationTypeCode(code);
        observationTypes[observationTypeCount++] = new MeasurementObservationType(code, name, unit);
    }

    // Add a new category observation type
    public void addCategoryObservationType(String code, String name, String[] categories) throws Exception {
        validateUniqueObservationTypeCode(code);
        observationTypes[observationTypeCount++] = new CategoryObservationType(code, name, categories);
    }

    // Add a new patient
    public void addPatient(String id, String name) throws Exception {
        validateUniquePatientId(id);
        patients[patientCount++] = new Patient(id, name);
    }

    // Add a measurement observation for a patient
    public void addMeasurementObservation(String patientId, String observationCode, double value) throws Exception {
        Patient patient = findPatientById(patientId);
        MeasurementObservationType obsType = (MeasurementObservationType) findObservationTypeByCode(observationCode);
        patient.addObservation(new MeasurementObservation(obsType, value));
    }

    // Add a category observation for a patient
    public void addCategoryObservation(String patientId, String observationCode, String value) throws Exception {
        Patient patient = findPatientById(patientId);
        CategoryObservationType obsType = (CategoryObservationType) findObservationTypeByCode(observationCode);
        patient.addObservation(new CategoryObservation(obsType, value));
    }

    // Helpers and validations...
    private void validateUniqueObservationTypeCode(String code) throws Exception {
        for (int i = 0; i < observationTypeCount; i++) {
            if (observationTypes[i].getCode().equals(code)) {
                throw new Exception("Observation type with this code already exists.");
            }
        }
    }

    private void validateUniquePatientId(String id) throws Exception {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getId().equals(id)) {
                throw new Exception("Patient with this ID already exists.");
            }
        }
    }

    private Patient findPatientById(String id) throws Exception {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getId().equals(id)) {
                return patients[i];
            }
        }
        throw new Exception("Patient not found.");
    }

    private ObservationType findObservationTypeByCode(String code) throws Exception {
        for (int i = 0; i < observationTypeCount; i++) {
            if (observationTypes[i].getCode().equals(code)) {
                return observationTypes[i];
            }
        }
        throw new Exception("Observation type not found.");
    }

    @Override
    public String toString() {
        String result = "PatientRecordSystem [\nPatients:\n";
        for (int i = 0; i < patientCount; i++) {
            result += patients[i].toString() + "\n";
        }
        result += "ObservationTypes:\n";
        for (int i = 0; i < observationTypeCount; i++) {
            result += observationTypes[i].toString() + "\n";
        }
        result += "]";
        return result;
    }
}