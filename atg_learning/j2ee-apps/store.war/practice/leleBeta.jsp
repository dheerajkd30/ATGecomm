<dsp:page>

<dsp:importbean bean="/practice/ApnaFormHandler"/>

<dsp:form>
Daaal ne be chu***ye::: <dsp:input type="text"  bean="ApnaFormHandler.yourInfo" required="true"/>
     
<dsp:input type="submit" bean="ApnaFormHandler.SeeApna" value="Register"/>
         
</dsp:form>

<dsp:droplet name="/atg/dynamo/droplet/ErrorMessageForEach">
       <dsp:param name="exceptions" bean="ApnaFormHandler.formExceptions"/>
      
       <dsp:oparam name="output">
          <b>
          <dsp:valueof param="message"/>
          </b>
          <p>
      </dsp:oparam>
    </dsp:droplet>
    
</dsp:page>