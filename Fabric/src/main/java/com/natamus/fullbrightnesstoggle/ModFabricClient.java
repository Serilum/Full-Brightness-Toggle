package com.natamus.fullbrightnesstoggle;

import com.natamus.collective.check.ShouldLoadCheck;
import com.natamus.fullbrightnesstoggle.data.Constants;
import com.natamus.fullbrightnesstoggle.events.ToggleEvent;
import com.natamus.fullbrightnesstoggle.util.Reference;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		ModCommon.registerHotkeys();

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (Constants.hotkey.isDown()) {
				ToggleEvent.onHotkeyPress();
				Constants.hotkey.setDown(false);
			}
		});  	
	}
}
