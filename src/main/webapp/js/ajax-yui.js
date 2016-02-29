/**
 * 
 */
// Create a new YUI instance and populate it with the required modules.
YUI({ skin: 'night' }).use('panel','datasource', 'datatable', 'dataschema', function(Y) {
	var dialog = new Y.Panel({
        contentBox : Y.Node.create('<div id="dialog"/>'),
        bodyContent: '<div class="message icon-warn">Are you sure you want to [take some action]?</div>',
        width      : 410,
        zIndex     : 6,
        centered   : true,
        modal      : false, // modal behavior
        render     : '.example',
        visible    : false, // make visible explicitly with .show()
        buttons    : {
            footer: [
                {
                    name  : 'cancel',
                    label : 'Cancel',
                    action: 'onCancel'
                },

                {
                    name     : 'proceed',
                    label    : 'OK',
                    action   : 'onOK'
                }
            ]
        }
    });

    dialog.onCancel = function (e) {
        e.preventDefault();
        this.hide();
        // the callback is not executed, and is
        // callback reference removed, so it won't persist
        this.callback = false;
    }

    dialog.onOK = function (e) {
        e.preventDefault();
        this.hide();
        // code that executes the user confirmed action goes here
        if(this.callback){
           this.callback();
        }
        // callback reference removed, so it won't persist
        this.callback = false;
    }
	
	// Create a simple table
	AjaxBean.getTestData({
		callback : function(data) {
			if ( data.status == 'FAILURE' ) {
				// set the content you want in the message
			    Y.one('#dialog .message').setHTML(data.message);
			    dialog.show();
			}
			else if (data.status == 'SUCCESS') {
				var html = "<table><thead><tr>";
				var hdr = data.results.header;
				for (var i = 0; i < hdr.length; i++) {
					html += "<th>" + hdr[i] + "</th>";
				}
				html += "</tr></thead><tbody>";
				var rows = data.results.rows;
				var source = [];
				for (var i = 0; i < rows.length; i++) {
					html += "<tr>";
					var row = rows[i];
					source[i] = {};
					for (var j = 0; j < row.length; j++) {
						html += "<td>" + row[j] + "</td>";
						source[i][hdr[j]] = row[j];
					}
					html += "</tr>";
				}
				html += "</tbody></table>";
				var element = $(html);
				console.log(html);
				$('#results').append(element);
				console.log(source);
				var mySchema = {
					resultListLocator : "results.rows",
					resultFields : [ {
						key : "ID-X"
					}, {
						key : "NAME-X"
					} ]
				};
				// Returns an object with the properties "results" and "meta"
				var myOutput = Y.DataSchema.Array.apply(mySchema, data);

				var myDataSource = new Y.DataSource.Local({
					source : myOutput
				});
				
				var table = new Y.DataTable.Base({ columns: [ 'ID', 'NAME' ], data: source });
				table.render("#testData");
			}
		}
	});
	// A table from data with keys that work fine as column names
	var simple = new Y.DataTable({
		columns : [ "id", "name", "price" ],
		data : [ {
			id : "ga_3475",
			name : "gadget",
			price : "$6.99"
		}, {
			id : "sp_9980",
			name : "sprocket",
			price : "$3.75"
		}, {
			id : "wi_0650",
			name : "widget",
			price : "$4.25"
		} ],
		summary : "Price sheet for inventory parts",
		caption : "Example table with simple columns"
	});

	simple.render("#simple");
});
// jQuery - Invoked when the document is ready
$(function() {
});