Feature: Rishwanth_04_05_2026_LoginFeature_DataTable
 description:login test for DemoBlaze Application with valid Credentials using DataTable

  @validCred
  Scenario: Login with DataTable on valid credentials
    Given The user is in DemoBlazeWeb
    When The user click login link in page
    And The user enters valid username and password  and clicks login Button
      | admin | admin |
      | mp34  | mp3   |
    Then The user name should be dispayed with Welcome username text
