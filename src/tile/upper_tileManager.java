package tile;

import Game.GamePanel;
import entity.Player;
import entity.entity;

import java.awt.*;



public class upper_tileManager {

    GamePanel panel;
    Tile[] tiles;
    public static float filterall=0.8f;

    //    int maptilenum[][];

    public static int[] map= {

            1 , 1, 3, 1,1 , 1

    };





    public upper_tileManager(GamePanel panel) {
        this.panel = panel;
        tiles = new Tile[10];


    }

    public void draw(Graphics2D g) {
        int worldcol=0;
        int worldrow=0;
//            if(GamePanel.sun_screen_periods<=250) {
//                GamePanel.sky_height = GamePanel.sky_height - 6;
//            }else if(GamePanel.sun_screen_periods<=500) {
//                GamePanel.sky_height = GamePanel.sky_height + 6;
//            }
        int count=0;
        while (worldcol<5 && worldrow<GamePanel.maxworldrow) {


            int worldx= worldcol*GamePanel.titlesize;
            int worldy= worldrow*GamePanel.titlesize;
            int screenx=worldx- entity.worldx + Player.screenx+GamePanel.sun_screenx_constant;
            int screeny=worldy- entity.worldy + Player.screeny+GamePanel.sun_screeny_constant;

            count++;

            if (map[count]!=1 && map[count]!=2 && map[count]!=0) {


                switch (map[count]) {

                    case 3:

                        g.drawImage(GamePanel.images.get(GamePanel.sky_bright), screenx-60, screeny, 1380, GamePanel.sky_height, null);

                        break;
                }
            }

            worldcol++;


            if (worldcol==5) {
                worldcol=0;
                worldrow++;



            }

        }




    }
}

