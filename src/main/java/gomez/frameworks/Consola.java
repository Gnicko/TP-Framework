package gomez.frameworks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Consola {
    private Properties properties = new Properties();
    private ArrayList<Actions> actions;
    private String clases;

    public Consola() {
        actions = new ArrayList<>();
        ejecutar();
    }

    private void ejecutar() {

        try (InputStream archivo = getClass().getResourceAsStream("/config.properties")) {
            properties.load(archivo);
            clases = properties.getProperty("clase");
            String[] cadena = clases.split(",");
            for (String s : cadena) {
                Class c = Class.forName(s);
                actions.add((Actions) c.getDeclaredConstructor().newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar las clases", e);
        }
        cargarConsola();
    }

    private void cargarConsola() {

        Scanner sc = new Scanner(System.in);
        int salir = 0;
        int valor = 0;
        do {
            int i = 1;
            for (Actions a : actions) {
                System.out.println(i + " " + a.nombreItemMenu() + " (" + a.descripcionItemMenu() + ")");
                i++;
            }

            salir = i;
            System.out.println(salir + " Salir");
            valor = sc.nextInt();
            if (valor == salir)
                System.out.println("Ejecucion finalizada.");
            else {
                try {
                    actions.get(valor - 1).ejecutar();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("La opción ingresada no es válida, intente de nuevo");
                }
            }
        } while (valor != salir);
    }
}
