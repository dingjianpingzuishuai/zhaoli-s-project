package org.example;

import javaBean.attendanceBean;
import utility.attendanceUtil.selectCheck;

import java.util.List;

public class selectCheckTest {
    public static void main(String []args){
        selectCheck s = new selectCheck();
        List<attendanceBean> list = s.selectCheck(1);
        for(int i = 0;i<list.size();i++){
            attendanceBean a = list.get(i);
            System.out.println(a.getEmpID());
            System.out.println(a.getSigninTime());
        }
    }
}
