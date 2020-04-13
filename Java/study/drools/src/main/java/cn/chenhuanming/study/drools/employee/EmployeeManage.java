package cn.chenhuanming.study.drools.employee;

import lombok.extern.slf4j.Slf4j;

/**
 * @author guangdao
 * Created at 2019-04-18
 */
@Slf4j
public class EmployeeManage {
    public void handleOldMan(Employee employee){
        System.out.println("old man:"+ employee);
    }

    public void handleLady(Employee employee){
        System.out.println("lady:"+employee);
    }
}
