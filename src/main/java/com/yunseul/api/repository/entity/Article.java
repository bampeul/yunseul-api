package com.yunseul.api.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "yunseul_article_tb")
@Entity
public class Article extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String aid;
    private String uid;
    private String title;
    private String content;
    private String hit;
}
