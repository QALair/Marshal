package jaxb;

import jaxb.abstractFactory.Receipt;
import jaxb.abstractFactory.ReceiptFactory;
import jaxb.abstractFactory.ReceiptTypeFactory;
import jaxb.repository.EmitRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Serializacao {
    private final EmitRepository repository;

    public Serializacao(EmitRepository repository) {
        this.repository = repository;
    }

    public static void buildMarshaller(EmitRepository repository, Boolean personTypePF) throws JAXBException, FileNotFoundException {
        String cnpj = repository.findById(1).get().getCNPJ();
        String xnome = repository.findById(1).get().getXNome();
        String doc = "012.345.678-90";
        String pessoa;

        if (personTypePF){
            pessoa = "PF";
        }else{
            pessoa = "PJ";
            doc = cnpj;
        }

        Receipt rcp = ReceiptTypeFactory.mountReceipt(pessoa,cnpj,xnome,doc,"Algum nome","");

        JAXBContext context = JAXBContext.newInstance(rcp.getNfeProc().getClass());
        Marshaller marshaller = context.createMarshaller();

        marshaller.marshal(rcp.getNfeProc(), new File("D:/nota.xml"));
    }
}
