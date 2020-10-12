<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >
        <title>Seller Profile</title>
		<meta name="description" content="text/html;">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style><%@include file="/mystyle.css"%></style>
       <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
      
</head>

    <body> 


      <div class="header">
        <div id="mySidenav" class="sidenav">
          <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
          <a href="#" style="font-size: medium;">Most popular auctions</a>
          <a href="#" style="font-size: medium;">Popular today</a>
          <a href="#" style="font-size: medium;">Popular auctions</a>
          <a href="#" style="font-size: medium;">All categories</a>
          <a href="loginSeller.jsp" style="font-size: medium;">Seller account login</a>
           <a href="buyerHomePage.jsp" style="font-size: medium;">- Log Out -</a>
        </div>
        <span style="font-size:25px;cursor:pointer" onclick="openNav()">&#9776;</span>
        
        <script>
        function openNav() {
          document.getElementById("mySidenav").style.width = "250px";
        }
        
        function closeNav() {
          document.getElementById("mySidenav").style.width = "0";
        }
        </script>

          <a class="searchbar">
            <input type="text"  placeholder="Search here ">
          </a>

          <a href="sellerProfile.jsp">Hello user</a>
        
      </div>

      <div class="container">
      <button class="btn"><i class="fa fa-home"> </i> Home</button> 
        <a style="padding-left: 900px;"> Hello, Seller !</a>
      <br> <br></div><br>

      <div class="container">
	      <div class="row">
        <div class="profile-header-container">   
    		<div class="profile-header-img">
                <img class="rounded-circle" height="200px" width="200px" src="https://upload.wikimedia.org/wikipedia/en/thumb/0/02/The_Amazing_Spider-Man_theatrical_poster.jpeg/220px-The_Amazing_Spider-Man_theatrical_poster.jpeg" />
                
                
                <div class="rank-label-container"><br>
                    <span class="label label-default rank-label">10 followers | 10 following</span>
                </div>
            </div>
        </div>   
        <pre style="font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;">
        


        user bio rahega yahaa pe masst sa user bio 
        rahega yahaa pe masst sa user bio rahega yahaa pe masst sa 
        and also basic info bhi
        </pre>
	      </div> 
      </div>

        <div class="container" >
          <br><br><br><br>       
            <center><div> 
            <button type="button" class="btn btn-outline-secondary" onclick="addProd()">
              <a > <img src="https://image.flaticon.com/icons/png/512/120/120069.png" width="60px" height="60px" alt="imghere">
                    &nbsp; &nbsp; Add Auction </a> 
            </button> &nbsp; &nbsp;

            <script>
              function addProd(){
                location.replace("sellerAddProduct.jsp");
              }
            </script>
           
            <button type="button" class="btn btn-outline-secondary" onclick="yourHistory()">
              <a > <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/GNOME_Todo_icon_2019.svg/1200px-GNOME_Todo_icon_2019.svg.png" width="60px" height="60px" alt="imghere">
                    &nbsp; &nbsp; Your Actions</a> 
            </button>&nbsp; &nbsp;
             <script>
              function yourHistory(){
                location.replace("Merchant_auction_history.jsp");
              }
            </script>

            <button type="button" class="btn btn-outline-secondary">
              <a > <img src="https://img.pngio.com/blue-circle-lock-privacy-safe-secure-security-icon-security-icon-png-512_512.png" width="65px" height="60px" alt="imghere">
                    &nbsp;  Your Security </a> 
            </button> <br> <br>

            <button type="button" class="btn btn-outline-secondary">
              <a > <img src="https://cdn4.iconfinder.com/data/icons/contact-us-set-1-5/64/Untitled-3-25-512.png" width="56x" height="60px" alt="imghere">
                    &nbsp; &nbsp; Add Address </a> 
            </button>&nbsp; &nbsp;
           
            <button type="button" class="btn btn-outline-secondary" onclick="payment()">
              <a > <img src="https://images.vexels.com/media/users/3/137089/isolated/preview/c3286d4d32fa90ebcf09b488654612b9-wallet-icon-by-vexels.png" width="64px" height="60px" alt="imghere">
                    &nbsp; &nbsp; Your Wallets </a> 
            </button>&nbsp; &nbsp;
            <script>
              function payment(){
                location.replace("Payment.jsp");
              }
            </script>

            <button type="button" class="btn btn-outline-secondary">
              <a > <img src="https://cdn1.iconfinder.com/data/icons/gdpr-outline/48/gdpr-outline-14-512.png" width="60px" height="60px" alt="imghere">
                    &nbsp;  Personal data </a> 
            </button>
          </div>
        </center> 
            <br><br><br><br><br><br><br><br><br><br>
            <hr >
                      
            <div class="row">
              <div class="col-lg-3">

              </div>

              <div class="col-lg-3">
                <h6>Bidbig's online auction rules</h6> <hr>
                <ul style="font-size: small;">
                  <li>Group bidding not allowed</li>
                  <li>Do not use 3rd party bidding softwares</li>
                  <li>Violation of rules will result in suspension of your acount</li>
                </ul>
                
                
              </div>
              <div class="col-lg-3">
                <h6>Secure and safe online bidding</h6> <hr>
                <p style="font-size: x-small;"> Bidig adheres to some random security kuch bhi bakwaas ye woo, some random stuff regarding security compliances. some random stuff regarding security compliances.</p>
                
              </div>
              <div class="col-lg-3">
                
                
              </div>
              
              
            </div>

           
         </div>

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