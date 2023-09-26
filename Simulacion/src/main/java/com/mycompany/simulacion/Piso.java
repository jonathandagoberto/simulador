package com.mycompany.simulacion;

import java.util.ArrayList;

public class Piso {
    private int numeroPiso;
    private boolean ocupado;
    private boolean alguienEspera;
    private Boton boton;
    private ArrayList<Persona> personas;

    public Piso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
        ocupado = false;
        alguienEspera = false;
        boton = new Boton();
        personas= new ArrayList<>();
    }
    
    public void agregarPersona(Persona persona){
        personas.add(persona);
        ocupado=true;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public boolean alguienEspera() {
        return alguienEspera;
    }

    public void presionarBoton() {
        boton.presionarBoton();
    }

    public void restablecerBoton() {
        boton.restablecerBoton();
    }

    public void activarLuzBoton() {
        boton.activarLuz();
    }

    public void desactivarLuzBoton() {
        boton.desactivarLuz();
    }

    public void personaEntra() {
        ocupado = true;
        alguienEspera = false;
    }

    public void personaEspera() {
        alguienEspera = true;
    }

    public void personaSale() {
        ocupado = false;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }
}

