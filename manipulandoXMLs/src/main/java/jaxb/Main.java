package jaxb;

import jaxb.repository.EmitRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.context.*;

import javax.xml.bind.JAXBException;

@ComponentScan(basePackageClasses={Emit.class, EmitRepository.class})
@SpringBootApplication
public class Main {

    //    public static void main(String[] args) throws FileNotFoundException, JAXBException {
//        TestesNotaEmpresa testesNotaEmpresa = new TestesNotaEmpresa();
//        testesNotaEmpresa.validaSeExisteEmpresaPeloCnpj();
//        Deserializacao testeDes = new Deserializacao();
//        ImprimoAlgo imprimir = new ImprimoAlgo();
//
//        testeDes.givenAnExistentReceiptThereMustBeTheTagCNPJ();
//        imprimir.givenEuPossoImprimir();
//
//
//        SpringApplication.run(Main.class, args);
//    }
    private String firstPage;

    public static void main(String[] args) throws JAXBException {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Main.class, args);

        //Beans
        EmitRepository emitRepository = configurableApplicationContext.getBean(EmitRepository.class);


        Serializacao objSer = new Serializacao(emitRepository);
        objSer.buildMarshaller(emitRepository);
    }
}
