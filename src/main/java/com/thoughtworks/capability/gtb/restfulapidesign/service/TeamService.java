package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.StudentList;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamService {

    private Map<Team, List<Student>> teamMap=new HashMap<>();

    public TeamService(){
        List<Student> students=new ArrayList<>();
        teamMap.put(new Team(1, "Team 1", null),students);
        teamMap.put(new Team(2, "Team 2", null),students);
        teamMap.put(new Team(3, "Team 3", null),students);
        teamMap.put(new Team(4, "Team 4", null),students);
        teamMap.put(new Team(5, "Team 5", null),students);
        teamMap.put(new Team(6, "Team 6", null),students);
    }

    StudentList studentList = new StudentList();

    public Team updateTeam(Integer id, String name){
        for(Team team:teamMap.keySet()){
            if(team.getId()==id){
                team.setName(name);
            }
            return team;
        }
        return null;
    }

    public Map<Team, List<Student>> getAllTeam(){
        return teamMap;
    }

    public List<Student> getTest(){
        List<Student> stu=studentList.getStudentList();
        Collections.shuffle(stu);
        return stu;
    }
}
