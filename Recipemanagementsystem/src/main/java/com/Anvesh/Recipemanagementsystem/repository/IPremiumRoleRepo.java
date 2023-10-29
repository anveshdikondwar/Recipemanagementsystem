package com.Anvesh.Recipemanagementsystem.repository;

import com.Anvesh.Recipemanagementsystem.model.PremiumRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPremiumRoleRepo extends JpaRepository<PremiumRole,Long> {
}
