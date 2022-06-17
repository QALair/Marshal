package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
// unintilized class -- using Main.java
public class deserializacao {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(NfeProc.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        NfeProc nfeProc = (NfeProc)unmarshaller.unmarshal(new FileReader("D:\\test\\Danfe.xml"));
        System.out.println("versao = "     + nfeProc.getVersao());
    }
}
