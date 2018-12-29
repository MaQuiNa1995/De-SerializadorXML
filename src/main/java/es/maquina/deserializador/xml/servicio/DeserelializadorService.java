package es.maquina.deserializador.xml.servicio;

import java.io.File;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.maquina.deserializador.xml.dominio.Elemento;
import es.maquina.deserializador.xml.dominio.ListaNodos;

public class DeserelializadorService {

    // TODO usar Log
    private static final Logger LOG = Logger.getLogger(DeserelializadorService.class.getName());

    /**
     * Este metodo sirve para el paso de un XML a un objeto Java
     * <p>
     * Lo primero que haremos ser� instanciar el objeto que nos permitira leer el
     * XML, JAXBContext y Unmarshaller
     * <p>
     * Despues crearemos la lista que contendra todos los objetos que leamos
     * <p>
     * Seguidamente recorreremos la lista con un forEach mostrando por pantalla los
     * atributos del XML
     *
     * @throws JAXBException
     */
    public String deserializar(File fichero) {

	ListaNodos unidadesLista = null;

	try {
	    JAXBContext jaxbContext = JAXBContext.newInstance(ListaNodos.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    unidadesLista = (ListaNodos) jaxbUnmarshaller.unmarshal(fichero);
	} catch (JAXBException exception) {
	    exception.getMessage();
	    // TODO manejar excepcion
	}

	StringBuilder elemento = new StringBuilder();
	if (unidadesLista != null) {
	    for (Elemento unidadSacada : unidadesLista.getListaNodos()) {
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
     * Despues le setearemos la salida para que lo imprima en el XML formateado
     * <p>
     * Seguidamente lo mostraremos por pantalla y lo imprimiremos en el XML
     *
     * @throws JAXBException
     */
    public void serializar(ListaNodos listaNodos, File fichero, Class<?> clase) {

	try {
	    JAXBContext jaxbContext = JAXBContext.newInstance(ListaNodos.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//	    jaxbMarshaller.marshal(listaNodos, System.out);
	    jaxbMarshaller.marshal(listaNodos, fichero);

	} catch (JAXBException exception) {
	    exception.getMessage();
	    // TODO manejar excepcion
	}

    }
}
