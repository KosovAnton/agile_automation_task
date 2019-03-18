@Message
Feature: Authorization

  @PostMessage
  Scenario: Post message
    Given User logs in with credentials "kosov.business@gmail.com"/"Fossil!123!FB"
    And User opens profile page
    And User posts new message with text "test"

  @UpdateMessage
  Scenario: Update message
    Given User logs in with credentials "kosov.business@gmail.com"/"Fossil!123!FB"

  @DeleteMessage
  Scenario: Delete message
    Given User logs in with credentials "kosov.business@gmail.com"/"Fossil!123!FB"

