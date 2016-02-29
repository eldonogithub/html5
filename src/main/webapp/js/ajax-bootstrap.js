// jQuery - Invoked when the document is ready
$(function() {
	// Create a simple table
	AjaxBean.getTestData({
		callback : function(data) {
			if (data.status == 'FAILURE') {
			} else if (data.status == 'SUCCESS') {
				var html = "<table class='table'><thead><tr>";
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
				$('#testData').replaceWith(element);
				console.log(source);
			}
		}
	});
});