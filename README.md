# Stacc code challenge 2022

## Oppgavebeskrivelse
Jeg valgte å lage et API for å utføre PEP sjekker av enkeltpersoner og bedrifter. Sjekken utføres ved å søke gjennom en liste med objekter generert ved å lese vedlagt CSV-fil.
APIet har to endepunkter, hvor det ene tar inn et navn og utfører en sjekk på navnet, og det andre tar inn et organisasjonsnummer og utfører en sjekk på alle personer som har en viktig rolle i organisasjonen. 
Applikasjonen inneholder også en enkel servering hvor en bruker kan skrive inn navn på person eller organisasjonsnummer og utføre sjekk ved å kalle på APIet.

## Hvordan kjøre prosjektet
- Klon prosjektet
- I terminalvindu, naviger til rot-mappe
- Kjør kommandoen `./mvnw clean package`
- Kjør så kommandoen `java -jar target/Stacc-KYC-PEP-API-0.0.1-SNAPSHOT.jar`
- I nettleser, naviger til `http://localhost:8080/`
- Bruk skjemaet til å fylle ut enten navn på person eller organisasjonsnummer og søk
- Eventuelt kall på APIet direkte ved å legge til `/pep?name=...` eller `/roller?orgNr=...` og navn/organisasjonsnummer du vil søke på til nettadressen
- Responsen er et JSON objekt av personen(e) som ga treff og informasjon om organisasjonen ved søk på organisasjon

## Kommentarer
Dette har vært en interessant oppgave som har krevd mye læring. Jeg har aldri laget eller konsumert et API før, var ikke kjent med Spring rammeverket, og har ikke håndtert datafiler i Java før.