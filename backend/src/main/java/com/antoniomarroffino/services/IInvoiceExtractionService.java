package com.antoniomarroffino.services;

import com.antoniomarroffino.models.dto.InvoiceExtractionResultDto;
import org.jboss.resteasy.reactive.multipart.FileUpload;

public interface IInvoiceExtractionService {

    InvoiceExtractionResultDto extract(FileUpload file);
}
