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
                                        <label class="form-label" for="form3Example1cg">Your first name</label>
                                        <@spring.formInput "ticketDto.firstName" 'id="form3Example1cg" class="form-control form-control-lg"' />
                                        <@spring.showErrors "<br>" "error text-danger" />
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example2cg">Your last name</label>
                                        <@spring.formInput "ticketDto.lastName" 'id="form3Example2cg" class="form-control form-control-lg"' />
                                        <@spring.showErrors "<br>" "error text-danger" />
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example2cg">Your address</label>
                                        <@spring.formInput "ticketDto.address" 'id="form3Example2cg" class="form-control form-control-lg"' />
                                        <@spring.showErrors "<br>" "error text-danger" />
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example3cg">Your passport number</label>
                                        <@spring.formInput "ticketDto.passport" 'id="form3Example3cg" class="form-control form-control-lg"' />
                                        <@spring.showErrors "<br>" "error text-danger" />
                                    </div>


                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example4cg">Password</label>
                                        <@spring.formInput "ticketDto.password" 'id="form3Example4cg" class="form-control form-control-lg"' />
                                        <@spring.showErrors "<br>" "error text-danger" />
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example4cg">Confirm password</label>
                                        <@spring.formInput "ticketDto.confirmPassword" 'id="form3Example4cg" class="form-control form-control-lg"' />
                                        <@spring.showErrors "<br>" "error text-danger" />
                                    </div>


                                    <div class="d-flex justify-content-center">
                                        <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Get ticket</button>
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