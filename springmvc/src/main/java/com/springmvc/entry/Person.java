package com.springmvc.entry;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 1.当返回数据为XML格式，需要在实体类上添加@XmlRootElement注解，否则无法返回xml格式数据，
 * 两个条件：
 *   a) 返回对象的类具有XmlRootElement注解；
     b) 请求头中的Accept属性包含application/xml。 
     
 * 2.要返回json格式数据，只需要在请求头中的Accept属性包含application/xml。 @XmlRootElement注解可写可不写。
 * @author wanda
 *
 */
@XmlRootElement
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}