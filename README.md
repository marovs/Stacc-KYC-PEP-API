# Stacc code challenge 2022

## Oppgavebeskrivelse
Jeg valgte å lage et enkelt API for PEP sjekk av enkeltpersoner. Videre ville jeg brukt csv-filen med alle PEP, og hatt en enkel servering av APIet med HTML. Deretter ville jeg utvidet APIet til å også sjekke organisasjoner.


## Hvordan kjøre prosjektet
- Klon prosjektet
- I terminalvindu, naviger til rot-mappe
- Kjør kommandoen `./mvnw clean package`
- Kjør så kommandoen `java -jar target/Stacc-KYC-PEP-API-0.0.1-SNAPSHOT.jar`
- I nettleser, naviger til `http://localhost:8080/` (her ville index.html blitt vist)
- Gjør kall på APIet med `/pep?name=...` og bytt ut ... med navn funnet i `pep_small.json`
- Responsen er et JSON objekt av personen som ga treff

## Kommentarer
Oppgaven er interessant, men jeg har dessverre ikke fått så mye tid til å arbeide med den. Jeg har heller aldri laget et API før, og var ikke kjent med Spring rammeverket, så dette lille prosjektet har hatt en god lærekurve.
