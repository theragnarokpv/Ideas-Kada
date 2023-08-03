package com.proyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 *
 * @author Laboratorios
 */

@Data
@Entity
@Table(name="tipo")

public class Tipo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_tipo")
    private Long idTipo;
    private String descripcion;
    private boolean activo;

    @OneToMany
    @JoinColumn (name="id_tipo")
    List<Pedido> pedidos;
}