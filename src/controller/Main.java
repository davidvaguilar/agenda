/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Anexo;
import model.Empleado;
import model.Persona;

/**
 *
 * @author David
 */
public class Main {

    ArrayList<Empleado> empleados=new ArrayList();  // FORMA DE ALMACENAMIENTO
    InputStreamReader flujoBytes=new InputStreamReader(System.in);  //CAPTURA INGRESO DE LETRAS
    BufferedReader entrada=new BufferedReader(flujoBytes);  // BUFFER PARA ALMACENAR LETRAS DEVUELVE STRING
    
    public String verMenu(){
        try {
            Object opcion=JOptionPane.showInputDialog(
                    null,
                    "Seleccione Opcion","Agenda de Anexos",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"1.- Registrar Empleado",
                        "2.- Asignar Anexo a Empleado",
                        "3.- Obtener ubicacion de un Anexo",
                        "4.- Modificar Anexo a Empleado",
                        "5.- Desasignar Anexo a Empleado",
                        "6.- Listado de Asignaciones",
                        "7.- Salir del Programa"},
                    "1.- Registrar Empleado");
            return(String.valueOf(opcion).substring(0, 1));  //  RETORNA A FUNCION VOID MAIN
        } catch (Exception ex) {
            System.out.println("Hubo un error al ingresar una opcion "+ex.toString());
        }
        return "0";
    }
    
    public void registroEmpleado(Empleado e){
        while(e.getPerRut().isEmpty()){
            try{
                e.setPerRut(JOptionPane.showInputDialog(null, "Ingrese Rut", "Registro Empleado", 0));
                if(e.getPerRut()==null){
                    e.setPerRut("");
                }
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Debe Ingresar un Rut");
                e.setPerRut("");
            }catch(Exception ex){
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            }
        }
        while(e.getPerNombre().isEmpty()){
            try{
                e.setPerNombre(JOptionPane.showInputDialog(null, "Ingrese Nombre", "Registro Empleado", 0));
                if(e.getPerNombre()==null){
                   e.setPerNombre("");
                }
            }catch(Exception ex){
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            }
        }
        while(e.getPerApellidoPaterno().isEmpty()){
            try{
                e.setPerApellidos(JOptionPane.showInputDialog(null, "Ingrese Apellidos", "Registro Empleado", 0));
                if(e.getPerApellidoPaterno()==null){
                   e.setPerApellidos("");
                }
            }catch(Exception ex){
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            }
        }
        try{
            e.setPerNacimiento(JOptionPane.showInputDialog(null, "Ingrese Fecha de Nacimiento (dd-mm-aaaa)", "Registro Empleado", 0));
            if(e.getPerNacimiento()==null){
               e.setPerNacimiento("");
            };
        }catch(Exception ex){
            System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
        }
//        System.out.println("Menu Sexo: ");
//        String contenedor=new String[];
//        int i=0;
//        for (Persona.SexoPersona s: Persona.SexoPersona.values() ) {
//            contenedor[i]="\t" + s.toString() + " es " + s.getSexDescripcion();
//            System.out.println(contenedor[i]);
//            i++;
//        }
        
        try{
            Object sexo=JOptionPane.showInputDialog(
                    null,
                    "Seleccione Sexo","Registro Empleado",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"M.-Masculino","F.- Femenino","I.- Indeterminado"},
                     "I.- Indeterminado");
            
        }catch(Exception ex){
            System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
        }
        try{
            empleados.add(e);   //AGREGAR AL ARRAYLIST
            System.out.println("*****Empleado registrado con Exito*****");
        }catch(Exception ex){
            System.out.println("Empleado no fue registrado, error "+ex.toString());
        }
        
    } //FIN FUNCION REGISTROEMPLEADO
    
    //FUNCIONA ASIGNA ANEXO AL EMPLEADO
    public void asignarAnexo(){
        String indiceStr;
        int indice, i=0;
        System.out.println("-----------------------------------");
        System.out.println("      Lista de Empleados");
        System.out.println("-----------------------------------");
        //RECORRER ARRAYLIST
        for (i=0 ; i<empleados.size() ; i=i+1) {
            System.out.print( (i + 1) +" "+empleados.get(i).getPerNombre()+" "+
                    empleados.get(i).getPerApellidoPaterno()+" "+
                    empleados.get(i).getPerApellidoMaterno()+" tiene el anexo : ");
            if(empleados.get(i).getEmpAnexo() != null){
                System.out.println(empleados.get(i).getEmpAnexo()); //QUE ANEXO TIENE
            }else{
                System.out.println(" Sin asignar ");
            }
        }
        if(i>0){
            try {
                System.out.print("Seleccione el codigo del empleado : \t");
                indiceStr = entrada.readLine();
                indice = Integer.parseInt(indiceStr);
                indice = indice - 1;
                System.out.println("-----------------------------------");
                System.out.println("         Lista de Anexo");
                System.out.println("-----------------------------------");
//                  RECORRE ENUMERADO ANEXOS
                for(Anexo a : Anexo.values()){ 
                    System.out.println("\t" + a.getAneCodigo()+ " - "+a.toString() + " area: "+ a.getAneUbicacion());
                }
                System.out.print("Seleccione Anexo: ");
                // ASIGNA ANEXO A EMPLEADO
                empleados.get(indice).setEmpAnexo(entrada.readLine());
                System.out.println("*****Empleado se asigno anexo "+empleados.get(indice).getEmpAnexo().name()+" *****");
            } catch (IOException ex) {
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            } catch(NumberFormatException ex){
                System.out.println("Ocurrio un error al convertir numero= "+ex.toString());
            }
        }else{
            System.out.println("-NO existen Empleado Registrados-");
        }
    }
    
    public void obtenerUbicacion(){
        String indiceStr;
        Integer indice, i = 0,j = 0;
        System.out.println("-----------------------------------");
        System.out.println("  Lista de Trabajadores con Anexo");
        System.out.println("-----------------------------------");
        // RECORRE ARRAYLIST EMPLEADOS
        for (i = 0 ; i < empleados.size() ; i=i+1) {
            if(empleados.get(i).getEmpAnexo() != null){
                System.out.print( (i+1) +" "+empleados.get(i).getPerNombre()+" "+
                    empleados.get(i).getPerApellidoPaterno()+" "+
                    empleados.get(i).getPerApellidoMaterno()+" tiene el anexo : ");
                System.out.println(empleados.get(i).getEmpAnexo());
                j=j+1;
            }
        }
        if(j > 0){
            try {
                System.out.print("Seleccione un empleado : \t");
                indiceStr = entrada.readLine();
                indice = Integer.parseInt(indiceStr);
                indice = indice-1;
                System.out.println("El anexo se encuentra ubicado en: "+
                        empleados.get(indice).getEmpAnexo().getAneUbicacion());
            } catch (IOException ex) {
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }catch(IndexOutOfBoundsException ex){
                System.out.println("Empleado no existe, codigo = "+ex.toString());
            }
        }else{
            System.out.println("No existen Empleados con Anexo asignado");
        }
    }
    
    public void modificarAsignacion(){
        String indiceStr;
        Integer indice,i=0;
        System.out.println("-----------------------------------");
        System.out.println("   Lista de Empleados con Anexo");
        System.out.println("-----------------------------------");
        for (i=0;i<empleados.size();i++) {
            if(empleados.get(i).getEmpAnexo() != null){
                System.out.print( (i+1) +" "+empleados.get(i).getPerNombre()+" "+
                    empleados.get(i).getPerApellidoPaterno()+" "+
                    empleados.get(i).getPerApellidoMaterno()+" tiene el anexo : ");
                System.out.println(empleados.get(i).getEmpAnexo());
            }
        }
        if(i>0){
            try {
                System.out.print("Seleccione un empleado : \t");
                indiceStr = entrada.readLine();
                indice = Integer.parseInt(indiceStr);
                indice = indice-1;
                System.out.println("-----------------------------------");
                System.out.println(empleados.get(indice).getPerNombre()+
                        " actualmente tiene el acceso"+empleados.get(indice).getEmpAnexo().name());
                System.out.println("-----------------------------------");
                System.out.println("Elija nuevo Anexo: ");
                for(Anexo a:Anexo.values()){ 
                    System.out.println("\t" + a.getAneCodigo()+ " - "+a.toString() + " area: "+ a.getAneUbicacion());
                }
                System.out.print("Seleccione Anexo: ");
                empleados.get(indice).setEmpAnexo(entrada.readLine());
                System.out.println("**** Anexo modificado *****");
            } catch (IOException ex) {
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("No existen Empleados con Anexo asignado");
        }
    }
    
    public void desasignarAnexo(){
        String indiceStr;
        Integer indice,i=0;
        System.out.println("-----------------------------------");
        System.out.println("      Lista de Empleados");
        System.out.println("-----------------------------------");
        for (i=0;i<empleados.size();i++) {
            if(empleados.get(i).getEmpAnexo() != null){
                System.out.print( (i+1) +" "+empleados.get(i).getPerNombre()+" "+
                    empleados.get(i).getPerApellidoPaterno()+" "+
                    empleados.get(i).getPerApellidoMaterno()+" tiene el anexo : ");
                System.out.println(empleados.get(i).getEmpAnexo());
            }
        }
        try {
            System.out.print("Seleccione un empleado : \t");
            indiceStr = entrada.readLine();
            indice = Integer.parseInt(indiceStr);
            indice=indice-1;
            empleados.get(indice).setEmpAnexo(null);
            System.out.println("El anexo se ha eliminado del usuario"+
                    empleados.get(indice).toString());
        } catch (IOException ex) {
            System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void listadoAsignaciones(){
        System.out.println("-----------------------------------");
        System.out.println("      Reporte de Empleados");
        System.out.println("-----------------------------------");
        for (int i=0;i<empleados.size();i++) {
            System.out.print( (i+1) +" "+empleados.get(i).getPerNombre()+" "+
                    empleados.get(i).getPerApellidoPaterno()+" "+
                    empleados.get(i).getPerApellidoMaterno()+" tiene el anexo : ");
            if(empleados.get(i).getEmpAnexo() != null){
                System.out.println(empleados.get(i).getEmpAnexo());
            }else{
                System.out.println(" Sin asignar ");
            }
        }
        System.out.println("**** Fin reporte ****");
    }
    
    
    /**
     * FUNCION PRINCIPAL (PUNTO DE PARTIDA)
     */
    public static void main(String[] args) {
        String salir = "n"; //INICIALIZAR VARIABLE SALIR CON "N"
        Main principal = new Main();  //INSTANCIA CLASE LA MAIN, PARA FUNCIONES DEL MAIN
        do{
            switch(principal.verMenu()){
                case "1":principal.registroEmpleado(new Empleado());
                    break;
                case "2":principal.asignarAnexo();
                    break;
                case "3":principal.obtenerUbicacion();
                    break;
                case "4":principal.modificarAsignacion();
                    break;
                case "5":principal.desasignarAnexo();
                    break;
                case "6":principal.listadoAsignaciones();
                    break;
                case "7":
                    salir="s";  //BANDERA
                default:
            }
        }while(salir.equals("n")); //PREGUNTA A LA VARIABLE SALIR
              
    }
    
}
