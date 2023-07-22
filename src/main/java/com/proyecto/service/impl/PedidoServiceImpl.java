/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.service.impl;

import com.proyecto.dao.PedidoDao;
import com.proyecto.domain.Pedido;
import com.proyecto.service.PedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Laboratorios
 */
@Service
public class PedidoServiceImpl implements PedidoService{
    
    @Autowired
    private PedidoDao pedidoDao;
    
    @Override
    public List<Pedido> getPedidos(boolean activos) {
        var lista = pedidoDao.findAll();
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido getPedido(Pedido pedido) {
        return pedidoDao.findById(pedido.getIdPedido()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Pedido pedido) {
        pedidoDao.save(pedido);
    }

    @Override
    @Transactional
    public void delete(Pedido pedido) {
        pedidoDao.delete(pedido);
    }
    
}
