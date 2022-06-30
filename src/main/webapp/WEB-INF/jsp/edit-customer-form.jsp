<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>Update Customer</title>
   </head>

   <body>
      <h1>Customer Relationship Management</h1>
      <h2>Save Customer</h2>

      <form:form method = "POST" action = "update" >
         <table>
            <!--tr>
                <td><form:label path = "id">Id of Student to be updated</form:label></td>
                <td><form:input readonly="true"  path = "id" /></td>
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