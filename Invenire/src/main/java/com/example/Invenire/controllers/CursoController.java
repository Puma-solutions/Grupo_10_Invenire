package com.example.Invenire.controllers;

import com.example.Invenire.entities.Curso;
import com.example.Invenire.services.CursoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/curso")
public class CursoController extends BaseControllerImpl<Curso, CursoServiceImpl>{
}
