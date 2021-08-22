package view;

import controller.KillController;

public class Principal {

	public static void main(String[] args) {
		
		KillController kill = new KillController();
		
		kill.listProcess();

	}

}
