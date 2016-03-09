package uk.ac.glasgow.jagora.test.stub;

import static uk.ac.glasgow.jagora.test.stub.StubTrader.trader;
import static uk.ac.glasgow.jagora.test.stub.StubStock.lemons;

import uk.ac.glasgow.jagora.SellOrder;
import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.TradeException;
import uk.ac.glasgow.jagora.Trader;

public class StubSellOrder implements SellOrder {

	public static final SellOrder sellOrder = new StubSellOrder();
	
	private Integer quant = 500;
	
	@Override
	public Trader getTrader() {
		
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
		
		// update quantity after satisfying trade.		
		quant -= tradeEvent.getEvent().getQuantity();

	}

	@Override
	public void rollBackTrade(TickEvent<Trade> tradeEvent) throws TradeException {
		
		// update quantity after rolling back trade.
		quant += tradeEvent.getEvent().getQuantity();
	}

	@Override
	public int compareTo(SellOrder order) {
		// TODO Auto-generated method stub
		return this.compareTo(order);
	}

}