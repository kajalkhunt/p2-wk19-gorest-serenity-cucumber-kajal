Feature: Testing different request on the gorest app

  As a user I want to test booking Application

  Scenario Outline: As a user I am creating new users
    When I create a new user by providing the information name "<name>" gender "<gender>" email "<email>" status "<status>"
    And I update user with name "<name>" gender "<gender>" email "<email>" status "<status>"
    And I delete user with name "<name>" gender "<gender>" email "<email>" status "<status>"
    Then I verify the response has status code
    Examples:
      | name       | gender | email                    | status   |
      | Enriqueta1 | Female | eflott0@weibo.com        | active   |
      | Alphonso1  | Male   | aartiss1@paginegialle.it | active   |
      | Alastair1  | Male   | ashillitoe2@elpais.com   | inactive |
      | Weider1    | Male   | wclaige3@wufoo.com       | active   |

