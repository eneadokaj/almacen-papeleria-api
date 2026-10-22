package com.hellin.almacen.controller;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para consultar los artÃ­culos del almacÃ©n.
 *
 * @author Equipo de desarrollo
 * @version 1.0
 */
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService servicio;

    /**
     * Construye el controlador con el servicio de artÃ­culos.
     *
     * @param servicio servicio encargado de gestionar los artÃ­culos
     */
    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    /**
     * Obtiene todos los artÃ­culos del almacÃ©n.
     *
     * @return respuesta HTTP 200 con la lista de artÃ­culos
     */
    @GetMapping
    public ResponseEntity<List<Articulo>> listarTodos() {
        List<Articulo> articulos = servicio.listarTodos();
        return ResponseEntity.ok(articulos);
    }

    // TODO (#n de la incidencia): GET /api/articulos/{id}/basico
    // Lo implementarÃ¡ la persona responsable de ese endpoint.
}
