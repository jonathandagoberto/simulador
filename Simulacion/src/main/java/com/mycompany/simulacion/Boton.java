package com.mycompany.simulacion;

public class Boton {
    private boolean iluminado;

    public Boton() {
        iluminado = false;
    }

    public boolean estaIluminado() {
        return iluminado;
    }

    public void presionarBoton() {
        iluminado = true;
    }

    public void restablecerBoton() {
        iluminado = false;
    }
    
    public void activarLuz() {
        iluminado = true;
    }

    public void desactivarLuz() {
        iluminado = false;
    }
}

