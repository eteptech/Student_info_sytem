<%@include file="inc/header.jsp" %>
    <article id="registerArticle">
        <%String fpassword=pageContext.getServletContext().getContextPath()+"/fpassword";%>
    <hgroup>
	<h1>Forgotten Password</h1>
	<h5>Enter the fields below to change your password</h5>
    </hgroup>
    <div id="formDiv">
	<progress id="progressBar"></progress>
        <label id="checkProgress">
	    
        </label><br/>
        <form action="<%= fpassword%>">
	    <span id="spanfname">*</span><input type="text"id="fname" 
		   placeholder="Enter your first name."/>
	    
	   <span>*</span> <input type="text" id="lname"
                                 placeholder="Enter your last name"/>
	    
	    <span>*</span><input type="password"  id="psswd"
		   placeholder="Create a password. "/>
	    
	   <span>*</span> <input type="password" id="cpsswd" 
		   placeholder="Comfirm password"/>
	    
	    <br/>
            <p><em id="emassage"></em></p>
	 <span>*</span>   <input type="text"  id="email"
		 placeholder="Enter your email address" onblur="javascript:checkAvailability('MAIL');"/>
	    
	 <span>*</span>  <input type="text"   id="mobilenumber" 
		   placeholder="Enter phone number"/>
         <button type="submit" id="Submit" value="Change">Change</button>
          </form>   
    </div>
</article>
<%@include file="inc/footer.jsp" %>