package Tasks;

import Controllers.LogicController;

public class ElixerGain extends BaseTask {
	
	public static boolean isDoubleElixerTriggered = false;
	public static boolean triggered = false; 
	public ElixerGain(LogicController controller) {
		super(controller);
	}

	@Override
	public void run() {
		if(controller.getElixer() >= 10)
			return;
		if(controller.getStarTime() + 120000 < System.currentTimeMillis()) {
			controller.addElixer(0.2f);
			isDoubleElixerTriggered = true;
		} else {
			controller.addElixer(0.1f);
		}
		
		if(isDoubleElixerTriggered && !triggered) { 
			controller.addElixer(1);
			triggered = true;
		}
		
		controller.updateElixerBar();
	}
}
