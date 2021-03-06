package com.yunseul.api.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "yunseul_comment_tb")
@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String cid;
    private String aid;
    private String uid;
    private String memo;
}
