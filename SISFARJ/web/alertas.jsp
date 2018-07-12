<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 11/07/18
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Erro: Identificação do Usuário -->
<%
    Boolean erroIdentificacao = (Boolean) request.getAttribute("erroIdentificacao");
    if(erroIdentificacao != null && erroIdentificacao) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível identificar o usuário.",
        icon: "error"
    })
</script>
<% } %>

<!-- Sucesso: Identificação do Usuário -->
<%
    Boolean sucessoIdentificacao = (Boolean) request.getAttribute("sucessoIdentificacao");
    if(sucessoIdentificacao != null && sucessoIdentificacao) {
%>
<script>
    swal({
        title: "Sucesso",
        text: "Você agora está logado no sistema!",
        icon: "success"
    })
</script>
<% } %>

<!-- Sucesso: Cadastrar Atleta -->
<%
    Boolean sucessoCadastro = (Boolean) request.getAttribute("sucessoCadastro");
    if(sucessoCadastro != null && sucessoCadastro) {
%>
<script>
    swal({
        title: "Sucesso",
        text: "Novo Atleta cadastrado com sucesso!",
        icon: "success"
    })
</script>
<% } %>

<!-- Erro: Cadastro -->
<%
    Boolean erroCadastro = (Boolean) request.getAttribute("erroCadastro");
    if(erroCadastro != null && erroCadastro) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível cadastrar o Atleta.",
        icon: "error"
    })
</script>
<% } %>

<!-- Sucesso: Alterar Atleta -->
<%
    Boolean sucessoAlterar = (Boolean) request.getAttribute("sucessoAlterar");
    if(sucessoAlterar != null && sucessoAlterar) {
%>
<script>
    swal({
        title: "Sucesso",
        text: "Atleta alterado com sucesso!",
        icon: "success"
    })
</script>
<% } %>

<!-- Erro: Alterar Atleta -->
<%
    Boolean erroAlterar = (Boolean) request.getAttribute("erroAlterar");
    if(erroAlterar != null && erroAlterar) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível alterar atleta!",
        icon: "error"
    })
</script>
<% } %>

<!-- Erro: Matrícula da Associação -->
<%
    Boolean erroMatriculaAssociacao = (Boolean) request.getAttribute("erroMatriculaAssociacao");
    if(erroMatriculaAssociacao != null && erroMatriculaAssociacao) {
%>
<script>
    swal({
        title: "Erro",
        text: "Matrícula de associação não encontrada.",
        icon: "error"
    })
</script>
<% } %>

<!-- Erro: Preenchimento -->
<%
    Boolean erroPreenchimento = (Boolean) request.getAttribute("erroPreenchimento");
    if(erroPreenchimento != null && erroPreenchimento) {
%>
<script>
    swal({
        title: "Erro",
        text: "Existem campos que não foram preenchidos corretamente.",
        icon: "error"
    })
</script>
<% } %>