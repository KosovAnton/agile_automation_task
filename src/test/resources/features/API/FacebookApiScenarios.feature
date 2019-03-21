@API @ApiPostCrudScenarios
Feature: User verifies create, update and delete post functionality on API side

  @ApiCreatePost
  Scenario: create new post
    Given API User sends request to create post with message "to update"
    And API User receives response with status code "200"
    Then API User verifies that feed contains post with message "to update"

  @ApiUpdatePost
  Scenario: update post
    Given API User sends request to update post message "to update" with text "was updated"
    And API User receives response with status code "200"
    Then API User verifies that feed contains post with message "was updated"

  @ApiDeletePost
  Scenario: delete post
    Given API User sends request to delete post with message "was updated"
    And API User receives response with status code "200"
    Then API User verifies that feed does not contain post with message "was updated"

