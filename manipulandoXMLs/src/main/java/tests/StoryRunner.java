package tests;

import jaxb.Deserializacao;
import jaxb.ImprimoAlgo;
import jaxb.jbehave.LogReporter;
import jdk.jpackage.internal.Log;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RestController
@RequestMapping("/StoryRunner")
public class StoryRunner extends ConfigurableEmbedder {
    public Embedder embedder;

    @Override
    @Test
    public void run() {
        embedder = configuredEmbedder();
        embedder.configuration();

        embedder.runStoriesAsPaths(new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList("**/*.story"), asList("")));
    }
    public Configuration configuration(){
        return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().withReporters(getReporters())
                .withDefaultFormats()
                .withFormats(Format.CONSOLE));
    }

    @Override
    public InjectableStepsFactory stepsFactory(){
        return new InstanceStepsFactory(configuration(), new Deserializacao(), new ImprimoAlgo());
    }

    protected StoryReporter[] getReporters(){
        List<StoryReporter> reporters = new LinkedList<>();
        reporters.add(new LogReporter());
        return reporters.toArray(new StoryReporter[0]);
    }

}
