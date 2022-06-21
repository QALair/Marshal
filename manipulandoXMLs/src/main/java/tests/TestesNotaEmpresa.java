package tests;

import jaxb.Deserializacao;
import org.jbehave.core.annotations.*;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class TestesNotaEmpresa {

    @When("I look into the receipt I found the CNPJ filled inside its own tag")
    public void validaSeExisteEmpresaPeloCnpj() throws JAXBException, FileNotFoundException {
        Deserializacao deserializador = new Deserializacao();

        String CNPJ = deserializador.deserializacao();

        if (CNPJ != null) {
            imprimeSeValidado(CNPJ);
        }
    }
    @Then("I print the document")
    public void imprimeSeValidado(String CNPJ){
        System.out.println("CNPJ da empresa:" + CNPJ);
    }
}
