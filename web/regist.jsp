<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
<html>
    <head>
        <script type="text/javascript">
            window.onload=function () {
                document.getElementById("countrySelect").onchange=function () {
                    //发送异步请求，首先创建一个对象
                    var xmlHttp=new XMLHttpRequest();
                    //打开一个管道（用来与服务器进行通信）
                    xmlHttp.open("post","selectAreaByCid?cid="+this.value,true);
                    //发送请求
                    xmlHttp.send();
                    xmlHttp.onreadystatechange=function () {
                        if(xmlHttp.readyState==4&&xmlHttp.status==200){
                            //处理信息
                            //找到地区的那个span标签
                            var areaSpanEle=document.getElementById("areaSpan");
                            //将响应信息放入标签，即handleAreaList中的内容
                            areaSpanEle.innerHTML=xmlHttp.responseText;
                            document.getElementById("areaSelect").onchange=function () {
                                var xmlHttp1=new XMLHttpRequest();
                                xmlHttp1.open("post","selectCityByAid?aid="+this.value,true);
                                xmlHttp1.send();
                                xmlHttp1.onreadystatechange=function () {
                                    if(xmlHttp1.readyState==4&&xmlHttp1.status==200){
                                        var citySpanEle=document.getElementById("citySpan");
                                        citySpanEle.innerHTML=xmlHttp1.responseText;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        </script>

    </head>
    <body>
        <form action="" method="post">
            账号:<input type="text" name="name" value=""><br>
            密码:<input type="text" name="name" value=""><br>
            确认:<input type="text" name="name" value=""><br>
            性别:
            <input type="radio" name="sex" value="男">男
            <input type="radio" name="sex" value="女">女
            <br>
            国家：
            <select id="countrySelect">
                <option>==请选择==</option>
                <c:forEach var="country" items="${requestScope.countryArrayList}">
                    <option value="${country.cid}">${country.cname}</option>
                </c:forEach>
            </select>
            地区:
            <span id="areaSpan">
                <select>
                    <option>==请选择==</option>
                </select>
            </span>
            城市:
            <span id="citySpan">
                <select>
                    <option>==请选择==</option>
                </select>
            </span>
            <br>
            电话:<input type="text" name="name" value=""><br>
            邮箱:<input type="text" name="name" value=""><br>
            <input type="submit" value="注册">
            <input type="reset" value="重置">
        </form>
    </body>
</html>
