package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.StudentRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.teamNameExists;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamService {

    TeamRepository teamRepository = new TeamRepository();
    StudentRepository studentRepository = new StudentRepository();
    Map<Integer, Team> teamList = teamRepository.getTeamList();

    public void updateTeamName(Integer id, String name){
        Map<String,Integer> teamNameMap= new HashMap<>();
        for(int key = 1; key<=6; key++){
            teamNameMap.put(teamList.get(key).getName(),key);
        }
        if(teamNameMap.get(name)!=null){
            throw new teamNameExists("team name has exist");
        }
        Team team = teamList.get(id);
        team.setName(name);
        teamList.put(id,team);
    }

    public Map<Integer, Team> getAllTeam(){
        return teamList;
    }

    public Map<Integer, Team> groupTeam(){
        List<Student> stu=studentRepository.getStudentList();
        Collections.shuffle(stu);
        for(int key = 1 ;key<=6;key++){
            teamList.get(key).setStudents(new ArrayList<Student>());
        }
        for(int i=0;i<stu.size();){
            for(int k=1;i<stu.size()&&k<=6;k++,i++){
                teamList.get(k).getStudents().add(stu.get(i));
            }
            System.out.println(teamList);
        }
        return teamList;
    }
}
