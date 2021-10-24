<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/10/13
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <link  rel="stylesheet" href="views/bootstrap/css/bootstrap.min.css">
    <link  rel="stylesheet" href="views/css/font-awesome.min.css">
    <link  rel="stylesheet" href="views/layer/layer.js">
    <script type="text/javascript" src="views/js/jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="views/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="views/script/docs.min.js"></script>
    <style>

        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
        .tree-closed {
            height : 40px;
        }
        .tree-expanded {
            height : auto;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $(".list-group-item").click(function(){
                if ( $(this).find("ul") ) {
                    $(this).toggleClass("tree-closed");
                    if ( $(this).hasClass("tree-closed") ) {
                        $("ul", this).hide("fast");
                    } else {
                        $("ul", this).show("fast");
                    }
                }
            });
        });
    </script>
</head>

