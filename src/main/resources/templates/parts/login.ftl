<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="position-absolute top-0 end-0"></label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="User name" />
        </div>
    </div>
    <div class="form-group row">
        <label class="position-absolute top-0 end-0"></label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password" />
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !isRegisterForm><a href="/registration">Add new user</a></#if>
<button class="btn btn-primary" type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Sign Out</button>
</form>
</#macro>