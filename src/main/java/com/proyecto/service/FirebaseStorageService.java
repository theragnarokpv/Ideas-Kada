package com.proyecto.service;


import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    
    public String cargaImagen(
        MultipartFile archivoLocalCliente,
        String carpeta,
        Long id
    );
    
    final String BucketName="ideaskada.appspot.com";
    final String rutaSuperiorStorage="ideaskada";
    final String rutaJsonFile="firebase";
    final String archivoJsonFile="ideaskada-firebase-adminsdk-2xmyx-419f26c5cb.json";
}
