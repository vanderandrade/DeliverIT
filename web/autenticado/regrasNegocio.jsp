<%@page import="br.pucpcaldas.inf.lc.deliverit.model.Produto"%>
<%@page import="br.pucpcaldas.inf.lc.deliverit.model.Categoria"%>
<%@page import="br.pucpcaldas.inf.lc.deliverit.dao.CategoriaDAO"%>
<%@page import="br.pucpcaldas.inf.lc.deliverit.dao.ProdutoDAO"%>

<body>

    <%
        CategoriaDAO categoriadao = new CategoriaDAO((MySqlController) session.getAttribute("conexao"));
        ProdutoDAO produtodao = new ProdutoDAO((MySqlController) session.getAttribute("conexao"));
        Categoria listaCategorias[] = categoriadao.carregaCategorias();
        Produto listaProduto[] = produtodao.carregaProduto();
    %>
    <div id="wrapper">
        <jsp:include page="../WEB-INF/incluir/menu.jsp" />
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Regras de Negócio <small>-</small>
                        </h1>
                    </div>
                </div>

                <div class="col-md-1"></div>
                <div class="col-md-5">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            Quantidade de produtos
                        </h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" method="post" action="RegrasNegocioController">
                            <fieldset>
                                <div class="form-group">
                                    <select id="produtos" name="produtos" class="form-control" required="">
                                        <%
                                            for (Produto prod : listaProduto) {
                                        %>
                                        <option value="<%=prod.getCodProduto()%>"><%=prod.getNomeProduto()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input id="quantidade" name="quantidade" placeholder="Quantidade de produtos" class="form-control input-md" required="" type="text">
                                </div>
                                <div class="form-group">
                                    <input id="porcentagem" name="porcentagem" placeholder="Porcentagem de desconto" class="form-control input-md" required="" type="text">
                                </div>
                                <div class="form-group">
                                    <button id="registrarDQ" name="button" value="registrarPQ" class="btn btn-success">Registrar</button>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>

                <div class="col-md-1"></div>
                <div class="col-md-5">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            Preço total por categoria
                        </h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" method="post" action="RegrasNegocioController">
                            <fieldset>
                                <div class="form-group">
                                    <select id="categorias" name="categorias" class="form-control" required="">
                                        <%
                                            for (Categoria cat : listaCategorias) {
                                        %>
                                        <option value="<%=cat.getCodigo()%>"><%=cat.getNome()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input id="precomin" name="precomin" placeholder="R$ XX,XX" class="form-control input-md" required="" type="text">
                                </div>
                                <div class="form-group">
                                    <input id="porcentagem" name="porcentagem" placeholder="Porcentagem de desconto" class="form-control input-md" required="" type="text">
                                </div>
                                <div class="form-group">
                                    <button id="registrarCP" name="button" value="registrarCP" class="btn btn-success">Registrar</button>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>


                <div class="col-md-1"></div>
                <div class="col-md-5">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            Preço total do pedido
                        </h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" method="post" action="RegrasNegocioController">
                            <fieldset>
                                <div class="form-group">
                                    <input id="precomin" name="precomin" placeholder="R$ XX,XX" class="form-control input-md" required="" type="text">
                                </div>
                                <div class="form-group">
                                    <input id="porcentagem" name="porcentagem" placeholder="Porcentagem de desconto" class="form-control input-md" required="" type="text">
                                </div>
                                <div class="form-group">
                                    <button id="registrarPP" name="button" value="registrarPP" class="btn btn-success">Registrar</button>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>


                <div class="col-md-1"></div>
                <div class="col-md-5">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            Distância do pedido
                        </h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" method="post" action="RegrasNegocioController">
                            <fieldset>
                                <div class="form-group">
                                    <input id="distancia" name="distancia" placeholder="XX,X Km" class="form-control input-md" required="" type="text">
                                </div>
                                <div class="form-group">
                                    <input id="porcentagem" name="porcentagem" placeholder="Porcentagem de desconto" class="form-control input-md" required="" type="text">
                                </div>
                                <div class="form-group">
                                    <button id="registrarPD" name="button" value="registrarPD" class="btn btn-success">Registrar</button>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
</body>