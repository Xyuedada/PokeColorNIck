/*    */ package NickListener;
/*    */ 
/*    */

import catserver.api.bukkit.event.ForgeEvent;
import com.pixelmonmod.pixelmon.api.events.pokemon.SetNicknameEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.storage.PokemonStorage;
import com.pixelmonmod.pixelmon.api.storage.StoragePosition;
import net.minecraft.entity.player.EntityPlayerMP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Objects;
import java.util.UUID;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class nickname
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onnicknamechange(ForgeEvent nevent) {
/* 24 */     if (nevent.getForgeEvent() instanceof SetNicknameEvent) {
/* 25 */       EntityPlayerMP p = ((SetNicknameEvent)nevent.getForgeEvent()).player;
/* 26 */       String nick = ((SetNicknameEvent)nevent.getForgeEvent()).nickname;
/* 27 */       Pokemon pokemon = ((SetNicknameEvent)nevent.getForgeEvent()).pokemon;
/* 28 */       String pl = (p.getBukkitEntity()).entityName;
/* 29 */       Player player = Bukkit.getPlayer(pl);
/* 30 */       int a = ((StoragePosition)Objects.requireNonNull(pokemon.getPosition())).order;
/* 31 */       UUID pname = (UUID)Objects.requireNonNull(((PokemonStorage)Objects.requireNonNull(pokemon.getStorage())).uuid);
/* 32 */       int b = a + 1;
/*    */       SetNicknameEvent e = (SetNicknameEvent) nevent.getForgeEvent();
/* 34 */       if (((PokemonStorage)Objects.requireNonNull(pokemon.getStorage())).uuid == null) {
/* 35 */         player.sendMessage("&ePokeColorNick>>>>&c该精灵不存在，无法修改昵称！".replace("&", "§"));
/*    */       }
/* 37 */       else if (player.hasPermission("pokemon.nickname")) {
/* 38 */
/*    */          if (nick.contains("&") || nick.isEmpty() ){
                      e.setCanceled(true);
                      player.sendMessage("&ePokeColorNick>>>>&c你无权修改精灵已经设置的彩色昵称!".replace("&", "§"));
                }else {
                       player.sendMessage("&ePokeColorNick>>>>&a你正在修改昵称...".replace("&", "§"));
                     }
/*    */       } else {
                 e.setCanceled(true);
/* 50 */         player.sendMessage("&ePokeColorNick>>>>&7你缺少权限 &cpokemon.nickname &7来修改精灵的昵称！".replace("&", "§"));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }
