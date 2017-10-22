$(document).ready(function(){
	doGetObjects();
});
function doGetObjects(){
	//底层发起ajax异步请求
	var url="project/doFindObjects.do"
    $.getJSON(url,function(result){
    	//console.log("result="+result);
    	//将json对象转换为json字符串输出
    	console.log(JSON.stringify(result));
    	setTableRows(result);
    });	
}
function setTableRows(result){//result 为一个json对象
	//获得tbody对象
	var tBody=$("#tbodyId");
	//清空body中内容
	tBody.empty();
	//迭代json对象
	for(var i in result){
	var tr=$("<tr></tr>");
	tr.append('<td><input type="checkbox" name="checkedItem"></td>');	
	tr.append("<td>"+result[i].code+"</td>");
	tr.append("<td>"+result[i].name+"</td>");
	tr.append("<td>"+result[i].beginDate+"</td>");
	tr.append("<td>"+result[i].endDate+"</td>");
	tr.append("<td>"+result[i].valid+"</td>");
	tr.append("<td>修改</td>");
	tBody.append(tr);
	}
}

