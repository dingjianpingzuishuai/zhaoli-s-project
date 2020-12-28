package org.example;

import javaBean.empBean;
import utility.loginAndRegister.login;

import java.util.List;

public class loginTest {
    public static void main(String []args){
        login l = new login();
       List<empBean> list =  l.login(5,"123",3);
        //System.out.println(list.size());
        for(int i =0;i<list.size();i++){
           System.out.println(list.get(i).getEmpID());
           System.out.println(list.get(i).getEmpPassword());
           System.out.println(list.get(i).getRoleID());
       }
    }
}
