# Evidencias de pruebas del endpoint básico de artículos

**Fecha:** 22 de octubre de 2026  
**Endpoint probado:** `GET /api/articulos/{id}/basico`  
**Entorno:** Spring Boot con el perfil H2  
**Resultado general:** Las tres pruebas han sido satisfactorias.

## 1. Consulta de todos los artículos

**Petición:**
```bash
curl -i http://localhost:8080/api/articulos
```

**Resultado:** HTTP 200 OK.

Se devuelve la lista de cinco artículos de prueba.

## 2. Artículo existente con stock

**Petición:**
```bash
curl -i http://localhost:8080/api/articulos/1/basico
```

**Resultado:** HTTP 200 OK.

Respuesta obtenida:
```json
{"id":1,"nombre":"Bolígrafo azul","stock":500}
```

**Comprobación:** Se devuelven los datos básicos del artículo.

## 3. Artículo agotado

**Petición:**
```bash
curl -i http://localhost:8080/api/articulos/3/basico
```

**Resultado:** HTTP 200 OK.

Respuesta obtenida:
```json
{"id":3,"nombre":"Grapadora metálica","stock":0,"mensaje":"Agotado"}
```

**Comprobación:** Se incluye el mensaje `Agotado` cuando el stock es cero.

## 4. Artículo inexistente

**Petición:**
```bash
curl -i http://localhost:8080/api/articulos/999/basico
```

**Resultado:** HTTP 404 Not Found.

**Comprobación:** Se devuelve el código HTTP 404 cuando no existe el artículo.

## Conclusión

Las pruebas manuales verifican los tres comportamientos principales del endpoint:
- Artículo existente: HTTP 200.
- Artículo sin stock: HTTP 200 con el mensaje `Agotado`.
- Artículo inexistente: HTTP 404.

La compilación del proyecto también finalizó correctamente con `BUILD SUCCESS`.
