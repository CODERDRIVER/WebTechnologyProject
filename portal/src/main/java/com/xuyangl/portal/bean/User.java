package com.xuyangl.portal.bean;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/6/19 09:38
 */
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String telephoneNum;

    @Column(nullable = false)
    private boolean isTeacher;

    @Column(nullable = false)
    private  String password;

    //@Column
    @JoinTable(name="user_document",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="document_id", referencedColumnName="id")})
    @ManyToMany
    private Set<Document> documentSet;//  =  new HashSet<Document>();

   // @Column
   @JoinTable(name="user_grade",
           joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
           inverseJoinColumns={@JoinColumn(name="grade_id", referencedColumnName="id")})
   @ManyToMany
    private Set<Grade> gradeSet; // =  new HashSet<Grade>();


    public Set<Grade> getGradeSet() {
        return gradeSet;
    }

    public void setGradeSet(Set<Grade> gradeSet) {
        this.gradeSet = gradeSet;
    }

    public void setDocumentSet(Set<Document> documentSet) {
        this.documentSet = documentSet;
    }


    public Set<Document> getDocumentSet() {
        return documentSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}




