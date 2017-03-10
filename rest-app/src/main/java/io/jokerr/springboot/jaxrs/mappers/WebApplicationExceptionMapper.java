package io.jokerr.springboot.jaxrs.mappers;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author jokerr
 */
@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException exception) {
        System.out.println("exception message: " + exception.getMessage());
        System.out.println("exception response: " + exception.getResponse().toString());
        System.out.println("exception response entity: " + exception.getResponse().getEntity());
        return Response.status(exception.getResponse().getStatus())
                .entity(new ErrorMessage(exception.getResponse().getStatusInfo().getReasonPhrase()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
