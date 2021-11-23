/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Competidor;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jairo
 */
public interface IArchivo {
    public Competidor eliminar(String cc) throws IOException;
    public Competidor buscar(String cc) throws IOException;
    public List<Competidor> leer() throws IOException;
    public boolean escribir(Competidor c) throws IOException;
}
