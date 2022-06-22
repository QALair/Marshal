package jaxb;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.steps.Steps;

public class ImprimoAlgo extends Steps {
    @Given("eu posso imprimir")
    public void givenEuPossoImprimir(){
        System.out.println("Algo");
    }
}
