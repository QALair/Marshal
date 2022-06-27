package tests;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.io.StoryFinder;

import org.jbehave.core.junit.JUnitStories;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RunWith(JUnitReportingRunner.class)
public class TraderStories extends JUnitStories {

    public TraderStories() {
        // configure as TraderStory except for
        Configuration configuration = new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromURL());
    }

    @Override
    public List<String> storyPaths() {
        String codeLocation = codeLocationFromClass(this.getClass()).getFile();
        return new StoryFinder().findPaths(codeLocation, asList("/Stories/*.story"),
                asList(""), "file:" + codeLocation);
    }
}