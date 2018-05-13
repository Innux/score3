<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
	<title>Detail Admin - User list</title>
    
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
   <%@ include file="slidebar2.jsp" %>
    

	<!-- main container -->
    <div class="content">
        <div class="container-fluid">
            <div id="pad-wrapper" class="users-list">
                <h3>留言板</h3>
                <a href="#" onclick="showAdd()" class="btn-flat success opbtn">
                    +我要留言
                </a>

                <div class="ylcon">

                    <p class="tit"></p>
                    <div id="messDivId">
                        <div id="addReply" class="story" style="display: none;">
                            <form  action="${pageContext.request.contextPath }/ly_save.action"
                             method="post" novalidate="novalidate">
                                <label>内容:</label>
                                <textarea name="content" id="addContent" class="span3" rows="4" placeholder="内容不超过140字" maxlength="140"></textarea>
                                <input name="time" id="iTime" type="hidden" value="" />
                              
                                <input name="student.id" type="hidden" value="<s:property value="#session.user.id"/>" />
                                <div class="field-box">
                                    <input type="submit" class="btn-flat primary" value="提交" />
                                    <input type="button" class="btn-flat danger" style="margin-left: 50px" value="取消" onclick="closeAdd()"/>
                                </div>
                            </form>
                        </div>
<s:iterator var="ly" value="pageBean.list" status="status">
                        <div class="story">
                            <p class="story_m" style="width: 50em">
                            	<s:property value="#ly.content"/>
                            </p>
                            <p class="story_time">
                            	<s:property value="#ly.student.loginName"/>&nbsp;&nbsp;<s:property value="#ly.time"/>
                            	<a href="#" onclick="showReply('<s:property value="#ly.id"/>')">回复</a>
                            </p>
                            <div id="<s:property value="#ly.id"/>" class="replay" style="display: none;">
                            	
                                <form id="reForm" action="${pageContext.request.contextPath }/re_save.action"
                             method="post" novalidate="novalidate">
                                    <label>回复:</label>
                                    <textarea name="content" id="iTxt1" class="span3" rows="3" placeholder="内容不超过50字" maxlength="50"></textarea>
                                    <input name="time" id="iTime1" type="hidden" value="" />
                                	<input name="student.id" type="hidden" value="<s:property value="#session.user.id"/>" />
                                	<input name="liuyan.id" type="hidden" value="<s:property value="#ly.id"/>" />
                                    <div class="field-box">
                                         <input type="submit" class="btn-flat primary" value="提交"/>
                                       <!--  <button class="btn btn-info" type="button" onclick="clickAfter()">提交</button> -->
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="button" class="btn-flat danger" value="取消" onclick="clearSth()"/>
                                    </div>
                                </form>
                                                            
                            </div>
                        </div>
</s:iterator>                          
                    </div>
                </div>
<!--================= 分页======================== -->
第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页 
				<!-- =============================== -->
				<div class="pagination pull-right">
					<ul>
					<!--  上一页-->
					<li>
						<s:if test="pageBean.page != 1">
<a href="${ pageContext.request.contextPath }/ly_findByPage.action?page=<s:property value="pageBean.page-1"/>">&#8249;</a>
					</s:if>
						<s:else>
						<a href="#">&#8249;</a>
						</s:else>
					</li>
					<!-- 选页 -->
						<s:bean name="org.apache.struts2.util.Counter" id="counter">
						    <s:param name="first" value="1" />
						    <s:param name="last" value="pageBean.totalPage" />
						    <s:iterator>
						        <li><a href="${ pageContext.request.contextPath }/ly_findByPage.action?page=<s:property/>"><s:property/></a></li>
						    </s:iterator>
						</s:bean>
					<!-- 选页end -->
					<!-- 下一页 -->
					
						<li>
						<s:if test="pageBean.page != pageBean.totalPage">
<a href="${ pageContext.request.contextPath }/ly_findByPage.action?page=<s:property value="pageBean.page+1"/>">&#8250;</a>
						</s:if>
						<s:else>
						<a href="#">&#8250;</a>
						</s:else>
						</li>
					</ul>
				</div>
	<!--===================  -->


            </div>
        </div>
    </div>
    <!-- end main container -->

	<!-- scripts -->
    <script src="js/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/theme.js"></script>
    <script>
    window.onload = function(){
        showTime();
    }
    
    function clickAfter() {
    	document.getElementById('reForm').submit();
    	/* document.getElementById(lyid).style.display="";
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
        })   */
    }

   
   		 
	     function showTime()
	    {
	        var now=new Date();
	        var year=now.getFullYear();
	        var month=now.getMonth()+1;
	        var day=now.getDate();
	        var hour = now.getHours();
	        var minute = now.getMinutes();
	        
	        if (month >= 1 && month <= 9) {
	            month = "0" + month;
	        }
	        if (day >= 0 && day <= 9) {
	            day = "0" + day;
	        }
	        document.getElementById("iTime").value = year + "/" + month + "/" + day + " " + hour + ":" + minute;
	        document.getElementById("iTime1").value = year + "/" + month + "/" + day + " " + hour + ":" + minute;
	    } 
	    
	    setTimeout("showTime()",6000);
  /*添加留言  */
        function showAdd() {
        	 var flag = document.getElementById("addReply").style.display;
        	 if (flag == "") {
        		 document.getElementById("addContent").value="";
                 document.getElementById("addReply").style.display="none";
        	 }
             else
                 document.getElementById("addReply").style.display="";
        }
  
        function closeAdd() {
            document.getElementById("addContent").value="";
            document.getElementById("addReply").style.display="none";
        }

        function showReply(lyid) {          
            var flag = document.getElementById(lyid).style.display;
           
            if (flag == ""){
            	//清空p标签 
            	var s = document.getElementById(lyid).getElementsByTagName("p");
            	while(s.length-1>=0){
            		s[0].remove();
            	}
            	document.getElementById("iTxt1").value="";
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
                         for(var n=data.length-1;n>=0;n--){  
                          	var name=data[n].student.loginName;  
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