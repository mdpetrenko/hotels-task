<table>
    <thead>
    <tr>
        <g:each var="p" in="${domainProperties}">
            <g:sortableColumn property="${p.property}" titleKey="${p.name}.label"/>
        </g:each>
        <th>${message(code: 'actions.label')}<th>
    </tr>
    </thead>
    <tbody>
    <g:each var="bean" status="i" in="${collection}">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <g:each var="p" status="j" in="${domainProperties}">
                <g:if test="${j == 0}">
                    <td><g:link method="GET" resource="${bean}"><f:display bean="${bean}" property="${p.property}"
                                                                           displayStyle="${displayStyle ?: 'table'}"
                                                                           theme="${theme}"/></g:link></td>
                </g:if>
                <g:else>
                    <td><f:display bean="${bean}" property="${p.property}" displayStyle="${displayStyle ?: 'table'}"
                                   theme="${theme}"/>
                    </td>
                </g:else>
            </g:each>
            <td class="w-auto">
                <g:form resource="${bean}" method="DELETE">
                        <g:link class="btn btn-outline-dark text-decoration-none" action="edit" resource="${bean}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                        <input class="btn btn-outline-dark" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </g:form>
        </tr>
    </g:each>
    </tbody>
</table>