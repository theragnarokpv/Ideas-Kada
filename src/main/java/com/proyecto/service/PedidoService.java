/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.service;

import com.proyecto.domain.Pedido;
import java.util.List;

/**
 *
 * @author Laboratorios
 */
public interface PedidoService {
    public List<Pedido> getPedidos(boolean activos);
    
       // Se obtiene un Pedido, a partir del id de un pedido
    public Pedido getPedido(Pedido pedido);
    
    // Se inserta un nuevo pedido si el id del pedido esta vacío
    // Se actualiza un pedido si el id del pedido NO esta vacío
    public void save(Pedido pedido);
    
    // Se elimina el pedido que tiene el id pasado por parámetro
    public void delete(Pedido pedido);
    
}
