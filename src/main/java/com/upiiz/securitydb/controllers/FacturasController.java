package com.upiiz.securitydb.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/facturas")
public class FacturasController {
    @GetMapping("/listar")
    public String getFacturas() {
        return "Listado de Facturas";
    }

    @GetMapping("/listar/{id}")
    public String getFacturaById(@PathVariable int id) {
        return "Factura por id: " + id;
    }

    @PostMapping("/crear")
    public String createFactura() {
        return "Factura creada";
    }

    @PutMapping("/actualizar/{id}")
    public String updateFactura(@PathVariable int id) {
        return "Factura actualizada: " + id;
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteFactura(@PathVariable int id) {
        return "Factura eliminada: " + id;
    }

    @PatchMapping("/deploy/{id}")
    public String deployFactura(@PathVariable int id) {
        return "Factura desplegada: " + id;
    }

}
