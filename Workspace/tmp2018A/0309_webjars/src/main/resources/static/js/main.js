var golbalVar;
$(function(){
	$("#submit").click(function(){
		$("#text").val("1123");
	});
	$("#btnAjax").click(function(){
		$.ajax({
			"type":"GET",
			"url":"/getValue",
			dataType:"json",
			"success": function(data){
				$("#txtAjax").val("success");
		      },
		      "error": function(XMLHttpRequest,textStatus,errorThrown){
								$("#txtAjax").val(
										XMLHttpRequest.status + ","
												+ XMLHttpRequest.readyState
												+ "," + textStatus);
		      },
		});
	});
	
});
function fun(){
	var v1;
}
