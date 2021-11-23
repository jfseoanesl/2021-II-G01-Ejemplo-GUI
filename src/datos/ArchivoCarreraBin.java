/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Competidor;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class ArchivoCarreraBin implements IArchivo {
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    public ArchivoCarreraBin() {
        this.archivo = new File("ClasificacionF1Objetos.dat");
    }
    
    
    private void guardarList(ListCompetidores lista) throws IOException{
        
        this.aEscritura = new FileOutputStream(this.archivo);
        ObjectOutputStream escritor = new ObjectOutputStream(this.aEscritura);
        escritor.writeObject(lista);
        escritor.close();
        this.aEscritura.close();
        
    }
    
    private ListCompetidores leerLista()throws IOException{
        
        if(this.archivo.exists()){
            this.aLectura = new FileInputStream(this.archivo);
            ObjectInputStream lector = new ObjectInputStream(this.aLectura);
            try {
                ListCompetidores lista = (ListCompetidores)lector.readObject();
                return lista;
            } catch (ClassNotFoundException ex) {
                throw new IOException("Error en el contenido del achivo");
            }
            finally{
                lector.close();
                this.aLectura.close();
            }
        }
        else{
            return new ListCompetidores();
        }
        
    }
    
    

    @Override
    public Competidor eliminar(String cc) throws IOException {
        ListCompetidores lista = this.leerLista();
        Competidor eliminado = lista.eliminar(cc);
        this.guardarList(lista);
        return eliminado;
    }

    @Override
    public Competidor buscar(String cc) throws IOException {
       ListCompetidores lista = this.leerLista();
       return lista.buscar(cc);
    }

    @Override
    public List<Competidor> leer() throws IOException {
        ListCompetidores lista = this.leerLista();
        return lista.leer();
    }

    @Override
    public boolean escribir(Competidor c) throws IOException {
        ListCompetidores lista = this.leerLista();
        lista.escribir(c);
        this.guardarList(lista);
        return true;
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
     * @return the aLectura
     */
    public FileInputStream getaLectura() {
        return aLectura;
    }

    /**
     * @param aLectura the aLectura to set
     */
    public void setaLectura(FileInputStream aLectura) {
        this.aLectura = aLectura;
    }

    /**
     * @return the aEscritura
     */
    public FileOutputStream getaEscritura() {
        return aEscritura;
    }

    /**
     * @param aEscritura the aEscritura to set
     */
    public void setaEscritura(FileOutputStream aEscritura) {
        this.aEscritura = aEscritura;
    }
}
