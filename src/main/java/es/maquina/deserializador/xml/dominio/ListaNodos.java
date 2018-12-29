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
    private List<Elemento> listaNodos = new ArrayList<>();

    public List<Elemento> getListaNodos() {
	return listaNodos;
    }

    public void setListaNodos(List<Elemento> listaNodos) {
	this.listaNodos = listaNodos;
    }

}