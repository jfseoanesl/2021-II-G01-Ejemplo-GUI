
package Vista;


import entidades.Competidor;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.RegistroClasificacion;

/**
 *
 * @author jairo
 */
public class VentanaConsulta extends JDialog {
    private Container contenedor;
    private JPanel panelFiltro, panelBase;
    private JScrollPane panelResultado;
    private JLabel lFiltro;
    private JTextField tFiltro;
    private JTable tabla;
    private DefaultTableModel modelo;
    private String titulos[]={"No doc", "Nombre", "Equipo", "Posicion", "Tiempo"};
    private RegistroClasificacion logica;
    
    public VentanaConsulta(JFrame frame, boolean bln) {
        super(frame, bln);
        this.logica = new RegistroClasificacion();
        this.setTitle("Consulta de pilotos - V1");
        this.iniciarComponentes();
        //this.pack(); 
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.actualizarTabla();
        this.setVisible(true);
    }
    
    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.panelBase = new JPanel();
        this.panelBase.setLayout(new BorderLayout());
        this.panelBase.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.contenedor.add(this.panelBase);
    }
    
    public void iniciarPanelFiltro(){
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.lFiltro= new JLabel("Filtro busqueda: ");
        this.tFiltro= new JTextField(10);
        this.tFiltro.addKeyListener(new eventoTecladoFiltro());
        
        this.panelFiltro.add(this.lFiltro);
        this.panelFiltro.add(this.tFiltro);
        
        this.panelBase.add(this.panelFiltro, BorderLayout.NORTH);
        
       
    }
    
    public void iniciarPanelResultado(){
        
        this.panelResultado = new JScrollPane();
        
        this.tabla = new JTable();
        this.modelo = new DefaultTableModel(null, this.titulos);
        this.tabla.setModel(modelo);
        this.panelResultado.setViewportView(this.tabla);
        
        this.panelBase.add(this.panelResultado, BorderLayout.CENTER);
    
    }
    
    public void actualizarTabla(){
        String texto = this.tFiltro.getText();
        try {
            List<Competidor> lista = this.logica.leer();
            this.modelo.setNumRows(0);
            for(Competidor c: lista){
                String fila[]={c.getCc(), c.getNombrePiloto(), c.getEquipoPiloto(), String.valueOf(c.getPosicioClasificacion()), String.valueOf(c.getTiempoCarrera())};
                if(texto==null){
                    this.modelo.addRow(fila);
                }
                else{
                    if(c.getNombrePiloto().toUpperCase().contains(texto.toUpperCase())){
                        this.modelo.addRow(fila);
                    }
                }
            }
            
            
        } catch (IOException ex) {
           VentanaEmergente.mostrarMsg(this, "Error", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    class eventoTecladoFiltro extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e) {
            actualizarTabla();
        }
        
    
    }
    
    
    
    
    
    
}
