package cn.chenhuanming.study.drools.employee;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guangdao
 * Created at 2019-04-18
 */
public class EmployeeService {
    public static void main(String[] args) {
        //初始化
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();


        EmployeeManage employeeManage = new EmployeeManage();
        List<Employee> employees = new ArrayList<Employee>(){
            private static final long serialVersionUID = -4067066320117884535L;

            {
                add(new Employee("a",40,1));
                add(new Employee("b",20,0));
                add(new Employee("c",25,1));
                add(new Employee("d",28,1));
                add(new Employee("e",35,0));
            }
        };

        final KieSession session = kc.newKieSession("employee-rules");
        session.setGlobal("employeeManage",employeeManage);

        employees.forEach(employee->{
            session.insert(employee);
            session.fireAllRules();
        });

        session.dispose();
    }

}
