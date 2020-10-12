<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
    history.forward();
</script>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Seller Registration</title>
    <style>
        h1 {
            font-weight: 400;
        }

        .inputtag {
            width: 62%;
        }

        #createaccountbutton {
            color: black;
            font-weight: 500;
        }

        label {
            font-weight: 650;
            font-size: small;
        }

        p {
            font-weight: 650;
            font-size: small;
        }

        form {
            border: 2px solid gray;
            max-width: 400px;
            border-radius: 5%;
        }

        .termsp {
            margin-left: 0%;
            font-size: small;
            font-weight: 650;
        }
        #namelabel {
            margin-left: -53%;
        }
        #emaillabel {
            margin-left: -53%;
        }
        #mobilelabel {
            margin-left: -39%;
        }
        #doblabel {
            margin-left: -42%;
        }
        #passwordlabel {
            margin-left: -48%;
        }
        #repasswordlabel {
            margin-left: -33%;
        }
    </style>
</head>

<body>
<%
HttpSession httpSession=request.getSession(false);
String referer = request.getHeader("Referer");
String refererpage=new String();
if(referer!=null)
{
String st[]=referer.split("/");
 refererpage=st[st.length-1];
}

if(httpSession!=null && httpSession.getAttribute("username")!=null)
{
	String type=(String)httpSession.getAttribute("type");
	if(type.equals("seller"))
	{
		
	    response.sendRedirect("sellerHomePage.jsp");
	}
	else
	{
		response.sendRedirect("buyerHomePage.jsp");
	}
}
else
{
	//response.sendRedirect("sellerHomePage.jsp");
}
%>
    <center><br>
        <form action="RegisterServlet" method="post">
            <h1>Create Account</h1><br><%
            String err=(String)request.getAttribute("error");
            if(err!=null)
            	out.println(err);
            
            %><br/><br/><strong>- &nbsp;&nbsp;  Hello Seller ! &nbsp;&nbsp; -</strong><br /><br />
            <label for="name" id="namelabel">Name</label><br />
            <input type="text" name="name" id="name" class="inputtag" required="required"/><br />
             <label for="email" id="emaillabel">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Username</label><br/>
            <input type="text" name="username" id="email" class="inputtag" required="required"/><br />
            <label for="email" id="emaillabel">Email</label><br/>
            <input type="email" name="email" id="email" class="inputtag" required="required"/><br />
            <label for="mobile" id="mobilelabel">Phone Number</label><br/>
            <input type="number" name="mobile" id="mobile" class="inputtag" required="required"/><br/>
             <label for="email" id="emaillabel">&nbsp;&nbsp;&nbsp;&nbsp;Address</label><br/>
            <input type="text" name="address" id="email" class="inputtag" /><br />
            <label for="dob" id="doblabel">Date Of Birth</label><br/>
            <input type="date" name="dob" id="dob" class="inputtag" required="required"/><br/>
            <label for="password" id="passwordlabel">Password</label><br/>
            <input type="password" name="password" id="password" class="inputtag" required="required"/><br/><br/>
            
            <button type="submit" id="createaccountbutton" class="btn btn-light">Create your BidBig Seller Account</button><br /><br />
            <p class="termsp">By continuing, you agree to BidBig's<br />
                <a href="">Conditions of Use</a> and <a href="">Privacy Notice</a>.</p>
            <p>Already have an account? <a href="loginSeller.jsp">Sign In</a></p>
            <pre>&nbsp;</pre>
        </form><br>
        
        <p id="otherlogin"><a href="registerBuyer.jsp">Register as Buyer</a></p>
    </center>
</body>

</html>