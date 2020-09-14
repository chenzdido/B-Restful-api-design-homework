package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
public class TeamRepository {
    private Map<Integer, Team> teamList= new LinkedHashMap<>();
    public TeamRepository(){
        teamList.put(1,new Team(1,"Team 1",null,new ArrayList<Student>()));
        teamList.put(2,new Team(2,"Team 2",null,new ArrayList<Student>()));
        teamList.put(3,new Team(3,"Team 3",null,new ArrayList<Student>()));
        teamList.put(4,new Team(4,"Team 4",null,new ArrayList<Student>()));
        teamList.put(5,new Team(5,"Team 5",null,new ArrayList<Student>()));
        teamList.put(6,new Team(6,"Team 6",null,new ArrayList<Student>()));
    }
}
