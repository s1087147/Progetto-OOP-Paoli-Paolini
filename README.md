# Geo Twitter Web Service

L'applicazione web in questione è un Web Service che usufruisce delle
API di Twitter per mettere a disposizione del proprio Client (Postman) un elenco di servizi, i quali possono essere richiesti da quest'ultimo tramite chiamate gestite con protocollo HTTP.

I servizi sopracitati si riferiscono ad operazioni di statistiche e filtraggio che fanno riferimento ad un Data-set di tweets di diversa estrazione all'interno del territorio italiano, ognuno caratterizzato da attributi che costituiscono l'oggetto di studio della nostra applicazione.

Mediante le API REST (sia GET che POST) da noi implementate è possibile  richiedere tramite rotte diverse i seguenti servizi:

- Visualizzazione dei dati relativi al Data-set di tweets.
- Visualizzazione dei metadati, ovvero l'elenco degli attributi dei record all'interno del Data-set e i relativi tipi di dato.
- Selezione dei tweet che rientrino entro determinate specifiche di filtraggio, anche più di una (es. filtrare tutti i tweet che sono stati postati all'interno del perimetro della regione Marche e che contemporaneamente contengano nel campo di testo la stringa "Univpm").
- Effettuare statistiche sui tweets, relative sia al campo di testo che alla locazione dei tweets stessi (es. individuare la distanza minima che intercorre tra i tweets e uno dei 5 capoluoghi marchigiani).

Tutte le richieste sopraindicate restituiscono al Client una risposta in formato JSON.

# Richieste
## Richieste possibili
| **Metodo** | **Rotta** |  **Descrizione** |
|------------|-----------|------------------|
|GET	     |/data      |Restituisce i dati relativi a tutti i tweet|
|GET	     |/metadata  |Restituisce i metadati|
|POST	     |/stats     |Restituisce le statistiche relative alle coordinate da cui sono stati inviati i tweet selezionati attraverso eventuali filtri forniti come body|
|POST	     |/stats?capoluogo=     |Restituisce le statistiche relative alle distanze da cui sono stati inviati i tweet selezionati attraverso eventuali filtri forniti come body|
|POST        |/filter    |Restituisce i tweet selezionati attraverso i filtri forniti come body|

## Filtri
I body delle richieste che prevedono l'applicazione di un operazione di filtraggio sui tweet devono seguire la seguente sintassi:

	{"filters":  
		[
			{
			"filter"  :  "filtro 1",
			"operator"  :  "operatore 1",
			"filterValue"  :  "valore 1"
			},
			{
			"filter"  :  "filtro 2",
			"operator"  :  "operatore 2",
			"filterValue"  : "valore 2"
			},
			(...)
		]
	}

### Tipi di filtro:
#### Filtro sul testo del tweet:
È possibile selezionare i tweet che contengono (o non contengono) stringhe di testo fornite dall'utente. 

**Operatori** disponibili:

- "**contains**" : se il testo **deve essere contenuto** nel tweet
- "**notcontains**" : se il testo **non deve essere contenuto** nel tweet
	
		{
		"filter" : "text",
		"operator" : "contains",
		"filterValue" : "testo da cercare nel tweet"
		}

#### Filtro sulla distanza da una provincia marchigiana

È possibile selezionare i tweet che rispettano determinati vincoli sulla distanza da una delle 5 province marchigiane: "Ancona", "AscoliPiceno", "Fermo", "Macerata" e "PesaroEUrbino".

**Operatori** disponibili:

- "**greater**" : se la distanza dal capoluogo indicato deve essere **maggiore** di quella fornita
- "**less**" : se la distanza dal capoluogo indicato deve essere **minore** di quella fornita
- "**between**" : se la distanza dal capoluogo indicato deve essere **compresa** tra le due fornite

		{
		"filter"  :  "distance",
		"operator"  :  "between",
		"filterValue"  : {"capoluogo"  :  "Ancona",
				    "distanza"  :  [1.3,  120]}
		}
		
#### Filtro con BoundingBox

È possibile selezionare i tweet che appartengono o meno ad una BoundingBox di cui si forniscono le coordinate dei vertice in alto a sinistra (top-left) e in basso a destra (bottom-right).

**Operatori** disponibili:

- "**inside**" : se il tweet deve essere stato inviato dall'**interno** della BoundingBox
- "**outside**" : se il tweet deve essere stato inviato dall'**esterno** della BoundingBox
	
		{
		"filter"  :  "boundingbox",
		"operator"  :  "inside",
		"filterValue"  : {"topleft":  [13,  44.11558105],
				    "bottomright"  :  [14.5,  43.4]}
		}

#### Filtro di appartenenza alle Marche

È possibile selezionare i tweet che sono stati inviati o meno dall'interno della regione Marche.

**Operatori** disponibili:

- "**inside**" : se il tweet deve essere stato inviato dall'**interno** delle Marche
- "**outside**" : se il tweet deve essere stato inviato dall'**esterno** delle Marche

		{
		"filter"  :  "marche",
		"operator"  :  "outside"
		}
**Importante: non inserire l'oggetto "filterValue" nella richiesta.**
