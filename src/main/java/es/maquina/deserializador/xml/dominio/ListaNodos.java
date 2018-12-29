package es.maquina.deserializador.xml.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listaNodos")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaNodos {

    @XmlElement(name = "nodo")
    private List<Nodo> listaNodos = new ArrayList<>();

    public List<Nodo> getListaNodos() {
	return listaNodos;
    }

    public void setListaNodos(List<Nodo> listaNodos) {
	this.listaNodos = listaNodos;
    }

}