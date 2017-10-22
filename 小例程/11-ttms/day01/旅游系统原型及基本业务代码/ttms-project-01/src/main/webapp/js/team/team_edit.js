//获得模态框绑定的id
var id=$('#modal-dialog').data('id');
$(document).ready(function(){
	$('#modal-dialog').on('click', '.ok', doSubmitEditForm);
	$("#modal-dialog").on("hidden.bs.modal", function() {
		$(this).off('click', '.ok')
		       .removeData("bs.modal")
		       .data("id","")
		       .data("projects","");
	})
	doInitProjectOptions();
	console.log("id="+id);
	if(id)doGetObjectById();
})

//初始化编辑页面的项目option列表
function doInitProjectOptions(){
	var projects=$('#modal-dialog').data('projects');
	for(var i in projects){
		$('#selectProjectEditId').append("<option value='"+projects[i].id+"'>"+projects[i].name+"</option>");
	}
}
//提交表单数据
function doSubmitEditForm(){
    var params=doGetFormParameterValues();
    var url=id?'team/update.do':'team/save.do';
    $.post(url,params,function(result){
    	if(result.state==1){
    		$('#modal-dialog').modal('hide');
    		doGetObjects();
    	}else{
    		alert(result.message);
    	}
    })
}
//获得表单数据
function doGetFormParameterValues(){
	var params={
		"id":id,
		"name":$('#nameId').val(),
		"projectId":$('#selectProjectEditId').val(),
	    "valid":$('input[name="valid"]:checked').val(),
	    "note":$('#noteId').val(),
	}
	return params;
}
//修改时根据id获得相关团信息
function doGetObjectById(){
	var url='team/findById.do';
	var params={"id":id};
	$.post(url,params,function(result){
		if(result.state==1){
		 doFillUpdateForm(result.data);
		}else{
		 alert(result.message);
		}
	});
}
//修改时填充页面数据
function doFillUpdateForm(obj){
	$('#nameId').val(obj.name);
	$('#selectProjectEditId option').each(function(){
		if($(this).val()==obj.projectId){
			$(this).prop("selected",true);
		}
	});
 	$('#noteId').html(obj.note);
 	$('input[name="valid"]').each(function(){
 		if($(this).val()==obj.valid){
 			$(this).prop("checked",true);
 		}
 	})
}



