package binaris.datagen.overload_advancements;

import binaris.datagen.overload_advancements.advancements_tabs.Mining_Tab;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.AdvancementEntry;

import java.util.function.Consumer;

public class AdvancementProvider extends FabricAdvancementProvider {
    public static String MOD_ID = "overload_advancements";

    protected AdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        new Mining_Tab().accept(consumer);
    }
}
