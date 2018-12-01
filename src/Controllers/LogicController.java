package Controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;

import javax.imageio.ImageIO;

import Cards.Card;
import Tasks.CheckCardsPlaced;
import Tasks.ElixerGain;
import Tasks.GetCardInfo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LogicController {

	// JavaFX stuff
	@FXML
	private ImageView card1;
	@FXML
	private ImageView card2;
	@FXML
	private ImageView card3;
	@FXML
	private ImageView card4;
	@FXML
	private ImageView card5;
	@FXML
	private ImageView card6;
	@FXML
	private ImageView card7;
	@FXML
	private ImageView card8;
	@FXML
	private Button startBtn;
	@FXML
	private ProgressBar elixerCounter;
	@FXML
	private Button subElixerBtn;
	@FXML
	private Button addElixerBtn;
	
	private float elixer = 1;
	private ArrayList<Card> hand;
	private LinkedList<Card> upComming;
	private Timer timer = new Timer();

	public void initialize() {
		startBtn.setOnMouseClicked(e -> start());
		subElixerBtn.setOnMouseClicked(e -> { elixer -= 1;});
		addElixerBtn.setOnMouseClicked(e -> addElixer(1));
	}
	
	public void start() {
		hand = new ArrayList<>();
		upComming = new LinkedList<>();
		for (int i = 0; i < 4; i++)
			hand.add(new Card("UNKNOWN", 0));
		for (int i = 0; i < 4; i++)
			upComming.add(new Card("UNKNOWN", 0));
		updateCards();
		timer.scheduleAtFixedRate(new CheckCardsPlaced(this), 0, 500);
		timer.scheduleAtFixedRate(new ElixerGain(this), 0, 280);
	}
	
	public synchronized void onNewCardPlaced(int index) {
		for (Card item : hand) {
			if (item.getDeckPos() != index)
				continue;
			elixer -= item.getCost();
			hand.add(upComming.removeFirst());
			upComming.addLast(item);
			hand.remove(item);
			updateCards();
			return;
		}

		for (Card card : hand) {
			if (!card.getName().equals("UNKNOWN"))
				continue;

			card.setDeckPos(index);
			timer.schedule(new GetCardInfo(this, index), 1000);
			elixer -= 1;
			hand.add(upComming.removeFirst());
			upComming.addLast(card);
			hand.remove(card);
			updateCards();
			return;
		}
	}

	public synchronized void onCardIdentified(Card card, int index) {
		upComming.forEach(item -> {
			if(item.getDeckPos() == index) {
				item.setCost(card.getCost());
				item.setName(card.getName());
				elixer -= item.getCost() - 1;
			}
		});
		updateCards();
	}
	
	public void updateCards() {
		card1.setImage(new Image("file:" + hand.get(0).getFilename()));
		card2.setImage(new Image("file:" + hand.get(1).getFilename()));
		card3.setImage(new Image("file:" + hand.get(2).getFilename()));
		card4.setImage(new Image("file:" + hand.get(3).getFilename()));
		card5.setImage(new Image("file:" + upComming.get(0).getFilename()));
		card6.setImage(new Image("file:" + upComming.get(1).getFilename()));
		card7.setImage(new Image("file:" + upComming.get(2).getFilename()));
		card8.setImage(new Image("file:" + upComming.get(3).getFilename()));
	}

	public void updateElixerBar() {
		if(elixer / 10 < 0) {
			elixerCounter.setProgress(0);
			elixer = 0;
		} else
			elixerCounter.setProgress(elixer / 10);
	}
	
	public float getElixer() {
		return elixer;
	}

	public void addElixer(float elixer) {
		if(this.elixer + elixer > 10) {
			this.elixer = 10;
		}
		if(this.elixer == 10)return;
		this.elixer += elixer;
	}
}
