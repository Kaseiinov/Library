<#import "layout.ftlh" as main>
<@main.layout>

    <#assign known = SPRING_SECURITY_CONTEXT?? >
    <#if known>
        <#assign
        user = SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        >
    </#if>


    <!-- Content -->
    <div class="container-fluid mt-4">
        <div class="row">

            <!-- Sidebar -->
            <aside class="col-12 col-md-3 col-lg-2 mb-4">
                <h5 class="fw-bold">Жанры:</h5>
                <div class="list-group">
                    <a href="/" class="list-group-item list-group-item-action active">Все</a>
                    <#if categories??>
                        <#list categories as category>
                            <a href="?category=${category.category}" class="list-group-item list-group-item-action">${category.category}</a>
                        </#list>
                    </#if>
                </div>
            </aside>

            <!-- Books Section -->
            <main class="col-12 col-md-9 col-lg-10">
                <div class="row g-3">

                    <#if books??>
                        <#list books as book>
                            <div class="col-12 col-sm-6 col-lg-4">
                                <div class="card h-100 shadow-sm">
                                    <img src="https://via.placeholder.com/300x200" class="card-img-top" alt="Book">
                                    <div class="card-body d-flex flex-column">
                                        <h6 class="card-title">${book.author} <br>${book.name}</h6>
                                        <button class="btn btn-primary mt-auto">Получить</button>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </#if>


                </div>
            </main>

        </div>
    </div>


</@main.layout>
