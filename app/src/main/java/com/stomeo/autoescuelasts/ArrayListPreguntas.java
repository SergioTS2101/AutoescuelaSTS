package com.stomeo.autoescuelasts;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPreguntas {

    private static List<ListaPreguntas> tema1Preguntas() {

        final List<ListaPreguntas> listaPreguntas = new ArrayList<>();

        final ListaPreguntas pregunta1 = new ListaPreguntas("¿Qué es la MMA de un vehículo?", "La masa del vehículo", "La masa máxima autorizada para la utilización del vehículo", "La suma de las masas del vehículo de motor y del remolque arrastrado", "La masa máxima autorizada para la utilización del vehículo", "");
        final ListaPreguntas pregunta2 = new ListaPreguntas("Es considerado vehículo especial...", "El tractor agrícola", "El remolque agrícola", "Las dos respuestas anteriores son correctas", "Las dos respuestas anteriores son correctas", "");
        final ListaPreguntas pregunta3 = new ListaPreguntas("¿Qué es un remolque?", "Un vehículo autopropulsado", "Un vehículo no autopropulsado", "A y B son incorrectas", "Un vehículo no autopropulsado", "");

        listaPreguntas.add(pregunta1);
        listaPreguntas.add(pregunta2);
        listaPreguntas.add(pregunta3);


        return listaPreguntas;


    }

    private static List<ListaPreguntas> tema2Preguntas() {

        final List<ListaPreguntas> listaPreguntas = new ArrayList<>();

        final ListaPreguntas pregunta1 = new ListaPreguntas("¿Qué otro nombre reciben los semáforos cuadrados?", "De carril", "Peatonales", "Reservados", "De carril", "");
        final ListaPreguntas pregunta2 = new ListaPreguntas("Si quiere girar a la derecha con la luz verde iluminada, ¿tiene preferencia de paso?", "No, la luz roja me prohíbe girar", "No, porque la flecha verde me permite pasar, pero debo ceder el paso a los vehículos que se aproximen", "Sí, porque la flecha verde me obliga a girar", "No, porque la flecha verde me permite pasar, pero debo ceder el paso a los vehículos que se aproximen", "");
        final ListaPreguntas pregunta3 = new ListaPreguntas("A la vista de la señal horizontal de STOP, ¿dónde se detendrán los vehiculos?", "En la línea longitudinal sin rebasarla", "Ante la línea de detención", "Antes de llegar a la señal", "Ante la línea de detención", "");
        listaPreguntas.add(pregunta1);
        listaPreguntas.add(pregunta2);
        listaPreguntas.add(pregunta3);


        return listaPreguntas;
    }

    private static List<ListaPreguntas> tema3Preguntas() {

        final List<ListaPreguntas> listaPreguntas = new ArrayList<>();

        final ListaPreguntas pregunta1 = new ListaPreguntas("Las señales de peligro son...", "Triangulares con borde rojo y fondo blanco", "Circulares con borde rojo y fondo blanco", "Cuadradas con fondo azul", "Triangulares con borde rojo y fondo blanco", "");
        final ListaPreguntas pregunta2 = new ListaPreguntas("¿Cuál de estas señales significa 'situación de un paso a nivel sin barreras'","La 1.", "La 2.", "Ninguna de las dos.", "Ninguna de las dos.", "");
        final ListaPreguntas pregunta3 = new ListaPreguntas("¿Cuál de estas señales significa badén?", "La 1", "La 2", "La 3", "La 3", "");
        listaPreguntas.add(pregunta1);
        listaPreguntas.add(pregunta2);
        listaPreguntas.add(pregunta3);


        return listaPreguntas;
    }

    private static List<ListaPreguntas> tema4Preguntas() {

        final List<ListaPreguntas> listaPreguntas = new ArrayList<>();

        final ListaPreguntas pregunta1 = new ListaPreguntas("¿Qué indica esta señal vertical?", "Prioridad en sentido contrario", "Calzada con prioridad", "Prioridad respecto al sentido contrario", "Prioridad respecto al sentido contrario", "");
        final ListaPreguntas pregunta2 = new ListaPreguntas("¿Qué indica esta señal vertical reglamentaria de prioridad?", "Prioridad en sentido contrario", "Fin de priordad", "Calzada con prioridad", "Fin de prioridad", "");
        final ListaPreguntas pregunta3 = new ListaPreguntas("¿Cuál de estas señales significa badén?", "La 1", "La 2", "La 3", "La 3", "");
        listaPreguntas.add(pregunta1);
        listaPreguntas.add(pregunta2);
        listaPreguntas.add(pregunta3);


        return listaPreguntas;
    }

    public static List<ListaPreguntas> getPreguntas(String temaElegido) {
        switch (temaElegido) {
            case "tema1":
                return tema1Preguntas();
            case "tema2":
                return tema2Preguntas();
            case "tema3":
                return tema3Preguntas();
            case "tema4":
                return tema4Preguntas();
            default:
                return tema1Preguntas();
        }
    }

}
