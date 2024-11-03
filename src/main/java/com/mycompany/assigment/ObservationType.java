/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assigment;
import java.io.*;
/**
 *
 * @author PC
 */
public abstract class ObservationType implements Serializable {
    private String code;
    private String name;

    public ObservationType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract String toString();
}
