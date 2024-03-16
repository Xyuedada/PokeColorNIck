/*    */ package pokemon;
/*    */ 
/*    */

import NickListener.nickname;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


/*    */ public class Main
        /*    */   extends JavaPlugin {
    /*    */   public void onEnable() {
        /* 12 */     MainPlugin = this;
        /* 13 */     getServer().getConsoleSender().sendMessage("&ePokeColorNick>>>&f正在加载监听器...".replace("&", "§"));
        /* 14 */     Bukkit.getPluginManager().registerEvents(new nickname(), this);
        /* 15 */     getServer().getConsoleSender().sendMessage("&ePokeColorNick>>>&f正在加载指令...".replace("&", "§"));
        /* 16 */     Bukkit.getPluginCommand("pnick").setExecutor(new GetEvent());
        /* 17 */     getServer().getConsoleSender().sendMessage("&ePokeColorNick>>>&f精灵彩色昵称插件成功加载了哦 !".replace("&", "§"));
        /* 17 */     getServer().getConsoleSender().sendMessage("&ePokeColorNick>>>&f当前版本:V1.4 欢迎你的使用！".replace("&", "§"));
        /* 18 */     getServer().getConsoleSender().sendMessage("&ePokeColorNick>>>&f作者:Xyue_dada  问题反馈加QQ:1289901426".replace("&", "§"));
        /*    */   }
    /*    */   private static Main MainPlugin;

    /*    */
    /*    */   public void onDisable() {
        /* 23 */     getServer().getConsoleSender().sendMessage("&ePokeColorNick>>>&f精灵彩色昵称插件成功卸载!".replace("&", "§"));
        /*    */   }
    /*    */
    /*    */   public static Main getMainPlugin() {
        /* 27 */     return MainPlugin;
        /*    */   }
    /*    */ }
