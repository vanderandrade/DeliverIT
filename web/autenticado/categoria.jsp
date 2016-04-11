<%@page import="Model.Categoria"%>
<%@page import="Controller.MySqlController"%>
<body>
    <% MySqlController conexao = new MySqlController(); %>
    <div id="wrapper">
        <jsp:include page="../WEB-INF/incluir/menu.jsp" />
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Categoria <small>-</small>
                        </h1>
                    </div>
                </div>

                <form class="form-horizontal" method="post" action="CategoriaController">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="textinput">Cadastrar categoria:</label>  
                            <div class="col-md-5">
                                <input id="cadastrar" name="cadastrar" placeholder="Insira o nome da categoria" class="form-control input-md" required="" type="text">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="cadastrar"></label>
                            <div class="col-md-4">
                                <button id="cadastrar" name="button" value="cadastrar" class="btn btn-primary">Cadastrar</button>
                            </div>
                        </div>
                    </fieldset>
                </form>

                <form class="form-horizontal" method="post" action="CategoriaController">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="alterarCombo">Alterar categoria:</label>
                            <div class="col-md-5">
                                <select id="alterarCombo" name="alterarCombo" class="form-control">
                                    <%
                                        
                                    for (Categoria cat : conexao.carregaCategorias()) {
                                    %>
                                    <option value="<%=cat.getCodigo()%>"><%=cat.getNome()%></option>
                                    <%}%>
                                </select>
                                <input id="novoNome" name="novoNome" placeholder="Insira o novo nome" class="form-control input-md" required="" type="text">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="alterar"></label>
                            <div class="col-md-4">
                                <button id="alterar" name="button" value="alterar" class="btn btn-primary">Alterar</button>
                            </div>
                        </div>
                    </fieldset>
                </form>

                <form class="form-horizontal" method="post" action="CategoriaController">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="removerCombo">Remover categoria:</label>
                            <div class="col-md-5">
                                <select id="removerCombo" name="removerCombo" class="form-control">
                                    <%                                         
                                    for (Categoria cat : conexao.carregaCategorias()) {
                                    %>
                                    <option value="<%=cat.getCodigo()%>"><%=cat.getNome()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="remover"></label>
                            <div class="col-md-4">
                                <button id="remover" name="button" value="remover" class="btn btn-primary">Remover</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>

        </div>
    </div>
<% conexao.Fechar(); %>
</body>