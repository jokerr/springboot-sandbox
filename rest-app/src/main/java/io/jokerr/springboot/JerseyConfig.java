package io.jokerr.springboot;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

/**
 * @author jokerr
 */
@Configuration
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("io.jokerr.springboot.jaxrs");

//        //work around for JERSEY-2722 - custom exceptions
//        register(JacksonJaxbJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);
    }
}
