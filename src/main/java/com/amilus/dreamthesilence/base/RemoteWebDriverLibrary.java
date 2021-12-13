package com.amilus.dreamthesilence.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.net.URL;

@Lazy
@Configuration
@Profile("remote")
public class RemoteWebDriverLibrary {

    @Value("${grid.url}")
    private URL remoteUrl;


    @Value("${browser}")
    private String browser;

    @Bean
    @Scope("browserscope")
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver getRemoteWebDriverForChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("se:recordVideo",true);
        return new RemoteWebDriver(remoteUrl, chromeOptions);
    }

    @Bean
    @Scope("browserscope")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver getRemoteWebDriverForFirefox() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("se:recordVideo",true);
        return new RemoteWebDriver(remoteUrl, firefoxOptions);
    }

}
