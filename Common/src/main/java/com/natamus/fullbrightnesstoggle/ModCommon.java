package com.natamus.fullbrightnesstoggle;


import com.natamus.collective.globalcallbacks.MainMenuLoadedCallback;
import com.natamus.fullbrightnesstoggle.events.ToggleEvent;

public class ModCommon {

	public static void init() {
		load();
	}

	private static void load() {
		MainMenuLoadedCallback.MAIN_MENU_LOADED.register(() -> {
			ToggleEvent.onMainMenuLoaded();
		});
	}
}