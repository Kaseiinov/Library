package org.example.library.Repository;

import org.example.library.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    Optional<Role> findRoleByRoleName(String roleName);
}
