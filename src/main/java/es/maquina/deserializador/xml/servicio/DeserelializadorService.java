package es.maquina.deserializador.xml.servicio;

import java.io.File;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.maquina.deserializador.xml.dominio.Nodo;
import es.maquina.deserializador.xml.dominio.ListaNodos;

/**
 * Servicio encargado de la serializacion y deserializacion de datos en XML
 * 
 * @author MaQuiNa1995
 *
 */
public class DeserelializadorService {

    /**
     * Logger generico de la clase
     */
    private static final Logger LOG = Logger.getLogger(DeserelializadorService.class.getName());

    /**
     * Este metodo sirve para el paso de un XML a un objeto Java
     * <p>
     * Lo primero que haremos sera instanciar el objeto que nos permitira leer el
     * XML, JAXBContext y Unmarshaller
     * <p>
     * Despues crearemos la lista que contendra todos los objetos que leamos
     * <p>
     * Seguidamente recorreremos la lista con un forEach mostrando por pantalla los
     * atributos del XML
     *
     * @param fichero a deserializar
     * @return contenido del fichero en formato String
     */
    public String deserializar(File fichero) {

	ListaNodos unidadesLista = null;

	try {
	    JAXBContext jaxbContext = JAXBContext.newInstance(ListaNodos.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    unidadesLista = (ListaNodos) jaxbUnmarshaller.unmarshal(fichero);
	} catch (JAXBException exception) {
	    LOG.warning("ha ocurrido una exception: " + exception.getMessage());
	}

	StringBuilder elemento = new StringBuilder();
	if (unidadesLista != null) {
	    for (Nodo unidadSacada : unidadesLista.getListaNodos()) {
		elemento.append(unidadSacada.toString()).append("\r\n");
	    }
	}
	return elemento.toString();
    }

    /**
     * Este metodo le usaremos para pasar de un objeto java a un XML
     * <p>
     * Lo primero que haremos sera instanciar los objetos que nos permitiran grabar
     * los atributos del objeto a un xml JAXBContext y Marshaller
     * <p>
     * Despues imprimimos los datos al XML
     *
     * @param listaNodos lista de nodos a serializar
     * @param fichero    fichero donde serializar los datos
     */
    public void serializar(ListaNodos listaNodos, File fichero) {

	try {
	    JAXBContext jaxbContext = JAXBContext.newInstance(ListaNodos.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    jaxbMarshaller.marshal(listaNodos, fichero);

	} catch (JAXBException exception) {
	    LOG.warning("ha ocurrido una exception: " + exception.getMessage());
	}

    }
}
