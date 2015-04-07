# dler

Shows the TBox and RBox in an OWL ontology in a Description Logic-like fashion

		$ mvn exec:java
		[INFO] Scanning for projects...
		[INFO]                                                                         
		[INFO] ------------------------------------------------------------------------
		[INFO] Building dler 0.0.1-SNAPSHOT
		[INFO] ------------------------------------------------------------------------
		[INFO] 
		[INFO] >>> exec-maven-plugin:1.1:java (default-cli) @ dler >>>
		[INFO] 
		[INFO] <<< exec-maven-plugin:1.1:java (default-cli) @ dler <<<
		[INFO] 
		[INFO] --- exec-maven-plugin:1.1:java (default-cli) @ dler ---
		file:/home/pasquale/owl/dler/target/classes/dbpedia2014/dbpedia_2014.owl
		Document IRI: file:/home/pasquale/owl/dler/target/classes/dbpedia2014/dbpedia_2014.owl
		Ontology: OntologyID(OntologyIRI(<http://dbpedia.org/ontology/>))
		Format: RDF/XML
		dom(dataProperty:nrhpReferenceNumber) ⊑ class:HistoricPlace
		range(dataProperty:juniorYearsStartYear) ⊑ xsd:gYear
		range(dataProperty:amateurTie) ⊑ xsd:nonNegativeInteger
		class:Pope ⊑ class:Cleric
		objectProperty:lastWin ⊑ objectProperty:DUL.owl#isParticipantIn
		dom(objectProperty:subTribus) ⊑ class:Species
		class:Infrastructure ⊑ class:ArchitecturalStructure
		range(objectProperty:lastFamilyMember) ⊑ class:Person
		range(objectProperty:comparable) ⊑ class:Rocket
		range(objectProperty:prospectLeague) ⊑ class:SportsLeague
		range(dataProperty:tournamentOfChampions) ⊑ xsd:string
		range(dataProperty:deathYear) ⊑ xsd:gYear
		range(dataProperty:mukhtar) ⊑ xsd:string
		range(dataProperty:geologicPeriod) ⊑ xsd:string
		range(dataProperty:sentence) ⊑ xsd:string
		dom(dataProperty:espnId) ⊑ class:Athlete
		range(objectProperty:aircraftHelicopterTransport) ⊑ class:MeanOfTransportation
		dom(dataProperty:coden) ⊑ class:WrittenWork
		range(dataProperty:distanceToLondon) ⊑ xsd:double
		dom(dataProperty:killedBy) ⊑ class:Person
		objectProperty:cpu ⊑ objectProperty:DUL.owl#coparticipatesWith
		range(dataProperty:teamTitle) ⊑ xsd:string
		dom(objectProperty:subdivision) ⊑ class:Place
		class:ComicStrip ⊑ class:Comics
		objectProperty:architectualBureau ⊑ objectProperty:DUL.owl#coparticipatesWith
		class:List ⊑ class:DUL.owl#Collection
		range(dataProperty:europeanUnionEntranceDate) ⊑ xsd:date
		dom(dataProperty:titleSingle) ⊑ class:Athlete
		dataProperty:area ≡ dataProperty:waterArea
		range(dataProperty:activeYearsEndDate) ⊑ xsd:date
		dom(objectProperty:archipelago) ⊑ class:Atoll
		range(dataProperty:eptTitle) ⊑ xsd:string
		range(objectProperty:march) ⊑ class:MusicalWork
		range(dataProperty:wheelbase) ⊑ xsd:double
		range(dataProperty:casualties) ⊑ xsd:integer
		dom(objectProperty:linkedTo) ⊑ class:SkiResort
		range(dataProperty:ridId) ⊑ xsd:string
		range(objectProperty:ladinName) ⊑ class:22-rdf-syntax-ns#langString
		range(objectProperty:city) ⊑ class:City
		dom(objectProperty:periapsis) ⊑ class:Galaxy
		objectProperty:cluster ⊑ objectProperty:DUL.owl#hasPart
		range(dataProperty:racketCatching) ⊑ xsd:string
