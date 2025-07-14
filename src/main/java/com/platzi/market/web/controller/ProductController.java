package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Productos", description = "Operaciones relacionadas con productos del supermercado")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Obtener todos los productos")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Buscar producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @Parameter(description = "ID del producto", example = "2", required = true)
            @PathVariable int id) {
        return productService.getById(id)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Buscar productos por categoría")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos encontrados"),
            @ApiResponse(responseCode = "404", description = "No se encontraron productos en esta categoría")
    })
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductByCategory(
            @Parameter(description = "ID de la categoría", example = "5", required = true)
            @PathVariable int id) {
        return productService.getByCategory(id)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Guardar un nuevo producto")
    @ApiResponse(responseCode = "201", description = "Producto creado exitosamente")
    @PostMapping("/create")
    public ResponseEntity<Product> saveProduct(
            @Parameter(description = "Producto a guardar", required = true)
            @RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @Operation(summary = "Eliminar producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto eliminado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductById(
            @Parameter(description = "ID del producto a eliminar", example = "2", required = true)
            @PathVariable int id) {
        if (productService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
