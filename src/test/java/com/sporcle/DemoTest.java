package com.sporcle;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class DemoTest {
    @Test
    public void test1() {
        method1();
    }

    @Test
    public void test2() {
        method1();
        method2();
    }

    @Step("My step 1")
    public void method1() {
        System.out.println("Step1");
    }

    @Step("My step 2")
    public void method2() {
        System.out.println("Step2");
    }
}
