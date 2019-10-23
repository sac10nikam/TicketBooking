package com.ticketprovider.functional;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ticketprovider.TicketProviderServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        TicketProviderServiceApplication.class},
      webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class FunctionalSpringTestRunner {

}
