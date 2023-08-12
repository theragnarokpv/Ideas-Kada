/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.service.ReporteService;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static org.springframework.web.servlet.function.RequestPredicates.headers;

/**
 *
 * @author abcas
 */

@Service
public class ReporteServiceImpl implements ReporteService {
    
     @Autowired
     DataSource datasource;

    @Override
    public ResponseEntity<Resource> generaReporte(String reporte, Map<String, Object> parametros, String tipo) throws IOException {
        
        
        try {
            
            String estilo;
            
            if("vPdf".equalsIgnoreCase(tipo)){
                estilo= "inline; ";
            } else {
                estilo= "attachment; ";
            }
            
            String reportePath = "reportes";
            
            ByteArrayOutputStream salida = new ByteArrayOutputStream();
            
            ClassPathResource fuente = new ClassPathResource(
                    reportePath + File.separator + reporte + ".jasper"
            );
            
            InputStream elReporte = fuente.getInputStream();
            
            var reporteJasper = JasperFillManager.fillReport(elReporte, parametros, datasource.getConnection());
            
            MediaType mediaType = null;
            String archivoSalida = "";
            
            byte[] data;
            
            if(tipo!=null) {
                switch(tipo) {
                    case "Pdf", "vPdf" -> {
                        JasperExportManager.exportReportToPdfStream(reporteJasper, salida);
                        
                        mediaType=MediaType.APPLICATION_PDF;
                        archivoSalida = reporte+".pdf";
                    }
                }
            }
            
            data = salida.toByteArray();
           
            HttpHeaders headers = new HttpHeaders();
            
            headers.set("content-Disposition", estilo+"filename=\""+archivoSalida+"\"");
            
            return ResponseEntity
                    .ok().headers(headers).contentType(mediaType).contentLength(data.length).body(new InputStreamResource(new ByteArrayInputStream(data)));
            
        } catch (SQLException | JRException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
