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

    // populate table
    function loadTable() {
        console.log("Loading the table");
        dt = $("table#toursdbForm").DataTable({
            "pageLength" : 25
        });
    }

    // Load the table with the initial data
    loadTable();
    $("form#toursdbForm tr").each(function(idx, row) {
        console.log("Row = ", row);
        $(row).click(function() {
            console.log("row clicked: " + row);
        });
    });

});
