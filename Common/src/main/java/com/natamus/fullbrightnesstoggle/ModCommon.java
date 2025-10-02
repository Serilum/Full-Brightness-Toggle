package com.natamus.fullbrightnesstoggle;


import com.natamus.collective.globalcallbacks.MainMenuLoadedCallback;
import com.natamus.collective.services.Services;
import com.natamus.fullbrightnesstoggle.data.Constants;
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

	public static void registerHotkeys() {
		Constants.hotkey = Services.REGISTERKEYMAPPING.registerKeyMapping("fullbrightnesstoggle.key.togglebrightness", 71, "key.categories.misc");
	}
}