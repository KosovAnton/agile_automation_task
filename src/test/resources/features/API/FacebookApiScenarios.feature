@ApiScenarios
Feature: User verifies create, update and delete post functionality on API side

  @ApiCreatePost
  Scenario: create new post
    Given API User
    And User opens profile page
    And User creates post with text "just delete"
    When User updates post "just delete" with text " this message"
    Then User deletes post with text message "just delete this message"

  @ApiUpdatePost
  Scenario: update post
    Given User logs in with credentials "casey_jones123@mail-pro.info"/"CaseyJones123"
    And User opens profile page
    And User creates post with text "just delete"
    When User updates post "just delete" with text " this message"
    Then User deletes post with text message "just delete this message"

  @ApiDeletePost
  Scenario: delete post
    Given User logs in with credentials "casey_jones123@mail-pro.info"/"CaseyJones123"
    And User opens profile page
    And User creates post with text "just delete"
    When User updates post "just delete" with text " this message"
    Then User deletes post with text message "just delete this message"

