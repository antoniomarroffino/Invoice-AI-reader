package com.antoniomarroffino.controllers;

import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import com.antoniomarroffino.services.IInvoiceExtractionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;
import org.jetbrains.annotations.NotNull;

@Path("/invoices")
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)
public class InvoiceExtractionController {

    @Inject
    IInvoiceExtractionService extractionService;

    @POST
    @Path("/extract")
    public InvoiceExtractionResultDto extractInvoice(
            @NotNull @RestForm("file") FileUpload file
    ) {
        return extractionService.extract(file);
    }
}
