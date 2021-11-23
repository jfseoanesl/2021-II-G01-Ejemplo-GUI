/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Competidor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author jairo
 */
public class ArchivoCarreraTexto implements IArchivo {
    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoCarreraTexto() {
        this.archivo = new File("ClasificacionF1.dat");
    }
    
    public ArchivoCarreraTexto(String name){
        this.archivo = new File(name);
    }

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    /**
     * @return the aEscritura
     */
    public FileWriter getaEscritura() {
        return aEscritura;
    }

    /**
     * @param aEscritura the aEscritura to set
     */
    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    /**
     * @return the aLectura
     */
    public Scanner getaLectura() {
        return aLectura;
    }

    /**
     * @param aLectura the aLectura to set
     */
    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }
    
    public Competidor leerCompetidor(String linea[]){
        Competidor c = new Competidor();
        c.setCc(linea[0]);
        c.setNombrePiloto(linea[1]);
        c.setEquipoPiloto(linea[2]);
        c.setPosicioClasificacion(Integer.valueOf(linea[3]));
        c.setTiempoCarrera(Double.valueOf(linea[4]));
        return c;
    }
    
    @Override
    public Competidor eliminar(String cc) throws IOException {
        
        List<Competidor> listadoInicial =  this.leer();
        ArchivoCarreraTexto archivoAux = new ArchivoCarreraTexto("ArchvivoTmpF1.dat");
        Competidor eliminado = null;
        for(Competidor f: listadoInicial){
            if(f.getCc().equals(cc)){ // elemento a eliminar
                eliminado = f;
            }
            else{
                archivoAux.escribir(f);
            }
        }
        
        if(this.archivo.delete()){
            if(archivoAux.getArchivo().exists()){
                if(!archivoAux.getArchivo().renameTo(this.archivo)){
                    throw new IOException("El archivo temporal no pudo ser renombrado");
                }

            }
            else
               this.archivo.createNewFile();
        }
        else{
            throw new IOException("El archivo original no pudo ser elimiando");
        }
            
        
        
        return eliminado;
    }
    
    @Override
    public Competidor buscar(String cc) throws IOException{
        Competidor buscado = null;
        try {
            this.aLectura = new Scanner(this.archivo);
            while(this.aLectura.hasNext()){
                String linea[] = this.aLectura.nextLine().split(";");
                Competidor c = this.leerCompetidor(linea);
                if(c.getCc().equals(cc)){
                    buscado = c;
                    break;
                }
            }
            return buscado;
            
        } catch (FileNotFoundException ex) {
                throw new IOException("EL archivo no se encuentra o no pueder ser leido");
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
    }
    
    @Override
    public List<Competidor> leer() throws IOException{
       List<Competidor> lista = null;
        try {
            
            this.aLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while(this.aLectura.hasNext()){
                String linea[] = this.aLectura.nextLine().split(";");
                Competidor c = this.leerCompetidor(linea);
                lista.add(c);
            }
            
            return lista;
            
        } catch (FileNotFoundException ex) {
                throw new IOException("EL archivo no se encuentra o no pueder ser leido");
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
        
    }
    
    @Override
    public boolean escribir(Competidor c) throws IOException{
        PrintWriter escritor = null;
        try{
            this.aEscritura = new FileWriter(this.archivo,true); // edicio
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(c.getDatosFileText());
            return true;
        }catch(IOException ioe){
            throw new IOException("Error al abrir el archivo para escritura...");
           
        }
        finally{
            if(escritor!=null)
                escritor.close();
            
            if(this.aEscritura!=null){
                 this.aEscritura.close();
            }    
        }
    }
    
    
}
