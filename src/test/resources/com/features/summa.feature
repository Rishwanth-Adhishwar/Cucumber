Feature: Rishwanth_04_05_2026_LoginFeature
 description:login test for DemoBlaze Application with invalid credentials

  @InvlaidCredentials
  Scenario Outline: Login with invalid credentials
    Given The user is in DemoApp website
    When The user clicks login link
    And The user enters username as "<username>" and password as "<password>" 
    And The user clicks on the login button
    Then The error message should be displayed in alert "<errorMessage>"

    Examples:
      | username | password | errorMessage                           |
      | admin$   | admin    | User does not exist.                   |
      |          | admin    | Please fill out Username and Password. |
      | admin    | rishwa   | Wrong password.                        |
