package com.neuralnoise.owlaxioms;

import java.util.List;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.ClassExpressionType;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;

public class DisplayHelper {

	public DisplayHelper() { }
	
	public String parseClassExpression(OWLClassExpression owlClass) {
		String ret = null;
		if (owlClass.getClassExpressionType() == ClassExpressionType.OWL_CLASS) {
			OWLClass _owlClass = (OWLClass) owlClass;
			ret = "class:" + FilenameUtils.getName(_owlClass.getIRI().toString());
		} else {
			throw new RuntimeException("Expression type in " + owlClass + " not supported.");
		}
		return ret;
	}
	
	public String parseObjectPropertyExpression(OWLObjectPropertyExpression owlObjectProperty) {
		String ret = null;
		OWLObjectProperty _owlObjectProperty = (OWLObjectProperty) owlObjectProperty;
		ret = "objectProperty:" + FilenameUtils.getName(_owlObjectProperty.getIRI().toString());
		return ret;
	}
	
	public String parseDataPropertyExpression(OWLDataPropertyExpression owlDataProperty) {
		String ret = null;
		OWLDataProperty _owlDataProperty = (OWLDataProperty) owlDataProperty;
		ret = "dataProperty:" + FilenameUtils.getName(_owlDataProperty.getIRI().toString());
		return ret;
	}
	
