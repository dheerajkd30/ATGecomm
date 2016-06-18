<dsp:page>


    <jsp:body>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <img alt="Visa Checkout" class="v-button" role="button"	src="https://sandbox.secure.checkout.visa.com/wallet-services-web/xo/button.png"/>
		<script type="text/javascript" src="https://sandbox-assets.secure.checkout.visa.com/checkout-widget/resources/js/integration/v1/sdk.js"></script>
		
      	<script type="text/javascript">
				  function onVisaCheckoutReady(){
					  V.init( {
					 	apikey: "7O07VN664O10JW6A9ESS113p8sf9JeGzr6_2haC9F9m_ANtLM",
					   	paymentRequest:{
					    currencyCode: "USD",
					    total: "10.00"
					  }
					  });
				  
					V.on("payment.success", function(payment)
				 	 {  
						$.ajax({
							type : 'GET',
	                          url : '/crs/checkout/prat.jsp?payment='+JSON.stringify(payment),
	                          success : function(response) {
	                          alert(JSON.stringify(payment));
	                        }
	                    });
					});
					
					V.on("payment.cancel", function(payment)
				  	{
						alert(JSON.stringify(payment)); 
					});
					V.on("payment.error", function(payment, error)
				  	{
						alert(JSON.stringify(error)); 
					});
				}
				
		</script>
    </jsp:body>
  
</dsp:page>