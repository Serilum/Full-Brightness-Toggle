package com.natamus.fullbrightnesstoggle;


import com.natamus.collective.globalcallbacks.MainMenuLoadedCallback;
import com.natamus.collective.services.Services;
import com.natamus.fullbrightnesstoggle.data.Constants;
import com.natamus.fullbrightnesstoggle.events.ToggleEvent;
import com.mojang.blaze3d.platform.InputConstants;

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
		Constants.hotkey = Services.REGISTERKEYMAPPING.registerKeyMapping("fullbrightnesstoggle.key.togglebrightness", InputConstants.KEY_G,"key.categories.misc");
	}
}