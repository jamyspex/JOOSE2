package uk.ac.glasgow.jagora.test.stub;

import static uk.ac.glasgow.jagora.test.stub.StubStock.lemons;
import static uk.ac.glasgow.jagora.test.stub.StubTrader.trader;

import uk.ac.glasgow.jagora.BuyOrder;
import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.TradeException;
import uk.ac.glasgow.jagora.Trader;

public class StubBuyOrder implements BuyOrder {

	public static final BuyOrder buyOrder = new StubBuyOrder ();

	private Integer quant = 500;
	
	@Override
	public Trader getTrader() {
		// TODO Auto-generated method stub
		return trader;
	}

	@Override
	public Stock getStock() {
		// TODO Auto-generated method stub
		return lemons;
	}

	@Override
	public Integer getRemainingQuantity() {
		// TODO Auto-generated method stub
		return quant;
	}

	@Override
	public Double getPrice() {
		// TODO Auto-generated method stub
		return 1000.0d;
	}

	@Override
	public void satisfyTrade(TickEvent<Trade> tradeEvent) throws TradeException {
		// TODO Auto-generated method stub
		
		quant -= tradeEvent.getEvent().getQuantity();

	}

	@Override
	public void rollBackTrade(TickEvent<Trade> tradeEvent) throws TradeException {
		// TODO Auto-generated method stub
		
		quant += tradeEvent.getEvent().getQuantity();
	}

	@Override
	public int compareTo(BuyOrder order) {
		// TODO Auto-generated method stub
		return this.compareTo(order);
	}

}
