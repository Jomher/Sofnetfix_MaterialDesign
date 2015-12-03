package com.sofnetfix.sofnetfix;
/**
 * Created by isai on 11-16-15.
 */
public class Servicios {
    private int imagen;
    private String servicio;
    private String detalle;

    public Servicios(int imagen, String nombre, String visitas) {
        this.imagen = imagen;
        this.servicio = nombre;
        this.detalle = visitas;
    }

    public String getNombre() {
        return servicio;
    }

    public String getVisitas() {
        return detalle;
    }

    public int getImagen() {
        return imagen;
    }
}
