/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import entidades.Competidor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modelo.RegistroClasificacion;
/**
 *
 * @author jairo
 */
public class VistaConsola {
    
    
    public void run(){
        
        RegistroClasificacion registro = new RegistroClasificacion();
        Competidor comp1 = new Competidor("333", "Montoya", "BMW", 1, 1.30);
        Competidor comp2 = new Competidor("444", "Alonso", "Renault", 2, 1.31);
        Competidor comp3 = new Competidor("555", "Hamilton", "Mercedes", 3, 1.32);
        Competidor comp4 = new Competidor("777", "Schummager", "Ferrari", 4, 1.33);
        
        try{
            registro.escribir(comp1);
            registro.escribir(comp2);
            registro.escribir(comp3);
            registro.escribir(comp4);

            System.out.println("\n-------------------");
            System.out.println("Lista inicial: ");
            List<Competidor> lista = registro.leer();
            imprimirLista(lista);

            System.out.println("\n-------------------");
            Competidor eliminado = registro.eliminar("333");
            if(eliminado!=null){ // 
                System.out.println("Elemento eliminado: ");
                imprimirCompetidor(eliminado);
            }
            else{
                System.out.println("El competidor de cc 333 no se encuentra en el archivo");
            }

            System.out.println("\n-------------------");

            Competidor buscado = registro.buscar("555");
            if(buscado!=null){ // 
                System.out.println("Elemento encontrado: ");
                imprimirCompetidor(buscado);
            }
            else{
                System.out.println("El competidor de cc 555 no se encuentra en el archivo");
            }

            System.out.println("\n-------------------");
            System.out.println("Lista Final: ");
            lista = registro.leer();
            imprimirLista(lista);
        }catch(IOException ioe){
            System.out.println(ioe);
        }   
        
    }
    
    public  void imprimirCompetidor(Competidor c){
        
        System.out.printf("%-10s %-10s %-10s %-10d %.2f %n", c.getCc(), c.getNombrePiloto(), c.getEquipoPiloto(), 
                c.getPosicioClasificacion(), c.getTiempoCarrera());
        System.out.println("Pais: " + c.getPais().getNombre());
    }
    
    public void imprimirLista(List<Competidor> lista){
        System.err.printf("%-10s %-10s %-10s %-10s %s%n", "Cedula", "Nombre", "Equipo","Posicion", "Tiempo");
        for(Competidor c: lista){
            imprimirCompetidor(c);
        }
    }
}
