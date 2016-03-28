$(function() {
    var dt;
    var persons;
    // Crazy stupid way of doing HTML encoding for javascript. But it works
    function encode(txt) {
        var t2h = $("<div/>");
        return t2h.text(txt).html();
    }

    // 1.TABLE_CAT String => table catalog (may be null)
    // 2.TABLE_SCHEM String => table schema (may be null)
    // 3.TABLE_NAME String => table name
    // 4.TABLE_TYPE String => table type. Typical types are "TABLE", "VIEW",
    // "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS",
    // "SYNONYM".
    // 5.REMARKS String => explanatory comment on the table
    // 6.TYPE_CAT String => the types catalog (may be null)
    // 7.TYPE_SCHEM String => the types schema (may be null)
    // 8.TYPE_NAME String => type name (may be null)
    // 9.SELF_REFERENCING_COL_NAME String => name of the designated "identifier"
    // column of a typed table (may be null)
    // 10.REF_GENERATION String => specifies how values in
    // SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER",
    // "DERIVED". (may be null)

    var titles = [
            {
                "data" : "tableCat",
                "title" : "Table Catalog"
            },
            {
                "data" : "tableSchema",
                "title" : "Table Schema"
            },
            {
                "data" : "tableName",
                "title" : "Table Name",
                "render" : function(data, type, row, meta) {
                    return "<a href=\"" + encode(baseUrl) + "/databases/toursdb/viewTable.do?tableSchema=" + row.tableSchema + "&tableName=" + data + "\">"
                            + data + "</a>";
                }
            },
            {
                "data" : "tableType",
                "title" : "Table Type"
            },
            {
                "data" : "remarks",
                "title" : "Remarks"
            },
            {
                "data" : "typeCat",
                "title" : "Type Catalog"
            },
            {
                "data" : "typeSchem",
                "title" : "Type Schema"
            },
            {
                "data" : "typeName",
                "title" : "Type Name"
            },
            {
                "data" : "selfReferencingColName",
                "title" : "Self Referencing Column Name"
            },
            {
                "data" : "refgenerationString",
                "title" : "Reference Generation"
            },
            {
                "data" : null,
                "title" : "Operation",
                "render" : function(data, type, row, meta) {
                    return "<button id='edit' class='ui-widget ui-state-default'>Edit</button>"
                            + "<button id='delete' class='ui-widget ui-state-default'>Delete</button>";
                },
            } ];
    // populate table
    function loadTable() {
        console.log("Loading the table");
        dt = $("table#toursdbForm").DataTable({
            "ajax" : function(data, cb, settings) {
                console.log("AjaxHibernate.getTables() invoked");
                AjaxHibernate.getTables({
                    "callback" : function(ajaxMetaData) {
                        console.log("Received a result back " + ajaxMetaData.status);
                        if (ajaxMetaData.status === 'SUCCESS') {
                            console.log("Calling DataTable() callback...");
                            console.log("Received response ", ajaxMetaData.results);

                            cb({
                                "data" : ajaxMetaData.results,
                            });
                        }
                    }
                });
            },
            "columns" : titles,
            "pageLength" : 25
        });
        $('.dataTables_scrollBody').on('scroll', (function(e) {
            console.log(e);
        }));
    }

    // Load the table with the initial data
    loadTable();
    $("form#toursdbForm tr").each(function(idx, row) {
        console.log("Row = ", row);
        $(row).click(function() {
            console.log("row clicked: " + row);
        });
    });

    // Set the on submit handler
    $("form#toursdbForm").submit(function(e) {

        e.preventDefault();

        // serialize the form data
        var data = $(this).serializeArray();
        console.log("Data serialized");
        console.log(data)

        // this won't work always, multiple form fields won't be injected
        // corrected
        var result = {};
        $(data).each(function(idx, field) {
            result[field.name] = field.value;
            console.log(field.name + " = " + field.value);
        });
        console.log("result converted to:");
        console.log(result);
        AjaxHibernate.submitPerson(result, {
            callback : function(ajaxMetaData) {
                console.log("Received a result back " + ajaxMetaData.status);
                console.log("Submit Tables result ", ajaxMetaData);
                if (ajaxMetaData.status === 'SUCCESS') {
                    console.log("Reloading DataTable()...");
                    dt.ajax.reload();
                }
            }
        });
        return false;
    });
});
