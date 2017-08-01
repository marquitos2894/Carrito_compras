<%@page import="Beans.*"%>
<%@page import="Models.*"%>
<%@page import="java.util.ArrayList"%>


<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart | E-Shopper</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    
    <script src="ajax/ajax.js" type="text/javascript"></script>
    <script src="jquery-ui-1.9.2.custom/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="js/jquery.js" type="text/javascript"></script>
    
<script type="text/javascript">

                 function   enviarZona() { // enviamos el id de text idp para que que me traiga el combo de atencion a oc.php
                var zone_cd = document.getElementById('region').value;
                
 
                var cadena = "zone_cd=" + zone_cd;
 
               
                var peticion = null;
                peticion = new XMLHttpRequest();
 
                if (peticion) {
                    peticion.open('POST',"ejecuciondeajax", false);
 
                    peticion.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                                     
                    peticion.send(cadena);
 
                   var zone = document.getElementById('resp').innerHTML = peticion.responseText;
                   //document.getElementById('Em_Pro').value=id;
                }
            }



</script>
    
    
</head><!--/head-->



<body>

    <jsp:include page="div_header.jsp"/>
    
    <form action="Registrar_venta">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
                                                        <td class="quantity">Impuesto</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
                                      
                                                <%
                                                    HttpSession sesion = request.getSession(true);
                                                    ArrayList<Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
                                                    
                                                    String item_cd = request.getParameter("idproducto");
                                                    double total = 0;
                                                    double shcost = 0;
                                                    int so_no = 0;
                                                    
                                                    if(articulos != null){
                                                   
                                                    int x=0;    
                                                    for(Articulo a: articulos){
                                                         x++;
                                                        Item_beans ib= new  Item_models().getItem_beans(a.getIdProducto());
                                                        //max_no m = new so_hea_models().getMax();
                                                        //so_no = m.getSo_no_max();
                                                        total += (a.getCantidad() * ib.getItem_unit_price_va())+(ib.getItem_tax_pe()*ib.getItem_unit_price_va())/10.0;
                                                        shcost += (a.getCantidad() * ib.getItem_tax_pe()/10);
                                                        
                                                %>
     
						<tr>
                                                  
                                                        <td name="item" class="cart_product">
                                                            <h4> <%=x %></h4>
                                                            <input type="hidden" name="li_no" value="<%=x%>"/>
							</td>
                                                        
							<td class="cart_product">
								<a href=""><img src="images/cart/one.png" alt=""></a>
							</td>
                                                                                         
                   
							<td class="cart_description">
								<h4><%=ib.getItem_ds()%></h4>
                                                                <input type="hidden" name="item_ds" value="<%=ib.getItem_ds()%>"/>
								<p><%=ib.getItem_cd()%></p>
                                                                <input type="hidden" name="item_cd" value="<%=ib.getItem_cd()%>"/>
							</td>
							<td class="cart_price">
								<p>$<%=ib.getItem_unit_price_va()%></p>
                                                                <input type="hidden" name="item_unit_p" value="<%=ib.getItem_unit_price_va()%>"/>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="<%=a.getCantidad()%>" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
                                                        <td class="cart_total">
								<p class="cart_price">$<%=Math.round(ib.getItem_tax_pe()*ib.getItem_unit_price_va())/10.0%></p>
                                                                <input type="hidden" name="impuesto" value="<%=Math.round(ib.getItem_tax_pe()*ib.getItem_unit_price_va())/10.0%>"/>
                                                        </td> 
							<td class="cart_total">
                                                                <input type="hidden" name="item_tax_pe" value="<%=ib.getItem_tax_pe()%>"/>
								<p class="cart_total_price">$<%= Math.round(((ib.getItem_unit_price_va()*a.getCantidad()*100.0) / 100.0)+(ib.getItem_tax_pe()*ib.getItem_unit_price_va())/10.0)%></p>
                                                                <input type="hidden" name="cart_tota_price" value="<%= Math.round(((ib.getItem_unit_price_va()*a.getCantidad()*100.0) / 100.0)+(ib.getItem_tax_pe()*ib.getItem_unit_price_va())/10.0)%>"/>
                                                        </td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
                                                        
						</tr>
                                                <%//}%>
                                                  <%}}%>
						
				
					</tbody>
				</table>
			</div>

	<section id="do_action">
		<div class="container">
			<div class="heading">
                            
                                 <%  
                                     so_hea_models shm = new so_hea_models();
                                     for(so_hea_beans shb : shm.getAllSo_he_det())
                                          {
                                      //max_no mn = new so_hea_models().getMax();
                                            %>
                                    <input type="hidden" name="so_no" value="<%=shb.getSo_no()%>">
                                    <label><%=shb.getSo_no()%></label>
                                    <label>marcos</label>
                                       <% } %>
				<h3>MARCOS</h3>
				<p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="chose_area">
                                             
						<ul class="user_option">
                                                             <li class="single_field">
                                                            
                                                                
								<label>Metodo de Pago</label>
                                                                <select name="paymet">
                                                                    <option>Seleccion Metode de pago</option>
                                                                    <%     
                                                                        Payment_models pm = new Payment_models();
                                                                        for(Payment_Beans pb : pm.listar_payment())
                                                                        {
                                                                    %>
                                                                        <option value="<%=pb.getPayment_cd()%>"> <%=pb.getPayment_ds()%> </option>
                                                                    <%  } %>
                                                                </select>
							</li>   
                                                    
						</ul>
						<ul class="user_info">
                                                    
                                               
                                                    
							<li class="single_field">
                                                            <input type="hidden" name="accion" value="RegistrarVenta">
                                                           
                                                             
                                                            <input type="hidden" name="cus_id" value="45636">
								<label>Zona:</label>
                                                                <select id="region" name="region" onchange="enviarZona()">
                                                                    <option>Seleccion Zona</option>
                                                                    <%   
                                                                Zone_models zm = new Zone_models();
                                                                for(Zone_beans zone : zm.getAllZone_models())
                                                                {
                                                                    %>
									<option  id="region" value="<%=zone.getZone_cd()%>"><%=zone.getZone_ds()%></option>
                                                               
								<% } %>
                                                                </select>
							</li>
							<li class="single_field">
                                                            <label>Region / State:</label>
       
                                                            <div id='resp' name="pais" /> </div>
							
							</li>
                                                        
							<li class="single_field zip-field">
								<label>Zip Code:</label>
								<input type="text">
							</li>
						</ul>
						<a class="btn btn-default update" href="">Get Quotes</a>
						<a class="btn btn-default check_out" href="">Continue</a>
					</div>
                                              
				</div>
				<div class="col-sm-6">
					<div class="total_area">
						<ul>    <li>Cart Sub Total <span>$<%=so_no%></span></li>
							<li>Cart Sub Total <span>$<%=total%></span></li>
                                                        <input type="hidden"  name="cart_sub_total" value="<%=total%>"/>
							<li>Eco Tax <span></span></li>
							<li>Shipping Cost <span><%=Math.rint((shcost)*10)/10%></span></li>
                                                        <input type="hidden"  name="shipping_cost" value="<%=Math.rint((shcost)*10)/10%>"/>
							<li>Total <span><%=total+Math.rint((shcost)*10)/10%></span></li>
                                                        <input type="hidden"  name="total" value="<%=total+Math.rint((shcost)*10)/10%>"/>
						</ul>
							<a class="btn btn-default update" href="">Update</a>
                                                        <input type="submit"  class="btn btn-default check_out" value="check out"/>
                                                      
					</div>
				</div>
			</div>
		</div>
         </form>                                    
	</section><!--/#do_action-->
           
	<footer id="footer"><!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="companyinfo">
							<h2><span>e</span>-shopper</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sed do eiusmod tempor</p>
						</div>
					</div>
					<div class="col-sm-7">
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe1.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe2.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe3.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe4.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="address">
							<img src="images/home/map.png" alt="" />
							<p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form>
		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Service</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Online Help</a></li>
								<li><a href="">Contact Us</a></li>
								<li><a href="">Order Status</a></li>
								<li><a href="">Change Location</a></li>
								<li><a href="">FAQ’s</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Quock Shop</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">T-Shirt</a></li>
								<li><a href="">Mens</a></li>
								<li><a href="">Womens</a></li>
								<li><a href="">Gift Cards</a></li>
								<li><a href="">Shoes</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Policies</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Terms of Use</a></li>
								<li><a href="">Privecy Policy</a></li>
								<li><a href="">Refund Policy</a></li>
								<li><a href="">Billing System</a></li>
								<li><a href="">Ticket System</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Company Information</a></li>
								<li><a href="">Careers</a></li>
								<li><a href="">Store Location</a></li>
								<li><a href="">Affillate Program</a></li>
								<li><a href="">Copyright</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3 col-sm-offset-1">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<form action="#" class="searchform">
								<input type="text" placeholder="Your email address" />
								<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
								<p>Get the most recent updates from <br />our site and be updated your self...</p>
							</form>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
					<p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>
				</div>
			</div>
		</div>
		
	</footer><!--/Footer-->
	


    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>