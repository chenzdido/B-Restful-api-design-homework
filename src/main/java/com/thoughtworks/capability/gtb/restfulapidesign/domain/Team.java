package com.thoughtworks.capability.gtb.restfulapidesign.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private Integer id;
    private String name;
    private String note;
    private List<Student> students;
}
