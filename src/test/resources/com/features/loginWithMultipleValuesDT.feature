Feature: Rishwanth_04_05_2026_LoginFeature_DataTable
 description:login test for DemoBlaze Application with valid Credentials using DataTable

  @validCred
  Scenario: Login with DataTable on valid credentials multiple values
    Given The user is in DemoBlazeWebApp
    Then The user enters valid usernames and passwords and clicks login button
      | username | password |
      | admin    | admin    |
      | mp34     | mp3      |
