# Social Import Programm

Programm um  Daten aus dem Open Data Portal der Stadt Chemnitz zu importieren und in eine Datenbank zu schreiben.

## Workflow

- Verbindung zum Open Data Portal aufbauen
- Daten aus dem Portal laden
- Parsen der JSON Daten
- Übertragen in lokale Datenstruktur
- Anzeigen in Table View

## To-Do
- [x] JSON Url herrausfinden
  - https://services6.arcgis.com/jiszdsDupTUO3fSM/arcgis/rest/services/Schulen_OpenData/FeatureServer/0/query?outFields=*&where=1%3D1&f=geojson
- [] HTTPClient erstellen
- [] HTTPClient mit URL verbinden
- [] HTTPClient get request
- [] JSON Daten parsen mit GSON
- [] Füllen des lokalen Datenmodells, Arraylist adressen
- [] Erzeugen der Table View
- [] Erzeugen der Table View Columns
- [] Erzeugen der Cell Value Factories
- [] Erstellen der Observable List
- [] Füllen der Observable List mit Daten aus dem Datenmodell
- [] Anzeigen der Daten in der Table View


## Quellen
- https://github.com/google/gson - GSON Library von Google zur Verarbeitung von JSON Daten