# Geo Twitter Web Service

L'applicazione web in questione è un Web Service che usufruisce delle
API di Twitter per mettere a disposizione del proprio Client (Postman) un elenco di servizi, i quali possono essere richiesti da quest'ultimo tramite chiamate gestite con protocollo HTTP.

I servizi sopracitati si riferiscono ad operazioni di statistiche e filtraggio che fanno riferimento ad un Data-set di tweets di diversa estrazione all'interno del territorio italiano, ognuno caratterizzato da attributi che costituiscono l'oggetto di studio della nostra applicazione.

Mediante le API REST (sia GET che POST) da noi implementate è possibile  richiedere tramite rotte diverse i seguenti servizi:

- Visualizzazione dei dati relativi al Data-set di tweets.
- Visualizzazione dei metadati, ovvero l'elenco degli attributi dei record all'interno del Data-set e i relativi tipi di dato.
- Selezione dei tweet che rientrino entro determinate specifiche di filtraggio, anche più di una (es. filtrare tutti i tweet che sono stati postati all'interno del perimetro della regione Marche e che contemporaneamente contengano nel campo di testo la stringa "Univpm").
- Effettuare statistiche relative sia al campo di testo che alla locazione dei tweets, effettuando prima un'eventuale operazione di filtraggio sugli stessi (es. individuare la distanza minima che intercorre tra i tweets e uno dei 5 capoluoghi marchigiani, considerando solamente i tweets che sono stati postati entro una delimitata zona geografica).

Tutte le richieste sopraindicate restituiscono al Client una risposta in formato JSON.

![use case diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Use%20Case%20Diagram/Use%20Case%20Diagram.jpg?raw=true)


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

È possibile selezionare i tweet che appartengono o meno ad una BoundingBox di cui si forniscono le coordinate dei vertici in alto a sinistra (top-left) e in basso a destra (bottom-right).

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


## Statistiche

#### Statistiche fornite dalla richiesta POST /stats
 - "**mean**": baricentro geografico delle coordinate dei tweets, espresso in longitudine e latitudine
 - "**variance**": varianza di longitudine e latitudine relative alle coordinate dei tweets
 - "**stdDev**": deviazione standard di longitudine e latitudine relative alle coordinate dei tweets
 - "**textAverageLength**": numero medio di caratteri per tweet
 - "**tweetsInsideMarche**": numero di tweets postati dall'interno del territorio marchigiano

#### Statistiche fornite dalla richiesta POST /stats?capoluogo=
 - "**mean**": media di tutte le distanze intercorrenti tra i singoli tweet e il capoluogo scelto
 - "**variance**": varianza della distanza intercorrente tra i singoli tweet e il capoluogo scelto
 - "**stdDev**": deviazione standard della distanza intercorrente tra i singoli tweet e il capoluogo scelto
 - "**max**": massima distanza misurata tra un tweet e il capoluogo scelto
 - "**min**": minima distanza misurata tra un tweet e il capoluogo scelto


# Progettazione

## Packages

![package diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Class%20Diagram/Packages%20Hierarchy.jpg?raw=true)

## Classi

- ### it.univpm.projectGeoTwitter.controller

![controller diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Class%20Diagram/controller%20diagram.jpg?raw=true)


- ### it.univpm.projectGeoTwitter.service

![service diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Class%20Diagram/service%20diagram.jpg?raw=true)

- ### it.univpm.projectGeoTwitter.model

![model diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Class%20Diagram/model%20diagram.jpg?raw=true)

- ### it.univpm.projectGeoTwitter.exception

![exception diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Class%20Diagram/exception%20diagram.jpg?raw=true)

- ### it.univpm.projectGeoTwitter.utils.runner

![runner diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Class%20Diagram/runner%20diagram.jpg?raw=true)


- ### it.univpm.projectGeoTwitter.utils.filter

![filter diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Class%20Diagram/filter%20diagram.jpg?raw=true)


- ### it.univpm.projectGeoTwitter.utils.stats

![stats diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Class%20Diagram/stats%20diagram.jpg?raw=true)


- ### it.univpm.projectGeoTwitter.utils.json

![json diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Class%20Diagram/json%20diagram.jpg?raw=true)


## Chiamate:

- #### GET /data
`GeoTwitterController`  richiama il metodo `getData`, implementato dalla classe `DataService`, che restituisce al primo una `Collection<TwitterData>` contenente i dati relativi ad ogni record, restituendola poi a sua volta al Client in formato JSON.

![retrieve data sequence](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Sequence%20Diagram/retrieve%20data%20sequence.jpg?raw=true)

- #### GET /metadata
`GeoTwitterController`  richiama il metodo `getMetadata`, implementato dalla classe `DataService`, che restituisce al primo una `Collection<TwitterData>` contenente i metadati relativi ad ogni record, restituendola poi a sua volta al Client in formato JSON.

![retrieve metadata sequence](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Sequence%20Diagram/retrieve%20metadata%20sequence.jpg?raw=true)

- #### POST /filter
`GeoTwitterController` utilizza la classe `FilterRunner` attraverso il metodo `getFilters`, il quale effettua il parsing del body della richiesta e, con le informazioni così ottenute relative alle operazioni di filtraggio, chiama iterativamente la classe `FiltersImpl` che provvede ad eseguire in serie i filtri richiesti. Al termine della procedura, il metodo `Collection<TwitterData>` restituisce i record che rientrano nelle specifiche richieste dal Client in formato JSON.
##### es. Filtrare i tweets che sono stati postati dall'interno di una determinata zona geografica delimitata da una Bounding Box
La classe `BoundingBoxFilter` fa uso del metodo `polygonGenerator` implementato da `Calculator` per istanziare la bounding box, rappresentata sotto forma di spezzata chiusa di tipo `Path2D`.

![bounding box filter diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Sequence%20Diagram/filter%20data%20with%20bounding%20box%20sequence.jpg?raw=true)


- #### POST /stats
`GeoTwitterController` utilizza la classe `StatsRunner` attraverso il metodo `getStats`, il quale richiama a sua volta tutti i metodi relativi alle statistiche su coordinate e testo implementati dalla classe `StatsImpl`. Nel caso in cui il body della richiesta contenga informazioni relative ad operazioni di filtraggio, queste vengono preventivamente elaborate ed applicate al Data-set di record dalla classe `FilterRunner`, ottenendo quindi una nuova `Collection<TwitterData>` di record filtrati sui quali calcolare le statistiche.

##### es. statistiche SENZA filtri

![stats coord diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Sequence%20Diagram/retrieve%20stats%20coord%20on%20data%20sequence.jpg?raw=true)

##### es. statistiche CON filtri

![stats coord on filtered data diagram](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Sequence%20Diagram/retrieve%20stats%20coord%20on%20filtered%20data%20sequence.jpg?raw=true)

- #### POST /stats?capoluogo="nome capoluogo"
`GeoTwitterController` utilizza la classe `StatsRunner` attraverso il metodo `getStats`, il quale a sua volta richiama `getCapoluogo` implementato da `CapoluogoGetter` per ottenere l'istanza `Geo` rappresentante il capoluogo che fa riferimento alla stringa `capoluogo` fornita come parametro della chiamata dal Client, per poi richiamare tutti i metodi relativi alle statistiche sulle distanze dei tweets dal capoluogo scelto implementati dalla classe `StatsImpl`. 
##### es. statistiche relative alle distanze dei tweets dal capoluogo scelto

![enter image description here](https://github.com/s1087147/Progetto-OOP-Paoli-Paolini/blob/master/UML%20diagrams/Sequence%20Diagram/retrieve%20stats%20distance%20on%20data%20sequence.jpg?raw=true)

## Risorse utilizzate
- #### [Spring Boot](https://spring.io/projects/spring-boot)
- #### [Eclipse](https://www.eclipse.org/)
- #### [Maven](https://maven.apache.org/)
- #### [UML Designer](http://www.umldesigner.org/)

## Autori
#### Francesco Paoli Leonardi
#### Davide Paolini
