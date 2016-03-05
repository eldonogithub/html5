$(function() {
	AjaxHibernate.getPersons({
		callback: function(ajaxPersons) {
			console.log(ajaxPersons);
		}
	});
});
