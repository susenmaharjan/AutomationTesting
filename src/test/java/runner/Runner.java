package runner;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import tests.AutomationTestingTest;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class Runner {

    SummaryGeneratingListener listener = new SummaryGeneratingListener();
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.ExecuteRunner();
    }

    public void ExecuteRunner() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(AutomationTestingTest.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);


    }
}
