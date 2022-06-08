package TranslaterAndGrammer;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)                
@CucumberOptions(features="src/test/resources/Features/TG.feature",
glue= {"TranslaterAndGrammer"},
tags= "@TranslatorAndGrammer",
monochrome = true,
plugin={"pretty","junit:target/JunitReports/Tgreport.xml",
		"json:target/cucumber/Tgreport.json",
		"html:target/cucumber/Tgreport.html"}

)





public class TGrunner {

}
