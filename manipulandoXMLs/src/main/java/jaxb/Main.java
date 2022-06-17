package jaxb;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        JAXBContext ctEmit = JAXBContext.newInstance(NfeProc.class);
        Unmarshaller unmarshaller = ctEmit.createUnmarshaller();

        // caminho da nota: D:\test\Danfe.xml
        // caminho da nota marshalled: D:\nota_teste.xml

        NfeProc nfeProc = (NfeProc) unmarshaller.unmarshal(new FileReader("D:\\nota_teste.xml"));

        System.out.println("emitente nfe = " + nfeProc.getnFe().getinfNFe().getEmit().getCNPJ());

    }

}
