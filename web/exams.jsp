<%@page import="java.sql.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@include file="inc/header.jsp"  %>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<%
    if(request.getMethod().equals("POST")){
        out.println(request.getParameter("COURSES"));
    }
   
%>
<br>
        <h1 class="text-center badge-success" >Examination registration</h1><br>
        <div class="row" >
            <div class="col-4" >
                <form style="padding: 10px">
                    <div align="left">
                        <label class="form-label" style="font-size: 20px;color: #9999ff;">Student name</label>
                        <input type="text" class="form-control" placeholder="Student name" name="sname" id="sname" required/> 
                    </div>
                    <div alight="left">
                        <label class="form-label" style="font-size: 20px;color: #9999ff;">Course</label>
                        <input type="text" class="form-control" placeholder="Course" name="scourse" id="course" required/>
                        
                    </div>
                    <div alight="left">
                        <label class="form-label" style="font-size: 20px;color: #9999ff;" >Fee</label>
                        <input type="text" class="form-control" placeholder="Fee" name="fee" id="fee" required/>
                        
                    </div><br>
                    <div alight="right">
                        <input type="submit" id="btnCourses" value="SUBMIT" class="btn btn-info"/>
                        <input type="reset" id="rst" value="Reset"  name="rest" class="btn btn-warning"/>
                    </div>
                </form>
                
            </div>
            
            <div class="col-8">
                <div class="panel-body">
                    <table id="tbl-student" class="table table-responsive table-bordered " cellpadding="0 " width="100%">
                        <thead>
                            <tr>
                                <th>Student name </th>
                                <th>Course</th>
                                <th>Fee</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>   
            </div>
        <script  type="text/javascript" src="js/accounts.js">
            
        </script>
	<%@include file="inc/footer.jsp" %>
