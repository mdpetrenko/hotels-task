<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'country.label', default: 'Country')}"/>
    <title><g:message code="countries.list.label"/></title>
</head>

<body>
<a href="#list-country" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.button.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-country" class="content scaffold-list" role="main">
    <h1><g:message code="countries.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:table collection="${countryList}"/>

    <div class="pagination">
        <g:paginate total="${countryCount ?: 0}"/>
    </div>
</div>
<p><b>${message(code: 'total.entities.label')}</b>${countryCount}</p>
</body>
</html>