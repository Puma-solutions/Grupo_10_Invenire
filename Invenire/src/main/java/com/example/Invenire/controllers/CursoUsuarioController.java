package com.example.Invenire.controllers;

import com.example.Invenire.entities.CursoUsuario;
import com.example.Invenire.services.CursoUsuarioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/curso-usuario")
public class CursoUsuarioController extends BaseControllerImpl<CursoUsuario, CursoUsuarioServiceImpl>{
}
