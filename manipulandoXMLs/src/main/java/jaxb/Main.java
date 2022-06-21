package jaxb;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import org.jbehave.core.annotations.*;
import tests.TestesNotaEmpresa;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        TestesNotaEmpresa testesNotaEmpresa = new TestesNotaEmpresa();
        testesNotaEmpresa.validaSeExisteEmpresaPeloCnpj();

    }

}
