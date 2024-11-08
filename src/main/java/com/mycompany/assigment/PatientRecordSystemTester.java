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
import java.util.*;

public class PatientRecordSystemTester {

    public static void main(String[] args) throws Exception {
        //testSaveData();
        testLoadData();
    }

    public static void testSaveData() throws Exception {
        // Create PatientRecordSystem
        // Add observation types, patients and observations
        PatientRecordSystem prs = new PatientRecordSystem();

        prs.addMeasurementObservationType("T100", "Blood Pressure", "psi");
        String[] categories = {"Group A", "Group B1", "Group B2"};
        prs.addCategoryObservationType("T200", "blood type", categories);

        String[] temp = {"low", "Medium", "high"};
        categories = temp;
        prs.addCategoryObservationType("T300", "stress level", categories);

        prs.addMeasurementObservationType("T400", "height", "cm");

        prs.addPatient("P100", "Smith");
        prs.addPatient("P200", "Adams");

        prs.addMeasurementObservation("P100", "T100", 120);
        prs.addCategoryObservation("P100", "T200", "Group A");
        System.out.println("");
        // save data to file
        prs.saveData();
    }

    public static void testLoadData() throws Exception {
        testSaveData();
        PatientRecordSystem prs = new PatientRecordSystem();
        prs.loadData();
        System.out.println(prs);
    }
}

/*	Output for testAddObservations()

===== PATIENT RECORD SYSTEM =====
OBSERVATION TYPES:
>> MeasurementObservationType[code: T100, name: Blood Pressure,unit: psi]
>> CategoryObservationType[code: T200, name: blood type, categories: |Group A|Gr
oup B1|Group B2|]

PATIENTS:
>> Patient id: P100, name: Smith
Observations:

>> Patient id: P200, name: Adams
Observations:


===== PATIENT RECORD SYSTEM =====
OBSERVATION TYPES:
>> MeasurementObservationType[code: T100, name: Blood Pressure,unit: psi]
>> CategoryObservationType[code: T200, name: blood type, categories: |Group A|Group B1|Group B2|]

PATIENTS:
>> Patient id: P100, name: Smith
Observations:
- MeasurementObservation[observationType: MeasurementObservationType[code: T100,name: Blood Pressure,unit: psi], value: 120.0]

>> Patient id: P200, name: Adams
Observations:


===== PATIENT RECORD SYSTEM =====
OBSERVATION TYPES:
>> MeasurementObservationType[code: T100, name: Blood Pressure,unit: psi]
>> CategoryObservationType[code: T200, name: blood type, categories: |Group A|Group B1|Group B2|]

PATIENTS:
>> Patient id: P100, name: Smith
Observations:
- MeasurementObservation[observationType: MeasurementObservationType[code: T100,name: Blood Pressure,unit: psi], value: 120.0]
- CategoryObservation[observationType: CategoryObservationType[code: T200, name: blood type, categories: |Group A|Group B1|Group B2|], value: Group A]

>> Patient id: P200, name: Adams
Observations:


ERROR: The patient already has observation of this type
===== PATIENT RECORD SYSTEM =====
OBSERVATION TYPES:
>> MeasurementObservationType[code: T100, name: Blood Pressure,unit: psi]
>> CategoryObservationType[code: T200, name: blood type, categories: |Group A|Gr
oup B1|Group B2|]

PATIENTS:
>> Patient id: P100, name: Smith
Observations:
- MeasurementObservation[observationType: MeasurementObservationType[code: T100,
 name: Blood Pressure,unit: psi], value: 120.0]
- CategoryObservation[observationType: CategoryObservationType[code: T200, name:
 blood type, categories: |Group A|Group B1|Group B2|], value: Group A]

>> Patient id: P200, name: Adams
Observations:


ERROR: Group D is an invalid category
===== PATIENT RECORD SYSTEM =====
OBSERVATION TYPES:
>> MeasurementObservationType[code: T100, name: Blood Pressure,unit: psi]
>> CategoryObservationType[code: T200, name: blood type, categories: |Group A|Gr
oup B1|Group B2|]

PATIENTS:
>> Patient id: P100, name: Smith
Observations:
- MeasurementObservation[observationType: MeasurementObservationType[code: T100,
 name: Blood Pressure,unit: psi], value: 120.0]
- CategoryObservation[observationType: CategoryObservationType[code: T200, name:
 blood type, categories: |Group A|Group B1|Group B2|], value: Group A]

>> Patient id: P200, name: Adams
Observations:
 */


/* Output for testQueries()

===== PATIENT RECORD SYSTEM =====
OBSERVATION TYPES:
>> MeasurementObservationType[code: T100, name: Blood Pressure,unit: psi]
>> CategoryObservationType[code: T200, name: blood type, categories: |Group A|Gr
oup B1|Group B2|]

PATIENTS:
>> Patient id: P100, name: Smith
Observations:
- MeasurementObservation[observationType: MeasurementObservationType[code: T100,
 name: Blood Pressure,unit: psi], value: 120.0]
- CategoryObservation[observationType: CategoryObservationType[code: T200, name:
 blood type, categories: |Group A|Group B1|Group B2|], value: Group A]

>> Patient id: P200, name: Adams
Observations:



MeasurementObservationType[code: T100, name: Blood Pressure,unit: psi]

CategoryObservationType[code: T200, name: blood type, categories: |Group A|Group
 B1|Group B2|]

There is no such observation type

Patient id: P100, name: Smith
Observations:
- MeasurementObservation[observationType: MeasurementObservationType[code: T100,
 name: Blood Pressure,unit: psi], value: 120.0]
- CategoryObservation[observationType: CategoryObservationType[code: T200, name:
 blood type, categories: |Group A|Group B1|Group B2|], value: Group A]


There is no such patient
*/
