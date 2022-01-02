package com.suheylcodes.springbootcrud.repository;

import com.suheylcodes.springbootcrud.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
