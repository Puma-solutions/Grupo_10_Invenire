package com.example.Invenire.controllers;

import com.example.Invenire.entities.entities.Categoria;
import com.example.Invenire.services.CategoriaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/categoria")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl>{
}
