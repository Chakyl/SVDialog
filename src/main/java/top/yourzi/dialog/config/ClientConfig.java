package top.yourzi.dialog.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import top.yourzi.dialog.Dialog;

/**
 * 对话系统的客户端配置类。
 */
@Mod.EventBusSubscriber(modid = Dialog.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    
    // 对话框UI配置
    public static final ForgeConfigSpec.ConfigValue<Integer> DIALOG_BOX_WIDTH; // 对话框宽度
    public static final ForgeConfigSpec.ConfigValue<Integer> DIALOG_BOX_HEIGHT; // 对话框高度
    public static final ForgeConfigSpec.ConfigValue<Integer> DIALOG_BOX_X_OFFSET; // 对话框 X-偏移量
    public static final ForgeConfigSpec.ConfigValue<Integer> DIALOG_BOX_PADDING; // 对话框内边距
    public static final ForgeConfigSpec.ConfigValue<Integer> DIALOG_TEXT_COLOR; // 对话文本默认颜色
    public static final ForgeConfigSpec.ConfigValue<Integer> DIALOG_BACKGROUND_COLOR; // 对话框背景颜色
    public static final ForgeConfigSpec.ConfigValue<Integer> DIALOG_BACKGROUND_OPACITY; // 对话框背景不透明度
    
    // 立绘配置
    public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_PORTRAIT_ANIMATIONS; // 启用立绘动画
    
    // 对话系统配置
    public static final ForgeConfigSpec.ConfigValue<Boolean> IS_PAUSE_SCREEN; // 是否在对话时暂停游戏（仅单人）
    public static final ForgeConfigSpec.ConfigValue<Integer> AUTO_ADVANCE_DELAY; // 自动推进对话延迟 (毫秒)
    public static final ForgeConfigSpec.ConfigValue<Boolean> SHOW_SPEAKER_NAME; // 显示说话者名称
    public static final ForgeConfigSpec.ConfigValue<Integer> TEXT_ANIMATION_SPEED; // 文本逐字显示速度 (每秒字符数，0表示立即显示全部)
    
    static {
        BUILDER.comment("==== [ Sunlit Dialog Config ] ====").push("dialog_client");

        BUILDER.comment("Dialog Box UI Configuration").push("ui");
        DIALOG_BOX_WIDTH = BUILDER
                .comment("Dialog box width")
                .define("dialogBoxWidth", 320);
        DIALOG_BOX_HEIGHT = BUILDER
                .comment("Dialog box height")
                .define("dialogBoxHeight", 100);
        DIALOG_BOX_PADDING = BUILDER
                .comment("Dialog box Padding")
                .define("dialogBoxPadding", 10);
        DIALOG_BOX_X_OFFSET = BUILDER
                .comment("Dialog box x-offset")
                .define("dialogBoxXOffset", 0);
        DIALOG_TEXT_COLOR = BUILDER
                .comment("Dialog box text color (ARGB format)")
                .define("dialogTextColor", 0xFFFFFFFF);
        DIALOG_BACKGROUND_COLOR = BUILDER
                .comment("Default background color of the dialog box (RGB format)")
                .define("dialogBackgroundColor", 0x000000);
        DIALOG_BACKGROUND_OPACITY = BUILDER
                .comment("Dialog box background opacity (0-255)")
                .define("dialogBackgroundOpacity", 200);
        BUILDER.pop();

        BUILDER.comment("Character illustration settings").push("portrait");
        ENABLE_PORTRAIT_ANIMATIONS = BUILDER
                .comment("Enable character portrait animations.")
                .define("enablePortraitAnimations", true);
        BUILDER.pop();

        BUILDER.comment("Dialogue system configuration").push("system");
        IS_PAUSE_SCREEN = BUILDER
                .comment("Pause the game during dialogue (single-player mode only)")
                .define("isPauseScreen", true);
        AUTO_ADVANCE_DELAY = BUILDER
                .comment("Automatic dialogue progression delay time (milliseconds)")
                .define("autoAdvanceDelay", 700);
        SHOW_SPEAKER_NAME = BUILDER
                .comment("Should the speaker's name be displayed?")
                .define("showSpeakerName", true);
        TEXT_ANIMATION_SPEED = BUILDER
                .comment("The speed at which text is displayed character by character (characters per second; setting it to 0 will display all text instantly).")
                .defineInRange("textAnimationSpeed", 20, 0, 1000);
        BUILDER.pop();

        BUILDER.pop();
    }
    
    public static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
    }
}