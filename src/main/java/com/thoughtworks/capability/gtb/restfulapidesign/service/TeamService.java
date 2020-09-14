package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.StudentRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamService {

    TeamRepository teamRepository = new TeamRepository();
    StudentRepository studentRepository = new StudentRepository();
    Map<Integer, Team> teamList = teamRepository.getTeamList();

    public void updateTeamName(Integer id, String name){
        Team team = teamList.get(id);
        team.setName(name);
        teamList.put(id,team);
    }

    public Map<Integer, Team> getAllTeam(){
        return teamList;
    }

    public List<List<Student>> getTest(){
        List<Student> students=new ArrayList<>();
        List<Student> stu=studentRepository.getStudentList();
        List<List<Student>> teamList=new ArrayList<>();
        Collections.shuffle(stu);
        for(int i=0;i<stu.size();i++){
            for(int k=0;i<stu.size()&&k<6;k++,i++){
                teamList.get(k).add(stu.get(i));
            }
            System.out.println(i);
        }
        return teamList;
    }
}
