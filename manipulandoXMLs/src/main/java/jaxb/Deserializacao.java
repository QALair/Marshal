package jaxb;

import org.jbehave.core.annotations.*;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.StepPatternParser;
import org.jbehave.core.steps.*;
import org.jbehave.core.steps.context.StepsContext;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class Deserializacao extends Steps {
    @Given("An existent receipt, there must be the tag CNPJ")
    public void givenAnExistentReceiptThereMustBeTheTagCNPJ() throws JAXBException, FileNotFoundException {
        JAXBContext ctEmit = JAXBContext.newInstance(NfeProc.class);
        Unmarshaller unmarshaller = ctEmit.createUnmarshaller();

        /*
         caminho da nota: D:\test\Danfe.xml
         caminho da nota marshalled: D:\nota_teste.xml
        */

        NfeProc nfeProc = (NfeProc) unmarshaller.unmarshal(new FileReader("D:\\nota_teste.xml"));

        Assert.assertTrue(nfeProc.getnFe().getinfNFe().getEmit().getCNPJ() != null);

    }

}
