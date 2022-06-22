package jaxb;

import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.junit.Test;
import tests.TestesNotaEmpresa;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        TestesNotaEmpresa testesNotaEmpresa = new TestesNotaEmpresa();
        testesNotaEmpresa.validaSeExisteEmpresaPeloCnpj();
        Deserializacao testeDes = new Deserializacao();
        ImprimoAlgo imprimir = new ImprimoAlgo();

        testeDes.givenAnExistentReceiptThereMustBeTheTagCNPJ();
        imprimir.givenEuPossoImprimir();
    }

}
