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
    A510("1","Box Atencion 01"),
    A511("2","Box Atencion 02"),
    A512("3","Box Atencion 03"),
    A513("4","Box Atencion 04"),
    A514("5","Box Atencion 05"),
    A515("6","Box Atencion 06"),
    A516("7","Box Atencion 07"),
    A517("8","Box Atencion 08"),
    A518("9","Box Atencion 09"),
    A519("10","Box Atencion 10"),
    A520("11","Box Atencion 11");
    
    private String aneCodigo;
    private String aneUbicacion;

    private Anexo(String aneCodigo, String aneUbicacion) {
        this.aneCodigo = aneCodigo;
        this.aneUbicacion = aneUbicacion;
    }   

    public String getAneUbicacion() {
        return aneUbicacion;
    }

    public String getAneCodigo() {
        return aneCodigo;
    }
    
}
