package tile;

import Game.GamePanel;
import entity.Player;
import entity.entity;

import java.awt.*;


public class Mountain_tileManager_3 {

    GamePanel panel;
    Tile[] tiles;

    public static int[] map= {

            1 , 1, 3, 1, 1, 1

    };





    public Mountain_tileManager_3(GamePanel panel) {
        this.panel = panel;
        tiles = new Tile[10];




    }

    public void draw(Graphics2D g) {
        int worldcol=0;
        int worldrow=0;



        int count=0;
        while (worldcol<5&&worldrow<GamePanel.maxworldrow) {


            int worldx= worldcol*GamePanel.titlesize;
            int worldy= worldrow*GamePanel.titlesize;
            int screenx=worldx- entity.worldx + Player.screenx+GamePanel.mountain_screenx_2;
            int screeny=worldy- entity.worldy + Player.screeny+GamePanel.mountain_screeny;

            count++;

            if (map[count]!=1 && map[count]!=2 && map[count]!=0) {


                switch (map[count]) {

                    case 3:
                        g.drawImage(GamePanel.images.get("Mountain_3"), screenx+300, screeny+269, 450, 300, null);
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


