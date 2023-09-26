package com.mycompany.simulacion;

public class Persona {
    private String nombre;
    private Piso pisoActual;
    private Piso pisoDestino;

    public Persona(String nombre, Piso pisoActual, Piso pisoDestino) {
        this.nombre = nombre;
        this.pisoActual = pisoActual;
        this.pisoDestino = pisoDestino;
    }
    
    public Piso getPisoDestino(){
        return pisoDestino;
    }
    
    public Piso getPisoActual(){
        return pisoActual;
    }

    public String getNombre() {
        return nombre;
    }

 public void entrarAlElevador(Elevador elevador) {
        if (elevador != null) {
            pisoActual = null;
            elevador.agregarPersona(this);
        }
    }

    public void salirDelElevador(Elevador elevador, Piso destino) {
        if (elevador != null && destino != null) {
            pisoActual = destino;
            elevador.removerPersona(this);
        }
    }

    public void presionarBoton(Piso piso) {
        if (piso != null) {
            piso.presionarBoton();
        }
    }

    public void cambiarPiso(Piso nuevoPiso) {
        if (nuevoPiso != null) {
            pisoActual = nuevoPiso;
        }
    }
}


