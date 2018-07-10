<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Boolean sucesso = (Boolean) session.getAttribute("sucessoIdentificacao");
    if(sucesso != null && sucesso) {
        session.setAttribute("sucessoIdentificacao", false);
%>
<script>
    swal({
        title: "Sucesso",
        text: "Você agora está logado no sistema!",
        icon: "success"
    })
</script>
<% } %>
