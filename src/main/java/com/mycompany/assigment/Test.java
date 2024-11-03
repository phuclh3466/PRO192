/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment;

/**
 *
 * @author PC
 */
public class Test {

    public static void main(String[] args) {
        try {
            // Create a new PatientRecordSystem
            PatientRecordSystem record = new PatientRecordSystem();

            // Adding observation types
            record.addMeasurementObservationType("T101", "Blood Pressure", "PSI");
            record.addCategoryObservationType("T102", "Blood Type", new String[]{"Group A", "Group B1", "Group B2"});

            // Adding patients
            record.addPatient("P001", "John Doe");
            record.addPatient("P002", "Jane Smith");

            // Adding observations for patients
            record.addMeasurementObservation("P001", "T101", 120); // Blood pressure for John Doe
            record.addCategoryObservation("P002", "T102", "Group A"); // Blood type for Jane Smith

            // Print the current system state
            System.out.println(record);

            // Saving the system state to a file
            record.saveData("patient_system.txt");

            // Loading the system state from the file
            PatientRecordSystem loadedSystem = PatientRecordSystem.loadData("patient_system.txt");
            System.out.println("Loaded System from File:");
            System.out.println(loadedSystem);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
