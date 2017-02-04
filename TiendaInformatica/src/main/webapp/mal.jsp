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
    border: solid 1px;
    border-color: rgb(0, 0, 255);
    color: rgb(255, 255, 255);
    background-color: rgb(0, 0, 255);
}
</style>
 
<script type="text/javascript">
Paginador = function(divPaginador, tabla, tamPagina)
{
    this.miDiv = divPaginador; //un DIV donde ir�n controles de paginaci�n
    this.tabla = tabla;           //la tabla a paginar
    this.tamPagina = tamPagina; //el tama�o de la p�gina (filas por p�gina)
    this.pagActual = 1;         //asumiendo que se parte en p�gina 1
    this.paginas = Math.floor((this.tabla.rows.length - 1) / this.tamPagina); //�?
 
    this.SetPagina = function(num)
    {
        if (num < 0 || num > this.paginas)
            return;
 
        this.pagActual = num;
        var min = 1 + (this.pagActual - 1) * this.tamPagina;
        var max = min + this.tamPagina - 1;
 
        for(var i = 1; i < this.tabla.rows.length; i++)
        {
            if (i < min || i > max)
                this.tabla.rows[i].style.display = 'none';
            else
                this.tabla.rows[i].style.display = '';
        }
        this.miDiv.firstChild.rows[0].cells[1].innerHTML = this.pagActual;
    }
 
    this.Mostrar = function()
    {
        //Crear la tabla
        var tblPaginador = document.createElement('table');
 
        //Agregar una fila a la tabla
        var fil = tblPaginador.insertRow(tblPaginador.rows.length);
 
        //Ahora, agregar las celdas que ser�n los controles
        var ant = fil.insertCell(fil.cells.length);
        ant.innerHTML = 'Anterior';
        ant.className = 'pag_btn'; //con eso le asigno un estilo
        var self = this;
        ant.onclick = function()
        {
            if (self.pagActual == 1)
                return;
            self.SetPagina(self.pagActual - 1);
        }
 
        var num = fil.insertCell(fil.cells.length);
        num.innerHTML = ''; //en rigor, a�n no se el n�mero de la p�gina
        num.className = 'pag_num';
 
        var sig = fil.insertCell(fil.cells.length);
        sig.innerHTML = 'Siguiente';
        sig.className = 'pag_btn';
        sig.onclick = function()
        {
            if (self.pagActual == self.paginas)
                return;
            self.SetPagina(self.pagActual + 1);
        }
 
        //Como ya tengo mi tabla, puedo agregarla al DIV de los controles
        this.miDiv.appendChild(tblPaginador);
 
        //�y esto por qu�?
        if (this.tabla.rows.length - 1 > this.paginas * this.tamPagina)
            this.paginas = this.paginas + 1;
 
        this.SetPagina(this.pagActual);
    }
}
</script>
</head>
 
<div id="paginador"></div>
<table border="1" align="center" id="tblDatos">
    <tr>
        <th>T�tulo 1</th>
        <th>T�tulo 2</th>
        <th>T�tulo 3</th>
        <th>T�tulo 4</th>
        <th>T�tulo 5</th>
    </tr>
    <tr>
        <td>Campo 1-1</td>
        <td>Campo 1-2</td>
        <td>Campo 1-3</td>
        <td>Campo 1-4</td>
        <td>Campo 1-5</td>
    </tr>
    <tr>
        <td>Campo 2-1</td>
        <td>Campo 2-2</td>
        <td>Campo 2-3</td>
        <td>Campo 2-4</td>
        <td>Campo 2-5</td>
    </tr>
    <tr>
        <td>Campo 3-1</td>
        <td>Campo 3-2</td>
        <td>Campo 3-3</td>
        <td>Campo 3-4</td>
        <td>Campo 3-5</td>
    </tr>
    <tr>
        <td>Campo 4-1</td>
        <td>Campo 4-2</td>
        <td>Campo 4-3</td>
        <td>Campo 4-4</td>
        <td>Campo 4-5</td>
    </tr>
    <tr>
        <td>Campo 5-1</td>
        <td>Campo 5-2</td>
        <td>Campo 5-3</td>
        <td>Campo 5-4</td>
        <td>Campo 5-5</td>
    </tr>
    <tr>
        <td>Campo 6-1</td>
        <td>Campo 6-2</td>
        <td>Campo 6-3</td>
        <td>Campo 6-4</td>
        <td>Campo 6-5</td>
    </tr>
    <tr>
        <td>Campo 7-1</td>
        <td>Campo 7-2</td>
        <td>Campo 7-3</td>
        <td>Campo 7-4</td>
        <td>Campo 7-5</td>
    </tr>
    <tr>
        <td>Campo 8-1</td>
        <td>Campo 8-2</td>
        <td>Campo 8-3</td>
        <td>Campo 8-4</td>
        <td>Campo 8-5</td>
    </tr>
    <tr>
        <td>Campo 9-1</td>
        <td>Campo 9-2</td>
        <td>Campo 9-3</td>
        <td>Campo 9-4</td>
        <td>Campo 9-5</td>
    </tr>
    <tr>
        <td>Campo 10-1</td>
        <td>Campo 10-2</td>
        <td>Campo 10-3</td>
        <td>Campo 10-4</td>
        <td>Campo 10-5</td>
    </tr>
    <tr>
        <td>Campo 11-1</td>
        <td>Campo 11-2</td>
        <td>Campo 11-3</td>
        <td>Campo 11-4</td>
        <td>Campo 11-5</td>
    </tr>
    <tr>
        <td>Campo 12-1</td>
        <td>Campo 12-2</td>
        <td>Campo 12-3</td>
        <td>Campo 12-4</td>
        <td>Campo 12-5</td>
    </tr>
</table>
<script type="text/javascript">
var p = new Paginador(
    document.getElementById('paginador'),
    document.getElementById('tblDatos'),
    4
);
p.Mostrar();
</script>
</html>