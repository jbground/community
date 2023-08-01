package com.jbground.community.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
public class Member {

    @Id
    private String id;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String phone;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
