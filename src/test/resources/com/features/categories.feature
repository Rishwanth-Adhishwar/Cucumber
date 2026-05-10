Feature: Rishwanth_04_05_2026_CartFeature
description:
Categories Fuctionality of demoBlaze Application

  Background:
    Given The user is in DemoBlaze Web Application
@phonesCategoriesTest
  Scenario: To Check The Phones Categories Display Phones
    When The user clicks on Phones link in Categories
    Then The List of Phones to be displayed
    
@laptopsCategoriesTest
  Scenario: To Check The Laptops Categories Display Laptops
    When The user clicks on Laptops link in Categories
    Then The List of Laptops to be displayed
    
@monitorsCategoriesTest
  Scenario: To Check The Monitors Categories Display Monitors
    When The user clicks on Monitors link in Categories
    Then The List of Monitors to be displayed
