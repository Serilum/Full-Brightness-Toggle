package com.natamus.fullbrightnesstoggle.forge.events;

import com.natamus.fullbrightnesstoggle.data.Constants;
import com.natamus.fullbrightnesstoggle.events.ToggleEvent;
import net.minecraftforge.api.distmarker.Dist;
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
