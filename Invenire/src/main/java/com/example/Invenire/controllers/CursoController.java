package com.example.Invenire.controllers;

import com.example.Invenire.entities.Curso;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/curso")
public class CursoController extends BaseControllerImpl<Curso, CursoServiceImpl>{
}
