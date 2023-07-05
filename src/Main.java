import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfaceArbol principalForm = new InterfaceArbol();
                principalForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                principalForm.setBounds(200,200,800,500);
                principalForm.setContentPane(principalForm.getMainPanel());
                principalForm.setVisible(true);


                /*for (int i=0;i<7;i++) {
                    presionarBoton();
                }*/
            }
        });
    }

    /*static int numEquipos = 8; // número de equipos
    static int numRondas = (int)(Math.log(numEquipos) / Math.log(2) + 1); // número de rondas
    static int rondaActual = 1; // ronda actual
    static int contadorBoton = 0; // contador de veces que se ha presionado el botón
    static int equiposRestantes = numEquipos; // número de equipos restantes en la ronda actual

    public static void presionarBoton() {
// al presionar el botón
        contadorBoton++; // incrementa el contador de veces que se ha presionado el botón

// verifica si se debe cambiar de ronda
        System.out.println("Contador boton: "+contadorBoton + " == " +"Equipos restantes/2:"+ equiposRestantes/2);
        if (contadorBoton == equiposRestantes / 2) {
            System.out.println("Ronda actual: " + rondaActual + "\n\n");
            rondaActual++; // incrementa la ronda actual
            contadorBoton = 0; // reinicia el contador de veces que se ha presionado el botón
            equiposRestantes /= 2; // reduce a la mitad el número de equipos restantes
        }

// verifica si aún quedan rondas restantes
        if (rondaActual > numRondas) {
            System.out.println("No quedan rondas restantes");
        }
    }*/
}