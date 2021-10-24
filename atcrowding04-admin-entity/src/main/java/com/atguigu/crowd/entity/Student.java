package com.atguigu.crowd.entity;

import java.util.List;
import java.util.Map;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer stuId;
    private String stuName;
    private Address address;
    private List<Subject> subjectList;
    private Map<String,String> map;

}
