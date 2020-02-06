package fr.epsi.atlas.monnaie.web;

public class MonnaieInexistanteException extends Exception {
    public MonnaieInexistanteException() {
        super("Monnaie inexistante");
    }
}
