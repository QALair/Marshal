package jaxb;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Slf4j
public class Deserializacao extends Steps {
    String cnpjValidado;

    @Given("An existent receipt, there must be the tag CNPJ")
    public void givenAnExistentReceiptThereMustBeTheTagCNPJ() throws JAXBException, FileNotFoundException {
        JAXBContext ctEmit = JAXBContext.newInstance(NfeProc.class);
        Unmarshaller unmarshaller = ctEmit.createUnmarshaller();

        NfeProc nfeProc = (NfeProc) unmarshaller.unmarshal(new FileReader("manipulandoXMLs/nota.xml"));

        cnpjValidado = nfeProc.getnFe().getinfNFe().getEmit().getCNPJ();
        log.info("CNPJ encontrado: [{}]", cnpjValidado);

    }
    @Then("some annotation about then step")
    public void someName(){
//
    }

}
