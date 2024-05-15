
package controlador;

import config.GenerarSerie;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Venta;
import modelo.VentaDAO;

/**
 *
 * @author nicol
 */
public class Controlador extends HttpServlet {
    Empleado em=new Empleado();
    EmpleadoDAO edao=new EmpleadoDAO();
    Producto pr=new Producto();
    ProductoDAO pdao=new ProductoDAO();
    Cliente cl=new Cliente();
    ClienteDAO cdao=new ClienteDAO();
    int ide;
    int idc;
    int idp;
    
    Venta v=new Venta();
    List<Venta>lista=new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    String numeroserie;
    VentaDAO vdao=new VentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if(menu.equals("Empleado")){
            switch (accion){
                case "Listar":
                    List lista=edao.listar();
                    request.setAttribute("empleados",lista);
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String tel=request.getParameter("txtTel");
                    String est=request.getParameter("txtEstado");
                    String user=request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e=edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String tel1=request.getParameter("txtTel");
                    String est1=request.getParameter("txtEstado");
                    String user1=request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if(menu.equals("Producto")){
            switch (accion){
                case "Listar":
                    List lista=pdao.listar();
                    request.setAttribute("productos",lista);
                    break;
                case "Agregar":
                    String nom=request.getParameter("txtNombres");
                    Double pre=Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock=Integer.parseInt(request.getParameter("txtStock"));
                    String est=request.getParameter("txtEstado");
                    pr.setNom(nom);
                    pr.setPre(pre);
                    pr.setStock(stock);
                    pr.setEstado(est);
                    pdao.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp=Integer.parseInt(request.getParameter("id"));
                    Producto p=pdao.listarId(idp);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1=request.getParameter("txtNombres");
                    Double pre1=Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock1=Integer.parseInt(request.getParameter("txtStock"));
                    String est1=request.getParameter("txtEstado");
                    pr.setNom(nom1);
                    pr.setPre(pre1);
                    pr.setStock(stock1);
                    pr.setEstado(est1);
                    pr.setId(idp);
                    pdao.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp=Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if(menu.equals("Cliente")){
            switch (accion){
                case "Listar":
                    List lista=cdao.listar();
                    request.setAttribute("clientes",lista);
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String dir=request.getParameter("txtDir");
                    String est=request.getParameter("txtEstado");
                    cl.setDni(dni);
                    cl.setNom(nom);
                    cl.setDir(dir);
                    cl.setEstado(est);
                    cdao.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc=Integer.parseInt(request.getParameter("id"));
                    Cliente c=cdao.listarId(idc);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String dir1=request.getParameter("txtDir");
                    String est1=request.getParameter("txtEstado");
                    cl.setDni(dni1);
                    cl.setNom(nom1);
                    cl.setDir(dir1);
                    cl.setEstado(est1);
                    cl.setId(idc);
                    cdao.actualizar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc=Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }
        if(menu.equals("NuevaVenta")){
            switch (accion){
                case "BuscarCliente":
                    String dni=request.getParameter("codigocliente");
                    cl.setDni(dni);
                    cl=cdao.buscar(dni);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("cl", cl);
                    lista.clear();
                    totalPagar=0;
                    break;
                case "BuscarProducto":
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    pr=pdao.listarId(id);
                    request.setAttribute("cl", cl);
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("totalpagar", totalPagar);
                    break;
                case "Agregar":
                    request.setAttribute("cl", cl);
                    if (lista.isEmpty()) {
                        item = 0;   
                    }
                    totalPagar=0.0;
                    item = item + 1;
                    cod=pr.getId();
                    descripcion=request.getParameter("nomproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cant"));
                    subtotal=precio*cant;
                    v=new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++){
                        totalPagar=totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    //Actualizacion Stock
                    /*for (int i = 0; i < lista.size(); i++) {
                        Producto pro=new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        ProductoDAO aO=new ProductoDAO();
                        pro=aO.buscar(idproducto);
                        int sac=pro.getStock()-cantidad;
                        aO.actualizarstock(idproducto, sac);
                    }*/
                    //Guardar Venta
                    if (lista != null) {
                        v.setIdcliente(cl.getId());
                        v.setIdempleado(2);
                        v.setNumserie(numeroserie);
                        v.setFecha("2024-05-09");
                        v.setMonto(totalPagar);
                        v.setEstado("1");
                        vdao.guardarVenta(v);
                        //Guardar Detalle ventas
                        int idv=Integer.parseInt(vdao.IdVenta());
                        for (int i = 0; i < lista.size(); i++) {
                            v=new Venta();
                            v.setId(idv);
                            v.setIdproducto(lista.get(i).getIdproducto());
                            v.setCantidad(lista.get(i).getCantidad());
                            v.setPrecio(lista.get(i).getPrecio());
                            vdao.guardarDetalleventa(v);
                        }
                    }
                    lista.clear();
                    totalPagar=0;
                    item = 0;
                    int incrementar1=Integer.parseInt(numeroserie);
                    GenerarSerie gss=new GenerarSerie();
                    numeroserie=gss.NumeroSerie(incrementar1);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "Editar":
                    totalPagar=0;
                    int edi = Integer.parseInt(request.getParameter("id"));
                    double precio = Double.parseDouble(request.getParameter("precio"));

                    // Buscar y editar el elemento basado en su identificador
                    Iterator<Venta> itera = lista.iterator();
                    while (itera.hasNext()) {
                        Venta elemento = itera.next();
                        if (elemento.getItem() == edi) {
                            //int nuevaCantidad = Integer.parseInt(request.getParameter("nuevacant"));
                            int nuevaCantidad = 6;
                            double subtotal = precio * nuevaCantidad;
                            // Actualizar la cantidad y el subtotal del elemento
                            elemento.setCantidad(nuevaCantidad);
                            elemento.setSubtotal(subtotal);
                            break;
                        }
                    }
                    for (int i = 0; i < lista.size(); i++){
                        totalPagar=totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("cl", cl);
                    request.setAttribute("lista", lista);
                    break;
                case "Delete":
                    totalPagar=0;
                    int indice = Integer.parseInt(request.getParameter("id"));

                    // Buscar y eliminar el elemento basado en su identificador
                    Iterator<Venta> iter = lista.iterator();
                    while (iter.hasNext()) {
                        Venta elemento = iter.next();
                        if (elemento.getItem() == indice) {
                            iter.remove();
                            break;
                        }
                    }
                    for (int i = 0; i < lista.size(); i++){
                        totalPagar=totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("cl", cl);
                    request.setAttribute("lista", lista);
                    break;
                default:
                    numeroserie = vdao.GenerarSerie();
                    lista.clear();
                    item = 0;
                    totalPagar=0;
                    if(numeroserie==null){
                        numeroserie="000000001";
                        request.setAttribute("nserie", numeroserie);
                    }
                    else {
                        int incrementar=Integer.parseInt(numeroserie);
                        GenerarSerie gs=new GenerarSerie();
                        numeroserie=gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
