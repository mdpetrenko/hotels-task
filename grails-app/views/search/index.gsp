<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>
<body>
<content tag="nav">
</content>


<div id="content" role="main">
    <section class="row colset-2-its justify-content-center h-auto">
        <h1>Enter part or full title of Hotel</h1>
        <g:form name="hotelForm" url="[controller:'hotel',action:'search']">
            <g:textField name="titlePart"/>
            <g:submitButton name="Find Hotel"/>
        </g:form>
    </section>
</div>

</body>
</html>
