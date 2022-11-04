package com.example.Invenire.controllers;

import com.example.Invenire.entities.entities.CuponDescuento;
import com.example.Invenire.services.CuponDescuentoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/descuento")
public class CuponDescuentoController extends BaseControllerImpl<CuponDescuento, CuponDescuentoServiceImpl>{
}
