package com.suheylcodes.springbootcrud.service;

import com.suheylcodes.springbootcrud.model.Team;
import com.suheylcodes.springbootcrud.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> listAll(){
        return teamRepository.findAll();
    }

    public void save(Team team){
        teamRepository.save(team);
    }

    public Team get(Integer id){
        return teamRepository.findById(id).get();
    }

    public void delete(Integer id){
        teamRepository.deleteById(id);
    }
}
