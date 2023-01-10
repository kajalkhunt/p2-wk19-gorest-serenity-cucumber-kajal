Feature: Testing different request on the gorest app

  Scenario Outline: As a user I am creating new users
    When I create a new user by providing the information name "<name>" gender "<gender>" email "<email>" status "<status>"
    Then I verify new user is created
    Examples:
      | name      | gender | email                    | status   |
      | Enriqueta1 | Female | eflott0@weibo.com        | active   |
      | Alphonso1  | Male   | aartiss1@paginegialle.it | active   |
      | Alastair1  | Male   | ashillitoe2@elpais.com   | inactive |
      | Weider1    | Male   | wclaige3@wufoo.com       | active   |

  Scenario Outline:As a user I update a user with name
    When I update user with name "<name>" gender "<gender>" email "<email>" status "<status>"
    Then I verify the response has "<code>" status code
    Examples:
      | name | gender | email | status | code |
      | Edwarto1 | Male | edwarto1@weibo.com        | active   |200|

  Scenario Outline:As a user I delete a user
    When I delete user with name "<name>" gender "<gender>" email "<email>" status "<status>"
    Then I verify the response has status code
    Examples:
      | name | gender | email | status | code |
      | Edwarto1 | Male | edwarto1@weibo.com        | active   |200|
