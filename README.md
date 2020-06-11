# Progetto-OOP-Paoli-Paolini

# Geo Twitter Web Service

L'applicazione web in questione è un Web Service che usufruisce delle
API di Twitter per mettere a disposizione del proprio Client (Postman) un elenco di servizi, i quali possono essere richiesti da quest'ultimo tramite chiamate gestite con protocollo HTTP.

I servizi sopracitati si riferiscono ad operazioni di statistiche e filtraggio che fanno riferimento ad un Data-set di tweets di diversa estrazione all'interno del territorio italiano, ognuno caratterizzato da attributi che costituiscono l'oggetto di studio della nostra applicazione.

Mediante le API REST (sia GET che POST) da noi implementate è possibile  richiedere tramite rotte diverse i seguenti servizi:
verificare quali tweet sono stati postati dall'interno del perimetro della regione Marche
distanza minima dal capoluogo scelto


- Visualizzazione dei dati relativi al Data-set di tweets.
- Visualizzazione dei metadati, ovvero l'elenco degli attributi dei record all'interno del Data-set e i relativi tipi di dato.
- Selezione dei tweet che rientrino entro determinate specifiche di filtraggio, anche più di una (es. filtrare tutti i tweet che sono stati postati all'interno del perimetro della regione Marche e che contemporaneamente contengano nel campo di testo la stringa "Univpm").
- Effettuare statistiche sui tweets, relative sia al campo di testo che alla locazione dei tweets stessi (es. individuare la distanza minima che intercorre tra i tweets e uno dei 5 capoluoghi marchigiani).

Tutte le richieste sopraindicate restituiscono al Client una risposta in formato JSON.
