package jaxb.steps;

import com.mashape.unirest.http.exceptions.UnirestException;
import jaxb.Marshall;
import jaxb.abstractFactory.Receipt;
import jaxb.abstractFactory.ReceiptTypeFactory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class ValidateIfThereIsARecipientNameTest {
    String nameFound;
    @Given("a receipt exists $name")
    public void aReceiptExists(String name) throws JAXBException, FileNotFoundException {
        Receipt rcp = ReceiptTypeFactory.mountReceipt("PJ",
                "01.442.521/0001-88",
                "Nome de exemplo",
                "01.442.521/0001-88",
                name,
                "Um nome fantasia");
        Marshall.buildMarshaller(rcp);
    }
    @When("I look into the name of the recipient inside the receipt")
    public void iLookIntoTheNameOfTheRecipientInsideTheReceipt() throws JAXBException, FileNotFoundException, UnirestException {
        nameFound = Marshall.buildUnmarshaller().getnFe().getinfNFe().getDest().getXNome();
    }
    @Then("the name filled should be the right one $name")
    public void theNameFilledShouldBeTheRightOne(String name){
        assertEquals(nameFound, name);
    }
}
