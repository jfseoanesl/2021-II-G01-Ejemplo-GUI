/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datos.*;
import entidades.Competidor;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jairo
 */
public class RegistroClasificacion {
    private IArchivo datos;

    public RegistroClasificacion() {
        //this.datos = new ArchivoCarreraTexto();
        this.datos = new ArchivoCarreraBin();
        //this.datos = new ListCompetidores();
    }

    /**
     * @return the datos
     */
    public IArchivo getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(IArchivo datos) {
        this.datos = datos;
    }
    
    public Competidor eliminar(String cc) throws IOException{
        return this.datos.eliminar(cc);
    }
    
    public Competidor buscar(String cc) throws IOException{
        return this.datos.buscar(cc);
    }
    public List<Competidor> leer() throws IOException{
        return this.datos.leer();
    }
    
    public boolean escribir(Competidor c) throws IOException{
        return this.datos.escribir(c);
    }
    
}
