/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import entidades.Competidor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import modelo.RegistroClasificacion;

/**
 *
 * @author jairo
 */
public class VentanaRegistro extends JDialog {
    private JPanel panelDatos, panelBotones;
    private JLabel lbCc, lbNombre, lbEquipo, lbPosicion, lbTiempo;
    private JFormattedTextField ftCc, ftTiempo;
    private JTextField tNombre;
    private JComboBox cbEquipo;
    private JSpinner jsPosicion;
    private RegistroClasificacion logica;
    
    private Container contenedor;
    
    private JButton bGuardar, bBuscar, bEliminar, bCancelar;

    
    public VentanaRegistro(JFrame owner, boolean modal) {
        super(owner, modal);
        this.logica = new RegistroClasificacion();
        this.initComponentes();
        this.setTitle("Registro de clasificacion---ventana secundaria");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.pack();
        this.setSize(600, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void initComponentes(){
        
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.panelDatos();
        this.panelBotones();
        
    }
    
    public void panelBotones(){
        this.panelBotones = new JPanel();
        this.panelBotones.setLayout(new GridLayout(4, 1, 5,5));
        
        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new clickBotonGuardar());
        
        this.bBuscar = new JButton("Buscar");
        this.bBuscar.addActionListener(new clickBotonBuscar());
        
        this.bEliminar = new JButton("Eliminar");
        this.bEliminar.addActionListener(new clickBotonEliminar());
        
        this.bCancelar = new JButton("Cancelar");
        this.bCancelar.addActionListener(new clickBotonCancelar());
        
        
        this.panelBotones.add(this.bGuardar);
        this.panelBotones.add(this.bBuscar);
        this.panelBotones.add(this.bEliminar);
        this.panelBotones.add(this.bCancelar);
        
        JPanel subpanel = new JPanel();
        subpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        subpanel.setLayout(new FlowLayout());
        subpanel.add(this.panelBotones);
        
        this.contenedor.add(subpanel, BorderLayout.EAST);
        
        
    }
    
    public void panelDatos(){
        this.panelDatos = new JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelDatos.setLayout(new GridLayout(5,2,5,5));
        
        this.lbCc = new JLabel("No Doc: ");
        this.lbEquipo=  new JLabel("Equipo: ");
        this.lbNombre = new JLabel("Nombre: ");
        this.lbPosicion = new JLabel("Posicion: ");
        this.lbTiempo = new JLabel("Timepo: ");
        
        
        try {
            MaskFormatter mascara = new MaskFormatter("##########");
            this.ftCc = new JFormattedTextField(mascara);
            this.ftCc.setValue("0123456789");
            
            MaskFormatter mascara2 = new MaskFormatter("#.####");
            this.ftTiempo = new JFormattedTextField(mascara2);
            this.ftTiempo.setValue("0.0000");
            
            
        } catch (ParseException ex) {
            
        }
        
        
        this.tNombre = new JTextField(null);
        
        SpinnerNumberModel modelo = new SpinnerNumberModel(1, 1, 30,1);
        this.jsPosicion = new JSpinner(modelo);
        
        this.cbEquipo = new JComboBox();
        this.cbEquipo.addItem("Ferrari");
        this.cbEquipo.addItem("BMW");
        this.cbEquipo.addItem("RedBull");
        
        this.panelDatos.add(this.lbCc);
        this.panelDatos.add(this.ftCc);
        
        this.panelDatos.add(this.lbNombre);
        this.panelDatos.add(this.tNombre);
        
        this.panelDatos.add(this.lbEquipo);
        this.panelDatos.add(this.cbEquipo);
        
        this.panelDatos.add(this.lbPosicion);
        this.panelDatos.add(this.jsPosicion);
        
        this.panelDatos.add(this.lbTiempo);
        this.panelDatos.add(this.ftTiempo);
        
        
        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);
        
        
    }
    
    public Competidor leerDatosComponentes(){
        
        Competidor c = new Competidor();
        Object cc = this.ftCc.getValue();
        if(cc!=null)
            c.setCc(cc.toString());
        else
            c.setCc(null);
        
        c.setNombrePiloto(this.tNombre.getText());
        c.setEquipoPiloto(this.cbEquipo.getSelectedItem().toString());
        c.setPosicioClasificacion(Integer.valueOf(this.jsPosicion.getValue().toString()));
        
        Object tiempo = this.ftTiempo.getValue();
        if(tiempo!=null)
            c.setTiempoCarrera(Double.valueOf(tiempo.toString()));
        else
            c.setTiempoCarrera(0);
        
        return c;
    
    }
    
    
    public void guardar(){
        Competidor c = this.leerDatosComponentes();
        try {
            this.logica.escribir(c);
            VentanaEmergente.mostrarMsg(this, "Confirmacion", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException | NullPointerException  ex) {
            
            VentanaEmergente.mostrarMsg(this, "Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    
    class clickBotonGuardar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           guardar();
        }

    }
    
    class clickBotonBuscar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           //codigo
           System.out.println("Buscar");
        }

    }
    
    class clickBotonEliminar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           //codigo
           System.out.println("Eliminar");
        }

    }
    
    class clickBotonCancelar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           //codigo
           System.out.println("Cancelar");
        }

    }
    
    
}
