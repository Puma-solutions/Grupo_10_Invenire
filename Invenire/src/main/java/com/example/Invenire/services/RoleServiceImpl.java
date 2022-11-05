package com.example.Invenire.services;

import com.example.Invenire.entities.entities.Role;
import com.example.Invenire.repositories.BaseRepository;
import com.example.Invenire.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,Long> implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    public RoleServiceImpl(BaseRepository<Role, Long> baseRepository) {
        super(baseRepository);
    }

    public Role findByNombre(String nombre){
        return roleRepository.findByNombre(nombre);
    }
}
