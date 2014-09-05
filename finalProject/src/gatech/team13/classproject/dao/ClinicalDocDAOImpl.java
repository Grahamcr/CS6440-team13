package gatech.team13.classproject.dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import gatech.team13.classproject.jxab.ClinicalDocumentType;

public class ClinicalDocDAOImpl {

	public ClinicalDocDAOImpl() {

	}

	public ClinicalDocumentType getDocumentData() {
		ClinicalDocumentType toReturn = null;
		try {
			Source source = new StreamSource(new File("MarlasCCD.xml"));

			JAXBContext jc = JAXBContext.newInstance(ClinicalDocumentType.class);
			Unmarshaller u = jc.createUnmarshaller();
			JAXBElement<ClinicalDocumentType> root = u.unmarshal(source,  ClinicalDocumentType.class);
			toReturn = root.getValue();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

}
