Feature: Rishwanth_04_05_2026_CartFeature
 description:Cart Functionality test for DemoBlaze Application

  Background:
    Given The user is in DemoBlaze Application

  @addingtoCart
  Scenario: Add to card Functionality
    When The user clicks on a Product
    And The user clicks on Add to cart button in product description page
    Then The Application should send an alert "Product added."

  @AddedproductIsInCart
  Scenario: To Check Added Product is in Cart
    When The user clicks on a Product
     And The user clicks on Add to cart button in product description page
    And The Application should send an alert "Product added."
    And  The user shoud navigate to cart  Page
    Then  The added Product should be in cart
    
