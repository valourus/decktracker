package Tasks;

import Controllers.LogicController;

public class ElixerGain extends BaseTask {

	public ElixerGain(LogicController controller) {
		super(controller);
	}

	@Override
	public void run() {
		if(controller.getElixer() >= 10)
			return;
		controller.addElixer(0.1f);
		controller.updateElixerBar();
	}
}
