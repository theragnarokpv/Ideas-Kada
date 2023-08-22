
package com.proyecto.controller;

import com.proyecto.service.ReporteService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/reportes")
public class ReporteController {
    @Autowired
    ReporteService reporteService;
    
    @GetMapping("/principal")
    public String listado(Model model){
        return "/reportes/principal";
    }
    
    @GetMapping("/usuario")
    public ResponseEntity<Resource> ReporteUsuarios(@RequestParam String tipo) throws IOException{
        var  reporteKada = "usuario";
        return reporteService.generaReporte(reporteKada, null, tipo);
    }
    
    @GetMapping("/ventas")
    public ResponseEntity<Resource> ReporteVentas(@RequestParam String tipo) throws IOException{
        var  reporteKada = "ventas";
        return reporteService.generaReporte(reporteKada, null, tipo);
    }
    
    @GetMapping("/categorias")
    public ResponseEntity<Resource> ReporteCategorias(@RequestParam String tipo) throws IOException{
        var  reporteKada = "categorias";
        return reporteService.generaReporte(reporteKada, null, tipo);
    }
    
    
}
