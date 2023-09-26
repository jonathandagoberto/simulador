package com.mycompany.simulacion;


import java.util.ArrayList;
import java.util.List;

public class Edificio {
    private List<Elevador> elevadores;
    private List<Piso> pisos;

    public Edificio(int cantidadPisos, int cantidadElevadores) {
        elevadores = new ArrayList<>();
        pisos = new ArrayList<>();
        for (int i = 1; i <= cantidadPisos; i++) {
            Piso piso = new Piso(i);
            pisos.add(piso);
        }

for (int i = 1; i <= cantidadElevadores; i++) {
    Elevador elevador = new Elevador(cantidadPisos); // Proporciona la cantidad de pisos
    elevadores.add(elevador);
}

    }

    public List<Elevador> getElevadores() {
        return elevadores;
    }

    public List<Piso> getPisos() {
        return pisos;
    }
    
    public Piso getPiso(int indice){
        return pisos.get(indice);
    }
    
    public void setPisos(Piso piso){
        pisos.add(piso);
    }
    
    
}
