
package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Servicio que gestiona las operaciones de los artículos del almacén.
 */
@Service
public class ArticuloService {

    private final ArticuloRepository repositorio;

    /**
     * Constructor del servicio.
     *
     * @param repositorio repositorio de artículos
     */
    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * Devuelve todos los artículos del almacén.
     *
     * @return lista de todos los artículos del catálogo
     */
    public List<Articulo> listarTodos() {
        return repositorio.findAll();
    }
int numero = ;
    public Optional<Map<String, Object>> buscarBasico(Integer id) {
        // TODO (#n de la incidencia): buscar el artículo por id y devolver un mapa con id, nombre y stock.
        // Si el stock es 0, añadir "mensaje": "Agotado". Si no existe, Optional.empty().
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}
