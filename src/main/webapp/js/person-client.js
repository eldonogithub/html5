$(function() {
    var dt;
    var persons;
    // Crazy stupid way of doing HTML encoding for javascript. But it works
    function encode(txt) {
        var t2h = $("<div/>");
        return t2h.text(txt).html();
    }

    // populate table
    function loadTable() {
        console.log("Loading the table");
        $("form#personForm button[value=updatePerson]").hide();
        $("form#personForm button[value=createPerson]").show();
        dt = $("table#personTable").DataTable({
            "ajax" : function(data, cb, settings) {
                console.log("AjaxHibernate.getPersons() invoked");
                AjaxHibernate.getPersons({
                    "callback" : function(ajaxPersons) {
                        console.log("Received a result back " + ajaxPersons.status);
                        if (ajaxPersons.status === 'SUCCESS') {
                            console.log("Calling DataTable() callback...");
                            $("#personSize").text(ajaxPersons.data.length);
                            cb({
                                "data" : ajaxPersons.data
                            });

                            $("table#personTable tr button.edit").each(function(idx, row) {
                                var data = ajaxPersons.data[idx];
                                $(row).click(function() {
                                    console.log("edit clicked: " + data.id);
                                    $("#personForm input[name=id]").val(data.id);
                                    $("#personForm input[name=firstname]").val(data.firstname);
                                    $("#personForm input[name=lastname]").val(data.lastname);
                                    $("#personForm input[name=age]").val(data.age);
                                    $("form#personForm button[value=updatePerson]").show();
                                    $("form#personForm button[value=createPerson]").hide();
                                });
                            });

                            $("table#personTable tr button.copy").each(function(idx, row) {
                                var data = ajaxPersons.data[idx];
                                $(row).click(function() {
                                    console.log("copy clicked: " + data.id);
                                    $("#personForm input[name=id]").val("");
                                    $("#personForm input[name=firstname]").val(data.firstname);
                                    $("#personForm input[name=lastname]").val(data.lastname);
                                    $("#personForm input[name=age]").val(data.age);
                                    $("form#personForm button[value=updatePerson]").hide();
                                    $("form#personForm button[value=createPerson]").show();
                                });
                            });

                            $("table#personTable tr button.delete").each(function(idx, row) {
                                var data = ajaxPersons.data[idx];
                                $(row).click(function() {
                                    console.log("delete clicked: " + data.id);
                                    var msg = "<span id='msg'>Delete Person ID " + data.id + " " + data.firstname + " " + data.lastname
                                    "</span>";

                                    $("#delete-confirm p span#msg").remove();
                                    $("#delete-confirm p").append(msg);
                                    $("#delete-confirm").dialog({
                                        modal : true,
                                        buttons : {
                                            "Delete" : function() {
                                                $(this).dialog("close");
                                                AjaxHibernate.deletePerson(data.id, {
                                                    callback : function(ajaxPersons) {
                                                        console.log("Received a result back " + ajaxPersons.status);
                                                        console.log("Submit Person result ", ajaxPersons);
                                                        if (ajaxPersons.status === 'SUCCESS') {
                                                            console.log("Reloading DataTable()...");
                                                            dt.ajax.reload();
                                                        } else {
                                                            $("ul#errors").append("<li>" + ajaxPersons.message + "</li>");
                                                        }
                                                    }
                                                });
                                            },
                                            "Cancel" : function() {
                                                $(this).dialog("close");
                                            }
                                        }
                                    });
                                });
                            });
                        }
                    }
                });
            },
            "columns" : [ {
                "data" : "id",
                "title" : "ID"
            }, {
                "data" : "firstname",
                "title" : "First Name"
            }, {
                "data" : "lastname",
                "title" : "Last Name"
            }, {
                "data" : "age",
                "title" : "Age"
            }, {
                "data" : null,
                "title" : "Operation",
                "render" : function(data, type, row, meta) {
                    var msg = "<button class='edit'>Edit</button>" + "<button class='delete'>Delete</button>" + "<button class='copy'>Copy</button>";
                    var x = $(msg);
                    x.find("button").button();
                    return msg;
                },
            } ],
            "pageLength" : 25,
            "processing" : true,
        });
        $('table#personTable').on( 'draw.dt', function () {
            $("table#personTable button").button();
            console.log("draw");
        } );
    }

    // Load the table with the initial data
    loadTable();
    $("button").button();
    // Set the on submit handler
    var button;

    $("form#personForm button[type=submit]").click(function() {
        button = $(this).attr("value");
    });
    $("form#personForm button[type=reset]").click(function() {
        $("ul#errors *").remove();
        $("#personForm input[name=id]").val("");
        $("#personForm input[name=firstname]").val("");
        $("#personForm input[name=lastname]").val("");
        $("#personForm input[name=age]").val("");
        $("form#personForm button[value=updatePerson]").hide();
        $("form#personForm button[value=createPerson]").show();
    });

    $("form#personForm").submit(function(e) {
        $("ul#errors *").remove();
        e.preventDefault();

        if (button == "createPerson") {
            $(this).find("input[name=id]").val("");
        }
        console.log("called " + button);

        // serialize the form data
        var data = $(this).serializeArray();
        console.log("Data serialized");
        console.log(data)

        // this won't work always, multiple identical form fields won't be
        // injected
        // correctly
        var result = {};
        $(data).each(function(idx, field) {
            result[field.name] = field.value;
            console.log(field.name + " = " + field.value);
        });
        console.log("result converted to:");
        console.log(result);

        AjaxHibernate.createOrUpdatePerson(result, {
            callback : function(ajaxPersons) {
                console.log("Received a result back " + ajaxPersons.status);
                console.log("Submit Person result ", ajaxPersons);
                if (ajaxPersons.status === 'SUCCESS') {
                    console.log("Reloading DataTable()...");
                    dt.ajax.reload();
                } else {
                    $("ul#errors").append("<li>" + ajaxPersons.message + "</li>");
                }
            }
        });
        return false;
    });
});
