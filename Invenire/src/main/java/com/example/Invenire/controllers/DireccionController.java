package com.example.Invenire.controllers;

import com.example.Invenire.entities.Direccion;
import com.example.Invenire.services.DireccionServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/direccion")
public class DireccionController extends BaseControllerImpl<Direccion, DireccionServiceImpl>{
}
