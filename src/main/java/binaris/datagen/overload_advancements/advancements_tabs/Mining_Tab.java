package binaris.datagen.overload_advancements.advancements_tabs;

import binaris.datagen.overload_advancements.AdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class Mining_Tab implements Consumer<Consumer<AdvancementEntry>> {

    @Override
    public void accept(Consumer<AdvancementEntry> advancementConsumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        Items.COBBLESTONE,
                        Text.literal("Your First Cobblestone Block"),
                        Text.literal("Maybe it's time to make a pickaxe!!"),
                        new Identifier("textures/gui/advancements/backgrounds/stone.png"),
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true,
                        true,
                        false
                )
                .criterion("got_cobblestone", InventoryChangedCriterion.Conditions.items(Items.COBBLESTONE))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/root");

        Advancement craftPickaxe = Advancement.Builder.create()
                .display(
                        Items.STONE_PICKAXE,
                        Text.literal("The perfect tool!"),
                        Text.literal("Conquer all the world"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("craftPickaxe", InventoryChangedCriterion.Conditions.items(Items.STONE_PICKAXE))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/craft_pickaxe").value();


        Advancement gotOakAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.OAK_LOG,
                        Text.literal("Your First Oak Block"),
                        Text.literal("Bare fisted"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1000))
                .criterion("got_wood", InventoryChangedCriterion.Conditions.items(Items.OAK_LOG))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/got_wood").value();

        Advancement eatAppleAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.APPLE,
                        Text.literal("Apple and Beef"),
                        Text.literal("Ate an apple and beef"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("ate_apple", ConsumeItemCriterion.Conditions.item(Items.APPLE))
                .criterion("ate_cooked_beef", ConsumeItemCriterion.Conditions.item(Items.COOKED_BEEF))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/ate_apple_and_beef").value();
    }
}
