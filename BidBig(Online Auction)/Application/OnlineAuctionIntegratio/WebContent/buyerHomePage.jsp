<%@page import="com.hsbc.dao.BidDAOImpl"%>
<%@page import="com.hsbc.background.EnumerationOfStatus"%>
<%@page import="com.hsbc.dao.ParticipantDAOImpl"%>
<%@page import="com.hsbc.model.Participant"%>

<%@page import="com.hsbc.model.ParticipationStatusType"%>
<%@page import="com.hsbc.enumm.BidStatusType"%>
<%@page import="com.hsbc.dao.DAO"%>
<%@page import="com.hsbc.dao.ProductDAOImpl"%>
<%@page import="com.hsbc.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hsbc.model.Bid"%>
<%@page import="java.util.List"%>
<%@page import="com.hsbc.model.Buyer"%>
<%@page import="com.hsbc.dao.UserDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <style><%@include file="/mystyle.css"%></style>
       <style><%@include file="/styleHome.css"%></style>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
        
</head>
<body>

 <%
				HttpSession httpSession=request.getSession(false);

                String username=null;
                long userid=0;
				if(httpSession!=null && httpSession.getAttribute("username")!=null)
					{
						String type=(String)httpSession.getAttribute("type");
						if(type.equals("buyer"))
							{
		
									username=(String)httpSession.getAttribute("username");
								//	String u=(String)httpSession.getAttribute("userid");
									userid=(Long)httpSession.getAttribute("userid");
									//userid=Long.parseLong(u);
								//	System.out.println(u);
							}
						else
							{
									response.sendRedirect("sellerHomePage.jsp");
							}
					}
				else
					{
						response.sendRedirect("home.jsp");
					}

		%>     
         <header>
         
          <div id="mySidenav" class="sidenav">
          <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a><br/><br/>
          <a href="buyerHomePage.jsp" style="font-size: medium;">Home</a>
         
          <a href="DeregisterSessionServlet?param=seller" style="font-size: medium;">Login as Seller</a>
          <a href="wallet.jsp" style="font-size: medium;">Update Wallet</a>
          <a href="DeregisterSessionServlet?param=logout" style="font-size: medium;">- Log Out -</a>
          
        </div>
        <span1 style=" position:absolute; top:0;left:0; font-size:25px;cursor:pointer" onclick="openNav()">&#9776;</span1>
              <h1>Bid<span>Big</span></h1>
              <br><br>
          
                 <div style="position: absolute; top: 0; right: 0; width: 100px; text-align:right;color: white">
                <h6>Welcome: <%=username %></h6>
                </div>
            
            
        <script>
            function openNav() {
                document.getElementById("mySidenav").style.width = "250px";
              }
              
              /* Set the width of the side navigation to 0 */
              function closeNav() {
                document.getElementById("mySidenav").style.width = "0";
              }   
              
              var yourDateToGo = new Date(); //here you're making new Date object
              yourDateToGo.setDate(yourDateToGo.getDate() + 1); //your're setting date in this object 1 day more from now
     
         var timing = setInterval( // you're making an interval - a thing, that is updating content after number of miliseconds, that you're writing after comma as second parameter
           function () {
     
             var currentDate = new Date().getTime(); //same thing as above
             var timeLeft = yourDateToGo - currentDate; //difference between time you set and now in miliseconds
     
             var days = Math.floor(timeLeft / (1000 * 60 * 60 * 24)); //conversion miliseconds on days 
             if (days < 10) days="0"+days; //if number of days is below 10, programm is writing "0" before 9, that's why you see "09" instead of "9"
             var hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)); //conversion miliseconds on hours
             if (hours < 10) hours="0"+hours;
             var minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60)); //conversion miliseconds on minutes 
             if (minutes < 10) minutes="0"+minutes;
             var seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);//conversion miliseconds on seconds
             if (seconds < 10) seconds="0"+seconds;
     
             document.getElementById("countdown").innerHTML = days + "d " + hours + "h " + minutes + "m " + seconds + "s"; // putting number of days, hours, minutes and seconds in div, 
             document.getElementById("countdown-one").innerHTML = days + "d " + hours + "h " + minutes + "m " + seconds + "s";
             document.getElementById("countdown-two").innerHTML = days + "d " + hours + "h " + minutes + "m " + seconds + "s"; 
            
             //which id is countdown
     
             if (timeLeft <= 0) {
               clearInterval(timing);
               document.getElementById("countdown").innerHTML = "It's over"; 
               document.getElementById("countdown-one").innerHTML = "It's over";
               document.getElementById("countdown-two").innerHTML = "It's over";
               //if there's no time left, programm in this 2 lines is clearing interval (nothing is counting now) 
               //and you see "It's over" instead of time left
             }
           }, 1000);
            </script>
           
            
                </header>
                <br><br>

              
        <div class="container">
            <center> <div>
              <h4>LIVE AUCTIONS</h4> 
             </div></center>
           </div>
           <br/><br/>

             <%
              UserDAOImpl daoImpl=new UserDAOImpl();
              ProductDAOImpl daoImpl2=new ProductDAOImpl();
              ParticipantDAOImpl daoImpl3=new ParticipantDAOImpl();
              BidDAOImpl bidDAOImpl=new BidDAOImpl();
              //username="Shanu";
              String type=daoImpl.getUserType(username);
              long buyerid=daoImpl.getUserID(username);
              Buyer buyer=new Buyer();
              Product product=new Product();
             
              Participant participant=new Participant();
             // Participant participant=new Participant();
      		  List<Bid> bids=new ArrayList<Bid>();
      		  List<Participant> participants=new ArrayList<Participant>();
      		  EnumerationOfStatus enumerationOfStatus=new EnumerationOfStatus();
      		  bids=bidDAOImpl.getAll();
               int i=1;
               %> 
        	   <div class="row">
               <div class="col-lg-2">
                 
               </div>
               <%
              
               for(Bid b:bids)
               {
            	  
            	   product=daoImpl2.getProduct(b.getProductId());
            	   String bidstatus=enumerationOfStatus.getValue(b.getStatusOfBid().name());
            	   double  maxvalue=b.getMaxBidValue();
            	   double minvalue=b.getMinBidValue();
            	   String startdate=b.getStartDate();
            	   String enddate=b.getEnddate();
            	  // String auctionstatus=enumerationOfStatus.getValue(participant.getParticipationStatusType().name());
            	   if(bidstatus.equals("Open"))
            	   {
            		   //System.out.println(i);
            	   if(i<=3)
                     {
            		   
            		   %>
            		   <div class="col-lg-3">
            	         <div class="card" style="width: 18rem;">
            	           <img src="https://i.ebayimg.com/images/g/0ugAAOSwhdFerpc3/s-l300.png" class="card-img-top" alt="..." style="width:300px" height="300px">
            	           <div class="card-body">
            	             <h5 class="card-title"><%=product.getName() %></h5>
            	             <p class="card-text">BID STATUS : <%=bidstatus %></p>
            	             <%--  <p class="card-text">YOUR BID STATUS :<%=auctionstatus %></p> --%>
            	               <p class="card-text">MAX BID VALUE : <%=maxvalue %></p>
            	                <p class="card-text">BASE BID VALUE : <%=minvalue %></p>
            	               <div><center><a href="bidnow.jsp?bidid=<%=b.getBidId() %>" class="btn btn-primary" style="height:45px">BID NOW</a></div></center>
            	                  
            	           </div>
            	           <ul class="list-group list-group-flush">
            	             <li class="list-group-item">START DATE : <%=startdate.substring(0, 10) %></li>
            	              <li class="list-group-item">END DATE : <%=enddate.substring(0, 10) %></li>
            	           </ul>
            	          
            	         </div>
            	         </div>
            	      <%
            	         i++;
                     }
            	   else
            	         {
            	        	  %> 
            	        	  </div>
            	        	   <div class="row">
            	               <div class="col-lg-2">
            	                 
            	               </div>
            	               </div>
            	               <br>
                               <br>
                               <br>
            	        	   <div class="row">
            	               <div class="col-lg-2">
            	                 
            	               </div>
            	               <div class="col-lg-3">
            	               <div class="card" style="width: 18rem;">
            	               <img src="https://i.ebayimg.com/images/g/0ugAAOSwhdFerpc3/s-l300.png" class="card-img-top" alt="..." style="width:300px" height="300px">
            	               <div class="card-body">
            	               <h5 class="card-title"><%=product.getName()  %></h5>
            	               <p class="card-text">BID STATUS : <%=bidstatus %></p>
            	             <%--   <p class="card-text">YOUR BID STATUS :<%=auctionstatus %></p> --%>
            	               <p class="card-text">MAX BID VALUE : <%=maxvalue %></p>
            	               <p class="card-text">BASE BID VALUE : <%=minvalue %></p>
            	               <div><center><a href="bidnow.jsp?bidid=<%=b.getBidId() %>" class="btn btn-primary" style="height:45px">BID NOW</a></div></center>
            	                  
            	           </div>
            	           <ul class="list-group list-group-flush">
            	             <li class="list-group-item">START DATE : <%=startdate.substring(0, 10) %></li>
            	              <li class="list-group-item">END DATE : <%=enddate.substring(0, 10) %></li>
            	           </ul>
            	          
            	         </div>
            	         </div>
            	               <%
            	        	 i=2;
            	         }
            	        	
               }
               }
               

          %>
          </div>
          <footer class="footer-distributed"> 

   <footer class="footer-distributed">    
        

    <div class="footer-left">

        <h3>Bid<span>Big</span></h3>

        <p class="footer-links">
            <a href="#">Terms & Conditions</a>
            ·
            <a href="#">Hot Products</a>
            ·
            <a href="#">Legal Terms of use</a>
            ·
            <a href="#">Privacy</a>
            ·
            <a href="#">FAQs</a>
            ·
            <a href="#">Partnership</a>
            ·
            <a href="#">About Us</a>
            ·
            <a href="#">Contact Us</a>
            
        </p> <br>

        <p class="footer-company-name">Bidbig &copy; 2020</p>
    </div>

    <div class="footer-center">

        <div>
            <i class="fa fa-map-marker"></i>
            <p><span>21 Young Road</span> Delhi, India</p>
        </div>

        <div>
            <i class="fa fa-phone"></i>
            <p>+1 222 654899</p>
        </div>

        <div>
            <i class="fa fa-envelope"></i>
            <p><a href="mailto:support@company.com">contact@bidbig.com</a></p>
        </div>

    </div>

    <div class="footer-right">

        <p class="footer-company-about">
            <span>About the company</span>
            BidBig is India's leading and reputed private online auction portal operating in 
            the specialised space of buying and selling surplus inventory.
        </p>

        <div class="footer-icons">

            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-github"></i></a>

        </div>

    </div>

</footer>

    </body>
</html>