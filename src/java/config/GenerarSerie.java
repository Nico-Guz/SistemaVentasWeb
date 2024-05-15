package config;

public class GenerarSerie {
    private int dato;
    private String numero;

    public String NumeroSerie(int dato) {
        this.dato = dato + 1;
        // Asegúrate de que la serie tenga una longitud fija de 9 dígitos
        String formato = "%09d";
        // Formatea el número con ceros a la izquierda
        this.numero = String.format(formato, this.dato);
        return this.numero;
    }
}
