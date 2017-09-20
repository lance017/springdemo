<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>demo</title>
</head>
<body>
    <h1>逻辑</h1>
    <h2>1,取基本值</h2>
    <div class="demo-div">
        <ul>
            <li>
                整数: <font color="red">${intVar}</font> <br/>
                Long: <font color="red">${longVar}</font> <br/>
                string: <font color="red">${stringVar}</font> <br/>
                double: <font color="red">${doubleVar}</font> <br/>
                bool: <font color="red">${boolVar?string('yes','no')}</font> <br/>
                date: <font color="red">${dateVar?string('yyyy-MM-dd HH:mm:ss')}</font> <br/>
                null: <font color="red">${nullVar!'我是默认值'}</font> <br/>
            </li>
        </ul>
        <ul>
            <li>赋值&运算</li>
            <#assign a=100/>
            a = <font color="red">${a}</font> <br/>
            a+100 = <font color="red">${a+100}</font> <br/>
        </ul>

        <ul>
            <li>对象</li>
            user.name = <font color="red">${(user.name)!"allen"}</font> <br/>
            ${(user.recommend)!"asdf"}
        </ul>

        <ul>
            <li>集合list</li>
            <#list myList as item>
                <font color="red">${item!}</font> <br/>
            </#list>
        </ul>

        <ul>
            <li>集合map</li>
            <#list myMap?keys as key>
                <font color="red">${key!} = ${myMap[key]}</font> <br/>
            </#list>
        </ul>

        <ul>
            <li>if</li>
            <#assign var=100/>
            <#if var == 100>
                <font color="red">var = 100</font> <br/>
            </#if>

            <#if var == 99>
                <font color="red">var = 99</font> <br/>
            <#else >
                <font color="red">var != 99</font> <br/>
            </#if>

            <#if var &gt; 99>
                <font color="red">var &gt; 99</font> <br/>
            <#elseif var == 99>
                <font color="red">var == 99</font> <br/>
            <#else>
                <font color="red">var 小于 99</font> <br/>
            </#if>

        </ul>

        <ul>
            <li>switch</li>
            <#assign var = 103/>
            <#switch var>
                <#case 10>
                10 <br/>
                <#break>
                <#case 100>
                100 <br/>
                <#break>
                <#default>
                101<br/>
                <#break>
            </#switch>
        </ul>

        <ul>
            <li>1,字符串常用内建函数</li>
            <#assign a = "hello"/>
            <#assign b = "world"/>
            <li>连接</li>
            <font color="red">${a+","+b}</font> <br/>
            <li>截取</li>
            <font color="red">${(a+","+b)?substring(5,8)}</font> <br/>
            <li>长度</li>
            <font color="red">${(a+","+b)?length}</font> <br/>
            <li>大些</li>
            <font color="red">${(a+","+b)?upper_case}</font> <br/>
            <li>小些</li>
            <font color="red">${(a+","+b)?lower_case}</font> <br/>
            <li>index_of</li>
            <font color="red">${(a+","+b)?index_of("w")}</font> <br/>
            <li>last_index_of</li>
            <font color="red">${(a+","+b)?last_index_of("o")}</font> <br/>
            <li>replace</li>
            <font color="red">${(a+","+b)?replace("o", "xx")}</font> <br/>
            <li>cap_first 首字母大写</li>
            <font color="red">${a?cap_first}</font> <br/>
            <li>end_with 以什么结尾</li>
            <font color="red">${(a?ends_with("o"))?string('yes','no')}</font> <br/>
            <li>contains 是否包含</li>
            <font color="red">${(a?contains("0"))?string('yes','no')}</font> <br/>
            <li>split</li>
            <font color="red">
                <#list "a|b|c|d"?split("|") as item>
                    ${item}
                </#list>
            </font> <br/>
            <li>字符串转日期</li>
            <#assign var1 = "01/03/2017"?date("MM/dd/yyyy")/>
            <#assign var2 = "15:05:30"?time("HH:mm:ss")/>
            <#assign var3 = "2016-12-31 03:05 PM"?datetime("yyyy-MM-dd hh:mm")/>
            ${var1} <br/>
            ${var2} <br/>
            ${var3} <br/>
        </ul>

        <ul>
            <li>数字类型内建函数</li>
            <#assign numVar1 = 314.5662/>
            ${numVar1?string("0.##")} <br/>
            ${numVar1?round} <br/>
        </ul>

        <ul>
            <li>list内建函数</li>
            <#assign listVar1 = [1,2,3,4,11,12,13,14,21,22,23,24]/>
            ${listVar1?chunk(4)?size} <br/>
            <#list listVar1?chunk(4)?last as item>
                ${item}
            </#list>
        </ul>

        <ul>
            <li>其他内建函数</li>
            <#assign sVar = "hello"/>
            ${sVar?is_number?string("yes","no")} <br/>
            ${sVar?has_content?string("yes","no")} <br/>
            ${"1"+"2"?eval} <br/>
        </ul>


        <ul>
            <li>自定义函数</li>
            <#assign myList = [9,4,5,3,16,6,7]/>
            未排序 <br/>
            <#list myList as item>
                ${item}
            </#list>
            <br/>
            已排序 <br/>
            <#list sort_int(myList) as item>
            ${item}
            </#list>
            已排序 <br/>
            <#list myList?sort as item>
            ${item_index} : ${item} <br/>
            </#list>
            <br/>
            已排序 <br/>
            <#list myList?sort?reverse as item>
            ${item_index} : ${item} <br/>
            </#list>
            <br/>
            list.size = ${myList?size}
            <br/>

        </ul>

        <ul>
            <li>自定义指令</li>
            用户 123456 是否拥有 admin 角色，并且返回 admin 的权限
            <br/>
            <@role user="123456" role="admin"; result1, result2>
                <#if result1>
                    我的角色是 <font color="red">admin</font>
                </#if>
                <br/>
                我拥有的权限是:<font color="red">
                    <#list result2 as item>
                        ${item},
                    </#list>
                </font>
                <br/>
            </@role>

        </ul>

        <ul>
            <li>macro:宏指令</li>
            无参数的

        </ul>

    </div>


</body>
</html>