package com.openpolicy.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role implements Serializable{
    @Id
    @GeneratedValue(generator = "role_id")
    @GenericGenerator(name = "role_id", strategy = "increment")
    private long role_id;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users = new HashSet<>();

//    @ElementCollection(targetClass = Right.class)
//    @CollectionTable(name = "rights", joinColumns = @JoinColumn(name = "rule_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "rights")
    private Right right;

    public enum Right{
        READ_ARTICLES,WRITE_ARTICLES,READ_CATEGORIES,WRITE_CATEGORIES,ADD_USER,ADD_RIGHTS
    }

    public long getId() {
        return role_id;
    }

    public void setId(long id) {
        this.role_id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Right getRight() {
        return right;
    }

    public void setRight(Right right) {
        this.right = right;
    }
}
