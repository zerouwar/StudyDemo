package cn.chenhuanming.study.drools.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author guangdao
 * Created at 2019-04-17
 */
@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private int age;
    private int sex;
}
