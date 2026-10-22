package com.hellin.almacen.service;

import com.hellin.almacen.model.Articulo;
import com.hellin.almacen.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// TODO: documentar la clase y todos sus métodos con Javadoc.
@Service
public class ArticuloService {

    private final ArticuloRepository repositorio;

    public ArticuloService(ArticuloRepository repositorio) {
        this.repositorio = repositorio;
    }

    /**
 * Devuelve todos los artículos del almacén.
 *
 * @return lista de todos los artículos
 */
public List<Articulo> listarTodos() {
        return repositorio.findAll();
    }

    /**
     * Busca un artículo por su identificador y devuelve sus datos básicos.
     *
     * @param id identificador del artículo que se desea buscar
     * @return los datos básicos del artículo, o Optional.empty() si no existe
     */
    public Optional<Map<String, Object>> buscarBasico(Integer id) {
        return repositorio.findById(id).map(articulo -> {
            Map<String, Object> datos = new java.util.LinkedHashMap<>();
            datos.put("id", articulo.getId());
            datos.put("nombre", articulo.getNombre());
            datos.put("stock", articulo.getStock());
            if (articulo.getStock() == 0) {
                datos.put("mensaje", "Agotado");
            }
            return datos;
        });
    }
}
