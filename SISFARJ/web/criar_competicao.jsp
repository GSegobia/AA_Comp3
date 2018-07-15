<%@ page import="dominio.CentroAquatico" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dominio.Prova" %><%--
  Created by IntelliJ IDEA.
  User: gsegobia
  Date: 12/07/18
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <h2 class="text-center text-uppercase text-secondary mb-0">Criar Competição</h2>
        <hr class="mb-5">
        <div class="container">
            <form class="form" action="criarCompeticao" method="post">
                <h4>Dados da Competição</h4>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nomeCompeticao">Nome</label>
                        <input type="text" class="form-control" id="nomeCompeticao" name="nomeCompeticao" placeholder="Digite o Nome da Competição">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="dataCompeticao">Data da Competição</label>
                        <input type="date" class="form-control" id="dataCompeticao" name="dataCompeticao">
                    </div>
                </div>
                <div id="show" style="display: none">
                    <div class="form-group">
                        <label for="local">Centro Aquático</label>
                        <br>
                        <select class="from-control" id="local"  name="local">
                            <%
                                for (CentroAquatico local : (ArrayList<CentroAquatico>)request.getAttribute("locaisProva")) {
                            %>
                            <option name="local" value="<%=local.getId()%>"><%=local.getNome()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="tipoPiscina">Tipo Piscina</label>
                        <br>
                        <select class="from-control" id="tipoPiscina" name="tipoPiscina">
                            <%
                                for (CentroAquatico local : (ArrayList<CentroAquatico>)request.getAttribute("locaisProva")) {
                            %>
                            <option name="tipoPiscina" value="<%=local.getTamanho_piscina()%>"><%=local.getTamanho_piscina()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <h5>Selecionar Provas</h5>
                    <div class="form-group">
                        <div class="form-group col-md-6">
                            <%
                                for (Prova p : (ArrayList<Prova>)request.getAttribute("provas")) {
                            %>
                            <div>
                                <input type="checkbox" class="form-control" id="prova[]" name="prova[]" value="<%=p.getId()%>" style="vertical-align: middle;padding-top: 20px!important;">
                                <label for="prova[]" style="vertical-align: middle;"><%=p.getNome()%></label>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Cadastrar</button>
                </div>
            </form>
        </div>
    </div>
</section>
<<script>
$('#nomeCompeticao').on('input', function() {
    $('#dataCompeticao').on('input', function() {
        $('#show').show();
    });
});
</script>
<%@include file="default_footer.jsp"%>
