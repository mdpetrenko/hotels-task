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
            <g:textField class="form-text" name="titlePart"/>
            <g:submitButton class="btn btn-default btn-outline-dark" name="Find Hotel"/>
        </g:form>
    </section>
</div>

</body>
</html>
