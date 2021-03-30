<#import "parts/common.ftl" as c>

<@c.page>
<h5>Hi,${username}</h5>
${message?ifExists}
<form  method="post">
    <div class="form-group row">
    </div>
    <div for="validationDefaultUsername" class="form-group row">
        <label for class="position-absolute top-0 end-0"></label>
        <div class="col-sm-3">
            <input type="password" name="password" class="form-control" id="validationDefaultUsername1"
                   aria-describedby="inputGroupPrepend2" required placeholder="new password" />
        </div>
    </div>
    <div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Save</button>
    </div>
</form>
</@c.page>