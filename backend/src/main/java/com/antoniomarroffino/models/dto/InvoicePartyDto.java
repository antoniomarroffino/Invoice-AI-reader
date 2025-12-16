package com.antoniomarroffino.models.dto;

public class InvoicePartyDto {

    public String name;
    public String vatNumber;
    public String address;
    public String country;

    /** IBAN if present in the document */
    public String iban;

    /** Optional email or phone if present */
    public String contact;
}
