@TradeMe
Feature: TradeMe UI and API Tests

    Scenario: "As a user, I can see all the car makes on the Mkae dropdown"
        Given I navigate to the TradeMe Motor page
        Then I can verify that the number of car makes is 79
        

    Scenario Outline: "As a user, I can validate thath each make has the right amoun of cars listed"
        Given I navigate to the TradeMe Motor page
        When I select the car make <Make>
        Then I can see it has <Amount> records in the results

            Examples:
                | Make    | Amount   | 
                | Ferrari | 39       | 
                 

    Scenario: "As a user, I want to verify the amount of car makes throught the API"
        Given I sen the request to the endpoint
        Then I can the are 78 car makes