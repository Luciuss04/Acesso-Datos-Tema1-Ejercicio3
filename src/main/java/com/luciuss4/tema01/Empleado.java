package com.luciuss4.tema01;
public class Empleado {

    private String id;
    private String nombre;
    private String departamento;
    private double salario;
    private String fechaAlta;

    public Empleado(String id, String nombre, String departamento, double salario, String fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }
}