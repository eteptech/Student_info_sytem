$(document).ready(function() {
    
});
$("#SubmitButton").click(function (){
    //$("#progressBar").show();
    var userDetails ={
        fname               :$("#fname").val(),
        lname               :$("#lname").val(),
        uname               :$("#uname").val(),
        psswd               :$("#psswd").val(),
        cpsswd              :$("#cpsswd").val(),
        email               :$("#email").val(),
        mobilenumber        :$("#mobilenumber").val(),
        dob                 :$("#dob").val(),
        gender              :$("#gender").val(),
        address             :$("#address").val()
    };   
        if(!userDetails.fname.match((/^([A-Za-z]{3,20}$)/i))){
            $("#checkProgress").text("Please enter a valid first name");
            $("#fname").focus();
            $("#fname").css("border","1px solid red");
            return false;
        }
        if(!userDetails.lname.match(/^([A-Za-z]{3,20}$)/i)){
            $("#checkProgress").text("Please enter a valid last name");
            $("#lname").focus();
            $("#lname").css("border","1px solid red");
            $('#fname').css("border","1px black dashed");
            return false;
        }
        if(!userDetails.uname.match(/^([A-Za-z]{3,20}$)/i)){
            $("#checkProgress").text("Please enter a valid username");
            $("#uname").focus();
            $("#uname").css("border","1px solid red");
            $('#lname').css("border","1px black dashed");
            return false;
        }
        if(!userDetails.psswd.match(/^([A-Za-z0-9]{8,30}$)/i)){
            $("#checkProgress").text("Enter a strong password");
            $("#psswd").focus();
            $("#psswd").css("border","1px solid red");
            $('#uname').css("border","1px black dashed");
            return false;
        }
        if(userDetails.psswd!==userDetails.cpsswd){
            $("#checkProgress").text("password and confirm password do not matched");
            $("#cpsswd").focus();
            $("#cpsswd").css("border","1px solid red");
            $('#psswd').css("border","1px black dashed");
            return false;
            
        }
        if(!userDetails.email.match(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/i)){
            $("#checkProgress").text("please enter a valid email address");
            $('#email').focus();
            $('#email').css("border","1px solid red");
            $('#cpsswd').css("border","1px black dashed");
            return false;
        }
        if(!userDetails.mobilenumber.match(/^([0]\d{10}$)/i)){
            $("#checkProgress").text("please enter a valid email mobile number");
            $("#mobilenumber").focus();
            $("#mobilenumber").css("border","1px solid red");
            $('#email').css("border","1px black dashed");
            return false;  
        }
       if(!userDetails.dob.match((/(\d+)(-|\/)(\d+)(?:-|\/)(?:(\d+)\s+(\d+):(\d+)(?::(\d+))?(?:\.(\d+))?)?/i))){
            $("#checkProgress").text("please give a valid date of birth " +"e.g YYYY-MM-DD");
            $("#dob").focus();
            $("#dob").css("border","1px solid red");
            return false;
        }
        $("#progressBar").show();
        $.ajax({
            type:"POST",
            url:"components/register.jsp",
            data: {USERDETAILS: JSON.stringify(userDetails)},
            success: function (data) {
                $("#progressBar").hide();
                $("#checkProgress").fadeOut(150);
                $("#checkProgress").text(data);
                $("#checkProgress").fadeIn(1500);
                $("#checkProgress").focus();
                $('#SubmitButton').html("Saving please wait...");
            }
        }); 
    return false;
}); 
function checkAvailability(val) {
    var option="";
    if(val==='USERNAME'){
       option=$("#uname").val(); 
    }else if(val==="MAIL"){
        option=$('#email').val();
    } else{
       option=""; 
    }
    if (option.length>2){
        $.ajax({
            type: 'GET',
            url: "components/register.jsp",
            data: {VALUE:val, OPTION:option},
            success: function (option) {
                option=$.trim(option);
                if(option==="Username not available"){
                    $('#uname').css("border-color","red");
                    $('#uname').css("color","red");
                    $("#umassage").html("Username not Available").css("color","red");
                }else if(option==="Username available"){
                    $("#uname").css("border-color","green");
                    $('#uname').css("color","green");
                    $("#umassage").html("Username available").css("color",'green');
                    }   
                else if(option==="Email not available"){
                    $("#email").css("border-color","red");
                    $("#email").css("color","red");
                    $("#emassage").css("color","red").html("Email not available");
                }else if (option==="Email available"){
                    $("#email").css("border-color","green");
                    $("#email").css("color","green");   
                    $("#emassage").css("color","green").html("Email available");
                }
            }
        });
    }else{
    }
}
$("#loginbtn").click(function (){
    var userName=$('#txtusername');
    var userpass=$('#txtPassword');
    var remember=$('#txtRemember').prop("checked");
    if(!userName.val().match(/^([A-Za-z._@]{3,20}$)/i)){
        $("#display").fadeOut();
        $("#display").text("Invalid username");
        $("#display").fadeIn(200);
        userName.css("border","2px solid red");
        userName.focus();
        return false; 
    }
    if (!userpass.val().match(/^([A-Za-z_0-9]{8,30}$)/i)){
        $("#display").fadeOut();
        $('#display').text("Invalid passord");
        userpass.css("border","2px solid red");
        $("#display").fadeIn(200);
        userpass.focus();
        return false;
    }
    $(".loginprogress").show();
    $("#loginbtn").val("Loging In...");
    $.ajax({
        type    :"POST",
        url     :"login.jsp",
        data    :{UNAME:userName.val(), PASSWRD:userpass.val(), REMEMBER:remember},
        success :function (data){
            
            data=$.trim(data);
            alert(data);
            if( data==="SUCCESS" ){
                
                document.location="profile.jsp";
            }else{
            $("#display").html(data);
            $(".loginprogress").hide();
            $("#loginbtn").val("Login");
        }
        } 
    });
    return false;
});
$("#btnSubmit").click(function () {
    alert("");
    
});

$("#btnCourses").click(function () {
    
    let coursereg={
    
   
    studentName :$('#sname').val(),
    couseName   :$("#course").val(),
    courseFee   :$("#fee").val()
    };
    
    $.ajax({
        
        type: 'POST',
        url: "components/CourseRegistration.jsp",
        data:{COURSES:JSON.stringify(coursereg)},
        success: function (data) {
        alert(data);
            
        }
        
    });
    return false;
    
});
 
 