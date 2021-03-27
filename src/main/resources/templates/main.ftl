<#import "parts/common.ftl" as c>

<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}"
                   placeholder="Search by message">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
        <br>
        <a class="btn btn-primary " data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
           aria-controls="collapseExample">
            Add new Message
        </a>
        <div class="position-relative">
            <div class="collapse" id="collapseExample">
            <div class="form-group mt-3">

                <form method="post" enctype="multipart/form-data">
                    <div  for="validationDefaultUsername" class="form-group">
                        <input type="message" class="form-control" name="message" id="validationDefaultUsername"
                               aria-describedby="inputGroupPrepend2" required  placeholder="Введите сообщение"/>
                    </div>
                    <div class="form-group">
                        <div class="custom-file">
                            <input type="file" name="file" id="file">
                            <label class="custom-file-label" for="file">Choose file</label>
                        </div>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Добавить</button>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
<#include "parts/messageList.ftl" />


</@c.page>