package com.proyecto.service.impl;

import com.proyecto.dao.TipoDao;
import com.proyecto.domain.Tipo;
import com.proyecto.service.TipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Laboratorios
 */
@Service
public class TipoServiceImpl implements TipoService{
    
    @Autowired
    private TipoDao tipoDao;
    
    @Override
    public List<Tipo> getTipos(boolean activos) {
        var lista = tipoDao.findAll();
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Tipo getTipo(Tipo tipo) {
        return tipoDao.findById(tipo.getIdTipo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tipo tipo) {
        tipoDao.save(tipo);
    }

    @Override
    @Transactional
    public void delete(Tipo tipo) {
        tipoDao.delete(tipo);
    }
    
}

