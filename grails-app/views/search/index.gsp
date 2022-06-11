<%@ page import="ru.mdpetrenko.testtasks.hotels.Hotel; ru.mdpetrenko.testtasks.hotels.Country" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its justify-content-center h-auto">
        <h1><g:message code="search.hotel.text" args="${Hotel}"/></h1>
        <g:form name="searchForm" url="[controller: 'search', action: 'search']">
            <g:set var="countries" value="${Country.list()}"/>
            <fieldset>
                <g:field type="text" name="titlePart"/>
                <g:select name="countryTitle"
                          from="${countries}"
                          noSelection="['' :'Any Country']"/>
            </fieldset>
            <fieldset class="buttons">
                <g:submitButton name="search" class="ui-icon-search"
                                value="${message(code: 'search.label', default: 'Search')}"/>
            </fieldset>
        </g:form>
    </section>
</div>

</body>
</html>
