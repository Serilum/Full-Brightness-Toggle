package com.natamus.fullbrightnesstoggle.neoforge.events;

import com.natamus.fullbrightnesstoggle.data.Constants;
import com.natamus.fullbrightnesstoggle.events.ToggleEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(Dist.CLIENT)
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
