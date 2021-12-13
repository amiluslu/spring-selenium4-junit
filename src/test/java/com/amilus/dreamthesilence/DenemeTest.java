package com.amilus.dreamthesilence;

import com.amilus.dreamthesilence.base.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@Execution(ExecutionMode.CONCURRENT)
public class DenemeTest extends TestBase
{
    @Autowired
    private WebDriver webDriver;

    @Test
    public void testDeneme() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" => test1A");
        webDriver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    public void testDenemeYeni() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" => test1B");
        webDriver.navigate().to("http://google.com");
        TimeUnit.SECONDS.sleep(5);
    }
}
