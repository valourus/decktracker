package Controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import Tasks.CheckCardsPlaced;
import Tasks.GetCardInfo;
import Cards.Card;

public class LogicController {

	@SuppressWarnings("unused")
	private float elixer = 0;
	private ArrayList<Card> hand;
	private LinkedList<Card> upComming;
	private Timer timer = new Timer();

	public LogicController() {
		hand = new ArrayList<>();
		upComming = new LinkedList<>();
		for (int i = 0; i < 4; i++)
			hand.add(new Card("UNKNOWN", 0));
		for (int i = 0; i < 4; i++)
			upComming.add(new Card("UNKNOWN", 0));

		timer.scheduleAtFixedRate(new CheckCardsPlaced(this), 0, 500);
	}

	public synchronized void onNewCardPlaced(int index) {
		System.out.println("played card " + index);
		for (Card item : hand) {
			if (item.getDeckPos() != index)
				continue;

			hand.add(upComming.removeFirst());
			upComming.addLast(item);
			hand.remove(item);
			printHand();
			return;
		}

		for (Card card : hand) {
			if (!card.getName().equals("UNKNOWN"))
				continue;

			card.setDeckPos(index);
			timer.schedule(new GetCardInfo(this, card), 2000);
			
			hand.add(upComming.removeFirst());
			upComming.addLast(card);
			hand.remove(card);
			printHand();
			return;
		}
	}

	public void onCardIdentified() {
	}

	private void printHand() {
//		System.out.println("------- HAND --------");
//		hand.forEach(item -> {
//			System.out.println("card " + item.getDeckPos());
//		});
//		System.out.println("------- UPCOMMING ------- ");
//		System.out.println(upComming.peek().getDeckPos());
	}
}
