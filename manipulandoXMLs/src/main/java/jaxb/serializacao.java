package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class serializacao {
    public static void main(String[] args) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(NfeProc.class);
        Marshaller marshaller = context.createMarshaller();
        Emit emitTeste = new Emit("03.402.181/0010-61", "Alguma razao social");
        InfNfe infNfeTeste = new InfNfe("4.0", emitTeste);
        NFe nfObj = new NFe("http://www.portalfiscal.inf.br/nfe",infNfeTeste);
        NfeProc nfeProc = new NfeProc(nfObj);



        marshaller.marshal(nfeProc, new File("D:\\nota_teste.xml"));

    }
}
