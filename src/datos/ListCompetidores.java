/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Competidor;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jairo
 */
public class ListCompetidores implements IArchivo, Serializable{
    private List<Competidor> lista;

    public ListCompetidores() {
        this.lista = new ArrayList();
    }
    
    
    
    @Override
    public Competidor eliminar(String cc) throws IOException {
        
        Iterator<Competidor> i = this.lista.iterator();
        while(i.hasNext()){
            Competidor c = i.next();
            if(c.getCc().equals(cc)){
                i.remove();
                return c;
            }
        }
        return null;
    }

    @Override
    public Competidor buscar(String cc) throws IOException {
        
        for(Competidor c : this.lista){
            if(c.getCc().equals(cc)){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Competidor> leer() throws IOException {
        return this.lista;
    }

    @Override
    public boolean escribir(Competidor c) throws IOException {
        
        return this.lista.add(c);
    }
    
}
