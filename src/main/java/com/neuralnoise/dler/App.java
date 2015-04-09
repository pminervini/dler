package com.neuralnoise.dler;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

public class App {

	public static void main(String[] args) throws OWLOntologyCreationException, InstantiationException, IllegalAccessException, ClassNotFoundException, URISyntaxException {
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		
		final URI x = App.class.getClassLoader().getResource("dbpedia2014/dbpedia_2014.owl").toURI();
		System.out.println(x);
		IRI documentIRI = IRI.create(x);

		OWLOntology ontology = manager.loadOntologyFromOntologyDocument(documentIRI);

		System.out.println("Document IRI: " + documentIRI);
		System.out.println("Ontology: " + ontology.getOntologyID());
		System.out.println("Format: " + manager.getOntologyFormat(ontology));

		//OWLReasonerFactory reasonerFactory = new Reasoner.ReasonerFactory();
		//OWLReasoner reasoner = reasonerFactory.createNonBufferingReasoner(ontology);
		
		Set<OWLAxiom> axioms = ontology.getAxioms();
		
		DisplayHelper dh = new DisplayHelper();
		
		for (OWLAxiom axiom : axioms) {
			String str = dh.parseAxiom(axiom);
			if (str != null) {
				System.out.println(str);
			}
		}
		
	}

}
