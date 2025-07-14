package com.platzi.market.web.controller;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
@Tag(name = "Compra", description = "Operaciones relacionadas con la compra del supermercado")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Operation(summary = "Obtener todas las compras")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseService.getAllPurchases(), HttpStatus.OK);
    }

    @Operation(summary = "Buscar una compra por id de cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Compra encontrada"),
            @ApiResponse(responseCode = "404", description = "Compra no encontrada")
    })
    @GetMapping("/{clienteId}")
    public ResponseEntity<List<Purchase>> getByClientId(@PathVariable String clienteId){
        return purchaseService.getByClienteId(clienteId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Guardar una compra")
    @ApiResponse(responseCode = "201", description = "Compra guardada exitosamente")
    @PostMapping("/create")
    public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
