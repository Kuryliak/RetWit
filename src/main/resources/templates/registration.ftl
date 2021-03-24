<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<h1>Add User</h1>

<h5>${message?ifExists}</h5>
<@l.login "/registration" true />
</@c.page>