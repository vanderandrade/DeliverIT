<%@page import="DAO.CategoriaDAO"%>
<%@page import="Model.Categoria"%>
<body>
    <%   
        CategoriaDAO categoriadao = new CategoriaDAO((MySqlController) session.getAttribute("conexao"));
        Categoria listaCategorias[] = categoriadao.carregaCategorias();
    %>
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
                            <label class="col-md-4 control-label" for="textinput">Cadastro:</label>  
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
                            <label class="col-md-4 control-label" for="alterarCombo">Categorias:</label>
                            <div class="col-md-5">
                                <select id="alterarCombo" name="alterarCombo" class="form-control">
                                    <%
                                        
                                    for (Categoria cat : listaCategorias) {
                                    %>
                                    <option value="<%=cat.getCodigo()%>"><%=cat.getNome()%></option>
                                    <%}%>
                                </select>
                                <input id="novoNome" name="novoNome" placeholder="Insira o novo nome" class="form-control input-md" type="text">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="alterar"></label>
                            <div class="col-md-4">
                                <button id="alterar" name="button" value="alterar" class="btn btn-primary">Alterar</button>
                                <button id="remover" name="button" value="remover" class="btn btn-danger">Remover</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
                  
                    </fieldset>
                </form>
            </div>
             <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
             
             
        </div>
    </div>
    <script>
        $('.collapse').collapse()
    </script>
</body>