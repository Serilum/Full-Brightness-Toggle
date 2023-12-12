package com.natamus.fullbrightnesstoggle.forge.events;

import com.natamus.fullbrightnesstoggle.data.Constants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT)
public class ForgeKeyMappingRegister {
    @SubscribeEvent
	public void registerKeyBinding(RegisterKeyMappingsEvent e) {
    	Constants.hotkey = new KeyMapping("fullbrightnesstoggle.key.togglebrightness", 71, "key.categories.misc");
    	e.register(Constants.hotkey);
    }
}