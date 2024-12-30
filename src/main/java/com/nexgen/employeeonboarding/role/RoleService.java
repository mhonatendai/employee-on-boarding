package com.nexgen.employeeonboarding.role;

import com.nexgen.employeeonboarding.model.Role;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Role with id " + id + " not found"));
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role update(Role role) {
        return roleRepository.save(role);
    }
}
