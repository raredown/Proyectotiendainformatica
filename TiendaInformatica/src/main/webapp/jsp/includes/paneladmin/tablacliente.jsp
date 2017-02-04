<%-- 
    Document   : tablacliente
    Created on : 04-feb-2017, 18:06:51
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            .pag_btn {
                border: solid 1px;
                border-color: rgb(0, 0, 255);
                color: rgb(0, 0, 255);
                background-color: rgb(255, 255, 255);
            }

            .pag_btn_des {
                border: solid 1px;
                border-color: rgb(200, 200, 200);
                color: rgb(200, 200, 200);
                background-color: rgb(245, 245, 245);
            }

            .pag_num {
                font-size: 30px;
                padding-left: 10px;
                padding-right: 10px;
            }
        </style>

        <script type="text/javascript">
            Paginador = function (divPaginador, tabla, tamPagina)
            {
                this.miDiv = divPaginador; //un DIV donde irán controles de paginación
                this.tabla = tabla;           //la tabla a paginar
                this.tamPagina = tamPagina; //el tamaño de la página (filas por página)
                this.pagActual = 1;         //asumiendo que se parte en página 1
                this.paginas = Math.floor((this.tabla.rows.length - 1) / this.tamPagina); //¿?

                this.SetPagina = function (num)
                {
                    if (num < 0 || num > this.paginas)
                        return;

                    this.pagActual = num;
                    var min = 1 + (this.pagActual - 1) * this.tamPagina;
                    var max = min + this.tamPagina - 1;

                    for (var i = 1; i < this.tabla.rows.length; i++)
                    {
                        if (i < min || i > max)
                            this.tabla.rows[i].style.display = 'none';
                        else
                            this.tabla.rows[i].style.display = '';
                    }
                    this.miDiv.firstChild.rows[0].cells[1].innerHTML = this.pagActual;
                }

                this.Mostrar = function ()
                {
                    //Crear la tabla
                    var tblPaginador = document.createElement('table');

                    //Agregar una fila a la tabla
                    var fil = tblPaginador.insertRow(tblPaginador.rows.length);

                    //Ahora, agregar las celdas que serán los controles
                    var ant = fil.insertCell(fil.cells.length);
                    ant.innerHTML = 'Anterior';
                    ant.className = 'btn btn-primary'; //con eso le asigno un estilo
                    var self = this;
                    ant.onclick = function ()
                    {
                        if (self.pagActual == 1)
                            return;
                        self.SetPagina(self.pagActual - 1);
                    }

                    var num = fil.insertCell(fil.cells.length);
                    num.innerHTML = ''; //en rigor, aún no se el número de la página
                    num.className = 'pag_num';

                    var sig = fil.insertCell(fil.cells.length);
                    sig.innerHTML = 'Siguiente';
                    sig.className = 'btn btn-primary';
                    sig.onclick = function ()
                    {
                        if (self.pagActual == self.paginas)
                            return;
                        self.SetPagina(self.pagActual + 1);
                    }

                    //Como ya tengo mi tabla, puedo agregarla al DIV de los controles
                    this.miDiv.appendChild(tblPaginador);

                    //¿y esto por qué?
                    if (this.tabla.rows.length - 1 > this.paginas * this.tamPagina)
                        this.paginas = this.paginas + 1;

                    this.SetPagina(this.pagActual);
                }
            }
        </script>
    </head>


    <table border="1" align="center" id="tblDatos" class="table table-striped">

        <tr>
            <th>Nombre usuario</th>
            <th>Ultimo acceso</th>
            <th>Bloquear</th>

        </tr>
        <c:forEach var="i" items="${requestScope.usuarios}">
            <tr>
                <td><c:out value="${i.username}"/></td>
                <td><c:out value="${i.ultimoAcesso}"/></td>
                <c:if test="${i.bloqueado=='n'}">
                    <td>
                        <input id="<c:out value="${i.idUsuario}"/>" type="checkbox" name="bloquear" value="" onclick="bloquear('<c:out value="${i.idUsuario}"/>')">
                    </td>
                </c:if>
                <c:if test="${i.bloqueado=='s'}">
                    <td>
                        <input id="<c:out value="${i.idUsuario}"/>" type="checkbox" name="bloquear" value="" checked onclick="bloquear('<c:out value="${i.idUsuario}"/>')">
                    </td>
                </c:if>

            </tr>

        </c:forEach>
    </table>
    <div id="paginador"></div>
    <script type="text/javascript">
        var p = new Paginador(
                document.getElementById('paginador'),
                document.getElementById('tblDatos'),
                10
                );
        p.Mostrar();
    </script>
</html>