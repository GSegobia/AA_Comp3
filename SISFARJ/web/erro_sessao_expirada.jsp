<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 11/07/18
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Erro: Sessão Expirada -->
<% if(session.getAttribute("usuario") == null) { %>
<script>
    swal({
        title: "Erro",
        text: "Sua expirou, por favor acesse o sistema novamente.",
        icon: "error"
    })
</script>
<% } %>
