package gomez.utilizacion;

import gomez.frameworks.Actions;

import java.util.Random;

public class Temperatura implements Actions {
    @Override
    public void ejecutar() {
        System.out.println(new Random().nextInt(100) + " C°");
    }

    @Override
    public String nombreItemMenu() {
        return "Temperatura";
    }

    @Override
    public String descripcionItemMenu() {
        return "Muetra la temperatura";
    }
}
