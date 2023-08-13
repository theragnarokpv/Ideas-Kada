
package com.proyecto.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;


//Este enunciado de método es para emitir un reporte particular en algún formato
public interface ReporteService {
    public ResponseEntity<Resource> generaReporte (
        String reporteKada, //Es el mombre del archivo .jasper que se creó anteriormente
        Map<String, Object> parametros, //parámetros del reporte
        String tipo //Tipo de archivo generado (pdf, xmls (excel), csv..)
    ) throws IOException;
}
