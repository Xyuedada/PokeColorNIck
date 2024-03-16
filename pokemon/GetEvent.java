/*    */ package pokemon;
/*    */ 
/*    */ import com.pixelmonmod.pixelmon.Pixelmon;
/*    */ import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetEvent
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
/* 18 */     if (commandSender.hasPermission("Pnick.op")) {
/* 19 */       if (args.length == 0 || "help".equalsIgnoreCase(args[0])) {
/* 20 */         commandSender.sendMessage("&ePokeColorNick>>>&c请输入/pnick set <player> <slot> <nickname> 来设置昵称哦!".replace("&", "§"));
/* 21 */       } else if ("set".equalsIgnoreCase(args[0])) {
/* 22 */         if (args.length <= 1) {
/* 23 */           commandSender.sendMessage("&ePokeColorNick>>>&c未输入玩家名！".replace("&", "§"));
/* 24 */           return false;
/*    */         } 
/* 26 */         Player player = Bukkit.getPlayer(args[1]);
/* 27 */         if (player == null || args[1].equals("")) {
/* 28 */           commandSender.sendMessage("&ePokeColorNick>>>&c该玩家并不在线！".replace("&", "§"));
/*    */         } else {
/* 30 */           if (args.length <= 2 || args[2].equals("")) {
/* 31 */             commandSender.sendMessage("&ePokeColorNick>>>&c你没有填写背包精灵序号呢（1~6）".replace("&", "§"));
/* 32 */             return false;
/*    */           } 
/* 34 */           if (args[2].equals("1") || args[2].equals("2") || args[2].equals("3") || args[2].equals("4") || args[2].equals("5") || args[2].equals("6")) {
/* 35 */             int i = Integer.parseInt(args[2]);
/* 36 */             int x = i - 1;
/* 37 */             if (args.length <= 3 || args[3].equals("")) {
/* 38 */               commandSender.sendMessage("&ePokeColorNick>>>&a昵称已清空！".replace("&", "§"));
/* 39 */               ((Pokemon)Objects.<Pokemon>requireNonNull(Pixelmon.storageManager.getParty(player.getUniqueId()).get(x))).setNickname(null);
/*    */             } else {
/* 41 */               ((Pokemon)Objects.<Pokemon>requireNonNull(Pixelmon.storageManager.getParty(player.getUniqueId()).get(x))).setNickname(args[3].replace("&", "§"));
/* 42 */               if (commandSender instanceof CommandExecutor) {
/* 43 */                 commandSender.sendMessage("&ePokeColorNick>>>&a你成功为精灵设置了昵称 !".replace("&", "§"));
/*    */               } else {
/* 45 */                 commandSender.sendMessage("&ePokeColorNick>>>>&a你成功给玩家&7 ".replace("&", "§") + player.getName() + " &a修改精灵昵称为&f ".replace("&", "§") + args[3].replace("&", "§"));
/*    */               } 
/*    */             } 
/*    */           } else {
/* 49 */             commandSender.sendMessage("&ePokeColorNick>>>&c背包精灵序号必须在（1~6）范围内！".replace("&", "§"));
/*    */           }
/*    */         
/*    */         }
/*    */       
/*    */       }
/*    */     
/*    */     } else {
/*    */       
/* 58 */       commandSender.sendMessage("&ePokeColorNick>>>>&7你缺少权限 &cPnick.op &7来修改精灵的昵称！".replace("&", "§"));
/*    */     } 
/* 60 */     return false;
/*    */   }
/*    */ }