package Tasks;

import java.util.TimerTask;

import Controllers.LogicController;

public abstract class BaseTask extends TimerTask {

	protected LogicController controller;

	public BaseTask(LogicController controller) {
		this.controller = controller;
	}

}
