package com.antoniomarroffino.exceptions.mapper;

import com.antoniomarroffino.exceptions.AiExtractionException;
import com.antoniomarroffino.models.dto.ApiErrorResponseDto;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.*;

@Provider
public class AiExtractionExceptionMapper
        implements ExceptionMapper<AiExtractionException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(AiExtractionException e) {
        return Response.status(Response.Status.BAD_GATEWAY)
                .entity(ApiErrorResponseDto.of(
                        502,
                        "Bad Gateway",
                        e.getMessage(),
                        uriInfo.getPath()
                ))
                .build();
    }
}
