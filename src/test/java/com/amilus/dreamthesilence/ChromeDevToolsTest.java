package com.amilus.dreamthesilence;

import com.amilus.dreamthesilence.base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.NetworkInterceptor;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.remote.http.Contents;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.http.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

@SpringBootTest
@Execution(ExecutionMode.CONCURRENT)
public class ChromeDevToolsTest extends TestBase
{

    @Autowired
    private WebDriver webDriver;

    @Test
    public void testNI() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" => test1C");
        var interceptor = new NetworkInterceptor(
                webDriver,
                Route.matching(httpRequest -> true)
                        .to(() -> req -> new HttpResponse()
                                .setStatus(404)
                                .setContent(Contents.utf8String("amilus Chrome Dev Tools Test"))));
        webDriver.get("https://shiftdelete.net");
        TimeUnit.SECONDS.sleep(10);

    }

    @Test
    public void testAuth() {
        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("the-internet.herokuapp.com");
        ((HasAuthentication) webDriver).register(uriPredicate, UsernameAndPassword.of("admin","admin"));
        webDriver.get("https://the-internet.herokuapp.com/basic_auth");
        Assertions.assertTrue(webDriver.getPageSource().contains("Congratulations!"));
    }

    @Test
    public void testConsoleLog() {
        ChromeDriver chromeDriver = (ChromeDriver) webDriver;
        var devTools = chromeDriver.getDevTools();
        devTools.createSession();
        devTools.send(Log.enable());

        devTools.addListener(Log.entryAdded(),
                logEntry -> {
                    System.out.println("logs: "+logEntry.getText());
                });
        chromeDriver.get("https://github.com/amiluslu");
    }

    @Test
    public void testCDPRequestResponse() {
        ChromeDriver chromeDriver = (ChromeDriver) webDriver;
        var devTools = chromeDriver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(),
                entry -> {
                    System.out.println("Request URI: "+entry.getRequest().getUrl()+ "\n"
                            + " With Method: "+entry.getRequest().getMethod() + "\n");
                    entry.getRequest().getMethod();
                });
        chromeDriver.get("https://sahibinden.com");
        devTools.send(Network.disable());
    }
}
