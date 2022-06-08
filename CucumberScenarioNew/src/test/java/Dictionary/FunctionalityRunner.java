package Dictionary;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)                
@CucumberOptions(features="src/test/resources/Features/dictionary.feature",
glue= {"Dictionary"},
tags= "@dictionaryfunctionality",
monochrome = true,
plugin={"pretty","junit:target/JunitReports/dictionaryreport.xml",
		"json:target/cucumber/dictionaryreport.json",
		"html:target/cucumber/dictionaryeport.html"}

)



public class FunctionalityRunner {

}
