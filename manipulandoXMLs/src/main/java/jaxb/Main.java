package jaxb;


import javax.swing.text.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        JAXBContext ctEmit = JAXBContext.newInstance(NfeProc.class);
        Unmarshaller unmarshaller = ctEmit.createUnmarshaller();

        // caminho da nota: D:\test\Danfe.xml
        // caminho da nota marshalled: D:\nota_teste.xml
        Emit emitTeste = new Emit();
        InfNfe infNfeTeste = new InfNfe();
        NFe nfObj = new NFe();
        NfeProc nfeProc = new NfeProc(nfObj);


        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document xmlDocument = (Document) builder.parse(new File("D:\\nota_teste.xml"));

            System.out.println("doc: "+ xmlDocument);
        } catch (Exception e) {
            e.printStackTrace();
        }


        nfeProc = (NfeProc) unmarshaller.unmarshal(new FileReader("D:\\nota_teste.xml"));


        System.out.println("emitente nfe = " + nfeProc.getnFe());

    }

}
