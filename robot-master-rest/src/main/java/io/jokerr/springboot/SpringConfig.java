package io.jokerr.springboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jokerr
 */
@Configuration
@ComponentScan(basePackages = {
        "io.jokerr.springboot.beans"
})
public class SpringConfig {

}
