package com.mbql.mongo.demo.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

public class TestSSL {

    public static void main(String[] args) throws IOException {

        // new TestSSL().function1();
        // new TestSSL().function2();

        File file = new File(ResourceUtils.getURL("classpath:").getPath());

        System.out.println(file.getAbsolutePath() + File.separator);

        // System.out.println(System.getProperty("user.dir") + "\\resource\\application.yaml");
        //
        // System.out.println(new File("").getAbsolutePath());

    }

    public void function1() {
        String path = this.getClass().getClassLoader().getResource("").getPath();//注意getResource("")里面是空字符串
        System.out.println(path);
    }

    public void function2() {
        String path = this.getClass().getResource("").getPath();//注意getResource("")里面是空字符串
        System.out.println(path);
    }

}
