package com.natamus.fullbrightnesstoggle.forge.events;

import com.natamus.fullbrightnesstoggle.data.Constants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeKeyMappingRegister {
    @SubscribeEvent
	public static void registerKeyBinding(RegisterKeyMappingsEvent e) {
    	Constants.hotkey = new KeyMapping("fullbrightnesstoggle.key.togglebrightness", 71, "key.categories.misc");
    	e.register(Constants.hotkey);
    }
}