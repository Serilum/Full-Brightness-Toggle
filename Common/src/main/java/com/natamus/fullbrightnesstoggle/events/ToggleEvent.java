package com.natamus.fullbrightnesstoggle.events;

import com.natamus.collective.functions.GameSettingsFunctions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.ChatScreen;

public class ToggleEvent {
	private static final Minecraft mc = Minecraft.getInstance();
	private static double initialgamma = -1;
	
	public static void onHotkeyPress() {
		if (mc.screen instanceof ChatScreen) {
			return;
		}

		Options options = mc.options;
		if (initialgamma < 0) {
			if (GameSettingsFunctions.getGamma(options) >= 1.0F) {
				initialgamma = 1.0F;
				GameSettingsFunctions.setGamma(options, 1.0F);
			}
			else {
				initialgamma = GameSettingsFunctions.getGamma(options);
			}
		}

		boolean gomax = false;
		double maxgamma = 14.0F % 28.0F + 1.0F;
		if (GameSettingsFunctions.getGamma(options) != initialgamma && GameSettingsFunctions.getGamma(options) != maxgamma) {
			initialgamma = GameSettingsFunctions.getGamma(options);
			gomax = true;
		}

		if (GameSettingsFunctions.getGamma(options) == initialgamma || gomax) {
			GameSettingsFunctions.setGamma(options, maxgamma);
		}
		else {
			GameSettingsFunctions.setGamma(options, initialgamma);
		}
	}
}
