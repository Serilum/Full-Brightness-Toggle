package com.natamus.fullbrightnesstoggle;

import com.mojang.blaze3d.platform.InputConstants;
import com.natamus.fullbrightnesstoggle.data.Constants;
import com.natamus.fullbrightnesstoggle.events.ToggleEvent;
import net.fabricmc.api.ClientModInitializer;
import com.natamus.fullbrightnesstoggle.util.Reference;
import com.natamus.collective.check.ShouldLoadCheck;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		Constants.hotkey = KeyBindingHelper.registerKeyBinding(new KeyMapping("fullbrightnesstoggle.key.togglebrightness", InputConstants.Type.KEYSYM, 71, "key.categories.misc"));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (Constants.hotkey.isDown()) {
				ToggleEvent.onHotkeyPress();
				Constants.hotkey.setDown(false);
			}
		});  	
	}
}
