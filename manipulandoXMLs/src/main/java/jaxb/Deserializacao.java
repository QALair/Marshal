package jaxb;

import org.jbehave.core.annotations.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Deserializacao {
    @Given("A existent receipt, there must be the tag CNPJ")
    public String deserializacao() throws JAXBException, FileNotFoundException {
        JAXBContext ctEmit = JAXBContext.newInstance(NfeProc.class);
        Unmarshaller unmarshaller = ctEmit.createUnmarshaller();

        /*
         caminho da nota: D:\test\Danfe.xml
         caminho da nota marshalled: D:\nota_teste.xml
        */

        NfeProc nfeProc = (NfeProc) unmarshaller.unmarshal(new FileReader("D:\\nota_teste.xml"));

        return nfeProc.getnFe().getinfNFe().getEmit().getCNPJ();
    }
}
