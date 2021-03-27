<#import "parts/common.ftl" as c>

<@c.page>
<h2>${userChannel.username}</h2>
<#if isCurrentUser>
</#if>

<#include "parts/messageList.ftl" />
</@c.page>