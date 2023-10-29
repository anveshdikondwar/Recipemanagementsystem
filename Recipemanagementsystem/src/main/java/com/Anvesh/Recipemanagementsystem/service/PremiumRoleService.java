package com.Anvesh.Recipemanagementsystem.service;

import com.Anvesh.Recipemanagementsystem.model.PremiumRole;
import com.Anvesh.Recipemanagementsystem.repository.IPremiumRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumRoleService {

    @Autowired
    IPremiumRoleRepo roleRepo;

    @Autowired
    HeadAdminService adminService;

    public String createRole(PremiumRole role , String email){
        if(adminService.isValidEmail(email)){
            roleRepo.save(role);
            return "Premium role created successfully....";
        }else
            return "You don't have the access to create premium roles..";
    }


}
