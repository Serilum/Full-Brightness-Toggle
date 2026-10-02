package com.serilum.fullbrightnesstoggle.neoforge.events;

import com.serilum.fullbrightnesstoggle.data.Constants;
import com.serilum.fullbrightnesstoggle.events.ToggleEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.bus.api.SubscribeEvent;

public class NeoForgeToggleEvent {
	@SubscribeEvent
	public static void onKey(InputEvent.Key e) {
		if (e.getAction() != 1) {
			return;
		}

		if (Constants.hotkey == null) {
			return;
		}

		if (e.getKey() == Constants.hotkey.getKey().getValue()) {
			ToggleEvent.onHotkeyPress();
		}
	}
}
