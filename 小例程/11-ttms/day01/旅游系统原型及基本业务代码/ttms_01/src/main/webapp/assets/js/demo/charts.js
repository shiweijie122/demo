"use strict";
$(document).ready(function() {
	$(".circular-charts-reload").click(function() {
		$(".circular-chart.demo-reload").each(function() {
			var a = Math.floor(100 * Math.random());
			$(this).data("easyPieChart").update(a);
			$("span", this).text(a)
		})
	})
});