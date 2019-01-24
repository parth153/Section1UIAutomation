#Author: parthparikhce@gmail.com
#Feature File for comparing four retail funds

Feature: Compare Retail Funds
  I want to be able to compare four Retail funds using the Product Facts

#Scenario to select all 4 funds from a single Add Funds button click
@Test
Scenario: Select all four funds from one button click and be able to Compare Retail Funds
    Given I am a Vanguard User and on HomePage
    When I Navigate to Individual & SMSF Investors
    And Click on Fund Compare
   	Then I should be able to compare 4 Retail funds by clicking one Add Funds button

#Scenario to select all 4 funds from all Add Funds button clicks
@Test 	
Scenario: Select fund from each Add Funds button click and be able to Compare Retail Funds
    Given I am a Vanguard User and on HomePage
    When I Navigate to Individual & SMSF Investors
    And Click on Fund Compare
   	Then I should be able to compare 4 Retail funds by clicking all Add Funds buttons