# E-Commerce Automation Testing Project

## Overview

This project contains automated end-to-end tests for the Magento Software Testing Board e-commerce website using Selenium WebDriver, TestNG, and the Page Object Model (POM) design pattern.

## Technology Stack

- **Java** - Programming language
- **Selenium WebDriver** - Web automation framework
- **TestNG** - Testing framework
- **WebDriverManager** - Automatic driver management
- **Chrome WebDriver** - Browser automation
- **Page Object Model** - Design pattern for maintainable tests

## Prerequisites

- Java 8 or higher
- Maven (for dependency management)
- Chrome browser installed
- Internet connection (for WebDriverManager)

### Running Tests

1. Clone the repository
2. Navigate to the project directory
3. Run tests using Maven:
   ```bash
   mvn test
   ```
4. Or run individual test classes from your IDE

## Test Scenarios

### Test Flow Overview

The test suite performs a complete e-commerce user journey:

1. **User Registration** (`testRegistrationWithRandomCredentials`)
   - Navigate to Magento testing site
   - Create new user account with random credentials
   - Verify successful registration

2. **User Login & Shopping** (`testRegistrationWithSignInCredentials`)
   - Sign in with previously created credentials
   - Browse Men's Jackets category
   - Add Proteus Fitness Jackshirt to cart
   - Add Montana Wind Jacket to cart
   - Verify success messages for both items

3. **Checkout Process** (`testCheckOutPage`)
   - Sign in to account
   - Proceed to shopping cart
   - Navigate to checkout
   - Fill shipping information
   - Select country (Tonga)
   - Complete order placement
   - Verify order confirmation

## Page Object Classes

### BaseTest.java
- Sets up WebDriver configuration
- Manages test data initialization
- Handles browser lifecycle (setup/teardown)

### HomePage.java
- Handles main navigation
- Account creation and sign-in links

### RegistrationPage.java
- User registration form interactions
- Registration verification

### SignInPage.java
- User login functionality
- Login verification with URL validation

### ProductPage.java
- Product browsing and selection
- Shopping cart operations
- Success message validation
- Hover actions for menu navigation

### Checkout.java
- Shipping information form filling
- Country selection
- Order placement
- Order confirmation verification

### Credentials.java
- Generates random test data
- Email, password, and name generation
- Ensures unique test data for each run

## Configuration Details

### Browser Configuration
- Chrome browser with optimized options
- Disabled extensions and GPU acceleration
- Window maximization for consistent element interaction
- 20-second implicit wait timeout

### Test Data
- Random email generation: `user{random}@testmaill343.com`
- Random password format: `Password{random}!`
- Predefined shipping details for Kumanovo, Macedonia
- Dynamic first and last name generation

## Test Execution Priority

Tests are executed in sequential order using TestNG priority:
1. Priority 0: Registration
2. Priority 1: Login and Shopping
3. Priority 2: Checkout Process
