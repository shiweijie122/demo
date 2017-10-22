# 一.jQuery中的对象
## 1.通过$得到的是jQuery对象

	$("img")
	$(img)
	$("<li>天津</li>")

## 2.修改方法返回jQuery对象

	$("p").html("abc")
	$("input").val("hello")

## 3.读取方法
- 若读取到了元素,则是jQuery对象

		obj.parent()
		obj.next()

- 若读取到了文本,则是字符串

		obj.html()
		obj.val()

## 4.万能办法
- 控制台输出对象,若输出了数组则是jQuery对象

# 二.jQuery事件
## 1.事件概述
### 1)什么是事件
- 和js一样

### 2)事件的分类
- 和js一样

## 2.事件定义
### 1)直接定义
- 和js一样

### 2)动态绑定(*)
#### $(function(){})
- onload只能写一次,因为后者会覆盖前者
- $(function(){})却可以写多次,都有效

#### obj.click(function(){})

### 3)取消事件
- 在事件内return false即可
> 和js一样

## 3.事件对象
### 1)什么是事件对象
- 和js一样

### 2)如何获取事件对象
#### 直接定义事件时
- 和js一样

#### 动态绑定事件时(*)
- 获取event的方式和js一样
- 获得的event被jQuery封装了
> 后面说明封装的内容

## 4.事件机制
### 1)冒泡机制
- 和js一样

### 2)取消冒泡

	e.stopPropagation()

### 3)作用
- 和js一样

### 4)如何获取事件源

	e.target