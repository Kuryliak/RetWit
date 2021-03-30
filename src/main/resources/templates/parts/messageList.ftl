<#include "security.ftl">

<div class="card-columns">
    <#list messages as message>
    <div class="card my-3">
        <#if message.file??>
        <img src="/img/${message.file}" class="card-img-top">
    </#if>
    <div class="m-1">
        <span>${message.message}</span><br/>
    </div>
    <div class="card-footer text-muted">
        <a href="/user-messages/${message.author.id}">${message.authorName}</a>
</div>
</div>
<#else>
No message
</#list>
</div>