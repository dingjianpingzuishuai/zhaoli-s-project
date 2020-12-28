package org.example;

import utility.loginAndRegister.register;

public class registerTest {
    public static void main(String[] args) {
        register r = new register();
        int n =r.register("张家豪的小朋友","123321",3,2,2000,"女","地球市地球村","974914773@qq.com",2);
        System.out.println(n);
    }
}
