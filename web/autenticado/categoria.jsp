<body>
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

                <form method="post" action="CategoriaController">               
                    <label for="inputCategoria">Cadastrar categoria</label>
                    <input name="nomeCategoria" type="text" required>
                    <button type="submit" name="cadastrar"> Cadastrar </button>
                </form>
                
              <!--  <form method="post" action="CategoriaController">               
                    <label for="inputUsuario">Atualizar categoria</label>
                    <input name="nomeCategoria" type="text" required>

                    <!-- INSERÇÃO DE UM COMBO BOX <input name="novoNome" type="combobox" required>
                    <button type="submit" name="atualizar"> Atualizar </button>
                </form>
                
                <form method="post" action="CategoriaController">               
                    <label for="inputUsuario">Remover categoria</label>
                    <input name="nomeCategoria" type="text" required>
                    <button type="submit" name="remover"> Remover </button>
                </form>-->
            </div>

        </div>
    </div>
</body>
