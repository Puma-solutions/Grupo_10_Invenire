package com.example.Invenire.controllers;

import com.example.Invenire.entities.entities.Pais;
import com.example.Invenire.services.PaisServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/pais")
public class PaisController extends BaseControllerImpl<Pais, PaisServiceImpl>{
}
