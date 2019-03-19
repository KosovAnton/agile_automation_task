@UiScenarios
Feature: User verifies create, update and delete post functionality on UI side

  @UiCreatePost
  Scenario: create, update and delete post
    Given User logs in with credentials "casey_jones123@mail-pro.info"/"CaseyJones123"
    And User opens profile page
    And User creates post with text "temporary"
    When User updates post "temporary" with text " message"
    Then User deletes post with text message "temporary message"

