<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}"/>
    <title><g:message code="hotels.list.label"/></title>
</head>

<body>
<a href="#list-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.button.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-hotel" class="content scaffold-list" role="main">
    <h1><g:message code="hotels.list.label"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:if test="${hotelCount == 0}">
        <h2><g:message code="list.empty.label"/> </h2>
    </g:if>
    <g:else>
        <f:table collection="${hotelList}"/>
    </g:else>
    <div class="pagination">
        <g:paginate total="${hotelCount ?: 0}"/>
    </div>

    <p><b>${message(code: 'total.entities.label')}</b>${hotelCount}</p>
</div>
</body>
</html>