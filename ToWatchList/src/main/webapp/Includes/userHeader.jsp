<%-- 
    Document   : userHeader
    Created on : 01/06/2018, 19:20:46
    Author     : josev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body{
                padding-top: 80px;
            }
            #searchBar{
                width: 600px;
            }
        </style>
    </head>
    <body>
         <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" role="navigation">
            <a class="navbar-brand" href="#">
                <h3>To Watch List</h3>
            </a>
            <!-- button to expand navbar when it is collapsed -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#nav-content" aria-controls="nav-content" aria-expanded="false" aria-label="Toggle navigation">
                <span class="fas fa-bars"></span>
            </button>
            <!-- Menu Itens -->
            <div class="collapse navbar-collapse" id="nav-content">
                <div class="navbar-item mx-auto">
                    <form class="navbar-form form-inline mr-5">
                        <input class="navbar-form form-control ml-4" type="search" id="searchBar" placeholder="Search..." name="search">
                            <div class="input-group-btn">
                                <button class="navbar-btn btn btn-primary" type="submit">
                                     <i class="fa fa-search"></i>
                                </button>
                            </div>
                    </form>
                </div>
                <div class="navbar-item"
                    <form class="navbar-form form-inline ml-5" data-toggle="modal" data-target="#logInModal">
                            <a href="#"><i class="fas fa-address-card fa-3x"></i></a>
                    </form>
                </div>
            </div> <!-- Navbar Collapse -->
        </nav> <!-- Navbar -->
    </body>
</html>

