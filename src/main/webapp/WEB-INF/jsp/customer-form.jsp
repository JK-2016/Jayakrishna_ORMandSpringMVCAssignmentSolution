<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>Student Registration</h2>

      <form:form method = "POST" action = "registerCustomer" >
         <table>
            <!--tr>
                <td><form:label path = "id">Id</form:label></td>
                <td><form:input path = "id" /></td>
            </tr-->
            <form:hidden path="id" />
            <tr>
               <td><form:label path = "fname">First Name</form:label></td>
               <td><form:input path = "fname" /></td>
            </tr>
            <tr>
               <td><form:label path = "lname">Last Name</form:label></td>
               <td><form:input path = "lname" /></td>
            </tr>
			<tr>
               <td><form:label path = "email">Email</form:label></td>
               <td><form:input type="email"  path = "email" /></td>
            </tr>

            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Save"/>
               </td>
            </tr>
         </table>
      </form:form>
   </body>

</html>