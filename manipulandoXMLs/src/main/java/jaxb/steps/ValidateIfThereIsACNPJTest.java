package jaxb.steps;

import com.mashape.unirest.http.exceptions.UnirestException;
import jaxb.Marshall;
import jaxb.abstractFactory.Receipt;
import jaxb.abstractFactory.ReceiptTypeFactory;
import lombok.NoArgsConstructor;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertNotNull;

@NoArgsConstructor
public class ValidateIfThereIsACNPJTest {
    @Given("An existent receipt")
    public void givenAnExistentReceipt() throws JAXBException, FileNotFoundException {
        Receipt rcp = ReceiptTypeFactory.mountReceipt("PJ",
                "01.442.521/0001-88",
                "Nome de exemplo",
                "01.442.521/0001-88",
                "Algum nome",
                "Um nome fantasia");
        Marshall.buildMarshaller(rcp);
    }
    @Then("Should be a tag CNPJ filled")
    public void thenShouldBeATagCNPJFilled() throws JAXBException, FileNotFoundException, UnirestException {
        assertNotNull(Marshall.buildUnmarshaller().getnFe().getinfNFe().getEmit().getCNPJ());
    }
}
