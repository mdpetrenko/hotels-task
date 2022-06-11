<%@ page import="ru.mdpetrenko.testtasks.hotels.Hotel; ru.mdpetrenko.testtasks.hotels.Country" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="hotels.search.label"/></title>
</head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its justify-content-center h-auto">
        <h1><g:message code="hotels.search.label" args="${Hotel}"/></h1>
        <g:form name="searchForm" url="[controller: 'home', action: 'search']">
            <g:set var="countries" value="${Country.list()}"/>
            <fieldset>
                <g:field type="text" name="titlePart" placeholder="${message(code: 'hotel.form.label')}"/>
                <g:select name="countryTitle"
                          from="${countries}"
                          noSelection="['' : message(code: 'country.select.label', default: 'Select Country')]"/>
            </fieldset>
            <fieldset>
                <g:submitButton name="search" class="save"
                                value="${message(code: 'search.label', default: 'Search')}"/>
            </fieldset>
        </g:form>
    </section>
</div>

</body>
</html>
