package com.natamus.fullbrightnesstoggle.neoforge.events;

import com.natamus.fullbrightnesstoggle.data.Constants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class NeoForgeKeyMappingRegister {
	@SubscribeEvent
	public static void registerKeyBinding(RegisterKeyMappingsEvent e) {
		Constants.hotkey = new KeyMapping("fullbrightnesstoggle.key.togglebrightness", 71, "key.categories.misc");
		e.register(Constants.hotkey);
	}
}