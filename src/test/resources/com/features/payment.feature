Feature: Rishwanth_04_05_2026_PaymentFeature
description: To Add products to cart and Placing Order

  Background:
    Given The user is in DemoBlaze WebApp
@Payment
  Scenario:
    When The user clicks on a Phone
    And The user clicks on Add to cart button in Phones description page
    And The Application should send an alert message "Product added."
    And The user shoud move to cart  Page
    And The added Phone should be in cart
    And The user clicks on Place Order button
    And Enter the order details name and credit card Number
    Then a pop should be displayed with message Thank you for purchase
