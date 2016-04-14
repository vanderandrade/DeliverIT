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
                        table {width: 70%; font-size: 14px; font-family: tahoma, arial, sans-serif;}
                        table thead th {background-color: #8b8; padding: 5px 8px;}
                        table td {background-color: #ddd; padding: 5px 8px;}

                        table.sorting-table {cursor: move;}
                        table tr.sorting-row td {background-color: #8b8;}
                    </style>

                    <table id="table1">
                        <thead>
                            <tr>
                                <th>Codigo </th>
                                <th>Cliente </th>
                                <th>Produtos </th>
                                <th>Horario </th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>0001</td>
                                <td>Produto Exemplo</td>
                                <td><!-- Trigger the modal with a button -->
                                    <button autofocus="true" type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#listarModal">Listar</button>
                                </td>
                                <td>7:45</td>
                            </tr>
                            <tr>
                                <td>0002</td>
                                <td>Produto Exemplo 2</td>
                                <td><button type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#listarModal">Listar</button></td>
                                <td>8:00</td>
                            </tr>
                   
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="4" id="logarea">&nbsp;</td>
                            </tr>                           
                        </tfoot>
                    </table>

                    <!-- Modal -->
                    <div id="listarModal" class="modal fade" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Modal Header</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Some text in the modal.</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>

                        </div>
                    </div>

                    <script type="text/javascript">
                        var logarea = document.getElementById("logarea");
                        function log(text)
                        {
                            logarea.innerHTML = text;
                        }

                        var sorter = $('#table1').rowSorter({
                            onDragStart: function (tbody, row, index)
                            {
                                //log('index: ' + index);
                                log('onDragStart: active row\'s index is ' + index);
                            },
                            onDrop: function (tbody, row, new_index, old_index)
                            {
                                //log('old_index: ' + old_index + ', new_index: ' + new_index);
                                log('onDrop: row moved from ' + old_index + ' to ' + new_index);
                                
                            }
                        });

                    </script>

                </div>
            </div>

        </div>
    </div>
</body>

