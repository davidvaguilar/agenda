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
import model.Sexo;

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
        System.out.println("-----------------------------------");
        System.out.print("Ingrese opcion\t");
        try {
            String opcion=entrada.readLine();
            return opcion;
        } catch (IOException ex) {
            System.out.println("Hubo un error al ingresar una opcion "+ex.toString());
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "0";
    }
    
    public void registroEmpleado(){
        Empleado empleado=new Empleado();
        System.out.println("-----------------------------------");
        System.out.println("       Registro Empleados");
        System.out.println("-----------------------------------");
        try{
            System.out.print("Ingrese Rut: ");
            empleado.setPerRut(entrada.readLine());
            System.out.print("Ingrese Nombre: ");
            empleado.setPerNombre(entrada.readLine());
            System.out.print("Ingrese Apellidos: ");
            empleado.setPerApellidos(entrada.readLine());
            System.out.println("Seleccione Sexo: ");
            for (Sexo s: Sexo.values() ) {
                System.out.println ("\t" + s.toString() + " es " + s.getSexDescripcion());
            }
            System.out.print("Opcion : \t");
            empleado.setPerSexo(entrada.readLine());
            
        }catch(IOException ex){
            System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
        }
        empleados.add(empleado);
    }
    
    public void asignarAnexo(){
        String indiceStr;
        int indice, i=0;
        
        System.out.println("-----------------------------------");
        System.out.println("      Lista de Trabajadores");
        System.out.println("-----------------------------------");
        for (i=0;i<empleados.size();i++) {
            System.out.println((i+1)+" "+empleados.get(i).getPerNombre()+" "+
                    empleados.get(i).getPerApellidoPaterno()+" "+
                    empleados.get(i).getEmpAnexo());
        }
        if(i>0){
            try {
                indiceStr = entrada.readLine();
                indice = Integer.parseInt(indiceStr);
                indice = indice-1;
                for(Anexo a:Anexo.values()){ 
                    System.out.println("\t" + a.getAneCodigo()+ " - "+a.toString() + " area: "+ a.getAneUbicacion());
                }
                System.out.print("Seleccione Anexo: ");
                empleados.get(indice).setEmpAnexo(entrada.readLine());
            } catch (IOException ex) {
                System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch(NumberFormatException ex){
                System.out.println("Ocurrio un error al convertir numero= "+ex.toString());
            }
        }else{
            System.out.println("-NO existen Trabajadores Ingresados-");
        }
    }
    
    public void obtenerUbicacion(){
        String indiceStr;
        Integer indice;
        System.out.println("-----------------------------------");
        System.out.println("      Lista de Trabajadores");
        System.out.println("-----------------------------------");
        for (int i=0;i<empleados.size();i++) {
            System.out.println((i+1)+" "+empleados.get(i).toString());
        }
        try {
            indiceStr = entrada.readLine();
            indice = Integer.parseInt(indiceStr);
            System.out.println("El anexo se encuentra ubicado en: "+
                    empleados.get(indice).getEmpAnexo().getAneUbicacion());
        } catch (IOException ex) {
            System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarAsignacion(){
        String indiceStr;
        Integer indice;
        System.out.println("-----------------------------------");
        System.out.println("      Lista de Trabajadores");
        System.out.println("-----------------------------------");
        for (int i=0;i<empleados.size();i++) {
            System.out.println((i+1)+" "+empleados.get(i).toString());
        }
        try {
            indiceStr = entrada.readLine();
            indice = Integer.parseInt(indiceStr);
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
        } catch (IOException ex) {
            System.out.println("Ocurrio un error al ingresar datos= "+ex.toString());
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desasignarAnexo(){
        String indiceStr;
        Integer indice;
        System.out.println("-----------------------------------");
        System.out.println("      Lista de Trabajadores");
        System.out.println("-----------------------------------");
        for (int i=0;i<empleados.size();i++) {
            System.out.println((i+1)+" "+empleados.get(i).toString());
        }
        try {
            indiceStr = entrada.readLine();
            indice = Integer.parseInt(indiceStr);
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
            System.out.println(empleados.get(i).reporte());
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String salir;
        Main principal=new Main();
        do{
            switch (principal.verMenu()){
                case "1":principal.registroEmpleado();
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
                default:
            }
            System.out.print("Desea Salir del Programa s = SI, n = NO :\t"); 

            salir=input.next();
        }while(salir.equals("n"));
       
        
        
        
        
        
        
        
        
    }
    
}
