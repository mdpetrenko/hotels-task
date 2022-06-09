<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="Hotel"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div id="search-hotel" class="content scaffold-list" role="main">
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:if test="${hotelCount == 0}">
        <h1>По Вашему запросу ничего не найдено</h1>
    </g:if>
    <g:else>
        <h1>Найдено отелей: ${hotelCount}</h1>
        <table class="content scaffold-list">
            <thead>
            <tr>
                <th>Hotel</th>
                <th>Stars</th>
            </tr>
            </thead>
            <tbody>
            <g:each var = "h" in="${hotelList}">
                <tr>
                    <td>${h.title}<g:if test="${h.site}"><br><a href="${h.site}" target="_blank">Перейти на сайт</a> </g:if></td>
                    <td>${h.stars}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </g:else>
    <div class="pagination">
        <g:paginate total="${hotelCount ?: 0}"/>
    </div>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="hotel.search.repeat.label"/></a></li>
        </ul>
    </div>
</div>
</body>
</html>