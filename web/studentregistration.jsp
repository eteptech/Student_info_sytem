<%@include file="inc/header.jsp" %>
<article id="registerArticle">
    <hgroup>
	<h1>Register for test</h1>
	<h5>Register for test and all other features</h5>
    </hgroup>
    <div id="formDiv">
	<progress id="progressBar"></progress>
        <label id="checkProgress">
	    
        </label><br/>
	<form >
	    <span id="spanfname">*</span><input type="text"id="fname" 
		   placeholder="Enter your first name."/>
	    
	   <span>*</span> <input type="text" id="lname"
                                 placeholder="Enter your last name"/>
           <p><em id="umassage"></em></p>
	   <span>*</span> <input type="text" id="uname"
		   placeholder="Choose a user name."  onblur="javascript:checkAvailability('USERNAME');"/>
	    <br/>
	    
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
	    
         <span>*</span><input type="text"  id="dob" 
		   placeholder="Date of birth DD/MM/YYY"/>
	  <span>*</span>  <select id="gender">
		<option value="-1">-Gender-</option>
                <option value="0">Male</option>
                <option  value="1">Female</option>
	    </select>
	    <br/><br/>
	    <small> &nbsp;&nbsp;Enter Your Full Address here.</small>
	    <textarea id="address" >

	    </textarea>
	    
	    <input type="submit" id="SubmitButton" value="Register"/>
       </form>   
    </div>
</article>
<script type="text/javascript" src="js/accounts.js">
	
</script>
<%@include file="inc/footer.jsp" %>
