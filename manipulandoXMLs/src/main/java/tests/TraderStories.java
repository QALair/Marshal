package tests;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.io.StoryFinder;

import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RunWith(JUnitReportingRunner.class)
public class TraderStories extends JUnitStories {
    protected ParameterConverters getConverters(){
        return new ParameterConverters();
    }
    public TraderStories() {
        // configure as TraderStory except for
        Configuration configuration = new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromURL());
//                .useStoryControls(new StoryControls().doResetStateBeforeScenario(true).doIgnoreMetaFiltersIfGivenStory(true))
//                .useParameterControls(new ParameterControls().useDelimiterNamedParameters(true))
//                .useParameterConverters(getConverters());
    }

    @Override
    public List<String> storyPaths() {
        String codeLocation = codeLocationFromClass(this.getClass()).getFile();
        return new StoryFinder().findPaths(codeLocation, asList("/Stories/*.story"),
                asList(""), "file:" + codeLocation);
    }
}