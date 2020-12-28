package org.example;

import javaBean.dimissionBean;
import utility.attendanceUtil.check;
import utility.job.applyLeaveJob;

import java.util.List;

public class checkTest {
    public static void main(String []args){
        applyLeaveJob a = new applyLeaveJob();

        List<dimissionBean> list = a.selectDimission(1);
        for(int i=0;i<list.size();i++){
            dimissionBean d = list.get(i);
            System.out.println(d.getEmpID()+d.getEmpName()+d.getJobStatus()+d.getpName()+d.getDimissionReason());
        }

    }
}
