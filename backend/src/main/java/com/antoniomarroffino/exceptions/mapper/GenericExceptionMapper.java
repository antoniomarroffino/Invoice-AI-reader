package com.antoniomarroffino.exceptions.mapper;

import com.antoniomarroffino.models.dto.ApiErrorResponseDto;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.*;

@Provider
public class GenericExceptionMapper
        implements ExceptionMapper<Throwable> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(Throwable e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ApiErrorResponseDto.of(
                        500,
                        "Internal Server Error",
                        "Unexpected error occurred",
                        uriInfo.getPath()
                ))
                .build();
    }
}
