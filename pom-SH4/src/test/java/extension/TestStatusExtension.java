package extension;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import pom.test.BaseClass;

import java.util.Optional;

public class TestStatusExtension  extends BaseClass implements TestWatcher {


    private static final Logger logger = LogManager.getLogger(TestStatusExtension.class);

    public void testDisabled(ExtensionContext context, Optional<String> reason) { logger.info(" Test Disabled edildi "); }

    public void testSuccessful(ExtensionContext context) {
        logger.info(" Test Success oldu ");
    }

    public void testAborted(ExtensionContext context, Throwable cause) { logger.info(" Test abort edildi "); }

    public void testFailed(ExtensionContext context, Throwable cause) { logger.info(" Test Fail oldu ");






    }


}

