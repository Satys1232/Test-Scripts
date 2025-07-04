# 🚀 Selenium Automation Journey – Complete Professional Java Test Framework

Welcome to my all-in-one Selenium automation repository!  
This project is a living record of my hands-on learning, advanced framework design, and real-world automation solutions as I progress from student to professional QA engineer.

---

## 👋 About Me

Hi, I’m **Satyabrata Patra** – a passionate learner and aspiring QA Automation Engineer from KIIT University.  
This repository documents my weekly progress, deep dives into Selenium, and practical solutions to real-world automation challenges.

---

## 🛠️ Tech Stack

- **Java 8+**
- **Selenium WebDriver 4+**
- **TestNG**
- **Maven**
- **Cucumber BDD**
- **Selenium Grid**
- **Jenkins CI/CD**
- **Page Object Model (POM) & Page Factory**
- **Extent Reports**
- **Git & GitHub**
- **IntelliJ IDEA / Eclipse**

---

## ✨ Key Features

- 🔹 **Cross-browser automation** (Chrome, Firefox, Edge)
- 🔹 **Page Object Model & Page Factory** for modular, maintainable code
- 🔹 **Parallel execution** and group management with TestNG XML
- 🔹 **Data-driven testing** using DataProvider, JSON, and Excel
- 🔹 **Hybrid framework** supporting both TestNG and Cucumber BDD
- 🔹 **CI/CD integration** with Jenkins and GitHub
- 🔹 **Selenium Grid** for distributed, cross-browser testing
- 🔹 **Robust reporting** with Extent Reports and TestNG listeners
- 🔹 **Reusable abstract components** and base test classes
- 🔹 **Global configuration** via properties files and Maven profiles
- 🔹 **Professional error handling**: retry analyzers, screenshot utilities, and listeners

---

## 📁 Project Structure

selenium-automation/
│
├── src/
│ ├── main/
│ │ └── java/
│ │ └── com/
│ │ └── satyabrata/
│ │ ├── pages/ # Page Object classes
│ │ ├── components/ # Abstract components & utilities
│ └── test/
│ └── java/
│ └── com/
│ └── satyabrata/
│ └── tests/ # Test classes
│ └── resources/ # Test data, configs
│
├── pom.xml # Maven build file
├── testng.xml # TestNG suite configuration
├── extent-config.xml # Extent Reports config
├── README.md # Project documentation
└── .gitignore

text

---

## 🚦 Getting Started

### Prerequisites

- Java JDK 8 or higher
- Maven
- ChromeDriver/GeckoDriver/EdgeDriver (or Selenium Manager)
- An IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Installation

1. **Clone this repository:**
git clone https://github.com/Satys1232/Selenium-Suits.git
cd Selenium-Suits


2. **Install dependencies:**
mvn clean install

text

3. **Run tests:**
mvn test


4. **Run with custom browser:**
mvn test -Dbrowser=firefox


## 📝 Example Usage

WebDriver driver = new ChromeDriver();
driver.get("https://example.com");
WebElement searchBox = driver.findElement(By.name("q"));
searchBox.sendKeys("Selenium WebDriver");
searchBox.submit();
driver.quit();

text

---

## 📊 Reporting & CI/CD

- **HTML reports** generated with Extent Reports for every test run.
- **Jenkins integration** for automated, scheduled, and parameterized test execution.
- **Selenium Grid** for distributed, cross-browser testing.

---

## 🥒 Cucumber BDD

- Write business-readable test cases in Gherkin syntax.
- Feature files and step definitions for collaborative automation.

---

## 📚 My Learning Journey

I document my weekly progress, deep dives, and advanced research on [Hashnode](https://selenium-journey.hashnode.dev/series/selenium-automation-journey).  
Check out my latest posts for code walkthroughs, troubleshooting, and automation best practices!

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!  
If you have suggestions or want to collaborate, please open an issue or submit a pull request.

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 🙏 Acknowledgements

- Special thanks to **Rahul Shetty (Venkatesh)** and Rahul Shetty Academy for world-class training and mentorship.
- SeleniumHQ, TestNG, and the open-source community for their amazing tools and documentation.

---

**Happy Testing!** 🚦  
_Satyabrata Patra_
