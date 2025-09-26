<#import "layout.ftlh" as main>
<@main.layout>

    <#assign known = SPRING_SECURITY_CONTEXT?? >
    <#if known>
        <#assign
        user = SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        >
    </#if>


    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Литература</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
        <div class="container-fluid">
            <a class="navbar-brand fw-bold" href="#">Литература</a>
            <div class="d-flex">
                <a href="#" class="nav-link">Мои книги</a>
                <button class="btn btn-outline-primary ms-2">Авторизация</button>
                <button class="btn btn-primary ms-2">Регистрация</button>
            </div>
        </div>
    </nav>

    <!-- Content -->
    <div class="container-fluid mt-4">
        <div class="row">

            <!-- Sidebar -->
            <aside class="col-12 col-md-3 col-lg-2 mb-4">
                <h5 class="fw-bold">Жанры:</h5>
                <div class="list-group">
                    <a href="#" class="list-group-item list-group-item-action active">Все</a>
                    <a href="#" class="list-group-item list-group-item-action">Остросюжетные</a>
                    <a href="#" class="list-group-item list-group-item-action">Религия</a>
                    <a href="#" class="list-group-item list-group-item-action">Детские</a>
                    <a href="#" class="list-group-item list-group-item-action">Проза</a>
                </div>
            </aside>

            <!-- Books Section -->
            <main class="col-12 col-md-9 col-lg-10">
                <div class="row g-3">

                    <!-- Book Card -->
                    <div class="col-12 col-sm-6 col-lg-4">
                        <div class="card h-100 shadow-sm">
                            <img src="https://via.placeholder.com/300x200" class="card-img-top" alt="Book">
                            <div class="card-body d-flex flex-column">
                                <h6 class="card-title">М. А. Булгаков <br> "Мастер и Маргарита"</h6>
                                <button class="btn btn-primary mt-auto">Получить</button>
                            </div>
                        </div>
                    </div>

                    <!-- Book Card with "Ожидается" -->
                    <div class="col-12 col-sm-6 col-lg-4">
                        <div class="card h-100 shadow-sm">
                            <img src="https://via.placeholder.com/300x200" class="card-img-top" alt="Book">
                            <div class="card-body d-flex flex-column">
                                <h6 class="card-title">М. А. Булгаков <br> "Мастер и Маргарита"</h6>
                                <p class="text-muted small">Ожидается к <br><strong>05/11/2020</strong></p>
                                <button class="btn btn-secondary mt-auto" disabled>Ожидается</button>
                            </div>
                        </div>
                    </div>

                    <!-- Repeat more cards -->
                    <div class="col-12 col-sm-6 col-lg-4">
                        <div class="card h-100 shadow-sm">
                            <img src="https://via.placeholder.com/300x200" class="card-img-top" alt="Book">
                            <div class="card-body d-flex flex-column">
                                <h6 class="card-title">М. А. Булгаков <br> "Мастер и Маргарита"</h6>
                                <button class="btn btn-primary mt-auto">Получить</button>
                            </div>
                        </div>
                    </div>

                </div>
            </main>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
    </html>


</@main.layout>
