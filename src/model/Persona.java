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
public class Persona {
    private String perRut;
    private String perNombre;
    private String perApellidoPaterno;
    private String perApellidoMaterno;
    private String perNacimiento;
    private Sexo perSexo;

    public Persona() {
        this.perRut="";
        this.perNombre="";
        this.perApellidoPaterno="";
        this.perApellidoMaterno="";
        this.perNacimiento="";
    }

    public Persona(String perRut, String perNombre, String perApellidoPaterno, String perApellidoMaterno, String perNacimiento, Sexo perSexo) {
        this.perRut = perRut;
        this.perNombre = perNombre;
        this.perApellidoPaterno = perApellidoPaterno;
        this.perApellidoMaterno = perApellidoMaterno;
        this.perNacimiento = perNacimiento;
        this.perSexo = perSexo;
    }

    public String getPerRut() {
        return perRut;
    }

    public void setPerRut(String perRut) {
        this.perRut = perRut;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellidoPaterno() {
        return perApellidoPaterno;
    }

    public void setPerApellidos(String apellidos) {
        String[] arrayApellidos = apellidos.split(" ");
        for (int i = 0; i < arrayApellidos.length; i++) {
            if(i == 0){
                this.perApellidoPaterno=arrayApellidos[i];
            }
            else{
                this.perApellidoMaterno=this.perApellidoMaterno+arrayApellidos[i];
            }
        }
    }

    public String getPerApellidoMaterno() {
        return perApellidoMaterno;
    }

    public String getPerNacimiento() {
        return perNacimiento;
    }

    public void setPerNacimiento(String perNacimiento) {
        this.perNacimiento = perNacimiento;
    }

    public Sexo getPerSexo() {
        return perSexo;
    }

    public void setPerSexo(String sexo) {
        switch(sexo){
            case "M" : perSexo=Sexo.M;
                break;
            case "F" : perSexo=Sexo.F;
                break;
            default : perSexo=Sexo.I;
                break;
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "perRut=" + perRut +
                ", perNombre=" + perNombre + 
                ", perApellidoPaterno=" + perApellidoPaterno + 
                ", perApellidoMaterno=" + perApellidoMaterno + 
                ", perNacimiento=" + perNacimiento + 
                ", perSexo=" + perSexo + '}';
    }

    public String reporte(){
        return this.perNombre+" "+this.perApellidoPaterno+" "+this.perApellidoMaterno+
                " es: "+this.perSexo;
    }
    
    public static enum Sexo {
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
   
   
}
