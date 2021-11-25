/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jairo
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem menuItemRegistro, menuItemConsulta;

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
        
        this.menuItemRegistro = new JMenuItem("Registrar");
        this.menuItemRegistro.addActionListener(this);
        this.menu.add(this.menuItemRegistro);
        
        this.menuItemConsulta = new JMenuItem("Consulta");
        this.menuItemConsulta.addActionListener(this);
        this.menu.add(this.menuItemConsulta);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.menuItemRegistro){
            VentanaRegistro registro = new VentanaRegistro(this, true);
        }
        else{
            
            VentanaConsulta consulta = new VentanaConsulta(this, true);
        }
        
        
    }
    
    
    
    
}
