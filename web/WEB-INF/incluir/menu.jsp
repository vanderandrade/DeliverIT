<%
String Usuario = null;
if(session.getAttribute("usuario")==null)
{
    response.sendRedirect("/index.jsp");
}else Usuario = (String) session.getAttribute("usuario");
%>
<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Deliver IT!</a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i><%=Usuario %> <b class="caret"></b></a>
                <ul class="dropdown-menu">

                    <li>
                        <a href="#"><i class="fa fa-fw fa-gear"></i> Configurações</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <form action="LogoutController" method="post"><i class="fa fa-fw fa-power-off"></i><input type="submit" value="Logout"></form>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li class="active">
                    <a href="index.jsp"><i class="fa fa-fw fa-dashboard"></i> Início</a>
                </li>
                <li>
                    <a href="charts.html"><i class="fa fa-fw fa-bar-chart-o"></i> Relatórios</a>
                </li>
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#cad"><i class="fa fa-fw fa-arrows-v"></i> Cadastro<i class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="cad" class="collapse">
                        <li>
                            <a href="categoria.jsp">Categoria de Produtos</a>
                        </li>
                        <li>
                            <a href="#">Produtos</a>
                        </li>
                        <li>
                            <a href="#">Descontos</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="tables.html"><i class="fa fa-fw fa-table"></i> Gerenciamento de Pedidos</a>
                </li>
                <li>
                    <a href="javascript:;" data-toggle="collapse" data-target="#reg"><i class="fa fa-fw fa-edit"></i> Regras de Negócios<i class="fa fa-fw fa-caret-down"></i></a>
                    <ul id="reg" class="collapse">
                        <li>
                            <a href="#">Descontos Condicionais</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> Dados de Pedido/Entrega</a>
                </li>
                <li>
                    <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Fluxo de Caixa</a>
                </li>                    
                <li>
                    <a href="blank-page.html"><i class="fa fa-fw fa-file"></i> ITEM</a>
                </li>
                <li>
                    <a href="index-rtl.html"><i class="fa fa-fw fa-dashboard"></i> ITEM</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>