package com.suheylcodes.springbootcrud.controller;

import com.suheylcodes.springbootcrud.model.Team;
import com.suheylcodes.springbootcrud.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/getAll")
    public List<Team> list(){
        return teamService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Team team){
        teamService.save(team);
        return "New Team Added.";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> get(@PathVariable Integer id){
        try{
             Team team = teamService.get(id);
             return new ResponseEntity<Team>(team,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> update(@RequestBody Team team, @PathVariable Integer id){
        try{
            Team existingTeam = teamService.get(id);
            teamService.save(team);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        teamService.delete(id);
        return "Deleted Team with id";
    }

}
