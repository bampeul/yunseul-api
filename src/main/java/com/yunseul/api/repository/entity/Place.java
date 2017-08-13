package com.yunseul.api.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "yunseul_place_tb")
@Data
public class Place {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String pid;
    private String name;
    private String description;
    // Todo 차후 enum 으로 변경
    private String type;
    private Double x;
    private Double y;
    private String imageUrl;
}
