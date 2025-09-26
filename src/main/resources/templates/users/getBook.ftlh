<#import "../layout.ftlh" as main>
<@main.layout ; spring>

    <section class="vh-100">
        <div class="mask d-flex align-items-center h-100 ">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                        <div class="card" style="border-radius: 15px;">
                            <div class="card-body p-5">
                                <h2 class="text-uppercase text-center mb-5">Get a ticket</h2>

                                <form action="/users/get_ticket" method="post" class="mt-4">

                                    <#if _csrf??>
                                        <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                                               value="${(_csrf.token)!'csrf-token'}"/>
                                    </#if>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1cg">Ticket number</label>
                                        <@spring.formInput "getBookDto.ticket" 'id="form3Example1cg" class="form-control form-control-lg"' />
                                        <@spring.showErrors "<br>" "error text-danger" />
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example2cg">${book.id}</label>
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example2cg">${book.author}</label>
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example3cg">${book.name}</label>
                                    </div>


                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example4cg">Date of return</label>
                                        <input type="date" name="returnDate" id="form3Example4cg">
                                        <span class="text-danger">error</span>
                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Send request</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</@main.layout>