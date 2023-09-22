package malte0811.ferritecore.mixin.fabric;

import malte0811.ferritecore.impl.Deduplicator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import net.minecraft.client.renderer.item.RenderItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/entity/ItemRenderer;<init>(Lnet/minecraft/client/Minecraft;Lnet/minecraft/client/renderer/texture/TextureManager;Lnet/minecraft/client/resources/model/ModelManager;Lnet/minecraft/client/color/item/ItemColors;Lnet/minecraft/client/renderer/BlockEntityWithoutLevelRenderer;Lnet/minecraft/client/renderer/item/RenderItem;Lnet/minecraft/client/renderer/entity/EntityRendererManager;Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;Lnet/minecraft/client/renderer/entity/MobEntityRenderer;Lnet/minecraft/client/renderer/entity/PlayerEntityRenderer;Lnet/minecraft/world/level/block/entity/BlockEntityRenderer;Lnet/minecraft/client/renderer/chunk/ChunkRenderDispatcher;)V"
            )
    )
    private void injectAfterModels(GameConfig gameConfig, CallbackInfo ci) {
        Deduplicator.registerReloadListener();
    }
}
