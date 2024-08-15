package com.example.projectP.clientpersonService.repository;

import com.example.projectP.clientpersonService.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
