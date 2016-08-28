<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
   <head>
      <title>秒杀详情页</title>
      <%@include file="common/head.jsp" %>
   </head>
   <body>
      <div class="container">
         <div class="panel panel-default text-align">
            <div class="panel-heading"><h1>${seckill.name}</h1></div>
            <div class="panel-body">
                  <h2 class="text-danger">
                      <span class="glyphicon glyphicon-time"></span>
                      <span  id="seckill-box"></span>
                  </h2>
            </div>
         </div>
      </div>
      
      <div id="killphoneModal" class="modal fade">
          <div class="modal-dialog">
              <div class="modal-content">
                   <div class="modal-heading">
                       <h3 class="modal-title text-center">
                           <span class="glyphicon glyphicon-phone">秒杀电话:</span>
                       </h3>
                   </div>
                   <div class="modal-body">
                        <div class="row">
                             <div class="col-xs-8 col-xs-offset-2">
                                 <input type="text" id="killphone" name="killphone" class="form-control" placeholder="输入手机号" />
                             </div>
                        </div>
                   </div>
                   <div class="modal-foot">
                       <span id="killphoneerror" class="glyphicon"></span>
                       <button type="button" class="btn btn-success" id="killphonebtn">
                           <span class="glyphicon glyphicon-phone"></span>submit
                       </button>
                   </div>
              </div>  
          </div>
      </div>
   </body>
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
      
      <script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
      
      <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
      
      <script src="/maven01/resources/script/seckill.js" type="text/javascript"></script>
      
      <script type="text/javascript">
          $(function(){
                seckill.detail.init({
                    seckillId : ${seckill.seckillId},
                    starttime : ${seckill.startTime.time},
                    endtime : ${seckill.endTime.time}
                });
          });
      </script>
</html>
