<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <link rel="stylesheet" href="/static/style.css">


    <div  for="validationDefaultUsername" class="form-group row">
        <label class="position-absolute top-0 end-0"></label>
        <div class="col-sm-4">
            <input type="text" name="username" class="form-control" id="validationDefaultUsername"
                   aria-describedby="inputGroupPrepend2" required placeholder="User name" />
        </div>
    </div>
    <div for="validationDefaultUsername" class="form-group row">
        <label for class="position-absolute top-0 end-0"></label>
        <div class="col-sm-4">
            <input type="password" name="password" class="form-control" id="validationDefaultUsername1"
                   aria-describedby="inputGroupPrepend2" required placeholder="Password" />
        </div>
        <div>
            <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
                    async defer>
            </script>
        </div>
    </div>


    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>
    <#if !isRegisterForm><a href="/registration">Add new user</a></#if>

</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Sign Out</button>
</form>
</#macro>