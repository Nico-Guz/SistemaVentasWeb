<%-- 
    Document   : Principal
    Created on : 2/05/2024, 2:53:40 p. m.
    Author     : nicol
--%>

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
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body> 
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light disabled" aria-current="page" href="#"><img src="img/logo.png" width="90" alt=""/></a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame" onclick="ocultarImagen()"><b>Producto</b></a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame" onclick="ocultarImagen()"><b>Empleado</b></a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame" onclick="ocultarImagen()"><b>Clientes</b></a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame" onclick="ocultarImagen()"><b>Nueva Venta</b></a>
                    </li>
                </ul>
            </div>
            <div class="dropdown">
                <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <b>${usuario.getNom()}</b>
                </button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="#">
                        <img style="border-radius: 50%" src="img/user.png" alt="" width="60" />
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                    <a class="dropdown-item" href="#">usuario@gmail.com</a>
                    <div class="dropdown-divider"></div>
                    <form action="CerrarSesion" method="POST">
                        <button type="submit" class="dropdown-item" href="#">Salir</button>
                    </form>
                </div>
            </div>
        </nav>
        <div class="logo" style="display: flex; justify-content: center; align-items: center;">
            <img id="logoImg" src="img/logo.png" alt="" style="width: 80%;margin-top: 10%">
        </div>
        <div class="m-4" style="height: 550px">
            <iframe name="myFrame" style="height: 100%; width: 100%;"></iframe>                 
        </div>
                    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script>
        function ocultarImagen() {
            // Oculta la imagen cambiando su estilo a display: none;
            document.getElementById('logoImg').style.display = 'none';
        }

        function mostrarImagen() {
            // Muestra la imagen cambiando su estilo a display: block;
            document.getElementById('logoImg').style.display = 'block';
        }
    </script>
    </body>
</html>
<%
    }
    else{
        request.getRequestDispatcher("error.html").forward(request, response);
    }
%>