	public String parseAxiom(OWLAxiom owlAxiom) {
		String ret = null;

		if (owlAxiom.getAxiomType() == AxiomType.CLASS_ASSERTION) {
		
		} else if (owlAxiom.getAxiomType() == AxiomType.ANNOTATION_ASSERTION) {
		
		} else if (owlAxiom.getAxiomType() == AxiomType.DECLARATION) {
			
		} else if (owlAxiom.getAxiomType() == AxiomType.ANNOTATION_PROPERTY_DOMAIN) {
			
		} else if (owlAxiom.getAxiomType() == AxiomType.ANNOTATION_PROPERTY_RANGE) {

		} else if (owlAxiom.getAxiomType() == AxiomType.SUB_ANNOTATION_PROPERTY_OF) {
			
		} else if (owlAxiom.getAxiomType() == AxiomType.OBJECT_PROPERTY_RANGE) {
			OWLObjectPropertyRangeAxiom _owlAxiom = (OWLObjectPropertyRangeAxiom) owlAxiom;
			OWLObjectPropertyExpression property = _owlAxiom.getProperty();
			OWLClassExpression range = _owlAxiom.getRange();
			ret = "range(" + parseObjectPropertyExpression(property) + ")" + " ⊑ " + parseClassExpression(range);
		} else if (owlAxiom.getAxiomType() == AxiomType.OBJECT_PROPERTY_DOMAIN) {
			OWLObjectPropertyDomainAxiom _owlAxiom = (OWLObjectPropertyDomainAxiom) owlAxiom;
			OWLObjectPropertyExpression property = _owlAxiom.getProperty();
			OWLClassExpression domain = _owlAxiom.getDomain();
			ret = "dom(" + parseObjectPropertyExpression(property) + ")" + " ⊑ " + parseClassExpression(domain);
		} else if (owlAxiom.getAxiomType() == AxiomType.SUB_OBJECT_PROPERTY) {
			OWLSubObjectPropertyOfAxiom _owlAxiom = (OWLSubObjectPropertyOfAxiom) owlAxiom;
			OWLObjectPropertyExpression subObjectProperty = _owlAxiom.getSubProperty(), superObjectProperty = _owlAxiom.getSuperProperty();
			ret = parseObjectPropertyExpression(subObjectProperty) + " ⊑ " + parseObjectPropertyExpression(superObjectProperty);
		} else if (owlAxiom.getAxiomType() == AxiomType.EQUIVALENT_OBJECT_PROPERTIES) {
			OWLEquivalentObjectPropertiesAxiom _owlAxiom = (OWLEquivalentObjectPropertiesAxiom) owlAxiom;
			Set<OWLObjectPropertyExpression> properties = _owlAxiom.getProperties();
			ret = "";
			for (OWLObjectPropertyExpression property : properties) {
				ret += (ret.length() > 0 ? " ≡ " : "") + parseObjectPropertyExpression(property);
			}
			
		} else if (owlAxiom.getAxiomType() == AxiomType.DATA_PROPERTY_RANGE) {
			OWLDataPropertyRangeAxiom _owlAxiom = (OWLDataPropertyRangeAxiom) owlAxiom;
			OWLDataPropertyExpression property = _owlAxiom.getProperty();
			OWLDataRange range = _owlAxiom.getRange();
			ret = "range(" + parseDataPropertyExpression(property) + ")" + " ⊑ " + range;
		} else if (owlAxiom.getAxiomType() == AxiomType.DATA_PROPERTY_DOMAIN) {
			OWLDataPropertyDomainAxiom _owlAxiom = (OWLDataPropertyDomainAxiom) owlAxiom;
			OWLDataPropertyExpression property = _owlAxiom.getProperty();
			OWLClassExpression domain = _owlAxiom.getDomain();
			ret = "dom(" + parseDataPropertyExpression(property) + ")" + " ⊑ " + parseClassExpression(domain);
		} else if (owlAxiom.getAxiomType() == AxiomType.SUB_DATA_PROPERTY) {
			OWLSubDataPropertyOfAxiom _owlAxiom = (OWLSubDataPropertyOfAxiom) owlAxiom;
			OWLDataPropertyExpression subObjectProperty = _owlAxiom.getSubProperty(), superObjectProperty = _owlAxiom.getSuperProperty();
			ret = parseDataPropertyExpression(subObjectProperty) + " ⊑ " + parseDataPropertyExpression(superObjectProperty);
		} else if (owlAxiom.getAxiomType() == AxiomType.EQUIVALENT_DATA_PROPERTIES) {
			OWLEquivalentDataPropertiesAxiom _owlAxiom = (OWLEquivalentDataPropertiesAxiom) owlAxiom;
			Set<OWLDataPropertyExpression> properties = _owlAxiom.getProperties();
			ret = "";
			for (OWLDataPropertyExpression property : properties) {
				ret += (ret.length() > 0 ? " ≡ " : "") + parseDataPropertyExpression(property);
			}
		} else if (owlAxiom.getAxiomType() == AxiomType.FUNCTIONAL_DATA_PROPERTY) {
			OWLFunctionalDataPropertyAxiom _owlAxiom = (OWLFunctionalDataPropertyAxiom) owlAxiom;
			OWLDataPropertyExpression property = _owlAxiom.getProperty();
			ret = "functional(" + parseDataPropertyExpression(property) + ")";
			
			
		} else if (owlAxiom.getAxiomType() == AxiomType.SUBCLASS_OF) {
			OWLSubClassOfAxiom _owlAxiom = (OWLSubClassOfAxiom) owlAxiom;
			OWLClassExpression subClass = _owlAxiom.getSubClass(), superClass = _owlAxiom.getSuperClass();
			ret = parseClassExpression(subClass) + " ⊑ " + parseClassExpression(superClass);
		} else if (owlAxiom.getAxiomType() == AxiomType.DISJOINT_CLASSES) {
			OWLDisjointClassesAxiom _owlAxiom = (OWLDisjointClassesAxiom) owlAxiom;
			Set<OWLClassExpression> classes = _owlAxiom.getClassExpressions();
			ret = "";
			for (OWLClassExpression _class : classes) {
				ret += (ret.length() > 0 ? ", " : "") + parseClassExpression(_class);
			}
			ret = "disjoint(" + ret + ")";
		} else if (owlAxiom.getAxiomType() == AxiomType.EQUIVALENT_CLASSES) {
			OWLEquivalentClassesAxiom _owlAxiom = (OWLEquivalentClassesAxiom) owlAxiom;
			Set<OWLClassExpression> classes = _owlAxiom.getClassExpressions();
			ret = "";
			for (OWLClassExpression _class : classes) {
				ret += (ret.length() > 0 ? " ≡ " : "") + parseClassExpression(_class);
			}
			
		} else {
			throw new RuntimeException("Axiom type in " + owlAxiom + " not supported.");
		}
		
		return ret;
	}
	
}
