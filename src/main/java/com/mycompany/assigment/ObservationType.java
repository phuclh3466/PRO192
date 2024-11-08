/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assigment;

/**
 *
 * @author PC
 */
import java.io.*;
import java.io.Serializable;

public abstract class ObservationType implements Serializable {
    protected String code;
    protected String name;

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
