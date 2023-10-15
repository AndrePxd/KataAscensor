package org.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AscensorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testPersonaEnPrimerPiso() throws Exception {
        Ascensor ascensor = new Ascensor();
        int[] mockData = {0, 1}; // 0 representa el primer piso, 1 el segundo piso como destino
        int[] index = {0};

        // Establecer el generador mock para simular la creación de una persona en el primer piso con destino al segundo piso
        ascensor.setRandomGenerator((bound) -> mockData[index[0]++ % mockData.length]);

        ascensor.crearPersona();
        assertEquals(2, ascensor.getPisoActual());
    }

    @Test
    public void testPersonaEnSegundoPiso() throws Exception {
        Ascensor ascensor = new Ascensor();
        int[] mockData = {1, 2}; // 1 representa el segundo piso, 2 el tercer piso como destino
        int[] index = {0};

        // Establecer el generador mock para simular la creación de una persona en el segundo piso con destino al tercer piso
        ascensor.setRandomGenerator((bound) -> mockData[index[0]++ % mockData.length]);

        ascensor.crearPersona();
        assertEquals(3, ascensor.getPisoActual());
    }

    @Test
    public void testAscensorSube() throws Exception {
        Ascensor ascensor = new Ascensor();
        int[] mockData = {0, 2}; // Persona creada en el primer piso con destino al tercer piso
        int[] index = {0};
        ascensor.setRandomGenerator((bound) -> mockData[index[0]++ % mockData.length]);

        ascensor.crearPersona();
        assertEquals(3, ascensor.getPisoActual());
    }

    @Test
    public void testAscensorBaja() throws Exception {
        Ascensor ascensor = new Ascensor();
        int[] mockData = {2, 0}; // Persona creada en el tercer piso con destino al primer piso
        int[] index = {0};
        ascensor.setRandomGenerator((bound) -> mockData[index[0]++ % mockData.length]);
        ascensor.crearPersona();
        assertEquals(1, ascensor.getPisoActual());
    }
    @Test
    public void testCreacionAleatoriaPersona() throws Exception {
        Ascensor ascensor = new Ascensor();
        ascensor.crearPersona();
        assertEquals(ascensor.getPisoActual(), ascensor.getPisoDestino());
    }
}
