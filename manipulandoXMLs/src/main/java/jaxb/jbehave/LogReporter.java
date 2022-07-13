package jaxb.jbehave;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.model.Story;
import org.jbehave.core.reporters.NullStoryReporter;

@Slf4j
public class LogReporter extends NullStoryReporter {
    protected ThreadLocal<Boolean> storyStatus = new ThreadLocal<>();
    protected ThreadLocal<Story> storyThread = new ThreadLocal<>();

    @Override
    public void beforeStory(Story story, boolean givenStory){
        storyThread.set(story);
        if (!story.getName().equals("BeforeStory") && !story.getName().equals("AfterStory")){
            storyStatus.set(true);
            reportBeforeStory(story);
        }
    }

    protected void reportBeforeStory(Story story) {
        log.info("");
        log.info(StringUtils.repeat("#", 80));
        log.info("Start story: "+story.getName());
        log.info(StringUtils.repeat("#", 80));
    }

    @Override
    public void afterStory(boolean givenStory){
        if (givenStory) {return;}
        Story story = storyThread.get();
        if (story == null){
            log.warn("Story has not been set");
            return;
        }
        if (story.getName() != null && !story.getName().equals("BeforeStory") && !story.getName().equals("AfterStory")){
            reportAfterStory(storyThread.get());
        }
    }

    protected void reportAfterStory(Story story){
        String status = storyStatus.get().booleanValue() ? "PASSED" : "FAILED";
        log.info(StringUtils.repeat("#", 80));
        log.info("End story: "+story.getName());
        log.info("Status: {}", status);
        log.info(StringUtils.repeat("#", 80));
    }

}
