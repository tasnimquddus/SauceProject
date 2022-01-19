Feature: Logging into the Sauce website

  As a user,
  I want to input a username and password,
  so that I can be given an appropriate response.

  Scenario:
    Successfully logging in

    Given I am on the log in page,
     When I enter the correct user details
     Then I will be taken to the inventory page and see products

    Given I am on the log in page,
    When I enter the correct problem user details
    Then I will be taken to the inventory page and see products

    Given I am on the log in page,
    When I enter the correct performance glitch user details
    Then I will be taken to the inventory page and see products
    #test both standard user and problem user

  Scenario:
    Entering the incorrect username

    Given I am on the log in page,
     When I do not enter a username,
     Then I will be told Epic sadface: username is required.

    Given I am on the log in page,
    When I enter the incorrect username,
    Then I will be told Epic sadface: username and password do not match any user in this service.
    #test empty username and one wrong one

  Scenario:
    Entering the wrong password

    Given I am on the log in page,
     When I do not enter a password,
     Then I will be told Epic sadface: password is required.

    Given I am on the log in page,
     When I do not enter a problem password,
     Then I will be told Epic sadface: password is required.

    Given I am on the log in page,
     When I do not enter a performance glitch password,
     Then I will be told Epic sadface: password is required.

    Given I am on the log in page,
    When I do not enter a locked out password,
    Then I will be told Epic sadface: password is required.

    Given I am on the log in page,
     When I enter the incorrect password,
     Then I will be told Epic sadface: username and password do not match any user in this service.

    Given I am on the log in page,
     When I enter the incorrect problem password,
     Then I will be told Epic sadface: username and password do not match any user in this service.

    Given I am on the log in page,
     When I enter the incorrect performance glitch password,
     Then I will be told Epic sadface: username and password do not match any user in this service.

    Given I am on the log in page,
     When I enter the incorrect locked out password,
     Then I will be told Epic sadface: username and password do not match any user in this service.
    #test empty password and wrong password for each username

  Scenario:
    Locked out of account

    Given I am on the log in page,
     When I enter the correct details of the locked out account,
     Then I will be told Epic sadface: Sorry, this user has been locked out.
    #test the locked out account

#  Scenario Outline: Logging in
#
#    Given I am on the log in page
#    When I input the <username> and <password>
#    Then I should get an appropriate <response>
#    Examples:
#      | username      | password     | response                                                                  |
#      | bsn           | secret_sauce | Epic sadface: Username and password do not match any user in this service |
#      | standard_user | secret       | Epic sadface: Username and password do not match any user in this service |
#      |               | secret_sauce | Epic sadface: Username is required.                                       |
#      | standard_user |              | Epic sadface: Password is required.                                       |
#
