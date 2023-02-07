package com.cos.dong_area_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String id;

    private String password;

    private String username;

    private String roles;
    private String clubname;

    private String stu_id;

    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    @Builder
    public User(String id, String password, String username, String roles, String clubname,String stu_id) {
        this.id = id;
        this.password = password;
        this.username=username;
        this.roles=roles;
        this.clubname=clubname;
        this.stu_id=stu_id;
    }

}
