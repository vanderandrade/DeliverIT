<%@page import="DAO.ClienteDAO"%>
<%@page import="DAO.PedidoDAO"%>
<%@page import="Model.Pedido"%>
<%    ClienteDAO clientedao = new ClienteDAO((MySqlController) session.getAttribute("conexao"));
    PedidoDAO pedidodao = new PedidoDAO((MySqlController) session.getAttribute("conexao"));
    Pedido listaPedidos[] = pedidodao.carregaPedidos();
%>
<body>
    <div id="wrapper">
        <jsp:include page="../WEB-INF/incluir/menu.jsp" />
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-10">
                        <h1 class="text-center page-header">
                            <i class="fa fa-desktop"></i>  Monitoramento dos Pedidos
                        </h1>
                    </div>
                </div>

                <div class="row">
                    <style>
                        table {width: 100%; font-size: 14px; font-family: tahoma, arial, sans-serif;}
                        table thead th {background-color: #8b8; padding: 5px 8px;}
                        table td {background-color: #ddd; padding: 5px 8px;}
                        table.sorting-table {cursor: move;}
                        table tr.sorting-row td {background-color: #8b8;}
                    </style>

                    <table id="tabelaPedidos">
                        <thead>
                            <tr>
                                <th>Codigo </th>
                                <th>Cliente </th>
                                <th>Produtos </th>
                                <th>Horario </th>
                                <th>Valor Total </th>
                                <th>Status </th>

                            </tr>
                        </thead>
                        <tbody>
                            <% for (Pedido pedido : listaPedidos) {
                            %>
                            <tr>
                                <td><%=pedido.getCodPedido()%></td>
                                <td><%=clientedao.consultaCliente(pedido.getCodCliente())%></td>
                                <td><!-- Trigger the modal with a button -->
                                    <button autofocus="true" type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#listarModal<%=pedido.getCodPedido()%>">Exibir</button>
                                </td>
                                <td><%=pedido.getDataPedido()%></td>
                                <td>R$ <%=pedido.getValorTotal()%></td>
                                <td><button autofocus="true" type="button" class="btn btn-success btn-block" data-toggle="modal" data-target="#alterarModal"><%=pedido.getStatusPedido()%></button></td>
                            </tr>


                        <div id="listarModal<%=pedido.getCodPedido()%>" class="modal fade" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Produtos - Pedido Nº <%=pedido.getCodPedido()%></h4>
                                    </div>
                                    <div class="modal-body">
                                        <% String listaProdutos[] = pedidodao.carregaItemPedido(pedido.getCodPedido());
                                            for (String prod : listaProdutos) {%>
                                        <p><%=prod%></p>
                                        <%}%>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%}%>
                        <div id="alterarModal" class="modal fade" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Alterar Status do Pedido</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form class="form-horizontal" method="post" action="PedidoController">
                                            <select id="alterarCombo" name="alterarCombo" class="form-control">
                                                <option value="criado">Criado</option>
                                                <option value="processando">Processando</option>
                                                <option value="enviado">Enviado</option>
                                                <option value="fechado">Fechado</option>
                                            </select>
                                            <input type="hidden" name="codPedido" value="">
                                            <div class="btn center-block">
                                            <button id="alterar" name="button" value="alterar" class="btn btn-primary">Alterar Status</button>
                                            </div>
                                        </form>           
                                        
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </tbody>

                    </table>

                    <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
                    <script type="text/javascript">
                        RowSorter("#tabelaPedidos");
                    </script>

                </div>
            </div>

        </div>
    </div>
</body>

