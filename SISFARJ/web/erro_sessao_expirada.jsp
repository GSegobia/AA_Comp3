<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean erroSessaoExpirada = (Boolean) session.getAttribute("erroSessaoExpirada");
    if(erroSessaoExpirada != null && erroSessaoExpirada) {
        session.setAttribute("erroIdentificacao", true);
%>
<script>
    swal({
        title: "Erro",
        text: "Sua expirou, por favor acesse o sistema novamente.",
        icon: "error"
    })
</script>
<% } %>
