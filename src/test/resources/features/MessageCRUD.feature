@Message
Feature: Authorization

  @PostMessage
  Scenario: Post message
    Given User logs in with credentials "casey_jones123@mail-pro.info"/"CaseyJones123"
    And User opens profile page
    And User creates post with text "test"
    And User updates post "test" with text "updated"

