package gomez.utilizacion;

import gomez.frameworks.Actions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hora implements Actions {
    @Override
    public void ejecutar() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    @Override
    public String nombreItemMenu() {
        return "Hora";
    }

    @Override
    public String descripcionItemMenu() {
        return "Muestra la hora actual";
    }
}
