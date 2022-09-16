package com.example.stacckycpepapi.domainmodel.enheter;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Domain object containing information about a company
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EnheterRoot {
    public String organisasjonsnummer;
    public String navn;
    public Organisasjonsform organisasjonsform;
    public String hjemmeside;
    public Postadresse postadresse;
    public String registreringsdatoEnhetsregisteret;
    public boolean registrertIMvaregisteret;
    public Naeringskode1 naeringskode1;
    public int antallAnsatte;
    public Forretningsadresse forretningsadresse;
    public String stiftelsesdato;
    public InstitusjonellSektorkode institusjonellSektorkode;
    public boolean registrertIForetaksregisteret;
    public boolean registrertIStiftelsesregisteret;
    public boolean registrertIFrivillighetsregisteret;
    public String sisteInnsendteAarsregnskap;
    public boolean konkurs;
    public boolean underAvvikling;
    public boolean underTvangsavviklingEllerTvangsopplosning;
    public String maalform;
    public Links _links;
}
