package com.mycompany.simulacion;
import java.lang.Thread;

public class Reloj {
    private int segundos;

    public Reloj() {
        segundos = 0;
    }

    public void avanzarSegundos(int cantidad) {
        try {
            for (int i = 0; i < 5; i++) {
               
                // it will sleep the main thread for 1 sec
                // ,each time the for loop runs
                Thread.sleep(cantidad);
                System.out.println("El piso esta ocupado, por favor espere...");
            }
        }
        catch (Exception e) {
           
            // catching the exception
            System.out.println(e);
        }
         
    }

    public int getSegundos() {
        return segundos;
    }

    public void hacerTic() {
        segundos++;
    }
}
