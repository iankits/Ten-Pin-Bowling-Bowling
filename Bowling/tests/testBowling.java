import org.junit.After;
import org.junit.Before;

import com.game.bowling.BowlingGame;
import junit.framework.TestCase;

/**
 * Test cases for Bowling Game.
 * @author Ankit Singh
 *
 */
public class testBowling extends TestCase {

	private BowlingGame bgame;

	@Before
	public void setUp() throws Exception {
		bgame = new BowlingGame();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test Class roll
	 */
	public void testBowlingGameClass() {
		System.out.println("######### test bowlingGame class #########");
		for(int i=0;i<21;i++){
			bgame.roll(0);
		}
		assertEquals(0, bgame.getScore());
	}

	/**
	 * Test function module for correctness
	 */
	public void testBowlingCorrectness() {
		System.out.println("######### test bowling correctness #########");
		for(int i=0;i<21;i++){
			bgame.roll(1);
		}
		assertEquals(21, bgame.getScore());
	}

	/**
	 * Test different Bowling Scenarios
	 */
	public void testBowlingScenariosAllStrikes() {
		System.out.println("######### test bowling all scenarios #########");
		int pinsDown = 10;
		for(int i=0;i<11;i++){
			bgame.roll(pinsDown);
		}
		assertEquals(300, bgame.getScore());
	}

	public void testBowlingScenarios1Spares() {
		System.out.println("######### test bowling scenario Spare1 #########");
		bgame.roll(6);
		bgame.roll(4); // spare
		bgame.roll(5);
		int pinsDown = 0;
		for(int i=0;i<18;i++){
			bgame.roll(pinsDown);
		}
		assertEquals(20, bgame.getScore());
	}

	public void testBowlingScenarios2Spares() {
		System.out.println("######### test bowling scenario Spare2 #########");
		bgame.roll(6);
		bgame.roll(4); // spare 10 + 5 = 15
		bgame.roll(5);
		bgame.roll(5); // spare 15 + 10 + 0 = 25
		int pinsDown = 0;
		for(int i=0;i<17;i++){
			bgame.roll(pinsDown);
		}
		assertEquals(25, bgame.getScore());
	}

	public void testBowlingScenarios3Spares() {
		System.out.println("######### test bowling scenario Spare3 #########");
		bgame.roll(6);
		bgame.roll(4); // spare 11
		int pinsDown = 1;
		for(int i=0;i<19;i++){
			bgame.roll(pinsDown);
		}
		assertEquals(30, bgame.getScore());
	}

	public void testBowlingScenarios4Spares() {
		System.out.println("######### test bowling scenario Spare4 #########");
		bgame.roll(6);
		bgame.roll(4); // spare 16
		bgame.roll(6); 
		bgame.roll(4); //spare
		bgame.roll(6);// check whether my algo makes it spare or not (yoo!! its working! not taking this as  spare)

		int pinsDown = 0;
		for(int i=0;i<16;i++){
			bgame.roll(pinsDown);
		}
		//bgame.printScoreArray();
		assertEquals(38, bgame.getScore());
	}

	public void testBowlingScenarios1StrikesSpares() {
		System.out.println("######### test bowling scenario 2 Strike Spare #########");
		bgame.roll(6);
		bgame.roll(4); // spare 10 + 5 = 15
		bgame.roll(5);
		bgame.roll(5); // spare 15 + 10 + 10 = 35
		bgame.roll(10); // strike 35 + 10 + 10+ 10 = 65
		bgame.roll(10); // strike 65 + 10 + 10 +3 = 88
		bgame.roll(10); // strike 88 + 10 + 3+ 7 = 108
		bgame.roll(3); 
		bgame.roll(7); // spare 108 + 10 + 4 = 122
		bgame.roll(4); // 122 + 4 + 0 = 126
		int pinsDown = 0;
		for(int i=0;i<8;i++){
			bgame.roll(pinsDown);
		}
		assertEquals(126, bgame.getScore());
	}

	public void testBowlingScenarios2StrikesSpares() {
		System.out.println("######### test bowling scenario 2 Strike Spare #########");
		bgame.roll(6);
		bgame.roll(4); // spare 10 + 5 = 15
		bgame.roll(5);
		bgame.roll(5); // spare 15 + 10 + 10 = 35
		bgame.roll(10); // strike 35 + 10 + 10+ 0 = 55
		bgame.roll(10); // strike 55 + 10 + 0 + 0 = 65
		int pinsDown = 0;
		for(int i=0;i<8;i++){
			bgame.roll(pinsDown);
		}
		bgame.roll(10); // strike 65 + 10 + 3+ 7 = 85
		bgame.roll(3); 
		bgame.roll(7); // spare 
		bgame.roll(4); // 85 + 3+7+4 = 99
		assertEquals(99, bgame.getScore());
	}

	public void testHetrasExample(){	
		System.out.println("######### test bowling Hetras Example #########");
		bgame.roll(1);
		bgame.roll(4); // 5

		bgame.roll(4);
		bgame.roll(5); // 5 + (4+5) = 14

		bgame.roll(6); 
		bgame.roll(4); // spare 14 + 10 + 5 = 29

		bgame.roll(5); 
		bgame.roll(5); // spare 29 + 10 + 10 = 49

		bgame.roll(10); // strike 49 + 10+ 0 + 1 = 50

		bgame.roll(0); 
		bgame.roll(1); //60 + 0 + 1 = 61

		bgame.roll(7);
		bgame.roll(3); // spare 61 + 10 + 6 = 77

		bgame.roll(6);
		bgame.roll(4); // spare 77 + 10 + 10 = 97

		bgame.roll(10); // strike 97 + 10 + 2+ 8 = 117

		bgame.roll(2);	
		bgame.roll(8); // spare 117 + 10 + 6 = 133
		bgame.roll(6);
		//bgame.printScoreArray();
		assertEquals(133, bgame.getScore());
	}
}
