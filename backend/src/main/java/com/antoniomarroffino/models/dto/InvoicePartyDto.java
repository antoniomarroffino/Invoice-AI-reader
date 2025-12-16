package com.antoniomarroffino.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoicePartyDto {

    /** Company or person name */
    @JsonAlias({
            "name",
            "companyName",
            "legalName",
            "businessName",
            "sellerName",
            "buyerName"
    })
    public String name;

    /** VAT / Tax identification number */
    @JsonAlias({
            "vatNumber",
            "vatId",
            "vat",
            "taxId",
            "taxNumber",
            "vat_code"
    })
    public String vatNumber;

    /** Full address (free text) */
    @JsonAlias({
            "address",
            "fullAddress",
            "billingAddress",
            "registeredAddress",
            "location"
    })
    public String address;

    /** Country (ISO or full name) */
    @JsonAlias({
            "country",
            "countryCode",
            "nation",
            "isoCountry"
    })
    public String country;

    /** IBAN if present in the document */
    @JsonAlias({
            "iban",
            "ibanNumber",
            "bankAccount",
            "bankIban"
    })
    public String iban;

    /** Optional email or phone if present */
    @JsonAlias({
            "contact",
            "email",
            "phone",
            "contactDetails",
            "contactInfo"
    })
    public String contact;
}
