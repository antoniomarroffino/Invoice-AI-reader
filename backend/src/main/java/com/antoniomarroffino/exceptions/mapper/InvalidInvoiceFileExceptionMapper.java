package com.antoniomarroffino.exceptions.mapper;

import com.antoniomarroffino.exceptions.InvalidInvoiceFileException;
import com.antoniomarroffino.models.dto.ApiErrorResponseDto;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.*;

@Provider
public class InvalidInvoiceFileExceptionMapper
        implements ExceptionMapper<InvalidInvoiceFileException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(InvalidInvoiceFileException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ApiErrorResponseDto.of(
                        400,
                        "Bad Request",
                        e.getMessage(),
                        uriInfo.getPath()
                ))
                .build();
    }
}
