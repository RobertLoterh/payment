<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PAYMENT SYSTEM</title>
</head>
<body>
   
   <f:view>
   
    <h:panelGrid columns="1" style="height:400px;width:500px;">
    
        <h:panelGrid id="header" style="height:100px;width:500px;">
             <h:panelGrid id="connected" rendered="#{main.connected}" style="height:100px;width:200px;">
                 <h:outputText value="Welcome #{main.connectedUser.mail_id}" />
                 <h:form>
                   <h:commandLink value="logout" action="#{main.disconnect}" />
                 </h:form>
             </h:panelGrid>
             <h:form>
                 <h:panelGrid id="notconnected" columns="3" rendered="#{!main.connected}" style="height:100px;width:200px;">                 
                   <h:outputText value="Mail ID"/>
                   <h:outputText value=": "/>
                   <h:inputText value="#{main.connectedUser.mail_id}"/>
                         
                   <h:outputText value="Password"></h:outputText>
                   <h:outputText value=": "></h:outputText>
                   <h:inputSecret value="#{main.connectedUser.password}"/>
                                      
                   <h:commandButton value="Sign in" action="#{main.connection}" />
                   <h:outputText value="error"/>   
                   <h:outputText value=""/>     
                   
                    <h:commandLink value="Sign up" action="#{main.signUp}" />   
                     
                </h:panelGrid>
             </h:form>
        </h:panelGrid> 
        
        
        
        
        <h:panelGrid id="body" style="height:300px;width:500px;">
          <h:panelGrid>
          <h:form>
              <h:outputText value=" Create an INVOICE " rendered="#{main.connected}"></h:outputText>
              <h:panelGrid columns="4" rendered="#{main.connected}"> 
                  <h:outputText value="To"></h:outputText>
                  <h:outputText value=" : "></h:outputText>
                  <h:inputText value="#{main.invoice.to_mail}"></h:inputText>
                  <h:outputText value=" error "></h:outputText>
       
                  <h:outputText value="value"></h:outputText>
                  <h:outputText value=" : "></h:outputText>
                  <h:inputText  value="#{main.invoice.value}"></h:inputText>
                  <h:outputText value=" error "></h:outputText>         
                  
                  <h:commandButton value="submit" action="#{main.insertInvoice}"/>
             </h:panelGrid>    
         </h:form>
         </h:panelGrid>
         
         <h:panelGrid>
         <h:dataTable value="#{main.invoices}" style="border:1px solid;" var="inv">
                <h:column>
    				<f:facet name="header">INVOICE ID</f:facet>
    				<h:outputText value=" #{inv.invoice_id}" />
    			</h:column>
                
                <h:column>
    				<f:facet name="header">TO</f:facet>
    				<h:outputText value=" #{inv.to_mail}" />
    			</h:column>
 
    			<h:column>
    				<f:facet name="header">VALUE</f:facet>
    				<h:outputText value=" #{inv.value}" />
    			</h:column>
 
    			<h:column>
    				<f:facet name="header">STATE</f:facet>
    				<h:outputText value=" #{inv.state}" />
    			</h:column>
    			
    			<h:column>
    				<f:facet name="header"></f:facet>
    				<h:form>
    				    
    				    <h:commandLink rendered="#{main.connected}" value="Edit" action="#{main.edit}"/>
    				    <h:outputText rendered="#{main.connected}" value=" || " />
    				    <h:commandLink rendered="#{main.connected}" value="Delete" action="#{main.delete}"/>
    				    <h:outputText rendered="#{main.connected}" value=" || " />
    				    <h:commandLink value="Pay" action="#{main.pay}"/>
    				       
    				    
    				</h:form>
    			</h:column>  
          </h:dataTable>
          </h:panelGrid>
       </h:panelGrid>  
        
    </h:panelGrid>
    
    
      
   
   </f:view>
   
</body>
</html>