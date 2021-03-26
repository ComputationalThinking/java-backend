package com.example.project_.markerhub.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

//    public Manager(Integer id, String name,String password) {
//        this.id = id;
//        this.name=name;
//        this.password = password;
//    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) { this.username=name; }
}
