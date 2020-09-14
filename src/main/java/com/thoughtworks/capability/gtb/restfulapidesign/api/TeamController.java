package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PutMapping("/teams/{id}")
    public void updateTeam(@PathVariable Integer id, @RequestBody String name){
        teamService.updateTeamName(id,name);
    }

    @GetMapping("/teams")
    public Map<Integer, Team> getAllTeam(){
        return teamService.getAllTeam();
    }

    @GetMapping("/group")
    public Map<Integer, Team> groupTeam(){
        return teamService.groupTeam();
    }
}
