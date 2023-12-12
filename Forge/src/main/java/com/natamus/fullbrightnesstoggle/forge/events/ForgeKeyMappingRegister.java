package com.natamus.fullbrightnesstoggle.forge.events;

import com.natamus.fullbrightnesstoggle.data.Constants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class ForgeKeyMappingRegister {
    public static void initClient(final FMLClientSetupEvent event) {
    	Constants.hotkey = new KeyMapping("fullbrightnesstoggle.key.togglebrightness", 71, "key.categories.misc");
    	ClientRegistry.registerKeyBinding(Constants.hotkey);
    }
}