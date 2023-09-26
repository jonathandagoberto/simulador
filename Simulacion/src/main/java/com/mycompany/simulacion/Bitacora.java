package com.mycompany.simulacion;

import java.util.ArrayList;
import java.util.List;

public class Bitacora {
    private ArrayList<String> eventos;
    private Reloj reloj;
    private ArrayList<Persona> personas;

    public Bitacora(Reloj reloj) {
        eventos = new ArrayList<>();
        this.reloj = reloj;
        personas = new ArrayList<>();
    }
    
    public Persona crearPersona(String nombre, Piso pisoActual, Piso pisoDestino){
     Persona persona = new Persona(nombre,pisoActual,pisoDestino);
     personas.add(persona);
     return persona;
    }

    public void registrarEvento(String evento) {
        String registro = "[" + reloj.getSegundos() + "s]: " + evento;
        eventos.add(registro);
        System.out.println(registro);
    }

    public void mostrarEventos() {
        System.out.println("\n--- Bitácora de Eventos ---");
        for (String evento : eventos) {
            System.out.println(evento);
        }
    }
    
    public ArrayList<Persona> getPersonas(){
        return personas;
    }
    
    public ArrayList<String> getEventos(){
        return eventos;
    }
}
