package tests;

import com.mashape.unirest.http.exceptions.UnirestException;
import jaxb.Marshall;
import jaxb.repository.EmitRepository;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.springframework.context.ConfigurableApplicationContext;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class ValidateIfThereIsACNPJTest {
    ConfigurableApplicationContext cac;
    EmitRepository emitRepository = cac.getBean(EmitRepository.class);

    @Given("An existent receipt")
    public void givenAnExistentReceipt() throws JAXBException, FileNotFoundException {
        Marshall.buildMarshaller(emitRepository, false);
    }
    @Then("Should be a tag CNPJ filled")
    public void thenShouldBeATagCNPJFilled() throws JAXBException, FileNotFoundException, UnirestException {
        Marshall.buildUnmarshaller();
    }
}
