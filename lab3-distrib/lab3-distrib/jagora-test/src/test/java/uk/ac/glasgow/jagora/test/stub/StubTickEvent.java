package uk.ac.glasgow.jagora.test.stub;

import static uk.ac.glasgow.jagora.test.stub.StubTrade.trade;

import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;

public class StubTickEvent<T> implements TickEvent<T> {

	private Trade t;
	
	// default constructor uses default trade stub
	public StubTickEvent() {
		// TODO Auto-generated constructor stub
		t = trade;
	}
	
	// allows custom trade to be used with TickEvent
	public StubTickEvent(Trade tr)
	{
		t = tr;
	}
	
	@Override
	public Long getTick() {
		// TODO Auto-generated method stub
		return 100000l;
	}

	@Override
	public int compareTo(TickEvent<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getEvent() {
		// TODO Auto-generated method stub
		return (T) t;
	}
	

}
