package jaxb;

import jaxb.repository.EmitRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Serializacao {
    private final EmitRepository repository;

    public Serializacao(EmitRepository repository) {
        this.repository = repository;
    }

    public static void buildMarshaller(EmitRepository repository) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(NfeProc.class);
        Marshaller marshaller = context.createMarshaller();

        Emit emitTeste = Emit.builder().CNPJ(repository.findById(1).get().getCNPJ()).xNome(repository.findById(1).get().getXNome()).build();

        InfNfe infNfeTeste = new InfNfe("4.0", emitTeste);
        NFe nfObj = new NFe(infNfeTeste);
        NfeProc nfeProc = new NfeProc("2.0", nfObj);

        marshaller.marshal(nfeProc, new File("D:\\nota_teste.xml"));

    }
}
