package es.cic.christian.serializadorxml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listanodes")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaNodes {

    @XmlElement(name = "unidad")
    private List<Unidad> listaNodes = null;

    public List<Unidad> getListaUnidad() {
        return listaNodes;
    }

    public void setListaUnidad(List<Unidad> listaNodes) {
        this.listaNodes = listaNodes;
    }

}