package es.maquina.deserializador.xml;

import java.io.File;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.maquina.deserializador.xml.config.Configuration;
import es.maquina.deserializador.xml.dominio.Elemento;
import es.maquina.deserializador.xml.dominio.ListaNodos;
import es.maquina.deserializador.xml.servicio.DeserelializadorService;

public class Main {

    public static void main(String[] args) {

	DeserelializadorService deserelializador = null;

	try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class)) {

	    deserelializador = context.getBean(DeserelializadorService.class);

	}

	if (deserelializador != null) {
	    ListaNodos listaNodos = new ListaNodos();

	    Elemento elemento = new Elemento();
	    elemento.setNombre("Templario Tetrico");
	    elemento.setMineral(150);
	    elemento.setVespeno(75);
	    elemento.setRaza("Protos");
	    elemento.setSegundosCreacion(45);
	    listaNodos.getListaNodos().add(elemento);

	    elemento = new Elemento();
	    elemento.setNombre("Coloso");
	    elemento.setMineral(300);
	    elemento.setRaza("Protos");
	    elemento.setSegundosCreacion(58);
	    elemento.setVespeno(250);
	    listaNodos.getListaNodos().add(elemento);

	    File fichero = new File("Prueba.xml");

	    deserelializador.serializar(listaNodos, fichero, Elemento.class);

	    if (fichero.exists()) {
		System.out.println(deserelializador.deserializar(fichero));
	    }
	}
    }

}
