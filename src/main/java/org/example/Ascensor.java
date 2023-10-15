package org.example;

import java.util.Random;
import java.util.random.RandomGenerator;


public class Ascensor {
    private int pisoActual;
    private int pisoDestino;
    @FunctionalInterface
    public interface RandomGenerator {
        int nextInt(int bound);
    }

    private RandomGenerator generator = new Random()::nextInt;  // Generador predeterminado

    // Setter para cambiar el generador, útil para pruebas
    public void setRandomGenerator(RandomGenerator generator) {
        this.generator = generator;
    }


    //El ascensor siempre esta en el piso 1
    public Ascensor() {
        this.pisoActual = 1;
    }


    public void mover() {
        //Comprobamos que el piso destino sea diferente al piso actual
        while (pisoActual != pisoDestino) {
            if (pisoActual < pisoDestino) {
                subir();
            } else {
                bajar();
            }
        }
    }

    private void subir() {
        System.out.println("Subiendo del piso " + pisoActual + " al piso " + (pisoActual + 1));
        pisoActual++;
    }

    private void bajar() {
        System.out.println("Bajando del piso " + pisoActual + " al piso " + (pisoActual - 1));
        pisoActual--;
    }

    public void crearPersona() throws Exception {
        int pisoPersona = generator.nextInt(3) + 1;
        int pisoDestinoPersona;

        do {
            pisoDestinoPersona = generator.nextInt(3) + 1;
        } while (pisoDestinoPersona == pisoPersona);

        System.out.println("Persona creada en el piso " + pisoPersona);

        // Simular presionar el botón de llamada
        presionarBotonLlamada(pisoPersona);

        System.out.println("Persona en el piso " + pisoPersona + " con destino al piso " + pisoDestinoPersona);

        if (pisoActual != pisoPersona) {
            this.pisoDestino = pisoPersona;
            mover();
        }
        recogerPersona();
        this.pisoDestino = pisoDestinoPersona;
        mover();
        System.out.println("Persona ha llegado a su destino en el piso " + pisoDestinoPersona);
    }

    private void presionarBotonLlamada(int pisoPersona) {
        System.out.println("Botón de llamada presionado en el piso " + pisoPersona);
    }
    private void recogerPersona() {
        System.out.println("Persona recogida en el piso " + pisoActual);
    }

    public int getPisoActual() {
        return pisoActual;
    }
    public int getPisoDestino() {
        return pisoDestino;
    }

}



