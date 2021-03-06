import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testGetWinner1() 
			throws InvalidScoreException, InvalidPlayerException, IllegalPlayerPoint 
	{
		Player p1 = new Player( new Score( 1 ) );
		Player p2 = new Player( new Score( 0 ) );
		Point p = new Point( p1, p2 );
		p.setWinner(p1);
		assertEquals(p1.getId() , p.getWinner());
	
	}	
	
	@Test
	public void testGetWinner2() 
			throws InvalidScoreException, InvalidPlayerException, IllegalPlayerPoint 
	{
		Player p1 = new Player( new Score( 0 ) );
		Player p2 = new Player( new Score( 1 ) );
		Point p = new Point( p1, p2 );
		p.setWinner(p2);
		assertEquals(p2.getId(), p.getWinner());
	}
	
	@Test
	public void testGetWinner3() 
			throws InvalidScoreException, InvalidPlayerException 
	{
		Player p1 = new Player( new Score( 0 ) );
		Player p2 = new Player( new Score( 0 ) );
		Point p = new Point( p1, p2 );
		assertEquals(0, p.getWinner());
		
	}
	
}
