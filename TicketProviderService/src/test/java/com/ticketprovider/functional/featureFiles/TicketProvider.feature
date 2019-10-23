Feature: TicketProvider 


Scenario: TicketProvider findAllTicket

When  We call TicketProvider findAll resource
Then  will get status code 200 

Scenario: Create Ticket

   Given I create a Ticket with following configuration
      | movieId | theaterId | numberOfTickets | price |ticketConsumerType |
    | 1       | 20       | 20              | 123   | BMS               |
     
   When We will Call TicketProvider createTicketResource
   Then we will get status code 200 and will check ticketConsumerType "BMS"


