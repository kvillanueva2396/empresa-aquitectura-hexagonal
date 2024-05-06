package com.codigo.msvillanuevareyna.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "empresa_info")
@Getter
@Setter
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "razonsocial")
    private String razonSocial;

    @Column(name = "tipodocumento")
    private String tipoDocumento;

    @Column(name = "numerodocumento")
    private String numeroDocumento;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "condicion")
    private String condicion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "esagenteretencion")
    private Boolean EsAgenteRetencion;

    @Column(name = "usuacrea")
    private String usuaCrea;

    @Column(name = "datecreate")
    private Timestamp dateCreate;

    @Column(name = "usuamodif")
    private String usuaModif;

    @Column(name = "datemodif")
    private Timestamp dateModif;

    @Column(name = "usuadelet")
    private String usuaDelet;

    @Column(name = "datedelet")
    private Timestamp dateDelet;
}
