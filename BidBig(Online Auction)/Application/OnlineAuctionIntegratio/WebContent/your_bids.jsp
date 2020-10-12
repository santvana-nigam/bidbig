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
<meta charset="ISO-8859-1">
<title>Your Bids</title>
<link rel="stylesheet" href="your_won_bids_style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
        
</head>
<body>
        <header>
        <center><h1>Bid<span>Big</span></h1></center>
        </header>
        <br/>  
        <div class="container">
            <center> <div>
              <h4>YOUR BIDS</h4> 
             </div></center>
           </div>
           <br/><br/>

             <%
              UserDAOImpl daoImpl=new UserDAOImpl();
              ProductDAOImpl daoImpl2=new ProductDAOImpl();
              ParticipantDAOImpl daoImpl3=new ParticipantDAOImpl();
              String username="Shanu";
              String type=daoImpl.getUserType(username);
              long buyerid=daoImpl.getUserID(username);
              Buyer buyer=new Buyer();
              Product product=new Product();
              Participant participant=new Participant();
             // Participant participant=new Participant();
      		  List<Bid> bids=new ArrayList<Bid>();
      		  List<Participant> participants=new ArrayList<Participant>();
      		 EnumerationOfStatus enumerationOfStatus=new EnumerationOfStatus();
      		  bids=buyer.getAllParticipatedBids(buyerid);
               int i=1;
               %> 
        	   <div class="row">
               <div class="col-lg-2">
                 
               </div>
               <%
              
               for(Bid b:bids)
               {
            	   product=daoImpl2.getProduct(b.getProductId());
            	   participants=daoImpl3.getAllParticipantsOfBid(b.getBidId());
            	   for(Participant p:participants)
            	   {
            		   if(p.getBuyerId()==buyerid)
            			   participant=daoImpl3.getParticipant(p.getParticipantId());
            	   }
            	   System.out.println(participant);
            	   String name=product.getName();
            	 
            	   String bidstatus=enumerationOfStatus.getValue(b.getStatusOfBid().name());
            	   double  maxvalue=b.getMaxBidValue();
            	   double minvalue=b.getMinBidValue();
            	   String startdate=b.getStartDate();
            	   String enddate=b.getEnddate();
            	   String auctionstatus=enumerationOfStatus.getValue(participant.getParticipationStatusType().name());
            	   if(i<=3)
                     {
            		   
            		   %>
            		   <div class="col-lg-3">
            	         <div class="card" style="width: 18rem;">
            	           <img src="https://i.ebayimg.com/images/g/0ugAAOSwhdFerpc3/s-l300.png" class="card-img-top" alt="..." style="width:300px" height="300px">
            	           <div class="card-body">
            	             <h5 class="card-title"><%=name %></h5>
            	             <p class="card-text">BID STATUS : <%=bidstatus %></p>
            	              <p class="card-text">YOUR BID STATUS :<%=auctionstatus %></p>
            	               <p class="card-text">MAX BID VALUE : <%=maxvalue %></p>
            	                <p class="card-text">BASE BID VALUE : <%=minvalue %></p>
            	              
            	                  
            	           </div>
            	           <ul class="list-group list-group-flush">
            	             <li class="list-group-item">START DATE : <%=startdate %></li>
            	              <li class="list-group-item">END DATE : <%=enddate %></li>
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
            	            <h5 class="card-title"><%=name %></h5>
            	             <p class="card-text">BID STATUS : <%=bidstatus %></p>
            	              <p class="card-text">YOUR BID STATUS :<%=auctionstatus %></p>
            	               <p class="card-text">MAX BID VALUE : <%=maxvalue %></p>
            	                <p class="card-text">BASE BID VALUE : <%=minvalue %></p>
            	              
            	                  
            	           </div>
            	           <ul class="list-group list-group-flush">
            	             <li class="list-group-item">START DATE : <%=startdate %></li>
            	              <li class="list-group-item">END DATE : <%=enddate %></li>
            	           </ul>
            	          
            	         </div>
            	         </div>
            	               <%
            	        	 i=1;
            	         }
            	        	
               }
               

          %>
          </div>


    </body>
</html>