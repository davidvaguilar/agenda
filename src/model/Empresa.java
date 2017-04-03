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
public enum Empresa {
    CLINICA ("55.555.555-5","Clinica Iquique"),
    INMOBILIARIA ("66.666.666-6","Inmobiliaria Iquique"),
    IMPORTADORA ("77.777.777-7","Importadora Iquique"),
    UNIVERSIDAD ("88.888.888-8","Universidad Iquique");
    
    private String empRut;
    private String empNombre;

    private Empresa(String empRut, String empNombre) {
        this.empRut = empRut;
        this.empNombre = empNombre;
    }
    
    
}
