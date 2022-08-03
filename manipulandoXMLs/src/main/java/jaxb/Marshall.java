package jaxb;

import com.mashape.unirest.http.exceptions.UnirestException;
import jaxb.abstractFactory.Receipt;
import jaxb.abstractFactory.ReceiptTypeFactory;
import jaxb.board.trello.TrelloService;
import jaxb.repository.EmitRepository;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Slf4j
@NoArgsConstructor
@Data
public class Marshall {
//    private static EmitRepository repository = null;
//    public Marshall(EmitRepository repository) {
//        this.repository = repository;
//    }
//repository.findById(1).get().getXNome();

    public static void buildMarshaller(Receipt receipt) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(receipt.getNfeProc().getClass());
        Marshaller marshaller = context.createMarshaller();

        marshaller.marshal(receipt.getNfeProc(), new File("D:/nota.xml"));
        log.info("File generated");
    }

    public static NfeProc buildUnmarshaller() throws JAXBException, FileNotFoundException, UnirestException {
        JAXBContext ctEmit = JAXBContext.newInstance(NfeProc.class);
        Unmarshaller unmarshaller = ctEmit.createUnmarshaller();

        NfeProc nfeProc = (NfeProc) unmarshaller.unmarshal(new FileReader("D:/nota.xml"));
        String cnpjValidado = nfeProc.getnFe().getinfNFe().getEmit().getCNPJ();
        log.info("CNPJ encontrado: [{}]", cnpjValidado);

        // a implementacao ta pronta, so tem que ver porque para de funcionar, vou deixar comentado
        // TrelloService trelloSvc = new TrelloService();
        // trelloSvc.moveCardToAnotherList("62d0018b4cc8a28bc398e2e5","62d001800499d46b52b16743");

        return nfeProc;
    }
}
