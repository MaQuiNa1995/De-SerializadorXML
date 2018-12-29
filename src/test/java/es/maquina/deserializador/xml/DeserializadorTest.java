package es.maquina.deserializador.xml;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.maquina.deserializador.xml.config.Configuration;
import es.maquina.deserializador.xml.dominio.Elemento;
import es.maquina.deserializador.xml.dominio.ListaNodos;
import es.maquina.deserializador.xml.servicio.DeserelializadorService;
import junit.framework.TestCase;

/**
 * Test del servicio de Deserializacion
 * 
 * @author MaQuiNa1995
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Configuration.class })
public class DeserializadorTest extends TestCase {

    /**
     * Creacion de los ficheros a nivel de clase para poder usar la misma referencia
     * en distintos test en el futuro
     */
    private File serializarFile = new File("serializar.xml");
    private File deserializarFile = new File("deserializar.xml");

    /**
     * De las siglas en Ingles (C.U.T) Class Under Test - Clase a Testear
     */
    @Autowired
    private DeserelializadorService cut;

    /**
     * Test de la serializacion
     * <p>
     * Este se encarga de la eliminacion por si acaso del archivo si existe que
     * vamos a serializar
     * <p>
     * Para acto seguido crear los POJOS necesarios para serializar correctamente el
     * XML
     * <p>
     * El test pasa si el archivo resultante tiene longitud
     */
    @Test
    public void serilizarTest() {
	serializarFile.deleteOnExit();

	// Nos aseguramos de que no nos de un falso positivo eliminandole si existe para
	// crearlo desde 0
	if (serializarFile.exists()) {
	    serializarFile.delete();
	}

	// Creamos un objeto random para inicializar las variables int a un numero al
	// azar
	Random numAleatorio = new Random();

	// Creamos la lista de elementos a serializar
	List<Elemento> listaElementos = new ArrayList<>();

	// Creamos el POJO donde guardaremos nuestros datos para serializar
	Elemento elemento = new Elemento();
	elemento.setNombre("Zerling");
	elemento.setRaza("Zerg");
	elemento.setSegundosCreacion(numAleatorio.nextInt(90) + 1);
	elemento.setVespeno(numAleatorio.nextInt(100) + 1);
	elemento.setMineral(numAleatorio.nextInt(50) + 1);

	// Le añadimos a la lista creada anteriormente
	listaElementos.add(elemento);

	// Creamos nuestra lista de POJOS para ser serializados
	ListaNodos listaNodos = new ListaNodos();
	listaNodos.setListaNodos(listaElementos);

	// El test pasa si el archivo resultante tiene algo dentro
	cut.serializar(listaNodos, serializarFile);
	assertTrue(serializarFile.length() != 0);
    }

    /**
     * Test de la deserializacion
     * <p>
     * Este se encarga de crear un archivo Xml para inmediatamente ser deserializado
     * (al hacer esta operacion en el propio test se consigue independencia)
     * <p>
     * El test fallara si lo que leemos del archivo no tiene longitud
     */
    @Test
    public void deserializarTest() {
	deserializarFile.deleteOnExit();

	// Creamos la String que contendra el xml formateado
	String xmlFormateado = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + "<listaNodos>\r\n"
		+ "    <nodo>\r\n" + "        <raza>Protos</raza>\r\n" + "        <nombre>Coloso</nombre>\r\n"
		+ "        <mineral>300</mineral>\r\n" + "        <vespeno>250</vespeno>\r\n"
		+ "        <segundosCreacion>58</segundosCreacion>\r\n" + "    </nodo>\r\n" + "</listaNodos>";

	// Escribimos en el fichero para poder leerlo mas tarde y asi conseguir un test
	// independiente de serilizarTest
	try (PrintWriter printWriter = new PrintWriter(deserializarFile, "UTF-8")) {
	    printWriter.write(xmlFormateado);
	} catch (IOException exception) {
	    // Si por algun casual no se pudiera crear el archivo el test fallaria
	    fail();
	}

	// Recuperamos en una variable lo que hemos deserializado del archivo
	String ficheroDeserializado = cut.deserializar(deserializarFile);

	// Comprobamos que tenga longitud
	assertTrue(ficheroDeserializado.length() != 0);

    }

}
