package com.natamus.fullbrightnesstoggle;

import com.natamus.collective.check.RegisterMod;
import com.natamus.fullbrightnesstoggle.forge.events.ForgeKeyMappingRegister;
import com.natamus.fullbrightnesstoggle.forge.events.ForgeToggleEvent;
import com.natamus.fullbrightnesstoggle.util.Reference;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Reference.MOD_ID)
public class ModForge {
	
	public ModForge() {
		if (!FMLEnvironment.dist.equals(Dist.CLIENT)) {
			return;
		}

		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		modEventBus.addListener(this::loadComplete);
		modEventBus.addListener(ForgeKeyMappingRegister::initClient);

		setGlobalConstants();
		ModCommon.init();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
    	MinecraftForge.EVENT_BUS.register(new ForgeToggleEvent());
	}

	private static void setGlobalConstants() {

	}
}