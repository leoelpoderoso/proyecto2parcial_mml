/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Usuario
 */
public class Datos {
    
    String nombre;
    int telefono;
    int cell;
    String direccion;

    public Datos(String nombre, int telefono, int cell, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cell = cell;
        this.direccion = direccion;
    }

    public Datos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
