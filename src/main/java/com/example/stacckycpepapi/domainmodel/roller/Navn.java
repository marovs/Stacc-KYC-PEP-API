package com.example.stacckycpepapi.domainmodel.roller;

public class Navn {
    public String fornavn;
    public String mellomnavn;
    public String etternavn;

    public String formatName() {
        StringBuilder builder = new StringBuilder();
        if (fornavn != null && !fornavn.isBlank()) {
            builder.append(fornavn).append(" ");
        }
        if (mellomnavn != null && !mellomnavn.isBlank()) {
            builder.append(mellomnavn).append(" ");
        }
        if (etternavn != null && !etternavn.isBlank()) {
            builder.append(etternavn).append(" ");
        }
        return builder.toString();
    }
}
