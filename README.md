# SamplecucumberBDDFrameworkprojectwithreportsusingpagefactory
CONCEPTS USED IN THE PROJECT IS,
Step 1 - Add Selenium Java maven dependency
Step 2 - Create a feature file and add Scenario and Steps
Step 3 - Create Step Definition/Glue Code for the steps
Step 4 - Download browser driver files 
Step 5 - Add Selenium WebDriver code
Step 6 - Run Feature file and check the execution
1 - What is parameterization
2 - What is data-driven testing
3 - How to run a feature multiple times with different sets of data

Prerequisites (Completed in earlier session)
1 - Project is setup with required maven dependencies (libraries) added
2 - A sample login test 
Demo site - https://example.testproject.io/web/​

Step 1 - In the feature file select the values that need to be parameterized
Step 2 - Put the values within conical brackets or double quotes (Parameterization)
Step 3 - Change Scenario to Scenario Outline
Step 4 - Add Examples section
Step 5 - Add data for the parameters in the Examples section
Step 6 - Update step definition to get values from feature file Examples section
Step 7 - Run and verify

What is POM
Design pattern to create Object Repository
A class is created for each page to identify web elements of that page
Also contains methods to do action on the objects
Separates test objects and test scripts




What is Page Factory
A simple and easier implementation of Page Object Model in Selenium
Selenium’s inbuilt and optimized Page Object Model concept
As POM, has separation of objects and tests
Uses annotation @FindBy to find WebElements
@FindBy can use id, name, css, xpath, tagName, linkText, partialLinkText etc
Uses method initElements to initialize web elements
on calling initElements method all objects on that page gets initialized

Demo How to implement Page Factory Model
Step 1 - Create a class for each page
Step 2 - Create locators of all objects to be used in that page using @FindBy
Step 3 - Create methods or actions to be performed on the objects
Step 4 - Create constructor to get driver instance and 
                initialize Elements using method initElements
public LoginPage_PF(WebDriver driver) {
  this.driver = driver;
  PageFactory.initElements(driver, LoginPage_PF.class);
 }
Step 5 - Update Test Scripts to refer methods from PageFactory class
Step 6 - Run and validate

Useful Tips 1
@CacheLookup
CacheLookup can be used to instruct the InitElements() method to cache the element once its located and so that it will not be searched over and over again whenever calling it from any method

@FindBy(id = "name") 
@CacheLookup
WebElement txt_username;

This works well with a basic web application, but not recommended if you have Ajax applications where DOM changes on user actions.
In case you get StaleElementExceptions, avoid using this.

Useful Tips 2
In Ajax applications to handle loading time for element and to avoid 
‘No Element Exception’, we can use

AjaxElementLocatorFactory Class
timeout for a WebElement can be assigned to the Object page class with the help of AjaxElementLocatorFactory 

AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
PageFactory.initElements(factory, Login_PF.class);

The above code will wait for maximum of 30 seconds until the elements specified by annotations is loaded. 
If the element is not found in the given time interval, it will throw ‘NoSuchElementException' exception.

Useful Tips 3

With PageFactory, you can also locate a list of Elements

@FindBy(partialLinkText = "raghav")
List＜WebElement＞ myLinks;
