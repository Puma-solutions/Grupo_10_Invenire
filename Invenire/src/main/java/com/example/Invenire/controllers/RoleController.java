package com.example.Invenire.controllers;


import com.example.Invenire.entities.entities.Role;
import com.example.Invenire.services.RoleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("role")
public class RoleController extends BaseControllerImpl<Role, RoleServiceImpl>{
    @GetMapping("/nombre")
    public ResponseEntity<?> nombre(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByNombre("ROLE_USER"));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
}
