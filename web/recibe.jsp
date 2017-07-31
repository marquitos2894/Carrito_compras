<%-- 
    Document   : recibe
    Created on : 30/07/2017, 10:51:23 AM
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
 
        <%
            String item_ds = request.getParameter("item_ds");
            String item_cd = request.getParameter("item_cd");
            String item_unit_p = request.getParameter("item_unit_p");
            String quantity = request.getParameter("quantity ");
            String cart_price = request.getParameter("cart_price");
            String cart_tota_price = request.getParameter("cart_tota_price");
            
            String paymet = request.getParameter("paymet");
            String region = request.getParameter("region");
            String pais = request.getParameter("pais");
            
            
            String cart_sub_total = request.getParameter("cart_sub_total");
            String shipping_cost = request.getParameter("shipping_cost");
            String total = request.getParameter("total");
        %>
        
        
        <%=item_cd%><br>
        <%=item_ds%><br>
        <%=item_unit_p%><br>
        <%=quantity%><br>
        <%=cart_price%><br>
        <%=cart_tota_price%><br>
        
        
        
        
        
        
        
        
        <%=paymet%><br>
        <%=region%><br>
        <%=pais%><br>
        <%=cart_sub_total%><br>
        <%=shipping_cost%><br>
        <%=total%><br>
   
        
        
        
    </body>
</html>
