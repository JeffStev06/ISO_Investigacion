package com.example.zapateria;

public class Variables {
    static String codeSolicitud;
    static String fecha;
    static String nombre;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        Variables.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Variables.nombre = nombre;
    }

    public String getCodeSolicitud() {
        return codeSolicitud;
    }

    public void setCodeSolicitud(String codeSolicitud) {
        Variables.codeSolicitud = codeSolicitud;
    }
}
