package com.example.Invenire.controllers;

import com.example.Invenire.entities.Carrito;
import com.example.Invenire.services.CarritoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/carrito")
public class CarritoController extends BaseControllerImpl<Carrito, CarritoServiceImpl>{
}
