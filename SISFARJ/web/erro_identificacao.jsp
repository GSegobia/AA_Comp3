<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean erroIdentificacao = (Boolean) session.getAttribute("erroIdentificacao");
    if(erroIdentificacao != null && erroIdentificacao) {
        session.setAttribute("erroIdentificacao", true);
%>
<script>
    swal({
        title: "Erro",
        text: "Não foi possível identificar o usuário.",
        icon: "error"
    })
</script>
<% } %>
