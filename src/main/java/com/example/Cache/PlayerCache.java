package com.example.Cache;


import com.example.model.SangongUser.SangongPlayer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.example.constant.ErrorMsg.ERROR_SAVE;
import static com.example.constant.ErrorMsg.SUCCESS;
import static com.example.constant.Player.PLAYER_TYPE_SANGONG;

/**
 * @author Administrator
 */
public class PlayerCache {
    private static final Logger logger = LogManager.getLogger(PlayerCache.class);
    private static final Map<Integer, SangongPlayer> playerCache = new ConcurrentHashMap<Integer, SangongPlayer>();

    /**
     * 新建一个用户
     *
     * @param type=1
     * @return
     */
    public static SangongPlayer newPlayer(Integer type) {
        switch (type) {
            case PLAYER_TYPE_SANGONG:
                return new SangongPlayer();
            /**
             * 如果新添加需要在这里添加
             */
            default:
                logger.error("新建玩家的时候type传入错误"+type);
                return new SangongPlayer();
        }
    }
    /**
     * 存储用户信息
     *
     * @param sangongPlayer
     * @return
     */
    public static int savePlayerInfo(SangongPlayer sangongPlayer) {
        if (sangongPlayer.getUserId() == null) {
            logger.error("存储用户信息的时候,用户uid为空"+sangongPlayer.toString());
            return ERROR_SAVE;
        }
        playerCache.put(sangongPlayer.getUserId(), sangongPlayer);
        return SUCCESS;
    }

    /**
     * 取出用户信息
     * @param uid
     * @return
     */
    public static SangongPlayer getPlayerInfo(Integer uid){
        if (uid==null){
            logger.error("取用户信息的时候uid为空了");
            return null;
        }
        return playerCache.get(uid);
    }

    /**
     * 删除用户信息
     * @param uid
     */
    public static void removePlayerInfo(Integer uid){
        if (uid==null||playerCache.get(uid)==null){
            logger.error("删除用户信息  uid错误");
        }else {
            playerCache.remove(uid);
        }
    }
}
