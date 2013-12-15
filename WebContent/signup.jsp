<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
<script type="text/javascript">
  function check(){
	  if(document.getElementById("signup:password").value == document.getElementById("signup:confirm").value)
	   {  
		      return true;
	      
	       
		}
	  else{
		  alert("You have entered different password");
		  return false;
	  }
		  
		  
  }
</script>
</head>
<body>
<f:view>
   <h:form id="signup">
                 <h:panelGrid id="notconnected" columns="3" rendered="#{!main.connected}" style="height:100px;width:200px;">                 
                   <h:outputText value="Mail ID"/>
                   <h:outputText value=": "/>
                   <h:inputText value="#{main.connectedUser.mail_id}"/>
                         
                   <h:outputText value="Password"></h:outputText>
                   <h:outputText value=": "></h:outputText>
                   <h:inputSecret id="password" value="#{main.connectedUser.password}"/>
                   
                   <h:outputText value="Confirm Password"></h:outputText>
                   <h:outputText value=": "></h:outputText>
                   <h:inputSecret id="confirm" value="#{main.connectedUser.password}"/>
                                      
                   <h:commandButton value="Sign in" onclick="javascript:return check()" action="#{main.createUser}" />
                   <h:commandLink value="Back" action="#{main.back}" />   
                     
                </h:panelGrid>
             </h:form>

</f:view>

</body>
</html>