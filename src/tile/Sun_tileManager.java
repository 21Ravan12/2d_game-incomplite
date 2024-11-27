package tile;

import Game.GamePanel;
import entity.Player;
import entity.entity;

import java.awt.*;



public class Sun_tileManager {

    GamePanel panel;
    Tile[] tiles;
    public static float filterall=0.5f;

    //    int maptilenum[][];

    public static int[] map= {

            1 , 1, 3, 1, 1, 1

    };





    public Sun_tileManager(GamePanel panel) {
        this.panel = panel;
        tiles = new Tile[10];


//        maptilenum = new int[game_panel.maxscreencol][game_panel.maxscreenrow];



    }

    public void draw(Graphics2D g) {
        if (GamePanel.sun_screen_periods>=0 && GamePanel.sun_screen_periods<=1280){
            GamePanel.sun_screenx+= 0.0625F/2;
            GamePanel.sun_screeny-=0.1875f/2;
        } else if (GamePanel.sun_screen_periods>=1281 && GamePanel.sun_screen_periods<=2560) {
            GamePanel.sun_screeny-=0.1875f/2;
            GamePanel.sun_screenx+=0.125f/2;
        }else if (GamePanel.sun_screen_periods>=2561 && GamePanel.sun_screen_periods<=3840) {
            GamePanel.sun_screenx+=0.125f/2;
            GamePanel.sun_screeny-=0.125f/2;
        }else if (GamePanel.sun_screen_periods>=3841 && GamePanel.sun_screen_periods<=5120) {
            GamePanel.sun_screenx+=0.1875f/2;
            GamePanel.sun_screeny-=0.0625f/2;
        }else if (GamePanel.sun_screen_periods>=5121 && GamePanel.sun_screen_periods<=6400) {
            GamePanel.sun_screenx+=0.25f/2;
            GamePanel.sun_screeny-=0.0625f/2;
        }else if (GamePanel.sun_screen_periods>=6401 && GamePanel.sun_screen_periods<=8000) {
            GamePanel.sun_screenx+=0.3125f/2;
            GamePanel.sun_screeny-=0.0625f/2;
        }else if (GamePanel.sun_screen_periods>=8001 && GamePanel.sun_screen_periods<=9600) {
            GamePanel.sun_screenx+=0.3125f/2;
            GamePanel.sun_screeny+=0.0625f/2;
        }else if (GamePanel.sun_screen_periods>=9601 && GamePanel.sun_screen_periods<=10880) {
            GamePanel.sun_screenx+=0.25f/2;
            GamePanel.sun_screeny+=0.0625f/2;
        }else if (GamePanel.sun_screen_periods>=10881 && GamePanel.sun_screen_periods<=12160) {
            GamePanel.sun_screenx+=0.1875f/2;
            GamePanel.sun_screeny+=0.0625f/2;
        }else if (GamePanel.sun_screen_periods>=12161 && GamePanel.sun_screen_periods<=13440) {
            GamePanel.sun_screenx+=0.125f/2;
            GamePanel.sun_screeny+=0.125f/2;
        }else if (GamePanel.sun_screen_periods>=13441 && GamePanel.sun_screen_periods<=14720) {
            GamePanel.sun_screeny+=0.1875f/2;
            GamePanel.sun_screenx+=0.0625f/2;
        }else if (GamePanel.sun_screen_periods>=14721 && GamePanel.sun_screen_periods<16000){
            GamePanel.sun_screenx+=0.0625f/2;
            GamePanel.sun_screeny+=0.1875f/2;

        }else if (GamePanel.sun_screen_periods>=16000){
            GamePanel.sun_screen_periods=0;
            GamePanel.sun_screen_periods_counter=0;
            GamePanel.sun_screenx=0;
            GamePanel.sun_screeny=0;
        }
        GamePanel.sun_screen_periods_counter++;
        GamePanel.sun_screen_periods++;
        GamePanel.cloud_appear_time+=1;

        if( GamePanel.sun_screen_periods%40==0&& map[2]==3&&GamePanel.sun_screen_periods_counter<=2000||
            GamePanel.sun_screen_periods%40==0&& map[2]==3&&GamePanel.sun_screen_periods_counter>=14000){
            GamePanel.sky_bright_counter_1++;

            if (GamePanel.sky_bright_counter_1>=0&&GamePanel.sky_bright_counter_1<=50){
                GamePanel.sky_bright_counter++;
                if (GamePanel.sky_bright_counter>50){
                    GamePanel.sky_bright_counter=50;
                }
                GamePanel.sky_bright="Sky_"+String.valueOf(GamePanel.sky_bright_counter);
                GamePanel.ground_bright="ground_1_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_1="mountain_1_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_2="mountain_2_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_3="mountain_3_"+String.valueOf(GamePanel.sky_bright_counter)+".png";


            }else if(GamePanel.sky_bright_counter_1 >= 51 && GamePanel.sky_bright_counter_1 <= 99){
                GamePanel.sky_bright_counter-=1;
                if (GamePanel.sky_bright_counter<1){
                    GamePanel.sky_bright_counter=1;
                }
                GamePanel.sky_bright="Sky_"+String.valueOf(GamePanel.sky_bright_counter);
                GamePanel.ground_bright="ground_1_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_1="mountain_1_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_2="mountain_2_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_3="mountain_3_"+String.valueOf(GamePanel.sky_bright_counter)+".png";

            }

        } else if (GamePanel.sun_screen_periods%40==0&& map[2]==4&&GamePanel.sun_screen_periods_counter<=2000||
                GamePanel.sun_screen_periods%40==0&& map[2]==4&&GamePanel.sun_screen_periods_counter>=14000) {
            if (GamePanel.sky_bright_counter==1){
                GamePanel.sky_bright_counter=51;
            }
            GamePanel.sky_bright_counter_1++;
            if (GamePanel.sky_bright_counter_1>=100&&GamePanel.sky_bright_counter_1<=150){
                GamePanel.sky_bright_counter++;
                if (GamePanel.sky_bright_counter>100){
                    GamePanel.sky_bright_counter=100;
                }
                GamePanel.sky_bright="Sky_"+String.valueOf(GamePanel.sky_bright_counter);
                GamePanel.ground_bright="ground_1_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_1="mountain_1_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_2="mountain_2_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_3="mountain_3_"+String.valueOf(GamePanel.sky_bright_counter)+".png";

            }else if(GamePanel.sky_bright_counter_1>=151&&GamePanel.sky_bright_counter_1<200){
                GamePanel.sky_bright_counter-=1;
                if (GamePanel.sky_bright_counter<51){
                    GamePanel.sky_bright_counter=51;
                }
                GamePanel.sky_bright="Sky_"+String.valueOf(GamePanel.sky_bright_counter);
                GamePanel.ground_bright="ground_1_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_1="mountain_1_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_2="mountain_2_"+String.valueOf(GamePanel.sky_bright_counter)+".png";
                GamePanel.mountain_bright_3="mountain_3_"+String.valueOf(GamePanel.sky_bright_counter)+".png";

            }else {
                GamePanel.sky_bright_counter=0;
                GamePanel.sky_bright_counter_1=0;
            }

        }






        int worldcol=0;
        int worldrow=0;

        if (GamePanel.sun_screen_periods>=16000){
            if (map[2]==3){
                map[2]=4;
            }else if (map[2]==4){
                map[2]=3;
            }

        }
        int count=0;
        while (worldcol<5&&worldrow<GamePanel.maxworldrow) {


            int worldx= worldcol*GamePanel.titlesize;
            int worldy= worldrow*GamePanel.titlesize;
            float screenx=worldx- entity.worldx + Player.screenx+GamePanel.sun_screenx+GamePanel.sun_screenx_constant;
            float screeny=worldy- entity.worldy + Player.screeny+GamePanel.sun_screeny+GamePanel.sun_screeny_constant;

            count++;

                if (map[count]!=1 && map[count]!=2 && map[count]!=0) {


                    switch (map[count]) {

                        case 3:

                            g.drawImage(GamePanel.images.get("Sun_1"), (int) (screenx-130), (int) (screeny+400), 96, 96, null);

                            break;
                        case 4:
                            g.drawImage(GamePanel.images.get("Moon_1"), (int) (screenx-130), (int) (screeny+400), 96, 96, null);
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

