package tests;

import jaxb.Deserializacao;
import jaxb.ImprimoAlgo;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
        return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder()
                .withDefaultFormats().withFormats(Format.CONSOLE,Format.HTML));
    }

    @Override
    public InjectableStepsFactory stepsFactory(){
        return new InstanceStepsFactory(configuration(), new Deserializacao(), new ImprimoAlgo());
    }

}
