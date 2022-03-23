import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "feaures",
        glue = {"steps"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
