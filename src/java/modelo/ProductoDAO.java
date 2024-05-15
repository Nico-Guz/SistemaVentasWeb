
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    /*public Producto buscar(int id){
        Producto p=new Producto();
        String sql="select * from producto where IdProducto"+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {}
        return p;
    }
    
    public int actualizarstock(int id, int stock){
        String sql="update producto set Stock=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {}
        return r;
    }*/
    
    //operaciones CRUD
    
    public List listar(){
        String sql="select * from producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Producto pr=new Producto();
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));
                pr.setPre(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));
                lista.add(pr);
            }
        } catch (Exception e) {
            System.out.println("Error al listar" + e.getMessage());
        }
        return lista;
    }
    
    public int agregar(Producto pr){
        String sql="insert into producto(Nombres,Precio,Stock,Estado)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNom());
            ps.setDouble(2, pr.getPre());
            ps.setInt(3, pr.getStock());
            ps.setString(4, pr.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar" + e.getMessage());
        }
        return r;
    }
    
    public Producto listarId(int id){
        Producto pro=new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                pro.setId(rs.getInt(1));
                pro.setNom(rs.getString(2));
                pro.setPre(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error al listarId" + e.getMessage());
        }
        return pro;
    }
    
    public int actualizar(Producto pr){
        String sql="update producto set Nombres=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNom());
            ps.setDouble(2, pr.getPre());
            ps.setInt(3, pr.getStock());
            ps.setString(4, pr.getEstado());
            ps.setInt(5, pr.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar" + e.getMessage());
        }
        return r;
    }
    
    public void delete(int id){
        String sql="delete from producto where idProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al borrar" + e.getMessage());
        }
    }
}
