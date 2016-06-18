package atg.commerce.pricing;


public class DDItemDiscountCalculator extends ItemDiscountCalculator {

	/*@Override
	public double findAdjustedPrice(
			DetailedItemPriceInfo pDetailedItemPriceInfo, List pPriceQuotes,
			List pItems, RepositoryItem pPricingModel, RepositoryItem pProfile,
			Locale pLocale, Order pOrder, Map pExtraParameters)
			throws PricingException {
		// current price of an item
		double currentAmount = pDetailedItemPriceInfo.getAmount();
		double discAmount = 0.0D;
		
		if(pDetailedItemPriceInfo.getQuantity() % 2 == 0){
			
		discAmount = (currentAmount / 2);
		
		pDetailedItemPriceInfo.setAmount(discAmount);
		}

		return discAmount;

	}
	
	
	@Override
	protected Collection findQualifyingItems(List pPriceQuotes, List pItems,
			RepositoryItem pPricingModel, RepositoryItem pProfile,
			Locale pLocale, Order pOrder, Map pExtraParameters)
			throws PricingException {
		// TODO Auto-generated method stub
		return super.findQualifyingItems(pPriceQuotes, pItems, pPricingModel, pProfile,
				pLocale, pOrder, pExtraParameters);
	}*/
}
