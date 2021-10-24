<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/9/28
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
<%--    js/jquery/jquery-3.6.0.min.j--%>
    <script type="text/javascript" src="views/js/jquery/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript">
        $(function (){
            // let $btn1=$("#btn01");
            // console.log($btn1);
            $("#btn01").click(function (){
                $.ajax({
                    url: "send/t1.html",
                    type: "post",
                    data: {
                        "array":[5,8,12]
                    },
                    dataType: "text",
                    success: function(response){
                        alert(response);
                    },
                    error: function(response){
                        alert(response);
                    }
                });
            });
            $("#btn02").click(function (){
                var array=[5,8,12];
                var requestBody=JSON.stringify(array);
                $.ajax({
                    url: "send/t2.html",
                    type: "post",
                    data: requestBody,
                    contentType:"application/json;character=UTF-8",
                    dataType:"text",
                    success: function(response){
                        alert(response);
                    },
                    error: function(response){
                        alert(response);
                    }
                });
            });

            $("#btn03").click(function (){
                var student={
                    stuID:123,
                    stuName:'高捷平',
                    address:{
                            province:'福建',
                            city:'漳州',
                            street:'古庙'
                    },
                    subjectList:[
                        {
                            subName:'菜和田',
                            subScore:100
                        },
                        {
                            subName:'马来话',
                            subScore:22
                        }
                    ],
                    map:{
                        key1:'海妖',
                        key2:'飞机'
                    }
                }
                let requestBody=JSON.stringify(student);
                $.ajax({
                    url:"send/t3.html",
                    type:'Post',
                    dataType:'text',
                    data:requestBody,
                    contentType: "application/json;charset=UTF-8",
                    success:function (response) {
                        alert(response);
                    },
                    error:function (response){
                      alert(response);
                    }
                    
                })
            });
            $("#btn04").click(function (){
                var student={
                    stuID:123,
                    stuName:'高捷平',
                    address:{
                        province:'福建',
                        city:'漳州',
                        street:'古庙'
                    },
                    subjectList:[
                        {
                            subName:'菜和田',
                            subScore:100
                        },
                        {
                            subName:'马来话',
                            subScore:22
                        }
                    ],
                    map:{
                        key1:'海妖',
                        key2:'飞机'
                    }
                }
                let requestBody=JSON.stringify(student);
                $.ajax({
                    url:"send/t4.html",
                    type:'Post',
                    dataType:'Json',
                    data:requestBody,
                    contentType: "application/json;charset=UTF-8",
                    success:function (response) {
                        console.log(response);
                    },
                    error:function (response){
                        console.log(response);
                    }

                })
            });
            $("#btn05").click(function (){
                layer.msg("layer的弹框");
            });
        })


    </script>
</head>
<body>
        <a href="${pageContext.request.contextPath}/handle/test1.html">
            测试链接
        </a>
        </br>
        </br>
        <button id="btn01">测试一</button>
        <button id="btn02">测试二</button>
        <button id="btn03">测试三</button>
        <button id="btn04">测试四</button>
        <button id="btn05">layer弹窗测试</button>
</body>
</html>
