<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
    history.forward();
</script>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Seller Login</title>
    <style>
        h1 {
            font-weight: 400;
        }

        #username {
            width: 60%;
        }

        #password {
            width: 60%;
        }

        #forgotpassword {
            margin-left: 1%;
            font-weight: 650;
            font-size: small;
        }


        label {
            font-weight: 650;
            font-size: small;
        }

        p {
            font-weight: 500;
            font-size: small;
        }

        form {
            border: 2px solid gray;
            max-width: 400px;
            border-radius: 5%;
        }

        #usernamelabel {
            margin-left: -37%;
        }

        #checkboxdiv {
            margin-left: -32%;
        }

        .termsp {
            margin-left: 0%;
            font-size: small;
            font-weight: 650;
        }

        #otherlogin {
            font-size: medium;
            margin-left: 18%;
        }
    </style>
    <script>
    history.forward();
    </script>
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
	
}

%>
    <center><br>
        <form action="LoginServlet" method="post">
            <h1>Sign In</h1><br><%
            String err=(String)request.getAttribute("error");
            if(err!=null)
            	out.println(err);
            
            %><br/><br/><strong>- &nbsp;&nbsp; Hello Seller ! &nbsp;&nbsp; -</strong><br /> <br />
            <label for="username" id="usernamelabel">Username</label><br />
            <input type="text" name="username" id="username" required="required" /><br />
            <label for="password">Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><a href=""
                id="forgotpassword">Forgot your password?</a><br />
            <input type="password" name="password" id="password" required="required" /><br />
            <div class="form-check" id="checkboxdiv">
                <input class="form-check-input" type="checkbox" value="" id="remembercheck" />
                <label class="form-check-label" for="remembercheck">Remember Me</label>
            </div><br />
            <button class="btn btn-outline-primary" type="submit" id="signinbutton">Sign In</button><br /><br />
            <p class="termsp">By continuing, you agree to BidBig's<br />
                <a href="">Conditions of Use</a> and <a href="">Privacy Notice</a>.</p>
            <p>New to BidBig?</p>
            <a class="btn btn-link" href="registerSeller.jsp">Create Your BidBig Seller Account</a><br/>
            <pre>&nbsp;</pre>
        </form>
        <p id="otherlogin">Go to <a href="loginBuyer.jsp">Buyer Login</a></p>

    </center>
</body>

</html>