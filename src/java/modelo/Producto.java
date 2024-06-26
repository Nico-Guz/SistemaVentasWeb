
package modelo;

public class Producto {
    private int id;
    private String nom;
    private Double pre;
    private int stock;
    private String estado;

    public Producto() {
    }

    public Producto(int id, String nom, Double pre, int stock, String estado) {
        this.id = id;
        this.nom = nom;
        this.pre = pre;
        this.stock = stock;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPre() {
        return pre;
    }

    public void setPre(Double pre) {
        this.pre = pre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
