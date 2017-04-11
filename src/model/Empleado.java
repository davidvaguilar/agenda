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
    private static int siguienteEmpCodigo=1;
    private String empCodigo;
    private Anexo empAnexo;

    public Empleado() { 
        this.setEmpCodigo();
        this.empAnexo=null;
    }

    public Empleado(Anexo empAnexo, String perRut, String perNombre, String perApellidoPaterno, String perApellidoMaterno, String perNacimiento, SexoPersona perSexo) {
        super(perRut, perNombre, perApellidoPaterno, perApellidoMaterno, perNacimiento, perSexo);
        setEmpCodigo();
        this.empAnexo = empAnexo;
    }
    
    public void setEmpCodigo(){
        this.empCodigo=String.valueOf(Empleado.siguienteEmpCodigo);
        Empleado.siguienteEmpCodigo=Empleado.siguienteEmpCodigo+1;
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
        return super.toString()+"\n"+
                " Empleado{" + "empCodigo=" + empCodigo + "\n" +
                " empAnexo=" + empAnexo + '}';
    }

    @Override
    public String reporte() {
        return super.reporte()+"\n"+
             " como Empleado tiene el codigo: "+this.empCodigo+ "\n"+
                " con el anexo "+this.empAnexo;
    }

    
    
}
