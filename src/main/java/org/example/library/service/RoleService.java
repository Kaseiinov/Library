package org.example.library.service;

import lombok.RequiredArgsConstructor;
import org.example.library.Repository.RoleRepository;
import org.example.library.exception.RoleNotFoundException;
import org.example.library.model.Role;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findRoleByName(String name){
        return roleRepository.findRoleByRoleName(name).orElseThrow(RoleNotFoundException::new);
    }


    public Role findRoleById(Long id){
        return roleRepository.findById(id).orElseThrow(RoleNotFoundException::new);
    }

}
