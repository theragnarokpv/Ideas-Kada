package com.proyecto.service;

import com.proyecto.domain.Tipo;
import java.util.List;

/**
 *
 * @author Laboratorios
 */
public interface TipoService {
    public List<Tipo> getTipos(boolean activos);
    
       // Se obtiene un Categoria, a partir del id de un categoria
    public Tipo getTipo(Tipo tipo);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Tipo tipo);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Tipo tipo);
    
}