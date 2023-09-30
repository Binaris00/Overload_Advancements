package binaris.datagen.overload_advancements.advancements_tabs;

import binaris.datagen.overload_advancements.AdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Blocks;
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
                        Text.literal("Your first cobblestone block!"),
                        Text.translatable("Good material to make a pickaxe"),
                        new Identifier("textures/gui/advancements/backgrounds/stone.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_cobblestone", InventoryChangedCriterion.Conditions.items(Items.COBBLESTONE))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/root");

        AdvancementEntry findDeepEmerald = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.DEEPSLATE_EMERALD_ORE,
                        Text.literal("Most rare ore"),
                        Text.literal("Why do you obtain this?"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )
                .criterion("find_deep_emerald", InventoryChangedCriterion.Conditions.items(Items.DEEPSLATE_EMERALD_ORE))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/find_deep_emerald");

        AdvancementEntry craftStonePickaxe = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.STONE_PICKAXE,
                        Text.literal("The loyal tool!"),
                        Text.literal("Upgrade your pickaxe"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("craft_stone_pickaxe", InventoryChangedCriterion.Conditions.items(Items.STONE_PICKAXE))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/craft_stone_pickaxe");

        AdvancementEntry craftIronPickaxe = Advancement.Builder.create().parent(craftStonePickaxe)
                .display(
                        Items.IRON_PICKAXE,
                        Text.literal("A necessary update"),
                        Text.literal("Perfect to mine other ores"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("craft_iron_pickaxe", InventoryChangedCriterion.Conditions.items(Items.IRON_PICKAXE))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/craft_iron_pickaxe");

        AdvancementEntry placeFurnace = Advancement.Builder.create().parent(craftStonePickaxe)
                .display(
                        Items.FURNACE,
                        Text.literal("Now, where are the cookies?"),
                        Text.literal("Used to smelt whatever you want"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("place_furnace", ItemCriterion.Conditions.createPlacedBlock(Blocks.FURNACE))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/place_furnace");

        Advancement placeBlastFurnace = Advancement.Builder.create().parent(placeFurnace)
                .display(
                        Items.BLAST_FURNACE,
                        Text.literal("Optimized production"),
                        Text.literal("Perfect for smelting ores"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("place_blast_furnace", ItemCriterion.Conditions.createPlacedBlock(Blocks.BLAST_FURNACE))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/place_blast_furnace").value();

        AdvancementEntry getCoal = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.COAL,
                        Text.translatable("Ore for burning"),
                        Text.translatable("Try to use with a furnace"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_coal", InventoryChangedCriterion.Conditions.items(Items.COAL))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_coal");

        Advancement getIron = Advancement.Builder.create().parent(getCoal)
                .display(
                        Items.IRON_INGOT,
                        Text.translatable("New Era"),
                        Text.translatable("Maybe an anvil will be the perfect use"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_iron", InventoryChangedCriterion.Conditions.items(Items.RAW_IRON))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_iron").value();

        Advancement getCopper = Advancement.Builder.create().parent(getCoal)
                .display(
                        Items.COPPER_INGOT,
                        Text.translatable("Electric conductor"),
                        Text.translatable("And, how can I use this?"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_copper", InventoryChangedCriterion.Conditions.items(Items.RAW_COPPER))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_copper").value();
    }
}
