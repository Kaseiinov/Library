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
    <div class="container-fluid mt-4 d-flex flex-column min-vh-100">
        <div class="row flex-grow-1">

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
            <main class="col-12 col-md-9 col-lg-10 ">
                <div class="row g-3">
                    <#if books??>
                        <#list books as book>
                            <div class="col-12 col-sm-6 col-lg-4">
                                <div class="card h-100 shadow-sm">
                                    <img src="/images/byName/${book.avatar}" width="80" height="200" class="card-img-top" alt="Book">
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

        <!-- Navigation - всегда внизу -->
        <#if items.getTotalElements() gt 0>
            <div class="mt-auto"> <!-- mt-auto для прижатия к низу -->
                <nav id="navigation" aria-label="..." class="d-flex justify-content-center py-3">
                    <ul class="pagination mb-0">
                        <li class="page-item <#if items.first>disabled</#if>">
                            <a class="page-link" href="?page=${items.getNumber()-1}&size=${items.size}">
                                previous
                            </a>
                        </li>

                        <#list 1..items.getTotalPages() as page>
                            <li class="page-item <#if page = items.getNumber() + 1>active</#if>" aria-current="page">
                                <a class="page-link" href="?page=${page - 1}&size=${items.size}">${page}</a>
                            </li>
                        </#list>

                        <li class="page-item <#if items.last>disabled</#if>">
                            <a class="page-link" href="?page=${items.getNumber()+1}&size=${items.size}">
                                next
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </#if>
    </div>

</@main.layout>