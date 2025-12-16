package com.antoniomarroffino.exceptions.mapper;

import com.antoniomarroffino.exceptions.PdfTextExtractionException;
import com.antoniomarroffino.models.dto.ApiErrorResponseDto;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.*;

@Provider
public class PdfTextExtractionExceptionMapper
        implements ExceptionMapper<PdfTextExtractionException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(PdfTextExtractionException e) {
        return Response.status(422)
                .entity(ApiErrorResponseDto.of(
                        422,
                        "Unprocessable Entity",
                        e.getMessage(),
                        uriInfo.getPath()
                ))
                .build();
    }
}
