/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author jairo
 */
public class Competidor implements Serializable {
    private String cc;
    private String nombrePiloto;
    private String equipoPiloto;
    private int posicioClasificacion;
    private double tiempoCarrera;
    private Pais pais;

    public Competidor(String cc, String nombrePiloto, String equipoPiloto, int posicioClasificacion, double tiempoCarrera) {
        this.cc = cc;
        this.nombrePiloto = nombrePiloto;
        this.equipoPiloto = equipoPiloto;
        this.posicioClasificacion = posicioClasificacion;
        this.tiempoCarrera = tiempoCarrera;
        this.pais = new Pais("Colombia");
    }

    public Competidor() {
        this.pais = new Pais("Colombia");
    }

    /**
     * @return the cc
     */
    public String getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * @return the nombrePiloto
     */
    public String getNombrePiloto() {
        return nombrePiloto;
    }

    /**
     * @param nombrePiloto the nombrePiloto to set
     */
    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }

    /**
     * @return the equipoPiloto
     */
    public String getEquipoPiloto() {
        return equipoPiloto;
    }

    /**
     * @param equipoPiloto the equipoPiloto to set
     */
    public void setEquipoPiloto(String equipoPiloto) {
        this.equipoPiloto = equipoPiloto;
    }

    /**
     * @return the posicioClasificacion
     */
    public int getPosicioClasificacion() {
        return posicioClasificacion;
    }

    /**
     * @param posicioClasificacion the posicioClasificacion to set
     */
    public void setPosicioClasificacion(int posicioClasificacion) {
        this.posicioClasificacion = posicioClasificacion;
    }

    /**
     * @return the tiempoCarrera
     */
    public double getTiempoCarrera() {
        return tiempoCarrera;
    }

    /**
     * @param tiempoCarrera the tiempoCarrera to set
     */
    public void setTiempoCarrera(double tiempoCarrera) {
        this.tiempoCarrera = tiempoCarrera;
    }
    
    public String getDatosFileText(){ // 123;jairo Francisco;ferrari;2;1.33
        return this.cc+";"+
               this.nombrePiloto+";"+ 
               this.equipoPiloto+";"+ 
               this.posicioClasificacion+";"+ 
               this.tiempoCarrera; 
    }

    /**
     * @return the pais
     */
    public Pais getPais() {
        return pais;
    }
    
}
