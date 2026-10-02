package com.serilum.fullbrightnesstoggle.forge.events;

import com.serilum.fullbrightnesstoggle.data.Constants;
import com.serilum.fullbrightnesstoggle.events.ToggleEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeToggleEvent {
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
