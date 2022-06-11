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
        <h1><g:message code="list.empty.label"/></h1>
    </g:if>
    <g:else>
        <h1>${message(code: 'search.results.label', args: hotelCount)}</h1>
        <table class="content scaffold-list table-hover">
            <thead>
            <tr>
                <th>${message(code: 'title.label')}</th>
                <th>${message(code: 'stars.label')}</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="h" status="i" in="${hotelList}">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${h.title}<g:if test="${h.site}"><br><a href="${h.site}"
                                                                target="_blank">Перейти на сайт</a></g:if></td>
                    <td>${h.stars}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <div class="pagination">
            <g:paginate total="${hotelCount ?: 0}"/>
        </div>
    </g:else>

    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}">Новый поиск</a></li>
        </ul>
    </div>
</div>
</body>
</html>