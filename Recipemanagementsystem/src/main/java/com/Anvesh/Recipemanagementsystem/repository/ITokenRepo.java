package com.Anvesh.Recipemanagementsystem.repository;

import com.Anvesh.Recipemanagementsystem.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<AuthenticationToken , Long> {

    AuthenticationToken findFirstByToken(String token);
}
