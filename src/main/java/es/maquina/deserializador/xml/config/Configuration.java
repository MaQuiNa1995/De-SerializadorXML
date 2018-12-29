package es.maquina.deserializador.xml.config;

import org.springframework.context.annotation.Bean;

import es.maquina.deserializador.xml.servicio.DeserelializadorService;

public class Configuration {

    @Bean
    public DeserelializadorService deserelializador() {
	return new DeserelializadorService();
    }
}
