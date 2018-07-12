<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 11/07/18
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default_header.jsp"%>
<section class="portfolio" style="padding-top:calc(6rem + 72px);padding-bottom:6rem" id="portfolio">
    <div class="container bg-white p-5 rounded">
        <div class="alert alert-danger" role="alert">
            <h4 class="alert-heading">Ei, você aí...</h4>
            <p>Infelizmente você está em uma área proibida!</p> <h1>☠</h1>
            <hr>
            <p class="mb-0">De qualquer forma, você pode retornar ao caminho normal do nosso sistema por <a href="<%=request.getContextPath()+"/"%>">aqui</a>. </p>
        </div>
    </div>
</section>
<%@include file="default_footer.jsp"%>
