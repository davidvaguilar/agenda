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
import model.Anexo;
import model.Empleado;
import model.Persona;

/**
 *
 * @author David
 */
public class Main {

    ArrayList<Empleado> empleados=new ArrayList();
    InputStreamReader flujoBytes=new InputStreamReader(System.in);
    BufferedReader entrada=new BufferedReader(flujoBytes);
    
    public String verMenu(){
        System.out.println("-----------------------------------");
        System.out.println("       Agenda de Anexos        ");
        System.out.println("-----------------------------------");
        System.out.println(" 1.- Registrar Empleado");
        System.out.println(" 2.- Asignar Anexo a Empleado");
        System.out.println(" 3.- Obtener ubicacion de un Anexo");
        System.out.println(" 4.- Modificar Anexo a Empleado");
        System.out.println(" 5.- Desasignar Anexo a Empleado");
        System.out.println(" 6.- Listado de Asignaciones");
        System.out.println(" 7.- Salir del Programa");
        System.out.println("-----------------------------------");
        System.out.print("Ingrese opcion\t");
        try {
            String opcion=entrada.readLine();
            return opcion;
        } catch (IOException ex) {
            System.out.println("Hubo un error al ingresar una opcion "+ex.toString());
        }
        return "0";
    }
    
    public void registroEmpleado(Empleado e){
        //=new Empleado();
        
        System.out.println("-----------------------------------");
        System.out.println("       Registro Empleados");
        System.out.println("-----------------------------------");
        System.out.print("Ingrese Rut: ");
        while(e.getPerRut().isEmpty()){
            try{
                e.setPerRut(entrada.readLine());
            }catch(IOException ex){
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            }
        }
        System.out.print("Ingrese Nombre: ");
        while(e.getPerNombre().isEmpty()){
            try{
                e.setPerNombre(entrada.readLine());
            }catch(IOException ex){
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            }
        }
        System.out.print("Ingrese Apellidos: ");
        while(e.getPerApellidoPaterno().isEmpty()){
            try{
                e.setPerApellidos(entrada.readLine());
            }catch(IOException ex){
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            }
        }
        System.out.print("Ingrese Fecha de Nacimiento formato(dd-mm-aaaa): ");
        try{
            e.setPerNacimiento(entrada.readLine());
        }catch(IOException ex){
            System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
        }
        System.out.println("Menu Sexo: ");
        for (Persona.SexoPersona s: Persona.SexoPersona.values() ) {
            System.out.println ("\t" + s.toString() + " es " + s.getSexDescripcion());
        }
        System.out.print("Seleccione una Opcion : \t");
        try{
            e.setPerSexo(entrada.readLine());
        }catch(IOException ex){
            System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
        }
        try{
            empleados.add(e);
            System.out.println("*****Empleado registrado con Exito*****");
            System.out.println(e.toString());
            System.out.println(e.getPerSexo().getSexDescripcion());
        }catch(Exception ex){
            System.out.println("Empleado no fue registrado, error "+ex.toString());
        }
        
    }
    
    public void asignarAnexo(){
        String indiceStr;
        int indice, i=0;
        System.out.println("-----------------------------------");
        System.out.println("      Lista de Empleados");
        System.out.println("-----------------------------------");
        for (i=0;i<empleados.size();i++) {
            System.out.print( (i+1) +" "+empleados.get(i).getPerNombre()+" "+
                    empleados.get(i).getPerApellidoPaterno()+" "+
                    empleados.get(i).getPerApellidoMaterno()+" tiene el anexo : ");
            if(empleados.get(i).getEmpAnexo() != null){
                System.out.println(empleados.get(i).getEmpAnexo());
            }else{
                System.out.println(" Sin asignar ");
            }
        }
        if(i>0){
            try {
                System.out.print("Seleccione un empleado : \t");
                indiceStr = entrada.readLine();
                indice = Integer.parseInt(indiceStr);
                indice = indice-1;
                System.out.println("-----------------------------------");
                System.out.println("         Lista de Anexo");
                System.out.println("-----------------------------------");
                for(Anexo a:Anexo.values()){ 
                    System.out.println("\t" + a.getAneCodigo()+ " - "+a.toString() + " area: "+ a.getAneUbicacion());
                }
                System.out.print("Seleccione Anexo: ");
                empleados.get(indice).setEmpAnexo(entrada.readLine());
                System.out.println("*****Empleado se asigno anexo "+empleados.get(indice).getEmpAnexo().name()+" *****");
            } catch (IOException ex) {
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            } catch(NumberFormatException ex){
                System.out.println("Ocurrio un error al convertir numero= "+ex.toString());
            }
        }else{
            System.out.println("-NO existen Trabajadores Ingresados-");
        }
    }
    
    public void obtenerUbicacion(){
        String indiceStr;
        Integer indice, i=0;
        System.out.println("-----------------------------------");
        System.out.println("  Lista de Trabajadores con Anexo");
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
        System.out.println("      Reporte de Trabajadores");
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
        String salir="n"; //INICIALIZAR VARIABLE SALIR CON "N"
        Main principal=new Main();  //INSTANCIA CLASE
        do{
            switch (principal.verMenu()){
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
                    salir="s";
                default:
            }
        }while(salir.equals("n")); //PREGUNTA A LA VARIABLE SALIR
              
    }
    
}
