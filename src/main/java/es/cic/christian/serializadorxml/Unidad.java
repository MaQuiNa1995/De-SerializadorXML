package es.cic.christian.serializadorxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "unidad")
@XmlAccessorType(XmlAccessType.FIELD)
public class Unidad {

    private String nombre;
    private int mineral;
    private int vespeno;
    private int segundosCreacion;
    private String raza;

    public Unidad() {

    }

    public Unidad(String nombre, int mineral, int vespeno, int segundosCreacion, String raza) {
        this.nombre = nombre;
        this.mineral = mineral;
        this.vespeno = vespeno;
        this.segundosCreacion = segundosCreacion;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMineral() {
        return mineral;
    }

    public void setMineral(int mineral) {
        this.mineral = mineral;
    }

    public int getVespeno() {
        return vespeno;
    }

    public void setVespeno(int vespeno) {
        this.vespeno = vespeno;
    }

    public int getSegundosCreacion() {
        return segundosCreacion;
    }

    public void setSegundosCreacion(int segundosCreacion) {
        this.segundosCreacion = segundosCreacion;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
