/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author jairo
 */
public class VentanaEmergente {
    
    
    public static void mostrarMsg(JDialog padre, String titulo, String contenido, int icono){
        
        JOptionPane.showMessageDialog(padre, contenido, titulo, icono);
        
    }
    
}
