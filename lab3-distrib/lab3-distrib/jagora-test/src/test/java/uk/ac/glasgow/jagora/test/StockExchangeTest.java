package uk.ac.glasgow.jagora.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.Trader;
import uk.ac.glasgow.jagora.World;
import uk.ac.glasgow.jagora.impl.DefaultStockExchange;
import uk.ac.glasgow.jagora.impl.LimitBuyOrder;
import uk.ac.glasgow.jagora.impl.LimitSellOrder;
import uk.ac.glasgow.jagora.test.stub.StubStock;
import uk.ac.glasgow.jagora.test.stub.StubTrader;
import uk.ac.glasgow.jagora.test.stub.StubWorld;

public class StockExchangeTest {
		
	
	// define dummy vars
	
		private DefaultStockExchange exchange; 
		private Stock stock;
		private World world;
		private Trader trader;
		
		private Integer quantity = 500;
		private Double order1Price = 4235.2;
		private Double order2Price = 5000.4;
		
		private LimitBuyOrder buyOrder1;
		private LimitBuyOrder buyOrder2;
		
		private LimitSellOrder sellOrder1;
		private LimitSellOrder sellOrder2;
		
		@Before
		public void setUp() throws Exception {
			
			// init dummy vars 
			this.stock = new StubStock();
			this.world = new StubWorld();
			this.trader = new StubTrader();
			
			// init class to test
			this.exchange = new DefaultStockExchange(world);
			
			// init orders to simulate test with
			this.buyOrder1 = new LimitBuyOrder(trader, stock, quantity, order1Price);
			this.buyOrder2 = new LimitBuyOrder(trader, stock, quantity, order2Price);
			
			this.sellOrder1 = new LimitSellOrder(trader, stock, quantity, order1Price);
			this.sellOrder2 = new LimitSellOrder(trader, stock, quantity, order2Price);
			
			// place orders
			exchange.placeBuyOrder(buyOrder1);
			exchange.placeBuyOrder(buyOrder2);

			exchange.placeSellOrder(sellOrder1);
			exchange.placeSellOrder(sellOrder2);
		}
		
		// check trade history is correct
		@Test
		public void testGetTradeHistory()
		{
			// all the previous trades for the dummy stock 
			List<TickEvent<Trade>> completedTrades = exchange.getTradeHistory(stock);
			
			// check they are in the correct order
			for(int i = 0; i < completedTrades.size()-1; i++)
			{
				assertTrue(completedTrades.get(i).compareTo(completedTrades.get(i+1)) < 0);
			}
			
		}
		
		// get the best bid and check it matches the best simulated bid
		@Test
		public void testGetBestBid()
		{
			assertEquals("Best bid incorrect", buyOrder2, exchange.getBestBid(stock));
			
		}
		
		// get the best offer and check it matches the best simulated offer
		@Test
		public void testGetBestOffer()
		{			
			assertEquals("Best bid incorrect", sellOrder1, exchange.getBestOffer(stock));
		}
		
		// do tear down
		@After
		public void tearDown()
		{
			exchange = null; 
			stock = null;
			world = null;
			trader = null;
			
			quantity = null;
			order1Price  = null;
			order2Price  = null;
			
			buyOrder1  = null;
			buyOrder2  = null;
			
			sellOrder1 = null;
			sellOrder2  = null; 
		}
	}


