@Feed
Feature: Feed posts CRUD operations

  @PostsCrud
  Scenario: Post message
    Given User logs in with credentials "casey_jones123@mail-pro.info"/"CaseyJones123"
    And User opens profile page
    And User creates post with text "just delete"
    When User updates post "just delete" with text " this message"
    Then User deletes post with text message "just delete this message"

