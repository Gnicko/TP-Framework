package gomez.utilizacion;

import gomez.frameworks.Actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha implements Actions {
    @Override
    public void ejecutar() {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    @Override
    public String nombreItemMenu() {
        return "Fecha";
    }

    @Override
    public String descripcionItemMenu() {
        return "Muestra la fecha actual";
    }
}
