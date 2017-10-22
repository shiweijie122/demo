$(document).ready(function(){
	doGetObjects();
});
function doGetObjects(){
	//定义一个url(对应服务端控制器中的一个方法)
	var url="project/doFindObjects.do"
	//定义一个params对象
	var params={"pageCurrent":1};
	//底层发起ajax异步请求($.ajax({....}))
	//getJSON方法是一个增强版的ajax方法
    $.getJSON(url,params,function(result){//result为一个json对象(JsonResult)
    	//console.log("result="+result);
    	//将json对象转换为json字符串输出
    	//console.log(JSON.stringify(result));
    	//将json对象中的数据,填充到table的tbody元素中
    	if(result.state==1){//成功
    		//alert(result.message);//假如有需要
    		//显示记录信息
    		setTableBodyRows(result.data.list);//data属性的值对应一个json对象
    		//设置及显示分页信息
    		setPagination(result.data.pageObject);
    	}else{//失败了(获取数据时出现异常了)
    		alert(result.message);
    	}
    });	

}
//定义函数将json对象中的数据取出来填充到表格中
function setTableBodyRows(result){//result 为一个json对象
	//获得tbody对象(根据id获得)
	//在使用$函数获得某个id对应的对象一定要添加#
	var tBody=$("#tbodyId");
	//清空body中内容(假如方法不记得了怎么办)
	tBody.empty();//doc.tedu.cn
	//迭代json对象
	for(var i in result){//循环一次取一行[{"name":"AAA",...},{},{}]
	//构建一个tr对象
	var tr=$("<tr></tr>");
	//tr对象中追加td字符串对象
	tr.append('<td><input type="checkbox" name="checkedItem"></td>');	
	tr.append("<td>"+result[i].code+"</td>");
	tr.append("<td>"+result[i].name+"</td>");
	tr.append("<td>"+result[i].beginDate+"</td>");
	tr.append("<td>"+result[i].endDate+"</td>");
	tr.append("<td>"+(result[i].valid?"启用":"禁用")+"</td>");
	tr.append("<td>修改</td>");
	tBody.append(tr);//将每一行记录再追加到tbody中
	}
}

