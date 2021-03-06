<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">RetWit</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
            </li>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/main">Messages</a>
            </li>
        </#if>
        <#if isAdmin>
        <li class="nav-item">
            <a class="nav-link" href="/user">User list</a>
        </li>
    </#if>
    <#if user??>
    <li class="nav-item">
        <a class="nav-link" href="/user/profile">Profile</a>
    </li>
</#if>
</ul>
<form>
    <div>  <a href="/user-messages/${currentUserId}" class="navbar-text mr-3">${name}</a></div>
</form>
<@l.logout />
</div>
</nav>