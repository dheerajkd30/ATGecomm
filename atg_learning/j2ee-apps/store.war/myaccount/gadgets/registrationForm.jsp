<%--
  Registration form gadget, should be inside of the <form> tag.
  
  Required parameters:
    formHandler
      Form handler to use for registration
    email
      new user email
      
  Optional parameters:
    None         
--%>
<dsp:importbean bean="/atg/core/i18n/LocaleTools"/>
<dsp:importbean bean="/atg/dynamo/droplet/Compare"/>
<dsp:importbean bean="/atg/dynamo/droplet/PossibleValues"/>
<dsp:importbean bean="/atg/store/StoreConfiguration"/>
<dsp:importbean bean="/atg/userprofiling/Profile"/>
<dsp:importbean bean="/atg/userprofiling/ProfileAdapterRepository"/>
<dsp:importbean bean="/atg/userprofiling/PropertyManager"/>

<dsp:getvalueof var="contextPath" vartype="java.lang.String" bean="/OriginatingRequest.contextPath"/>

<dsp:importbean bean="/atg/store/profile/RegistrationFormHandler"/>
<dsp:importbean bean="/atg/store/order/purchase/BillingFormHandler" />

<dsp:getvalueof var="formHandler" param="formHandler"/>

<dsp:page>
<p class="atg_store_registrationMessage">
  <fmt:message key="myaccount_registerOnce.title"/>
</p>
  <ul class="atg_store_basicForm">
    
    <!-- Register once text -->
    <li class="atg_store_registerEmail">
      <%-- Only populate the email address field when new user --%>
      <dsp:getvalueof var="email" vartype="java.lang.String" param="email"/>
      <c:if test="${empty email}">
        <dsp:getvalueof var="email" vartype="java.lang.String" bean="${formHandler}.value.email"/>
      </c:if>

      <label for="atg_store_registerEmailAddress" class="required">
        <fmt:message key="common.email" />
        <span class="required">*</span>
      </label>

      <dsp:input bean="${formHandler}.value.email" maxlength="255"
                 iclass="text" type="text" required="true"
                 id="atg_store_registerEmailAddress" value="${email}"/>
    </li>

    <li class="atg_store_registerPassword">
      <label for="atg_store_registerPassword" class="required">
        <fmt:message key="common.createPassword" />
        <span class="required">*</span>
      </label>            
      <fmt:message var="defaultMessage" key="common.passwordCharacters" />
      <dsp:input bean="${formHandler}.value.password"
                 type="password" required="true" iclass="text"
                 id="atg_store_registerPassword" value=""/>
     
       <span class="example">${defaultMessage}</span>
    </li>

    <li class="atg_store_registerConfirmPassword">

      <label for="atg_store_registerRetypePassword" class="required">
        <fmt:message key="common.confirmPassword" />
        <span class="required">*</span>
      </label>

      <dsp:input bean="${formHandler}.value.confirmPassword"
                 type="password" required="true" iclass="text"
                 id="atg_store_registerRetypePassword" value=""/>
      
    </li>

    <li class="atg_store_registerFirstName">
      <label for="atg_store_registerFirstName" class="required">
        <fmt:message key="common.firstName"/>
        <span class="required">*</span>
      </label>         
      <dsp:input bean="${formHandler}.value.firstName"
                 type="text" required="true" iclass="text"
                 id="atg_store_registerFirstName"/>
   </li>

   <li class="atg_store_registerLastName">
     <label for="atg_store_registerLastName" class="required">
        <fmt:message key="common.lastName"/>
        <span class="required">*</span>
      </label>
    
      <dsp:input bean="${formHandler}.value.lastName"
                 type="text" required="true" iclass="text"
                 id="atg_store_registerLastName">
             </dsp:input>  
			 
<dsp:input bean="${formHandler}.value.homeAddress.address1"  type="text" value="Mumabi"/>
<dsp:input bean="${formHandler}.value.homeAddress.city"  type="text" value="Mumabi"/>
<dsp:input bean="${formHandler}.value.homeAddress.state"  type="text" value="PR"/>
<dsp:input bean="${formHandler}.value.homeAddress.postalCode"  type="text" value="604"/>	
   </li>  
   </ul> 
 
</dsp:page>