 var projects;
$(document).ready(function(){
	$("#queryFormId").on('click','.btn-add,.btn-update',doShowEditDialog);
	$("#queryFormId").on('click','.btn-search',doGetObjects);
	$("#queryFormId").on('click','.btn-valid,.btn-invalid',doValidById);	
	doGetObjects();
	doGetProjectOptions();
});
//获得team记录信息
function doGetObjects(){
  var url="team/findObjects.do";
  var params=getQueryParamValues();
  var currentPage=$("#pagination").data('curPage');
  if(currentPage)params.pageCurrent=currentPage;
  $.post(url,params,function(result){
	   if(result.state==1){
		   setTableRows(result.data.list);
		   setPagination(result.data.pageObject);
	   }else{
		   alert(result.message);
	   }
  });
}
//获取查询参数
function getQueryParamValues(){
	var name = $('#searchNameId').val();
	var projectId=$('#selectProjectId option:selected') .val();//选中的值
	var params = {'name':name,'projectId':projectId,}
	return params;
}
//初始化列表页面
function setTableRows(list){
	var tBody=$('tbody');
	tBody.empty();
	var tds='<td><input type="checkbox" class="checkbox" name="checkedItem" value="[id]"></td>'+
	        '<td>[teamName]</td>'+
	        '<td>[projectName]</td>'+
	        '<td>[valid]</td>'+
	        '<td><a class="btn btn-default btn-update doShowEditDialog">修改</a></td>';
	for(var i in list){
	    var tr=$('<tr></tr>');
	    tr.data("id",list[i].teamId);
	    tr.append(tds.replace('[id]',list[i].teamId)
	    		  .replace('[teamName]',list[i].teamName)
	    		  .replace('[projectName]',list[i].projectName)
	    		  .replace('[valid]',list[i].valid?'启用':'禁用'));
	    
	    tBody.append(tr);
	}
}
//获得项目的选项信息
function doGetProjectOptions(){
	var url="team/findProjectOptions.do";
	$.getJSON(url,function(result){
		if(result.state==1){
			projects=result.data;
	        setProjectOptions(projects);
		}else{
			alert(result.message);
		}
	})
}
//初始化项目归属项目下拉列表
function setProjectOptions(list){
	var selectObj=$("#selectProjectId");
	for(var i in list){
	 selectObj.append("<option value='"+list[i].id+"'>"+list[i].name+"</option>");
	}
}
//显示编辑模态框
function doShowEditDialog(){
	 var url='team/editUI.do?t='+Math.random(1000);
	 $("#modal-dialog").data("projects",projects);
	 var title;
	 if($(this).hasClass("btn-add")){
		 title="添加团信息";
	 }
	 if($(this).hasClass("btn-update")){
		 $("#modal-dialog").data("id",$(this).parent().parent().data("id"));
		 title="修改团信息"
	 }
	 $("#modal-dialog .modal-body").load(url,function(){
		 $('#modal-dialog .modal-title').html(title);
		 $('#modal-dialog').modal('show');
	 })
}

//禁用&启用
function doValidById(){
	var state;
	//判断点击的按钮
	if($(this).hasClass("btn-valid")){
		state=1;
	}else{
		state=0;
	}
	//获得选中的id
	var checkedIds=getCheckedIds();
	if(checkedIds==''){
		alert("至少选择一个");
		return;
	}
	//发送ajax请求修改状态
	var url='team/doValidById.do';
	var params={'checkedIds':checkedIds,'valid':state}
	$.post(url,params,function(result){
		if(result.state==1){
		  doGetObjects();
		}else{
		  alert(result.message);
		}
	})
}
//获得选中的id，然后拼接成字符串
function getCheckedIds(){
	var checkedIds ='';
	$('tbody input[name="checkedItem"]').each(function(){
		if($(this).is(':checked')){  //或者用prop('checked')
			if(checkedIds==''){
			   checkedIds += $(this).val();
			}else{
			   checkedIds += ','+$(this).val();
			}
		}
	})
	return checkedIds;
}