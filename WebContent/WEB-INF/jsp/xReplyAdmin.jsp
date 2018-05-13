<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
	<title>留言板</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/layout.css" />
    <link rel="stylesheet" type="text/css" href="css/elements.css" />
    <link rel="stylesheet" type="text/css" href="css/icons.css" />

    <!-- libraries -->
    <link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/user-list.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css' />

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style type="text/css">
        *{
            margin:0;padding:0;
            -webkit-touch-callout: none; /* prevent callout to copy image, etc when tap to hold */
            -webkit-text-size-adjust: none; /* prevent webkit from resizing text to fit */
            -webkit-tap-highlight-color: rgba(210,210,210,0.35); /* make transparent link selection, adjust last value opacity 0 to 1.0 */
            -webkit-user-select: none; /* prevent copy paste, to allow, change 'none' to 'text' */
        }
        body{font-family:"微软雅黑";font-size:12px;}
        ul,li{list-style:none;}
        .ylcon{width:100%;min-width:320px;}
        .tit{height:26px;line-height:26px;padding:0px 15px;position:relative;font-size:18px;color:#1a2129;border-bottom:1px solid rgba(0, 0, 0, 0.15);}

        .story{border-bottom:1px dashed #cecece;padding:0 15px 3px;position:relative;}

        .story_m{color:rgba(110,110,110,1);line-height:21px;word-break:break-all;word-wrap:break-word;overflow:hidden;font-size:1.2em;padding:2px 0;}
        .story_time{color:rgba(154,154,154,1);padding:2px 0;font-size:10px;}
        .story_hf{background:rgb(245,245,245);font-size:1.2em;border:1px solid rgba(204,204,204,0.2);border-radius:2px;color:rgba(110,110,110,1);padding:4px;margin-bottom:5px;}
        .replay{background:rgb(245,245,245);font-size:1.2em;border:1px solid rgba(204,204,204,0.2);
            border-radius:2px;color:rgba(110,110,110,1);padding:4px;margin-bottom:5px;}

        .opbtn{position:absolute;top: 30px;right: 50px;}
    </style>
</head>
<body>

      <!-- navbar -->
   <%@ include file="navbar.jsp" %>
    <!-- sidebar -->
   <%@ include file="slidebar.jsp" %>
    

	<!-- main container -->
    <div class="content">
        <div class="container-fluid">
            <div id="pad-wrapper" class="users-list">
                <h3>留言板</h3>

                <div class="ylcon">

                    <p class="tit"></p>
                    <div id="messDivId">
                       
<s:iterator var="ly" value="pageBean.list" status="status">
                        <div class="story">
                            <p class="story_m" style="width: 50em">
                            	<s:property value="#ly.content"/>
                            </p>
                            <p class="story_time">
                            	<s:property value="#ly.student.name"/>&nbsp;&nbsp;<s:property value="#ly.time"/>
                            	<a href="#" onclick="showReply('<s:property value="#ly.id"/>')">查看回复</a>
                            	<a href="${ pageContext.request.contextPath }/ly_delete.action?id=<s:property value="#ly.id"/>">删除</a>
                            </p>
                            <div id="<s:property value="#ly.id"/>" class="replay" style="display: none;">                         
                            </div>
                        </div>
</s:iterator>                          
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- end main container -->

	<!-- scripts -->
    <script src="js/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/theme.js"></script>
    <script>

        function showReply(lyid) {          
            var flag = document.getElementById(lyid).style.display;
           
            if (flag == ""){
            	//清空p标签 
            	var s = document.getElementById(lyid).getElementsByTagName("p");
            	while(s.length-1>=0){
            		s[0].remove();
            	}
                document.getElementById(lyid).style.display="none";        
            }
            else {
            	document.getElementById(lyid).style.display="";
            	 var url = "re_findByLiuyanId.action?lyid=" + lyid;  
                 $.ajax( {  
                     type : "POST",  
                     url : url,  
                     data : {},  
                     dataType : "JSON",  
                     success : function(data) {    	 
                         for(var n=0;n<data.length;n++){  
                          	var name=data[n].student.name;  
                            var content=data[n].content;
                            var time=data[n].time;
                            var mydiv = document.getElementById(lyid)
                            var tag1 = document.createElement("p");
                            var tag2 = document.createElement("p");
                            tag1.innerHTML = name+": "+content;
                            tag2.innerHTML = time;
                            tag2.className = "story_time";
                            mydiv.appendChild(tag1);
                            mydiv.appendChild(tag2);
                         }  
                     }  
                 })  
                
            }
        }
    </script>

</body>
</html>