package com.serilum.fullbrightnesstoggle;

import com.natamus.collective.check.ShouldLoadCheck;
import com.serilum.fullbrightnesstoggle.data.Constants;
import com.serilum.fullbrightnesstoggle.events.ToggleEvent;
import com.serilum.fullbrightnesstoggle.util.Reference;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class ModFabricClient implements ClientModInitializer {
	private static boolean hotkeyWasHeld = false;

	@Override
	public void onInitializeClient() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		ModCommon.registerHotkeys();

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			boolean hotkeyPressed = false;
			while (Constants.hotkey.consumeClick()) {
				hotkeyPressed = true;
			}

			// Holding the key sends repeat clicks, which should not toggle again.
			if (hotkeyPressed && !hotkeyWasHeld) {
				ToggleEvent.onHotkeyPress();
			}

			hotkeyWasHeld = Constants.hotkey.isDown();
		});
	}
}
