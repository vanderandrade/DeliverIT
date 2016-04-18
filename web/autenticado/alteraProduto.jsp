<%@page import="Model.Produto"%>
<%@page import="Model.Categoria"%>
<%@page import="Controller.MySqlController"%>
<body>
    <% MySqlController conexao = (MySqlController) session.getAttribute("conexao");
        Categoria listaCategorias[] = conexao.carregaCategorias();        
    %>
    <div id="wrapper">
        <jsp:include page="../WEB-INF/incluir/menu.jsp" />
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">

                    <form class="form-horizontal" method="post" action="ProdutoController">
                        <fieldset>

                            <!-- Form Name -->
                            <legend>Alterar Produto</legend>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="nomeProduto">Nome do Produto</label>  
                                <div class="col-md-4">                                                                   
                                    <input id="nomeProduto" name="nomeProduto" placeholder="Digite o nome do produto" class="form-control input-md" required="" type="text" value="<%=request.getAttribute("nomeProduto")%>">
                                    
                                </div>
                            </div>

                            <!-- Select Basic -->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="categoriaProduto">Categoria</label>
                                <div class="col-md-4">
                                    <select id="categoriaProduto" name="categoriaProduto" class="form-control" required="" >
                                        <%
                                            for (Categoria cat : listaCategorias) {
                                        %>
                                        <option value="<%=cat.getCodigo()%>"><%=cat.getNome()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>

                            <!-- Prepended text-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="precoProduto">Preço</label>
                                <div class="col-md-4">
                                    <div class="input-group">
                                        <span class="input-group-addon">R$</span>
                                        <input id="precoProduto" name="precoProduto" class="form-control" placeholder="" required="" type="number" min="0" step="1" data-bind="value:replyNumber" value="<%=request.getAttribute("precoProduto")%>">
                                    </div>

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="quantidadeProduto">Quantidade</label>  
                                <div class="col-md-4">
                                    <input id="quantidadeProduto" name="quantidadeProduto" placeholder="Digite a quantidade em estoque" class="form-control input-md" required="" type="text" value="<%=request.getAttribute("quantidadeProduto")%>">

                                </div>    

                            </div>

                            <div class="col-md-4 ">      
                                <input type="hidden" name="codProduto" value="<%=request.getAttribute("codProduto")%>">
                                <button id="alterar" name="button" value="alterar" class="btn btn-primary">Alterar</button>
                                <a href="produto.jsp" class="btn btn-success">Voltar</a>
                            </div>
                        </fieldset>
                    </form>
                   



                </div>
            </div>

        </div>
    </div>    
</body>

