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
public enum Anexo {
    A510("1","Box Atencion 01","Analogo"),
    A511("2","Box Atencion 02","Analogo"),
    A512("3","Box Atencion 03","Analogo"),
    A513("4","Box Atencion 04","Digital"),
    A514("5","Box Atencion 05","Analogo"),
    A515("6","Box Atencion 06","Analogo"),
    A516("7","Box Atencion 07","Analogo"),
    A517("8","Box Atencion 08","Digital"),
    A518("9","Box Atencion 09","Analogo"),
    A519("10","Box Atencion 10","Analogo"),
    A520("11","Box Atencion 11","Digital"),
    A521("12","Box Atencion 12","Analogo"),
    A522("13","Box Atencion 13","Analogo"),
    A523("14","Box Atencion 14","Analogo");
    
    private String aneCodigo;
    private String aneUbicacion;
    private String aneTipo;

    private Anexo(String aneCodigo, String aneUbicacion, String aneTipo) {
        this.aneCodigo = aneCodigo;
        this.aneUbicacion = aneUbicacion;
        this.aneTipo = aneTipo;
    }
    
    public String getAneUbicacion() {
        return aneUbicacion;
    }

    public String getAneCodigo() {
        return aneCodigo;
    }
    
    
}
