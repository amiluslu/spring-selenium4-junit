# Selenium 4 - Spring Boot - JUnit Example 

<p>
  <a href="https://docs.expo.io/workflow/web/">
    <img alt="Supports Expo Web" longdesc="Supports Expo Web" src="https://img.shields.io/badge/web-4630EB.svg?style=flat-square&logo=GOOGLE-CHROME&labelColor=4285F4&logoColor=fff" />
  </a>
</p>

## ℹ️ About Project

This project is about Selenium 4 new features via Java - Spring Boot using JUnit 5 framework. In this project, you will see the how to use new features of Selenium 4 within a test automation framework which is scalable and easily maintainable.
In addition, Selenium 4 Dynamic Grid used with Docker images for running of test automation scenarios. It starts a Docker container in the background for each new session request, the test gets executed there, and when the test completes, the container gets thrown away.

> [Further info about Selenium 4 Dynamic Grid](https://github.com/SeleniumHQ/docker-selenium#dynamic-grid-)

- **Contributions are Welcome 😇**

## 🧑‍💻 Using Technologies

- Java 11
- Docker
- Maven
- Selenium 4 (Dynamic Grid with Video Recording)
- JUnit 5

## 🚀 How to use

- Install packages with  `docker-compose.yml` Compose file is located in `project root` directory.
- Open the `http://localhost:4444` in order to check grid is up or not.
- 2 profiles are existing in project, first is a remote configuration, second is a local configuration. You can specify your option editing configuration with `spring.profiles.active=remote`

    > Remote Configuration: Runs your tests in docker containers.
    > Local Configuration: Runs your tests in local machine.

- Videos of tests located in project folder `./selenium/assets`

## ⌨️ References

- Learn more about [Docker](https://docs.docker.com)
- Find out more about Selenium: [Selenium](https://www.selenium.dev/documentation/en/)
- Getting Started [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) in 5 minutes
- Documentation for [JUnit 5](https://junit.org/junit5/)