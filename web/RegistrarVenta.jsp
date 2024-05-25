<%-- 
    Document   : Registrarventa
    Created on : 2/05/2024, 3:55:42 p. m.
    Author     : nicol
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession obj = request.getSession();
    if (obj != null && obj.getAttribute("em") != null){
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>VENTAS</title>
        <style>
            @media print{
                *{
                    width: 100%;
                }
                .parte01{
                    display: none;
                }
                .parte02{
                    display: none;
                }
                .accion{
                    display: none;
                }
            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div><br>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigocliente" class="form-control" value="${cl.getDni()}" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-1"></div>
                                <div class="col-sm-5">
                                    <input type="text" name="nombrescliente" class="form-control" value="${cl.getNom()}" placeholder="Datos Cliente" readonly required>
                                </div>
                            </div><br>
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div><br>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-1"></div>
                                <div class="col-sm-5">
                                    <input type="text" name="nomproducto" value="${producto.getNom()}" class="form-control" placeholder="Datos Producto" readonly required>
                                </div>
                            </div><br>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${producto.getPre()}" class="form-control" placeholder="s/.0.00" readonly required>
                                </div>
                                <div class="col-sm-1"></div>
                                <div class="col-sm-2">
                                    <input type="number" name="cant" value="1" class="form-control" placeholder="" required>
                                </div>
                                <div class="col-sm-1"></div>
                                <div class="col-sm-2">
                                    <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock" readonly required>
                                </div>
                            </div><br>
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                         <div class="d-flex col-sm-5 ml-auto">
                             <label>Nro. Serie: </label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control" disabled>
                        </div>
                    </div>
                    <table class="table table-hover text-center">
                        <thead>
                            <tr>
                                <th>Nro</th>
                                <th>Codigo</th>
                                <th>Descripción</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>SubTotal</th>
                                <th class="accion">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>
                                        <form action="Controlador" method="GET">
                                            <input type="hidden" name="menu" value="NuevaVenta">
                                            <input type="hidden" name="accion" value="Editar">
                                            <input type="hidden" name="id" value="${list.getItem()}">
                                            <input type="hidden" name="precio" value="${list.getPrecio()}">
                                            <div class="d-flex">
                                                <input style="width: 50px;height: 30px;" type="number" name="edit" value="${list.getCantidad()}">
                                                <div class="parte02">
                                                    <button style="margin-left: 3px" type="submit" name="editButton" value="Editar" class="btn btn-warning parte02">Editar</button>
                                                </div>
                                            </div>
                                        </form>
                                    </td>
                                    <td>${list.getSubtotal()}</td>
                                    <td>
                                        <div class="accion">
                                            <div class="d-flex">
                                                <a href="Controlador?menu=NuevaVenta&accion=Delete&id=${list.getItem()}" class="btn btn-danger">Delete</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <div class="card-footer d-flex">
                        <div class="col-sm-6 parte02">
                            <div class="">
                                <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success btnuno">Generar venta</a>
                                <a href="Controlador?menu=NuevaVenta&accion=default" class="btn btn-danger btndos">Cancelar</a>
                            </div>
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txtTotal" value="S/. ${totalpagar}0" class="form-control" readonly>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
<%
    }
    else{
        request.getRequestDispatcher("error.html").forward(request, response);
    }
%>