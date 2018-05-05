<%-- 
    Document   : index
    Created on : 4/05/2018, 09:02:06 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>   
        <title>TODO supply a title</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <link rel="stylesheet" type="text/css" href="css.css" media="screen" />
      

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Latest compiled and minified CSS -->

</head>
<BODY>

<header>
	
	<h1>Conjunto Residencial</h1>

</header>

        <nav class="navbar navbar-default" style="">
            <div class="container">
                <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span> 
                <span class="icon-bar"></span> 
                <span class="icon-bar"></span> 
                </button>

                </div>
                <div class="container collapse navbar-collapse" id="navbar">
                    <ul class="nav navbar-nav">
                        <li id="sesion">
                         <span class="glyphicon glyphicon-user"></span>
                          <a style="display: inline-block;" href="#">Log in</a> 
                        </li>

                        <li id="registro" class="dropdown"><span class="glyphicon glyphicon-list-alt"></span>
                        <a id="reg" href="#" style="display: inline-block;" class="dropdown-toggle" data-toggle="dropdown">
                        Registrar <span class="caret"></span></a>

                        <ul class="dropdown-menu">
                           <li><a href="Asamblea" id="cliente" data-seleccion="polonia"> Asambleas </a></li>
                           <li><a href="GrupoFamiliar" id="mensajero" data-seleccion="senegal"> Grupo Familiar </a></li>
                           <li><a href="Inquilino" id="envio" data-seleccion="colombia" > Inquilino </a></li>
                           <li><a href="Multa" id="cliente" data-seleccion="polonia"> Multa </a></li>
                           <li><a href="Pago" id="mensajero" data-seleccion="senegal"> Pago </a></li>
                           <li><a href="Parentesco" id="envio" data-seleccion="colombia" > Parentesco </a></li>
                           <li><a href="Persona" id="cliente" data-seleccion="polonia"> Persona </a></li>
                           <li><a href="Recibo" id="mensajero" data-seleccion="senegal"> Recibo </a></li>
                           <li><a href="Tipo" id="envio" data-seleccion="colombia" > Tipo </a></li>
                           <li><a href="Vivienda" id="envio" data-seleccion="colombia" > Vivienda </a></li>
                        </ul>
                        </li>
                    </ul>
                </div>
            </div>
       </nav>



	<section class="content">
	<main>

<picture>
	<img src="https://i.ytimg.com/vi/MwpRqD8qqXU/maxresdefault.jpg">
</picture>

	</main>
    </section>

	<footer>

	<p>

Copyright (c) 2003 Company Name
All Rights Reserved
 
This product is protected by copyright and distributed under
licenses restricting copying, distribution, and decompilation.</p>
		

	</footer>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
          <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>



        <script>
    
     $("#cliente").click(function(event){
                $("main").load('resgistro-cliente.html');
        });

      $("#sesion").click(function(event){
                $("main").load('sesion.html');
        });

       $("#mensajero").click(function(event){
                $("main").load('resgistro-mensajero.html');
        });

       $("#envio").click(function(event){
                $("main").load('resgistro-envio.html');
        });


        </script>

	
</BODY>
</html>
