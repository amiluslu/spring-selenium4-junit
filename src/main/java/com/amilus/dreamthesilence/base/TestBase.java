package com.amilus.dreamthesilence.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class TestBase {

    @Autowired
    private WebDriver webDriver;

    @Value("${app.url}")
    private String appUrl;

    @BeforeEach
    protected void setupWebDriver(){
        webDriver.navigate().to(appUrl);
    }

    @AfterEach
    protected void afterEach(){
        webDriver.quit();
    }
}
