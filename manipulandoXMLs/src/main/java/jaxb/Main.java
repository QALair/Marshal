package jaxb;

import com.mashape.unirest.http.exceptions.UnirestException;
import jaxb.repository.EmitRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.*;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@ComponentScan(basePackageClasses={Emit.class, EmitRepository.class})
@SpringBootApplication
public class Main {

    public static void main(String[] args) throws JAXBException, FileNotFoundException, UnirestException {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Main.class, args);

        //Beans
        EmitRepository emitRepository = configurableApplicationContext.getBean(EmitRepository.class);

        //Serializacao objSer = new Serializacao(emitRepository);
        //objSer.buildMarshaller(emitRepository, false);

        //Marshall objNfe = new Marshall(emitRepository);
        //objNfe.buildMarshaller(emitRepository, false);
        //objNfe.buildUnmarshaller();

    }
}
