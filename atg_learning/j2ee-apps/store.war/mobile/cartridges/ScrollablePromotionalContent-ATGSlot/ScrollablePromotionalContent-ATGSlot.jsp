<%--
  Renders html for promotional items (top) slot.

  Page includes:
    /mobile/promo/gadgets/homePagePromotionalCell.jsp - Renders promotional item cell html

  Required Parameters:
    None

  Optional Parameters:
    None

  NOTES:
    1) The "mobileStorePrefix" request-scoped variable (request attribute), which is used here,
       is defined in the "mobilePageContainer" tag ("mobilePageContainer.tag" file).
       This variable becomes available within the <crs:mobilePageContainer> ... </crs:mobilePageContainer> block
       and in all the included pages (gadgets and Endeca cartridges).
--%>
<dsp:page>
  <dsp:importbean bean="/atg/store/droplet/ItemValidatorDroplet" />
  <dsp:importbean bean="/OriginatingRequest" var="originatingRequest" />

  <dsp:getvalueof var="contentItem" vartype="com.endeca.infront.assembler.ContentItem" value="${originatingRequest.contentItem}" />
  <dsp:getvalueof var="totalNumItems" value="${fn:length(contentItem['atg:contents'].items)}"/>
  
  <c:forEach var="promotionalContent" items="${contentItem['atg:contents'].items}" varStatus="status">
  
    <c:if test="${status.first}">
      <div id="homeTopSlot">
        <div class="shadowTopDown"></div>
        <div id="homeTopSlotContent">
        
    </c:if>

    <dsp:droplet name="ItemValidatorDroplet">
      <dsp:param name="item" value="${promotionalContent}" />
      <dsp:oparam name="true">
        <dsp:include page="${mobileStorePrefix}/promo/gadgets/homePagePromotionalCell.jsp">
          <dsp:param name="promotionalContent" value="${promotionalContent}" />
        </dsp:include>
      </dsp:oparam>
    </dsp:droplet>

    <c:if test="${status.last}">
      </div>
	  <c:if test="${totalNumItems > 1}">
	    <div id="circlesContainer">
          <table>
            <tbody>
              <tr>
                <td>
				  <div id="voiceOverText" class="transparentText"></div>
                  <c:forEach var="promotionalContent" items="${contentItem['atg:contents'].items}" varStatus="status">
                    <c:choose>
                      <c:when test="${status.first}">
                        <div id="pageCircle_0" class="ON"></div>
                      </c:when>
                      <c:otherwise>
                        <div id="pageCircle_${status.index}" class="BLANK"></div>
                      </c:otherwise>
                    </c:choose>
                  </c:forEach>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
	  </c:if>
      </div>
    </c:if>
  </c:forEach>
  <script>
    $(document).ready(function() {
      CRSMA.promo.initPromoSlider();
    });
  </script>

</dsp:page>
<%-- @version $Id: //hosting-blueprint/B2CBlueprint/version/11.1/Storefront/j2ee/store.war/mobile/cartridges/ScrollablePromotionalContent-ATGSlot/ScrollablePromotionalContent-ATGSlot.jsp#3 $$Change: 883241 $--%>
