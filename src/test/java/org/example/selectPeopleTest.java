package org.example;

import javaBean.empBean;
import utility.peopleUtil.selectPeople;

import java.util.List;

public class selectPeopleTest {
    public static void main(String[] args) {
        selectPeople s = new selectPeople();
        List list = s.selectDeptPeople(3);
        for(int i = 0;i<list.size();i++){
            empBean e = (empBean)list.get(i);
            System.out.println("员工编号为"+e.getEmpID()+" "+"员工姓名为"+e.getEmpName());

        }
    }
}
