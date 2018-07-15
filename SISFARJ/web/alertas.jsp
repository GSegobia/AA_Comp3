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
        text: "Cadastrado com sucesso!",
        icon: "success"
    })
</script>
<% } %>

<!-- Erro: Cadastro Atleta -->
<%
    Boolean erroCadastroAtleta = (Boolean) request.getAttribute("erroCadastro");
    if(erroCadastroAtleta != null && erroCadastroAtleta) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível cadastrar.",
        icon: "error"
    })
</script>
<% } %>

<!-- Sucesso: Filiar Associacao -->
<%
    Boolean sucessoFiliarAssociacao = (Boolean) request.getAttribute("sucessoFiliarAssociacao");
    if(sucessoFiliarAssociacao != null && sucessoFiliarAssociacao) {
%>
<script>
    swal({
        title: "Sucesso",
        text: "Nova Associacao fialiada com sucesso!",
        icon: "success"
    })
</script>
<% } %>

<!-- Erro: Filiar Associcao -->
<%
    Boolean erroFiliarAssociacao = (Boolean) request.getAttribute("erroFiliarAssociacao");
    if(erroFiliarAssociacao != null && erroFiliarAssociacao) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível filiar a Associação.",
        icon: "error"
    })
</script>
<% } %>

<!-- Sucesso: Alterar Filiacao Associacao -->
<%
    Boolean sucessoAlterarFiliacaoAssociacao = (Boolean) request.getAttribute("sucessoAlterarFiliacaoAssociacao");
    if(sucessoAlterarFiliacaoAssociacao != null && sucessoAlterarFiliacaoAssociacao) {
%>
<script>
    swal({
        title: "Sucesso",
        text: "Alteração na filiação realizada com sucesso!",
        icon: "success"
    })
</script>
<% } %>

<!-- Erro: Alterar Filiacao Associcao -->
<%
    Boolean erroAlterarFiliacaoAssociacao = (Boolean) request.getAttribute("erroAlterarFiliacaoAssociacao");
    if(erroAlterarFiliacaoAssociacao != null && erroAlterarFiliacaoAssociacao) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível alterar a fialiação da Associação.",
        icon: "error"
    })
</script>
<% } %>

<!-- Sucesso: Alterar Atleta -->
<%
    Boolean sucessoAlterarAtleta = (Boolean) request.getAttribute("sucessoAlterarAtleta");
    if(sucessoAlterarAtleta != null && sucessoAlterarAtleta) {
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
    Boolean erroAlterarAtleta = (Boolean) request.getAttribute("erroAlterarAtleta");
    if(erroAlterarAtleta != null && erroAlterarAtleta) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível alterar o Atleta!",
        icon: "error"
    })
</script>
<% } %>

<!-- Sucesso: Alterar Local -->
<%
    Boolean sucessoAlterarLocalCompeticao = (Boolean) request.getAttribute("sucessoAlterarLocalCompeticao");
    if(sucessoAlterarLocalCompeticao != null && sucessoAlterarLocalCompeticao) {
%>
<script>
    swal({
        title: "Sucesso",
        text: "Local alterado com sucesso!",
        icon: "success"
    })
</script>
<% } %>

<!-- Erro: Alterar Local -->
<%
    Boolean erroAlterarLocalCompeticao = (Boolean) request.getAttribute("sucessoAlterarLocalCompeticao");
    if(erroAlterarLocalCompeticao != null && erroAlterarLocalCompeticao) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível alterar o Local!",
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

<!-- Sucesso: Alterar Competicao -->

<%
    Boolean sucessoAlterarCompeticao = (Boolean) request.getAttribute("sucessoAlterarCompeticao");
    if(sucessoAlterarCompeticao != null && sucessoAlterarCompeticao) {
%>
<script>
    swal({
        title: "Sucesso",
        text: "Competicao alterada com sucesso!",
        icon: "success"
    })
</script>
<% } %>

<!-- Erro: Alterar Local -->
<%
    Boolean erroAlterarCompeticao = (Boolean) request.getAttribute("erroAlterarCompeticao");
    if(erroAlterarCompeticao != null && erroAlterarCompeticao) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível competicao!",
        icon: "error"
    })
</script>
<% } %>

<!-- Sucesso: Cadastrar Competicao -->

<%
    Boolean sucessoCadastroCompeticao = (Boolean) request.getAttribute("sucessoCadastroCompeticao");
    if(sucessoCadastroCompeticao != null && sucessoCadastroCompeticao) {
%>
<script>
    swal({
        title: "Sucesso",
        text: "Competicao cadastrada com sucesso!",
        icon: "success"
    })
</script>
<% } %>

<!-- Erro: Cadastrar Competicao -->
<%
    Boolean erroCadastroCompeticao = (Boolean) request.getAttribute("erroCadastroCompeticao");
    if(erroCadastroCompeticao != null && erroCadastroCompeticao) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível cadastrar competicao!",
        icon: "error"
    })
</script>
<% } %>

<!-- Sucesso: Cadastrar Local Competicao -->

<%
    Boolean sucessoCadastroLocalCompeticao = (Boolean) request.getAttribute("sucessoCadastroLocalCompeticao");
    if(sucessoCadastroLocalCompeticao != null && sucessoCadastroLocalCompeticao) {
%>
<script>
    swal({
        title: "Sucesso",
        text: "Local competicao alterada com sucesso!",
        icon: "success"
    })
</script>
<% } %>

<!-- Erro: Cadastrar Local Competicao-->
<%
    Boolean erroCadastroLocalCompeticao = (Boolean) request.getAttribute("erroCadastroLocalCompeticao");
    if(erroCadastroLocalCompeticao != null && erroCadastroLocalCompeticao) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível cadastrar Local competicao!",
        icon: "error"
    })
</script>
<% } %>

<!-- Sucesso: Inserir Resultado Atleta -->

<%
    Boolean sucessoInserirResultadoAtleta = (Boolean) request.getAttribute("sucessoInserirResultadoAtleta");
    if(sucessoInserirResultadoAtleta != null && sucessoInserirResultadoAtleta) {
%>
<script>
    swal({
        title: "Sucesso",
        text: "Resultado inserido com sucesso!",
        icon: "success"
    })
</script>
<% } %>

<!-- Erro: Inserir Resultado Atleta -->
<%
    Boolean erroInserirResultadoAtleta = (Boolean) request.getAttribute("erroInserirResultadoAtleta");
    if(erroInserirResultadoAtleta != null && erroInserirResultadoAtleta) {
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível inserir resultado!",
        icon: "error"
    })
</script>
<% } %>