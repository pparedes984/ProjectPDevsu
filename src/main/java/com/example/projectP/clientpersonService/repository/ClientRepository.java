package com.example.projectP.clientpersonService.repository;

import com.example.projectP.clientpersonService.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
