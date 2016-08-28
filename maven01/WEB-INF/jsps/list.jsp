<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
   <head>
      <title>秒杀页列表</title>
      <%@include file="common/head.jsp" %>
   </head>
   <body>
      <div class="container">
         <div class="panel panel-default">
              <div class="panel-heading text-center">
                 <h2>秒杀列表</h2>
              </div>
              <div class="panel-body">
                  <table class="table table=hover">
                    <thead>
                     <tr>
                         <th>名称</th>
                         <th>库存</th>
                         <th>开始时间</th>
                         <th>结束时间</th>
                         <th>创建时间</th>
                         <th>详情</th>
                     </tr>
                     </thead>
                     <tbody>
                        <c:forEach var="seckill" items="${list}" >
                           <tr>
                              <td>${seckill.name}</td>
                              <td>${seckill.number}</td>
                              <td>
                                <fmt:formatDate value="${seckill.startTime}" pattern="yyyy-MM-dd hh:mm:ss" />
                              </td>
                              <td>
                                <fmt:formatDate value="${seckill.endTime}" pattern="yyyy-MM-dd hh:mm:ss" />
                              </td>
                              <td>
                                <fmt:formatDate value="${seckill.createTime}" pattern="yyyy-MM-dd hh:mm:ss" />
                              </td>
                              <td>
                                 <a class="btn btn-info" target="_blank" href="<%=path %>/seckill/${seckill.seckillId}/detail">详情页</a>
                              </td>
                           </tr>
                        </c:forEach>
                     </tbody>
                  </table>
              </div>
         </div>
      </div>
   </body>
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</html>
