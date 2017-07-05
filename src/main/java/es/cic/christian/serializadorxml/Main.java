package es.cic.christian.serializadorxml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {

    static ListaUnidades listaUnidades = new ListaUnidades();

    /**
     * </p>
     * En este método inicializaremos los objetos que usaremos para grabar los
     * atributos en el XML
     * </p>
     */
    private static void iniciar() {
        listaUnidades.setListaUnidad(new ArrayList<Unidad>());

        Unidad unidad = new Unidad();
        unidad.setNombre("Templario Tetrico");
        unidad.setMineral(150);
        unidad.setVespeno(75);
        unidad.setRaza("Protos");
        unidad.setSegundosCreacion(45);

        Unidad unidad2 = new Unidad();
        unidad2.setNombre("Coloso");
        unidad2.setMineral(300);
        unidad2.setRaza("Protos");
        unidad2.setSegundosCreacion(58);
        unidad2.setVespeno(250);

        listaUnidades.getListaUnidad().add(unidad);
        listaUnidades.getListaUnidad().add(unidad2);
    }

    public static void main(String[] args) throws JAXBException {
        iniciar();
        serializar();
        System.out.println("************************************************");
        deserializar();
    }

    /**
     * <p>
     * Este método sirve para el paso de un XML a un objeto Java
     * </p><p>
     * Lo primero que haremos será instanciar el objeto que nos permitira leer
     * el XML, JAXBContext y Unmarshaller
     * </p><p>
     * Despues crearemos la lista que contendrá todos los objetos que leamos
     * </p><p>
     * Seguidamente recorreremos la lista con un forEach mostrando por pantalla
     * los atributos del XML
     * </p>
     *
     * @throws JAXBException
     */
    private static void deserializar() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ListaUnidades.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ListaUnidades unidadesLista = (ListaUnidades) jaxbUnmarshaller.unmarshal(new File("hola.xml"));

        System.out.println("-----------------------------------");
        for (Unidad unidadSacada : unidadesLista.getListaUnidad()) {
            System.out.println("Nombre: ".concat(unidadSacada.getNombre()));
            System.out.println("Raza: ".concat(unidadSacada.getRaza()));
            System.out.println("Mineral: " + unidadSacada.getMineral());
            System.out.println("Vespeno: " + unidadSacada.getVespeno());
            System.out.println("Tiempo De Construccion: " + unidadSacada.getSegundosCreacion());
            System.out.println("-----------------------------------");
        }
    }

    /**
     * <p>
     * Este método le usaremos para pasar de un objeto java a un XML
     * </p><p>
     * Lo primero que haremos será instanciar los objetos que nos permitirán
     * grabar los atributos del objeto a un xml JAXBContext y Marshaller
     * </p><p>
     * Despues le setearemos la salida para que lo imprima en el XML formateado
     * </p><p>
     * Seguidamente lo mostraremos por pantalla y lo imprimiremos en el XML
     * </p>
     *
     * @throws JAXBException
     */
    private static void serializar() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ListaUnidades.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(listaUnidades, System.out);
        jaxbMarshaller.marshal(listaUnidades, new File("hola.xml"));
    }

    
}
