package unit.stub;

public class PricingRepository {

	// [... other methods ...]

	public Price getPriceForTrade(Trade trade) {
		return trade.price;
	}
}