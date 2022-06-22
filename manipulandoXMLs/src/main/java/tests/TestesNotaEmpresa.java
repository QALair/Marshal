package tests;

import jaxb.Deserializacao;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class TestesNotaEmpresa {

    //@When("I look into the receipt I found the CNPJ filled inside its own tag")
    public void validaSeExisteEmpresaPeloCnpj() throws JAXBException, FileNotFoundException {
        Deserializacao deserializador = new Deserializacao();

        //String CNPJ = deserializador.givenAnExistentReceiptThereMustBeTheTagCNPJ();
        //deserializador.givenAnExistentReceiptThereMustBeTheTagCNPJ();

//        if (CNPJ != null) {
//            imprimeSeValidado(CNPJ);
//        }
    }
    //@Then("I print the document")
    public void imprimeSeValidado(String CNPJ){
        Assert.assertTrue(CNPJ != null);
        System.out.println("CNPJ da empresa:" + CNPJ);
    }

}
