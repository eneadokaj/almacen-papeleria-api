package com.hellin.almacen.controller;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Controlador REST para consultar los artículos del almacén.
 *
 * @author Equipo de desarrollo
 * @version 1.0
 */
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService servicio;

    /**
     * Construye el controlador con el servicio de artículos.
     *
     * @param servicio servicio encargado de gestionar los artículos
     */
    public ArticuloController(ArticuloService servicio) {
        this.servicio = servicio;
    }

    /**
     * Obtiene todos los artículos del almacén.
     *
     * @return respuesta HTTP 200 con la lista de artículos
     */
    @GetMapping
    public ResponseEntity<List<Articulo>> listarTodos() {
        List<Articulo> articulos = servicio.listarTodos();
        return ResponseEntity.ok(articulos);
    }

    /**
     * Obtiene los datos básicos de un artículo por su identificador.
     *
     * @param id identificador del artículo
     * @return HTTP 200 con los datos básicos o HTTP 404 si no existe
     */
    @GetMapping("/{id}/basico")
    public ResponseEntity<Map<String, Object>> buscarBasico(
            @PathVariable Integer id) {

        Optional<Map<String, Object>> articulo = servicio.buscarBasico(id);

        return articulo
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}