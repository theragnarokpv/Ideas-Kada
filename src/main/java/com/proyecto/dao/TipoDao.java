package com.proyecto.dao;

import com.proyecto.domain.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDao extends JpaRepository <Tipo, Long>{
    
}
