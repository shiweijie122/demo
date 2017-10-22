"use strict";
$(document).ready(function() {
	var a = function(d) {
		var c = d.length ? d : $(d.target), b = c.data("output");
		if (window.JSON) {
			b.val(window.JSON.stringify(c.nestable("serialize")))
		} else {
			b.val("JSON browser support required for this demo.")
		}
	};
	$("#nestable_list_1").nestable({
		group : 1
	}).on("change", a);
	$("#nestable_list_2").nestable({
		group : 1
	}).on("change", a);
	a($("#nestable_list_1").data("output", $("#nestable_list_1_output")));
	a($("#nestable_list_2").data("output", $("#nestable_list_2_output")));
	$("#nestable_list_menu").on("click", function(d) {
		var c = $(d.target), b = c.data("action");
		if (b === "expand-all") {
			$(".dd").nestable("expandAll")
		}
		if (b === "collapse-all") {
			$(".dd").nestable("collapseAll")
		}
	});
	$("#nestable_list_3").nestable()
});