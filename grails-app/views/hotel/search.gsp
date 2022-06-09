<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
%{--<a href="#list-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label"--}%
%{--                                                            default="Skip to content&hellip;"/></a>--}%

<div id="list-hotel" class="content scaffold-list" role="main">
    <h1><g:message code="hotel.search.results" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:if test="${hotelCount == 0}">
        <h2>No hotels found</h2>
    </g:if>
    <g:else>
        <f:table collection="hotelList" properties="title, stars"/>
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