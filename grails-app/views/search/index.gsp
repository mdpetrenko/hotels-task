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
        <h1>Введите часть или полное название отеля</h1>
        <g:form name="hotelForm" url="[controller:'hotel',action:'search']">
            <div class="row">
                <div class="col-8"><g:textField class="form-control" name="titlePart"/></div>
                <div class="col-4"><g:submitButton class="btn btn-default btn-outline-dark" name="Поиск"/></div>
            </div>
        </g:form>
    </section>
</div>

</body>
</html>
