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
public class Empleado extends Persona{
    private String empCodigo;
    private Anexo empAnexo;

    public Empleado() {
    }

    public Empleado(String empCodigo, Anexo empAnexo, String perRut, String perNombre, String perApellidoPaterno, String perApellidoMaterno, String perNacimiento, Sexo perSexo) {
        super(perRut, perNombre, perApellidoPaterno, perApellidoMaterno, perNacimiento, perSexo);
        this.empCodigo = empCodigo;
        this.empAnexo = empAnexo;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public Anexo getEmpAnexo() {
        return empAnexo;
    }

    public void setEmpAnexo(String anexo) {
        switch(anexo){
            case "1" : empAnexo=Anexo.A510;
                break;
            case "2" : empAnexo=Anexo.A511;
                break;
            case "3" : empAnexo=Anexo.A512;
                break;
            case "4" : empAnexo=Anexo.A513;
                break;
            case "5" : empAnexo=Anexo.A514;
                break;
            case "6" : empAnexo=Anexo.A515;
                break;
            case "7" : empAnexo=Anexo.A516;
                break;
            case "8" : empAnexo=Anexo.A517;
                break;
            case "9" : empAnexo=Anexo.A518;
                break;
            case "10" : empAnexo=Anexo.A519;
                break;
            case "11" : empAnexo=Anexo.A520;
                break;
            default : empAnexo=null;
                break;
        }
    }

    @Override
    public String toString() {
        return "Empleado{" + "empCodigo=" + empCodigo + 
                " empAnexo=" + empAnexo + '}';
    }

    @Override
    public String reporte() {
        return super.reporte()+
             " como Empleado tiene el codigo: "+this.empCodigo+
                " con el anexo "+this.empAnexo;
    }

    
    
}
