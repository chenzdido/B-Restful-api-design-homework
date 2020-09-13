package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TeamController {

    private TeamService teamService = new TeamService();

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PutMapping("/teams/{id}")
    public Team updateTeam(@PathVariable Integer id, @RequestBody String name){
        return teamService.updateTeam(id,name);
    }

    @GetMapping("/teams")
    public Map<Team, List<Student>> getAllTeam(){
        return teamService.getAllTeam();
    }
}
