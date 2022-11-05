package com.example.Invenire.repositories;

import com.example.Invenire.entities.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<Role,Long>{
    public Role findByNombre(String nombre);
}
