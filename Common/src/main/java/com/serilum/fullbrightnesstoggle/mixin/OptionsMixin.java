package com.serilum.fullbrightnesstoggle.mixin;

import com.serilum.fullbrightnesstoggle.events.ToggleEvent;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Options.class, priority = 1001)
public class OptionsMixin {
	@Inject(method = "save()V", at = @At(value = "HEAD"))
	public void save_head(CallbackInfo ci) {
		ToggleEvent.onOptionsSaveStart((Options)(Object)this);
	}

	@Inject(method = "save()V", at = @At(value = "RETURN"))
	public void save_return(CallbackInfo ci) {
		ToggleEvent.onOptionsSaveEnd((Options)(Object)this);
	}
}
