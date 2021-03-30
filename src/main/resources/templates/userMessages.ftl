<#import "parts/common.ftl" as c>

<@c.page>
<h1>${userChannel.username}</h1>
<#if !isCurrentUser>
<#if isSubscriber>
    <a class="btn btn-info" href="/user/unsubscribe/${userChannel.id}">Unsubscribe</a>
<#else>
    <a class="btn btn-info" href="/user/subscribe/${userChannel.id}">Subscribe</a>
</#if>
</#if>
<div class="container my-2">
    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <div class="card-title">Subscriptions</div>
                    <h3 class="card-text">
                        <a href="/user/subscriptions/${userChannel.id}/list">${user_subscriptions}</a>
                    </h3>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <div class="card-title">Subscribers</div>
                    <h3 class="card-text">
                        <a href="/user/subscribers/${userChannel.id}/list">${user_subscribers}</a>
                    </h3>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "parts/messageList.ftl" />
</@c.page>