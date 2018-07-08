package com.xuyangl.portal.bean;

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
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String documentname;

    @Column
    private String owner;  //外键依赖于username

    @Column
    private String url; //文件的存储路径

   // @Column
   @ManyToMany(mappedBy="documentSet")
   private Set<User> userSet;// = new HashSet<User>();



    public Long getId() {
        return id;
    }

    public String getDocumentname() {
        return documentname;
    }

    public String getOwner() {
        return owner;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDocumentname(String documentname) {
        this.documentname = documentname;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    //@Column
    //private Date date;   //记录文件创建的时间

//    @Column(nullable = true)
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private Timestamp date;

}
