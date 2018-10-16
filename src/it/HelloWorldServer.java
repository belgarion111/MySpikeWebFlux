package it;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloWorldServer {
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldServer.class, args);
	}
	
    @Bean
    public UndertowServletWebServerFactory undertowServletWebServerFactory(@Value("${server.port.secondary:9999}") int port) {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addBuilderCustomizers((UndertowBuilderCustomizer) builder -> builder.addHttpListener(port, "0.0.0.0"));
        return factory;
    }

}
