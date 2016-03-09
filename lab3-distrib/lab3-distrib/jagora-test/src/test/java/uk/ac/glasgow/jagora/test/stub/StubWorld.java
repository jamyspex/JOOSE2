package uk.ac.glasgow.jagora.test.stub;

import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.World;

public class StubWorld implements World{

	public static final World world = new StubWorld ();
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> TickEvent<T> createTickEvent(T event) {
		
		return (TickEvent<T>) event;
	}

}
