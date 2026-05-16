package top.yourzi.dialog;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

/**
 * 对话系统的配置类。
 */
@EventBusSubscriber(modid = Dialog.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    
    // 对话框UI配置
    public static final ModConfigSpec.ConfigValue<Integer> DIALOG_BOX_WIDTH; // 对话框宽度
    public static final ModConfigSpec.ConfigValue<Integer> DIALOG_BOX_HEIGHT; // 对话框高度
    public static final ModConfigSpec.ConfigValue<Integer> DIALOG_BOX_PADDING; // 对话框内边距
    public static final ModConfigSpec.ConfigValue<Integer> DIALOG_BOX_X_OFFSET; // 对话框 X-偏移量
    public static final ModConfigSpec.ConfigValue<Integer> DIALOG_TEXT_COLOR; // 对话文本默认颜色
    public static final ModConfigSpec.ConfigValue<Integer> DIALOG_BACKGROUND_COLOR; // 对话框背景颜色
    public static final ModConfigSpec.ConfigValue<Integer> DIALOG_BACKGROUND_OPACITY; // 对话框背景不透明度
    public static final ModConfigSpec.ConfigValue<Boolean> USE_CUSTOM_BUTTON_TEXTURE; // 是否使用自定义按钮纹理

    // 立绘配置
    public static final ModConfigSpec.ConfigValue<Boolean> ENABLE_PORTRAIT_ANIMATIONS; // 启用立绘动画
    
    // 对话系统配置
    public static final ModConfigSpec.ConfigValue<Boolean> IS_PAUSE_SCREEN; // 是否在对话时暂停游戏（仅单人）
    public static final ModConfigSpec.ConfigValue<Integer> AUTO_ADVANCE_DELAY; // 自动推进对话延迟 (毫秒)
    public static final ModConfigSpec.ConfigValue<Boolean> SHOW_SPEAKER_NAME; // 显示说话者名称
    public static final ModConfigSpec.ConfigValue<Integer> TEXT_ANIMATION_SPEED; // 文本逐字显示速度 (每秒字符数，0表示立即显示全部)

    static {
        BUILDER.comment("==== [ Sunlit Dialog Config ] ====").push("dialog_client");

        BUILDER.comment("Dialog Box UI Configuration").push("ui");
        DIALOG_BOX_WIDTH = BUILDER
                .comment("Dialog box width")
                .define("dialogBoxWidth", 240);
        DIALOG_BOX_HEIGHT = BUILDER
                .comment("Dialog box height")
                .define("dialogBoxHeight", 72);
        DIALOG_BOX_PADDING = BUILDER
                .comment("Dialog box Padding")
                .define("dialogBoxPadding", 10);
        DIALOG_BOX_X_OFFSET = BUILDER
                .comment("Dialog box x-offset")
                .define("dialogBoxXOffset", 30);
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
        USE_CUSTOM_BUTTON_TEXTURE = BUILDER
                .comment("是否使用自定义按钮纹理（否则使用Minecraft原版按钮纹理）")
                .define("useCustomButtonTexture", false);
        BUILDER.pop();

        BUILDER.pop();
    }

    public static final ModConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final net.neoforged.fml.event.config.ModConfigEvent event) {
    }
}
