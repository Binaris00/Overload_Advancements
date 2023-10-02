package binaris.datagen.overload_advancements.advancements_tabs;

import binaris.datagen.overload_advancements.AdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class Mining_Tab implements Consumer<Consumer<AdvancementEntry>> {

    @Override
    public void accept(Consumer<AdvancementEntry> advancementConsumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        Items.COBBLESTONE,
                        Text.literal("Mining"),
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

        AdvancementEntry deepslateLayer = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.DEEPSLATE,
                        Text.literal("More deeper"),
                        Text.literal("Go to negative coords"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("deepslate_layer", TickCriterion.Conditions.createLocation(LocationPredicate.Builder.createY(NumberRange.DoubleRange.exactly(1))))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/deepslate_layer");

        AdvancementEntry bedrockLayer = Advancement.Builder.create().parent(deepslateLayer)
                .display(
                        Items.BEDROCK,
                        Text.literal("Rich was here"),
                        Text.literal("Go to the bedrock"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion("bedrock_layer", TickCriterion.Conditions.createLocation(LocationPredicate.Builder.createY(NumberRange.DoubleRange.exactly(-63))))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/bedrock_layer");

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

        AdvancementEntry craftDiamondPickaxe = Advancement.Builder.create().parent(craftIronPickaxe)
                .display(
                        Items.DIAMOND_PICKAXE,
                        Text.literal("Finest tool"),
                        Text.literal("Maybe this could work in other dimension..."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("craft_diamond_pickaxe", InventoryChangedCriterion.Conditions.items(Items.DIAMOND_PICKAXE))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/craft_diamond_pickaxe");

        AdvancementEntry craftGoldPickaxe = Advancement.Builder.create().parent(craftIronPickaxe)
                .display(
                        Items.GOLDEN_PICKAXE,
                        Text.literal("A unnecessary update"),
                        Text.literal("Maybe this was a bad idea..."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        true
                )
                .criterion("craft_golden_pickaxe", InventoryChangedCriterion.Conditions.items(Items.GOLDEN_PICKAXE))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/craft_golden_pickaxe");

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

        Advancement getRawBlocks = Advancement.Builder.create().parent(craftIronPickaxe)
                .display(
                        Items.RAW_IRON_BLOCK,
                        Text.literal("Ores compression"),
                        Text.literal("Obtain all the 3 raw blocks"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_raw_iron", InventoryChangedCriterion.Conditions.items(Items.RAW_IRON_BLOCK))
                .criterion("get_raw_gold", InventoryChangedCriterion.Conditions.items(Items.RAW_GOLD_BLOCK))
                .criterion("get_raw_copper", InventoryChangedCriterion.Conditions.items(Items.RAW_COPPER_BLOCK))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_raw_blocks").value();

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

        AdvancementEntry getIron = Advancement.Builder.create().parent(getCoal)
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
                .criterion("get_iron", InventoryChangedCriterion.Conditions.items(Items.IRON_INGOT))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_iron");

        AdvancementEntry getLavaBucket = Advancement.Builder.create().parent(getIron)
                .display(
                        Items.LAVA_BUCKET,
                        Text.translatable("Hot Stuff"),
                        Text.translatable("Fill a bucket with lava"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_lava_bucket", InventoryChangedCriterion.Conditions.items(Items.LAVA_BUCKET))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_lava_bucket");

        Advancement getObsidian = Advancement.Builder.create().parent(getLavaBucket)
                .display(
                        Items.OBSIDIAN,
                        Text.translatable("Ice bucket challenge"),
                        Text.translatable("Obtain a block of Obsidian"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_obsidian", InventoryChangedCriterion.Conditions.items(Items.OBSIDIAN))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_obsidian").value();

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
                .criterion("get_copper", InventoryChangedCriterion.Conditions.items(Items.COPPER_INGOT))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_copper").value();

        Advancement getGold = Advancement.Builder.create().parent(getCoal)
                .display(
                        Items.GOLD_INGOT,
                        Text.translatable("Most Value Ore"),
                        Text.translatable("Obtain gold"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_gold", InventoryChangedCriterion.Conditions.items(Items.GOLD_INGOT))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_gold").value();

        Advancement getDiamond = Advancement.Builder.create().parent(getCoal)
                .display(
                        Items.DIAMOND,
                        Text.translatable("Diamonds!!"),
                        Text.translatable("Acquire diamonds"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_diamond", InventoryChangedCriterion.Conditions.items(Items.DIAMOND))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_diamond").value();

        AdvancementEntry getAmethystShard = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.AMETHYST_SHARD,
                        Text.translatable("Amethyst from the crystal gems"),
                        Text.translatable("Obtain amethyst shard"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_amethyst_shard", InventoryChangedCriterion.Conditions.items(Items.AMETHYST_SHARD))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/get_amethyst_shard");

        Advancement craftSpyGlass = Advancement.Builder.create().parent(getAmethystShard)
                .display(
                        Items.SPYGLASS,
                        Text.translatable("Classic Spyglass"),
                        Text.translatable("Craft a spyglass"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("craft_spyglass", InventoryChangedCriterion.Conditions.items(Items.SPYGLASS))
                .build(advancementConsumer, AdvancementProvider.MOD_ID + "/craft_spyglass").value();
    }
}
