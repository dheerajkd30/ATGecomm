<%--
  Shows a "Phone" link.

  Required parameters:
    None

  Optional parameters:
    None

  NOTES:
    1) The "mobileImagesPrefix" request-scoped variable (request attribute), which is used here,
       is defined in the "mobilePageContainer" tag ("mobilePageContainer.tag" file).
       This variable becomes available within the <crs:mobilePageContainer> ... </crs:mobilePageContainer> block
       and in all the included pages (gadgets and Endeca cartridges).
--%>
<dsp:page>
  <fmt:message var="phoneLabel" key="mobile.common.phone"/>
  <a class="contact" href="tel:<fmt:message key='mobile.contactUs.phoneNumber'/>" title="${phoneLabel}">
    <span class="tel"/>
  </a>  
  <a class="contact" href="tel:<fmt:message key='mobile.contactUs.phoneNumber'/>" title="${phoneLabel}">    
    <span>${phoneLabel}</span>
  </a>
</dsp:page>
<%-- @version $Id: //hosting-blueprint/B2CBlueprint/version/11.1/Storefront/j2ee/store.war/mobile/includes/gadgets/phone.jsp#2 $$Change: 883241 $ --%>
