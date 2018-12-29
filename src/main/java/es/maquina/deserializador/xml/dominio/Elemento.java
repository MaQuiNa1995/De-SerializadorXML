package es.maquina.deserializador.xml.dominio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nodo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Elemento {

    private String raza;
    private String nombre;
    private int mineral;
    private int vespeno;
    private int segundosCreacion;

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

    @Override
    public String toString() {

	StringBuilder stringBuilder = new StringBuilder();

	String retornoCarro = "\n\r";

	stringBuilder.append("Raza: ").append(raza).append(retornoCarro);
	stringBuilder.append("Nombre: ").append(nombre).append(retornoCarro);
	stringBuilder.append("Mineral: ").append(mineral).append(retornoCarro);
	stringBuilder.append("Vespeno: ").append(vespeno).append(retornoCarro);
	stringBuilder.append("segundosCreacion: ").append(segundosCreacion);

	return stringBuilder.toString();
    }

}
