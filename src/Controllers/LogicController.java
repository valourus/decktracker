package Controllers;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Timer;
import Tasks.CheckCardsPlaced;
import Cards.Card;

public class LogicController {

	private float elixer = 0;
	private ArrayList<Card> hand;
	private Stack<Card> upComming;

	public LogicController() {
		hand = new ArrayList<>();
		upComming = new Stack<>();
		for (int i = 0; i < 4; i++)
			hand.add(new Card("UNKNOWN", 0, null));
		for (int i = 0; i < 4; i++)
			upComming.add(new Card("UNKNOWN", 0, null));

		Timer t = new Timer();

		t.scheduleAtFixedRate(new CheckCardsPlaced(this), 0, 750);
	}

	public void onNewCardPlaced(int index) {
		for (Card item : hand) {
			if (item.getDeckPos() != index)
				continue;

			hand.add(upComming.pop());
			upComming.add(item);
			hand.remove(item);
			return;
		}

		System.out.println("card is unknown");
	}
}
