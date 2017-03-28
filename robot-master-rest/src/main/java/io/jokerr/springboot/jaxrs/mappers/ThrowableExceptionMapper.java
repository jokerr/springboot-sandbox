package io.jokerr.springboot.jaxrs.mappers;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author jokerr
 */
//@Provider
public class ThrowableExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {
        if(exception instanceof InternalServerErrorException) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorMessage(exception.getMessage()))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }

        if(exception instanceof NotAcceptableException) {

        }

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorMessage("Invalid Request"))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
