import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;


public class InterfaceArbol extends JFrame{
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JComboBox comboBox1;
    private JButton crearArbolButton;
    private JComboBox<String> comboBoxE1;
    private JComboBox<String> comboBoxE2;
    private JButton btnJugar;
    private JButton btnImprimir;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JList list5;
    private JList list6;
    private JLabel infoLabel;
    private JPanel JListPanel;
    private List<Arbol> listaEquipos = new ArrayList<>();
    private List<Arbol> listaNodosVacios = new ArrayList<>();
    private static int contadorClickJugar = 0;
    private int alturaArbol = 0; //No uso mucho
    private static int rondaActual = 1;
    private static int numRondas = 0;
    private int numEquiposIniciales;
    private int numEquiposTracking;
    private int numPartidosTotales;

    public InterfaceArbol() {

        list1.setName("list1");
        list2.setName("list2");
        list3.setName("list3");
        list4.setName("list4");
        list5.setName("list5");
        list6.setName("list6");


        DefaultListCellRenderer renderer1 = (DefaultListCellRenderer) list1.getCellRenderer();
        renderer1.setHorizontalAlignment(SwingConstants.CENTER);
        renderer1.setVerticalAlignment(SwingConstants.CENTER);

        DefaultListCellRenderer renderer2 = (DefaultListCellRenderer) list2.getCellRenderer();
        renderer2.setHorizontalAlignment(SwingConstants.CENTER);
        renderer2.setVerticalAlignment(SwingConstants.BOTTOM);

        DefaultListCellRenderer renderer3 = (DefaultListCellRenderer) list3.getCellRenderer();
        renderer3.setHorizontalAlignment(SwingConstants.CENTER);
        renderer3.setVerticalAlignment(SwingConstants.CENTER);

        DefaultListCellRenderer renderer4 = (DefaultListCellRenderer) list4.getCellRenderer();
        renderer4.setHorizontalAlignment(SwingConstants.CENTER);
        renderer4.setVerticalAlignment(SwingConstants.CENTER);

        DefaultListCellRenderer renderer5 = (DefaultListCellRenderer) list5.getCellRenderer();
        renderer5.setHorizontalAlignment(SwingConstants.CENTER);
        renderer5.setVerticalAlignment(SwingConstants.CENTER);

        DefaultListCellRenderer renderer6 = (DefaultListCellRenderer) list6.getCellRenderer();
        renderer6.setHorizontalAlignment(SwingConstants.CENTER);
        renderer6.setVerticalAlignment(SwingConstants.CENTER);

        crearArbolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listaEquipos.clear();
                listaNodosVacios.clear();

                numEquiposIniciales = comboBox1.getSelectedIndex();

                if (numEquiposIniciales == 0) {
                    numEquiposIniciales = 4;
                    list1.setVisible(true);
                    list2.setVisible(true);
                    list3.setVisible(true);
                } else if (numEquiposIniciales == 1) {
                    numEquiposIniciales = 8;
                    list1.setVisible(true);
                    list2.setVisible(true);
                    list3.setVisible(true);
                    list4.setVisible(true);
                } else if (numEquiposIniciales == 2) {
                    numEquiposIniciales = 16;
                    list1.setVisible(true);
                    list2.setVisible(true);
                    list3.setVisible(true);
                    list4.setVisible(true);
                    list5.setVisible(true);
                } else {
                    numEquiposIniciales = 32;
                    list1.setVisible(true);
                    list2.setVisible(true);
                    list3.setVisible(true);
                    list4.setVisible(true);
                    list5.setVisible(true);
                    list6.setVisible(true);
                }

                alturaArbol = (int) (Math.log(numEquiposIniciales) / Math.log(2)) + 1; //Altura del arbol
                numEquiposTracking = numEquiposIniciales;
                numRondas = (int)(Math.log(numEquiposIniciales) / Math.log(2) + 1);

                for(int i = 0; i< numEquiposIniciales; i++){

                    String equipo = JOptionPane.showInputDialog(null, "Ingresa nombre del equipo: ");

                    for (Arbol a: listaEquipos) {
                        if (equipo.equals(a.raiz.clave)) {
                            JOptionPane.showMessageDialog(null,"Verifique el nombre e ingrese nuevamente los equipos");
                            listaEquipos.clear();
                            return;
                        }
                    }

                    //Creando hojas del arbol
                    Arbol ar1 = new Arbol(equipo);
                    //Añadir a la lista de árboles
                    listaEquipos.add(ar1);
                }

                numEquiposIniciales = numEquiposIniciales /2; //NO MODIFICAR

                for(int i = 0; i< numEquiposIniciales; i++){
                    //Nodos vacios
                    Arbol ar2 = new Arbol();
                    //Añadir a la lista de nodos vacios
                    listaNodosVacios.add(ar2);
                    numEquiposIniciales = numEquiposIniciales /2;
                }

                if (!listaEquipos.isEmpty()) {
                    DefaultListModel<String> listModel = (DefaultListModel<String>) list1.getModel();
                    for (Arbol x:listaEquipos){
                        listModel.addElement("Equipo: "+x.raiz.clave);
                    }
                }



                infoLabel.setText("-\tInformación\n" + "Ronda 1: " + numEquiposTracking + " equipos restantes.");

                llenarComboBoxEquipos();

                //numPartidosTotales = numEquiposTracking/2;

            }
        });

        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Valido que haya alcanzado el número de rondas límite
                if (contadorClickJugar != alturaArbol) {

                    String ganador = JOptionPane.showInputDialog(null, "Escoga un ganador entre Equipo 1 y Equipo 2\n " +
                            "Escriba el nombre del equipo correctamente");
                    NodoArbol ganadorNodo = null;

                    String eq1 = comboBoxE1.getSelectedItem().toString();
                    String eq2 = comboBoxE2.getSelectedItem().toString();
                    Arbol equipo1 = null;
                    Arbol equipo2 = null;

                    if (!(eq1.equals(eq2))) {
                        for (Arbol a : listaEquipos) {

                            if (a.raiz.clave.equals(eq1)) {
                                a.raiz.setJugando(true);
                                equipo1 = a;

                            } else if (a.raiz.clave.equals(eq2)) {
                                a.raiz.setJugando(true);
                                equipo2 = a;
                            }
                        }

                        for (Arbol a : listaNodosVacios) {
                            if (equipo1.raiz.jugando && equipo2.raiz.jugando) {

                                //Juntar arboles, equipos que se enfrentan
                                ganadorNodo = a.juntarArboles(ganador, equipo1, equipo2);
                                a.raiz = ganadorNodo;
                                a.raiz.setJugando(false);


                            }

                        }


                        Arbol perdedor = null;
                        if (ganador.equals(eq1)) {


                            for (Arbol a : listaEquipos) {
                                if (a.raiz.clave.equals(eq2)) {
                                    perdedor = a;
                                }
                            }
                            listaEquipos.remove(perdedor);
                        } else {
                            for (Arbol a : listaEquipos) {
                                if (a.raiz.clave.equals(eq1)) {
                                    perdedor = a;
                                }
                            }
                            listaEquipos.remove(perdedor);
                        }

                    }

                    llenarComboBoxEquipos();

                    contadorClickJugar++;
                    if (contadorClickJugar == numEquiposTracking / 2) {
                        //System.out.println("Ronda actual: " + rondaActual);

                        String nombreLista = "list" + (rondaActual + 1); // construye el nombre de la lista

                        DefaultListModel<String> listModel = new DefaultListModel<>();
                        //listModel.addElement("Lista de equipos :\n");
                        for (Arbol x:listaEquipos){
                            listModel.addElement("Equipo: "+x.raiz.clave);
                        }

                        JList<String> lista = (JList<String>)getComponentByName(nombreLista);
                        lista.setModel(listModel);

                        rondaActual++; // incrementa la ronda actual
                        contadorClickJugar = 0; // reinicia el contador de veces que se ha presionado el botón
                        numEquiposTracking /= 2; // reduce a la mitad el número de equipos restantes
                    }

                    numPartidosTotales++;
                    infoLabel.setText("-  Información - " + " Ronda " + numRondas + ": " + numEquiposTracking + " equipos restantes.");

                    if (rondaActual > numRondas) {
                        JOptionPane.showMessageDialog(null,"No quedan rondas restantes");
                    }
                }
            }
        });
    }

    private Component getComponentByName(String name) {
        for (Component component : JListPanel.getComponents()) {
            if (name.equals(component.getName())) {
                return component;

            }
        }
        return null;
    }


    public void llenarComboBoxEquipos(){
        comboBoxE1.removeAllItems();
        comboBoxE2.removeAllItems();

        for(Arbol a:listaEquipos){
            if(a.raiz!=null){
                String data = a.raiz.clave;
                comboBoxE1.addItem(data);
                comboBoxE2.addItem(data);
            }

        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
