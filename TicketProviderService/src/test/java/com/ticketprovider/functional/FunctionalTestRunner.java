package com.ticketprovider.functional;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import com.ticketprovider.AbstractSingleServiceTest;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/ticketprovider/functional/featureFiles/"}
      //  glue = "com.ticketprovider.functional.stepDefinitions"
)
public class FunctionalTestRunner  {
}
