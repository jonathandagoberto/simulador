package com.mycompany.simulacion;
import java.lang.Thread;


public class Elevador {
    private String estado;
    private int capacidadActual;
    private int plantaActual;
    private String direccionMovimiento;
    private int pisoDestinoActual;
    private int capacidadMaxima; // Agregamos la capacidad máxima

    public Elevador(int capacidadMaxima) {
        estado = "detenido";
        capacidadActual = 0;
        plantaActual = 1; // Inicia en el primer piso
        direccionMovimiento = "detenido";
        this.capacidadMaxima = capacidadMaxima; // Inicializamos la capacidad máxima
    }

    public void abrirPuerta() {
        if (estado.equals("detenido")) {
            estado = "puerta abierta";
            System.out.println("Puerta abierta en el piso " + plantaActual);
        } else {
            System.out.println("No se puede abrir la puerta en movimiento.");
        }
    }

    public void cerrarPuerta() {
        if (estado.equals("puerta abierta")) {
            estado = "detenido";
            System.out.println("Puerta cerrada en el piso " + plantaActual);
        }
    }

    public boolean haLlegado() {
        return plantaActual == pisoDestinoActual;
    }

    public void setPisoDestinoActual(int pisoDestino) {
        pisoDestinoActual = pisoDestino;
    }

    public void moverseHaciaPisoDestino(int origen, int destino, Persona persona) {
        int suma = 0;
        if (plantaActual < origen) suma=1;
        else suma=-1;
        pisoDestinoActual=destino;
        System.out.println("Elevador con destino al origen de la persona");
        while (plantaActual!=origen){
            plantaActual+=suma;
            System.out.println("Elevador se encuentra en el piso " + plantaActual);
            if (suma==1) System.out.println("Elevador subiendo al piso: " + plantaActual);
            else System.out.println("Elevador descendiendo al piso: " + plantaActual);
            try {
                for (int i = 0; i < 3; i++) {Thread.sleep(1000);}
            }catch (Exception e) {} 
        }
        System.out.println();
        System.out.println("Elevador con destino" + destino);
        if (plantaActual < destino) suma=1;
        else suma=-1;
        while (plantaActual!=destino){
            plantaActual+=suma;
            System.out.println("Elevador se encuentra en el piso " + plantaActual);
            if (suma==1) System.out.println("Elevador subiendo al piso: " + plantaActual);
            else System.out.println("Elevador descendiendo al piso: " + plantaActual);
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                }
            }catch (Exception e) {} 
        }
        System.out.println();
        System.out.println("Elevador ha llegado al piso destino: "+ destino);
        System.out.println();
    }
    

    public int getPisoActual() {
        return plantaActual;
    }

    public String getDireccion() {
        return direccionMovimiento;
    }

    public int getCantidadPersonas() {
        return capacidadActual;
    }

    public String getEstado() {
        return estado;
    }

    public void agregarPersona(Persona persona) {
        if (capacidadActual < capacidadMaxima) {
            // Verificar que la capacidad no se exceda
            capacidadActual++;
            System.out.println(persona.getNombre() + " entra al elevador.");
        } else {
            System.out.println("El elevador está lleno, " + persona.getNombre() + " no puede entrar.");
        }
    }

    public void removerPersona(Persona persona) {
        if (capacidadActual > 0) {
            // Verificar que haya personas en el elevador
            capacidadActual--;
            System.out.println(persona.getNombre() + " sale del elevador.");
        } else {
            System.out.println("El elevador está vacío, " + persona.getNombre() + " no puede salir.");
        }
    }
}

