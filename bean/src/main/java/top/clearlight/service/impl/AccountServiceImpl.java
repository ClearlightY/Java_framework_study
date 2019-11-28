package top.clearlight.service.impl;

import top.clearlight.service.AccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    /**
     业务层调用持久层
     IoC(控制反转)
     将控制权交给工厂,来帮我们创建对象. 带来的好处就是 降低了程序间的依赖关系, 也叫削减计算机的耦合
      */
    private String name;
    private int age;
    private Date Birthday;

    public void setName(String name) {
        this.name = name;
    }

    public AccountServiceImpl(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        Birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }
}

