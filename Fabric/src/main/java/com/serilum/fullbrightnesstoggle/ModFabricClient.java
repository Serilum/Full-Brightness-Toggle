package com.serilum.fullbrightnesstoggle;

import com.natamus.collective.check.ShouldLoadCheck;
import com.serilum.fullbrightnesstoggle.data.Constants;
import com.serilum.fullbrightnesstoggle.events.ToggleEvent;
import com.serilum.fullbrightnesstoggle.util.Reference;
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
