package com.xuyangl.portal.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/6/19 09:38
 */
@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String username;


    private  String password;
}
