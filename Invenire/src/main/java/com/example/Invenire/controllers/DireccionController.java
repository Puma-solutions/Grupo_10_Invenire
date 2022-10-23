package com.example.Invenire.controllers;

import com.example.Invenire.entities.Direccion;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/direccion")
public class DireccionController extends BaseControllerImpl<Direccion, DireccionServiceImpl>{
}
