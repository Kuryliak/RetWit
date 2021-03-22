<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div>
    <@l.logout />
</div>
    <div>
        <form action="/user" name="users">
             <button>User List</button>
        </form>
    </div>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="message" placeholder="Введите сообщение" />
        <input type="text" name="tag" placeholder="Тэг">
        <input type="file" name="file">
        <input type="hidden" value="${_csrf.token}" name="_csrf">

        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список сообщений</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter!}">
    <button type="submit">Найти</button>
</form>
<#list messages as message>
<div>
    <b>${message.id!}</b>
    <span>${message.message!}</span>
    <i>${message.tag!}</i>
    <div>
        <#if message.file??>
        <img src="/img/${message.file}">
        </#if>
    </div>
</div>
<#else>
No message
</#list>
</@c.page>
