# Command for API
gradle executeMedSysApiFeature -DcucumberTags='@regression'

# Command for UI
gradle executeMedSysUiFeature -DcucumberTags='@regression'

# allure command in order to generate reports
allure generate allure-results --clean -o allure-report

# Web Server with IIS
## Setup API
http://127.0.0.1/allure/
## Setup UI
http://127.0.0.1/allure-at/

# Allure
https://github.com/allure-framework/allure2/releases

# Gradle
https://gradle.org/install/