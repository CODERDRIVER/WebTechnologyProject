package com.xuyangl.portal.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author: liwemg
 * @studentNo 15130110070
 * @Emailaddress 2286417608@qq.com
 * @Date: 2018/7/6
 */

@Entity
@Table(name = "t_grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String classname;

    @Column(nullable = false)
    private String builder;  //受外键username约束.

    //@Column
    @JsonIgnore
    @ManyToMany(mappedBy="gradeSet")
    private Set<User> userSet;// = new HashSet<User>();

    public long getId() {
        return id;
    }

    public String getClassname() {
        return classname;
    }

    public String getBuilder() {
        return builder;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
