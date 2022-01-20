# SauceDemo Project:
### About the project:
- This project was built with the purpose of testing the https://www.saucedemo.com/ website.
- The features tested were:
    1. The login
    2. The basic navigation around the website
    3. The individual links to each product's page
    4. The cart functionality (adding and removing items)
    5. The checkout process and delivery information
- The features that still need to be tested:
    1. The filter the inventory feature
    2. The burger button and its navigation bar
    3. The social media links

### Tooles used:
- Cucumber Java and JUnit
- JUnit Jupiter and Vintage
- Selenium IDE and WebDriver
- Maven
- Hamcrest

### Known website bugs/defects:
- The reset app button, inside the burger, doesn't reset the remove buttons
- You cannot change the quantity of each project
- The user can ckeckout without any products in the basket
- The user is logged out of the website fairly quickly if they are inactive

## How to run the project:
1. Clone the git repo
2. Download the appropriate Selenium WebDriver from https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/
3. Put your WebDriver in the resources folder
4. To run the Gherkin scripts run the .fearure files
5. To run the unit tests run the files indide the tests directory
