/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.*;

/**
 *
 * @author jairo
 */
public class VentanaPrincipal extends JFrame {
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem menuItem;

    public VentanaPrincipal() {
        
        this.setTitle("Registro calsificacion premio F1 - Ventana Principal");
        //this.setSize(300, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.initComponents();
        this.setVisible(true);
        
    }
    
    public void initComponents(){
        this.barraMenu = new JMenuBar();
        this.setJMenuBar(this.barraMenu);
        
        this.menu = new JMenu("Opciones");
        this.barraMenu.add(this.menu);
        
        this.menuItem = new JMenuItem("Registrar");
        this.menu.add(menuItem);
        
    }
    
    
    
    
}
