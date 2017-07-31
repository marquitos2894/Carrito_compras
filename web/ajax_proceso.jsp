

<%@page import="Models.Item_models"%>
<%@page import="Beans.Item_beans"%>
<%@page import="Beans.Region__Beans"%>
<%@page import="Beans.Zone_beans"%>
<%@page import="Models.Zone_models"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

         <% 
                    String zone01=request.getParameter("zone_cd"); %>
             <select>
                <% 
                               
                    
                    Zone_models m = new Zone_models();
                    for(Region__Beans rb : m.getAllRegion_models(zone01))
                    {
                %>
                    <option value="<%=rb.getZone_cd()%>"><%=rb.getRegion_ds()%></option>

                 <% } %>
	   </select>
