<%--
  Created by IntelliJ IDEA.
  User: devfbrp
  Date: 10/07/18
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="portfolio-modal mfp-hide" id="portfolio-modal-1">
    <div class="portfolio-modal-dialog bg-white">
        <a class="close-button d-md-block portfolio-modal-dismiss" href="#">
            <i class="fa fa-3x fa-times"></i>
        </a>
        <div class="container text-center">
            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <h2 class="text-secondary text-uppercase mb-0">Lista de Associações</h2>
                    <hr>
                    <%--<% if(ass) { %>--%>
                    <%--<h5>Nenhuma associação foi encontrada.</h5>--%>
                    <%--<% } else  {%>--%>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Matrícula</th>
                            <th scope="col">Nome</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${associacoes}" var="associacao">
                        <tr>
                            <th scope="row">${associacao.id}</th>
                            <td>${associacao.matricula}</td>
                            <td>${associacao.nome}</td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <%--<% } %>--%>
                </div>
            </div>
        </div>
    </div>
</div>
