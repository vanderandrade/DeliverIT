<body>
    <div id="wrapper">
        <jsp:include page="../WEB-INF/incluir/menu.jsp" />
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-10">
                        <h1 class="page-header">
                            Monitoramento dos Pedidos <small>-</small>
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
                            <tr>
                                <td>0001</td>
                                <td>Produto Exemplo</td>
                                <td><!-- Trigger the modal with a button -->
                                    <button autofocus="true" type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#listarModal">Exibir</button>
                                </td>
                                <td>7:45</td>
                                <td>R$ 100,00</td>
                                <td><button autofocus="true" type="button" class="btn btn-success btn-block" data-toggle="modal" data-target="#listarModal">Alterar</button></td>
                            </tr>
                            <tr>
                                <td>0002</td>
                                <td>Produto Exemplo 2</td>
                                <td><button type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#listarModal">Exibir</button></td>
                                <td>8:00</td>
                                <td>R$ 100,00</td>
                                <td><button autofocus="true" type="button" class="btn btn-success btn-block" data-toggle="modal" data-target="#listarModal">Alterar</button></td>
                            
                            </tr>
                   
                        </tbody>

                    </table>

                    <!-- Modal -->
                    <div id="listarModal" class="modal fade" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Produtos</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Produto 1</p>
                                    <p>Produto 1</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                                </div>
                            </div>

                        </div>
                    </div>
                    <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
                    <script type="text/javascript">
                        RowSorter("#tabelaPedidos");
                    </script>

                </div>
            </div>

        </div>
    </div>
</body>

