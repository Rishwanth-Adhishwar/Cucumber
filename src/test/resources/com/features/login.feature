Feature: Rishwanth_04_05_2026_LoginFeature
 description:login test for DemoBlaze Application with valid and invalid credentials

  Background:
    Given The user is in DemoBlaze Website
    When The user clicks on Login link

  @validCredentialsLogin
  Scenario Outline: Login with valid username and password
    When The user enters valid <username> and valid <password>
    And The user clicks login button
    Then The user name should be dispayed with Welcome username

    Examples:
      | username | password |
      | admin    | admin    |

  @invalidUsernameLogin
  Scenario Outline: Login with invalid username and valid password
    When The user enters invalid <username> and valid <password>
    And The user clicks login button
    Then The user should see a alert message "User does not exist".

    Examples:
      | username  | password |
      | testAdmin | admin    |

  @invalidPasswordLogin
  Scenario Outline: Login with invalid username and valid password
    And The user enters valid <username> and invalid <password>
    And The user clicks login button
    Then The user should see a alert message "Wrong Password"

    Examples:
      | username | password  |
      | admin    | testAdmin |
      
