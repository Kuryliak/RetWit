<#import "parts/common.ftl" as c>

<@c.page>
<h5>Hi,${username}</h5>
${message?ifExists}
<form  method="post">
    <div class="form-group row">
        <label class="position-absolute top-0 end-0"></label>
        <div class="col-sm-3">
            <input type="text" name="username" class="form-control" placeholder="User name" />
        </div>
    </div>
    <div class="form-group row">
        <label class="position-absolute top-0 end-0"></label>
        <div class="col-sm-3">
            <input type="password" name="password" class="form-control" placeholder="Password" />
        </div>
    </div>
    <div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Save</button>
    </div>
</form>
</@c.page>