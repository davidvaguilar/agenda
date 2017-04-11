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
    private SexoPersona perSexo;

    public Persona() {
        this.perRut = "";
        this.perNombre = "";
        this.perApellidoPaterno = "";
        this.perApellidoMaterno = "";
        this.perNacimiento = "";
        this.perSexo = Persona.SexoPersona.I;
    }

    public Persona(String perRut, String perNombre, String perApellidoPaterno, String perApellidoMaterno, String perNacimiento, SexoPersona perSexo) {
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
        //MODIFICAR;
    }

    public SexoPersona getPerSexo() {
        return perSexo;
    }

    public void setPerSexo(String sexo) {
        switch(sexo){
            case "M" : perSexo=SexoPersona.M;
                break;
            case "F" : perSexo=SexoPersona.F;
                break;
            default : perSexo=SexoPersona.I;
                break;
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "perRut=" + perRut + "\n"+
                ", perNombre=" + perNombre + "\n"+
                ", perApellidoPaterno=" + perApellidoPaterno + "\n"+
                ", perApellidoMaterno=" + perApellidoMaterno + "\n"+
                ", perNacimiento=" + perNacimiento + "\n"+
                ", perSexo=" + perSexo + '}';
    }

    public String reporte(){
        return this.perNombre+" "+this.perApellidoPaterno+" "+this.perApellidoMaterno+"\n"+
                " es: "+this.perSexo;
    }
    
    public static enum SexoPersona {
        M("Masculino"),
        F("Femenino"),
        I("Indeterminado");

        private String sexDescripcion;

        private SexoPersona(String sexDescripcion) {
            this.sexDescripcion = sexDescripcion;
        }

        public String getSexDescripcion() {
            return sexDescripcion;
        }
    }
}
