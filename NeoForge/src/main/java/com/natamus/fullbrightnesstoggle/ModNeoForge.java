package com.natamus.fullbrightnesstoggle;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import com.natamus.fullbrightnesstoggle.neoforge.events.NeoForgeKeyMappingRegister;
import com.natamus.fullbrightnesstoggle.neoforge.events.NeoForgeToggleEvent;
import com.natamus.fullbrightnesstoggle.util.Reference;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;

@Mod(Reference.MOD_ID)
public class ModNeoForge {
	
	public ModNeoForge(IEventBus modEventBus) {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		if (!FMLEnvironment.dist.equals(Dist.CLIENT)) {
			return;
		}


		modEventBus.addListener(this::loadComplete);
		modEventBus.register(NeoForgeKeyMappingRegister.class);

		setGlobalConstants();
		ModCommon.init();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
		NeoForge.EVENT_BUS.register(NeoForgeToggleEvent.class);
	}

	private static void setGlobalConstants() {

	}
}