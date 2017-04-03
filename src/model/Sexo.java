/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author David
 */
public enum Sexo {
    M("Masculino"),
    F("Femenino"),
    I("Indeterminado");
    
    private String sexDescripcion;

    private Sexo(String sexDescripcion) {
        this.sexDescripcion = sexDescripcion;
    }

    public String getSexDescripcion() {
        return sexDescripcion;
    }

    
}
