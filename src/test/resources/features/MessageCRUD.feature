@Message
Feature: Authorization

  @PostMessage
  Scenario: Post message
    Given User logs in with credentials "kosov.business@gmail.com"/"Fossil!123!FB"

  @UpdateMessage
  Scenario: Update message
    Given User logs in with credentials "kosov.business@gmail.com"/"Fossil!123!FB"

  @DeleteMessage
  Scenario: Delete message
    Given User logs in with credentials "kosov.business@gmail.com"/"Fossil!123!FB"

