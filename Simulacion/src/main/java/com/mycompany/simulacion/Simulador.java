package com.mycompany.simulacion;

import java.util.Random;

public class Simulador {

    private Reloj reloj;
    private Bitacora bitacora;
    private Edificio edificio;
    private Elevador elevador;
    
    
    public Simulador() {
        reloj = new Reloj();
        bitacora = new Bitacora(reloj);
        edificio = new Edificio(10,1);
        elevador = new Elevador(1);
    }

    public void inicializarSimulacion() {
        crearPersonasAleatorias();
    }

    public void ejecutarSimulacion() {
        for (Persona persona : bitacora.getPersonas()){
            System.out.println("persona: "+persona.getNombre()+" origen: "+persona.getPisoActual().getNumeroPiso()+" destino: "+persona.getPisoDestino().getNumeroPiso());
            elevador.moverseHaciaPisoDestino(persona.getPisoActual().getNumeroPiso(),persona.getPisoDestino().getNumeroPiso(),persona);
        }
            
        // Registrar eventos en la bitácora
        registrarEventos();

        // Mostrar estado del elevador en cada paso
        mostrarEstadoElevador();
        
        for (String event : bitacora.getEventos()){
            System.out.println(event);
        }
            
    }

    public void registrarEvento(String evento) {
        bitacora.registrarEvento(evento);
    }

    public void finalizarSimulacion() {
        // Mostrar eventos registrados al finalizar
        bitacora.mostrarEventos();
    }

private void crearPersonasAleatorias() {
    Random rand = new Random();
    Piso pisoO, pisoD;
    for (int i = 0; i < 2; i++) { 
        String nombrePersona = "Persona " + i;
        int pisoOrigen = rand.nextInt(edificio.getPisos().size()) ;
        int pisoDestino = rand.nextInt(edificio.getPisos().size());
        while (pisoDestino == pisoOrigen) {
            pisoDestino = rand.nextInt(edificio.getPisos().size()) ;
        }
        pisoO = edificio.getPiso(pisoOrigen);
        pisoD = edificio.getPiso(pisoDestino);
        boolean pisoOcupado = pisoO.estaOcupado();
        while(pisoOcupado){
            reloj.avanzarSegundos(2);
            pisoOrigen = rand.nextInt(edificio.getPisos().size()) ;
            pisoDestino = rand.nextInt(edificio.getPisos().size());
            pisoO = edificio.getPiso(pisoOrigen);
            pisoD = edificio.getPiso(pisoDestino);
            if (!pisoO.estaOcupado()) System.out.println("Elevador libre");
            pisoOcupado = pisoO.estaOcupado();
        }
        Persona persona = new Persona(nombrePersona,pisoO,pisoD);
        pisoO.agregarPersona(persona);
        bitacora.crearPersona(nombrePersona, pisoO, pisoD);
    }
}



    private void registrarEventos() {
        if (elevador.haLlegado()) {
            registrarEvento("Elevador llegó al piso " + elevador.getPisoActual());
        }
    }

    private void mostrarEstadoElevador() {
        // Muestra información sobre el estado del elevador en cada paso
        System.out.println("Estado del Elevador:");
        System.out.println("Piso actual: " + elevador.getPisoActual());
        System.out.println("Dirección: " + elevador.getDireccion());
        System.out.println("Personas a bordo: " + elevador.getCantidadPersonas());
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        Simulador simulador = new Simulador();
        simulador.inicializarSimulacion();
        simulador.ejecutarSimulacion();
        simulador.finalizarSimulacion();
    }
}


