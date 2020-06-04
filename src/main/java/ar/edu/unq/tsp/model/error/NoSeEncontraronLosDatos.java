package ar.edu.unq.tsp.model.error;

public class NoSeEncontraronLosDatos extends Exception {
    public NoSeEncontraronLosDatos() {
        super("No se encontraron los datos solicitados!");
    }
}
