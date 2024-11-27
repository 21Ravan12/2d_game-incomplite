package entity;

import Game.GamePanel;
import Game.keyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends entity {
    GamePanel panel;
    public static keyHandler handler;


    public static int screenx=0;
    public static int screeny=0;

    public static Rectangle hitBox;

    public static int playerHeight=144;
    public static int playerWidth=144;

    public Player(GamePanel panel, keyHandler handler) {

        this.panel = panel;
        Player.handler = handler;

        screenx=GamePanel.screenwith/2-GamePanel.titlesize/2+GamePanel.screen_move;
        screeny=GamePanel.screenheight/2-GamePanel.titlesize/2;

        hitBox = new Rectangle(screenx+20+GamePanel.screen_move,screeny+64,playerWidth-130,playerHeight);

        setDefaultValues();
     
    }




    public void setDefaultValues() {
        worldx=648;
        worldy=360;
        speed=4;
        direction="right";
        direction1="right";
    }

    

    public static void uptade() {
        GamePanel.jumpCooldown++;
        if (handler.upPressed||handler.downPressed||handler.leftPressed||handler.rightPressed||handler.jumpPressed) {
            GamePanel.mountain_screen_counter+=0.004;
            GamePanel.mountain_screen_counter_1+=0.0008;
            GamePanel.mountain_screen_counter_2+=0.00008;
        if (handler.leftPressed&& !handler.shiftPressed) {
            direction="left";
            direction1="left";

            if (worldx>650){
            if(GamePanel.screen_move<220){
               GamePanel.screen_move+=1;
            }
            worldx-=speed;
            GamePanel.sun_screenx_constant-=speed;
            GamePanel.mountain_screenx-=speed;
            GamePanel.mountain_screenx_1-=speed;
            GamePanel.mountain_screenx_2-=speed;
            if (GamePanel.mountain_screen_counter_1>=1){
                    GamePanel.mountain_screenx_1+=1;
                    GamePanel.mountain_screen_counter_1=0;

                }
                if (GamePanel.mountain_screen_counter_2>=1){
                    GamePanel.mountain_screenx_2+=1;
                    GamePanel.mountain_screen_counter_2=0;

                }
            if (GamePanel.mountain_screen_counter>=1){
            GamePanel.mountain_screenx+=1;
            GamePanel.mountain_screen_counter=0;

            }}
        }else if (handler.rightPressed&& !handler.shiftPressed) {
            direction="right";
            direction1="right";
            if(GamePanel.screen_move>-220){
                GamePanel.screen_move-=1;
            }
            GamePanel.sun_screenx_constant+=speed;
            worldx+=speed;
            GamePanel.mountain_screenx+=speed;
            GamePanel.mountain_screenx_1+=speed;
            GamePanel.mountain_screenx_2+=speed;
            if (GamePanel.mountain_screen_counter_1>=1){
                GamePanel.mountain_screenx_1-=1;
                GamePanel.mountain_screen_counter_1=0;
            }
            if (GamePanel.mountain_screen_counter_2>=1){
                GamePanel.mountain_screenx_2-=1;
                GamePanel.mountain_screen_counter_2=0;
            }
            if (GamePanel.mountain_screen_counter>=1){
                GamePanel.mountain_screenx-=1;
                GamePanel.mountain_screen_counter=0;

            }

        } else if (handler.leftPressed&&handler.shiftPressed) {
            direction="left";
            direction1="left";

            if (worldx>650){
                if(GamePanel.screen_move<220){
                    GamePanel.screen_move+=2;
                }
                worldx-=speed*2;
                GamePanel.sun_screenx_constant-=speed*2;
                GamePanel.mountain_screenx-=speed*2;
                GamePanel.mountain_screenx_1-=speed*2;
                GamePanel.mountain_screenx_2-=speed*2;
                if (GamePanel.mountain_screen_counter_1>=0.5){
                    GamePanel.mountain_screenx_1+=1;
                    GamePanel.mountain_screen_counter_1=0;

                }
                if (GamePanel.mountain_screen_counter_2>=0.5){
                    GamePanel.mountain_screenx_2+=1;
                    GamePanel.mountain_screen_counter_2=0;

                }
                if (GamePanel.mountain_screen_counter>=0.5){
                    GamePanel.mountain_screenx+=1;
                    GamePanel.mountain_screen_counter=0;

                }}


        } else if (handler.rightPressed&&handler.shiftPressed) {
            direction="right";
            direction1="right";
            if(GamePanel.screen_move>-220){
                GamePanel.screen_move-=2;
            }
            GamePanel.sun_screenx_constant+=speed*2;
            worldx+=speed*2;
            GamePanel.mountain_screenx+=speed*2;
            GamePanel.mountain_screenx_1+=speed*2;
            GamePanel.mountain_screenx_2+=speed*2;
            if (GamePanel.mountain_screen_counter_1>=0.5){
                GamePanel.mountain_screenx_1-=1;
                GamePanel.mountain_screen_counter_1=0;
            }
            if (GamePanel.mountain_screen_counter_2>=0.5){
                GamePanel.mountain_screenx_2-=1;
                GamePanel.mountain_screen_counter_2=0;
            }
            if (GamePanel.mountain_screen_counter>=0.5){
                GamePanel.mountain_screenx-=1;
                GamePanel.mountain_screen_counter=0;

            }


        } else {

            if(GamePanel.screen_move>0){
                GamePanel.screen_move-=1;
            }
        }
            if (handler.jumpPressed && GamePanel.jumpCooldown>150) {
                GamePanel.jumpCooldown=0;
                if (direction.equals("left")) {
                    worldx-=500;
                    GamePanel.sun_screenx_constant-=500;
                    GamePanel.mountain_screenx-=500;
                    GamePanel.mountain_screenx_1-=500;
                    GamePanel.mountain_screenx_2-=500;
                }else if (direction.equals("right")) {
                    worldx+=500;
                    GamePanel.sun_screenx_constant+=500;
                    GamePanel.mountain_screenx+=500;
                    GamePanel.mountain_screenx_1+=500;
                    GamePanel.mountain_screenx_2+=500;
                }

            }



            spriteCounter++;

        if(spriteCounter > 0 && spriteCounter<8){
           spriteNumber = 1;
        }else if (spriteCounter > 8 && spriteCounter<16){
           spriteNumber = 2;
        }else if (spriteCounter > 16 && spriteCounter<24){
           spriteNumber = 3;
        }else if (spriteCounter > 24&&spriteCounter<32){
           spriteNumber = 4;
        }else if (spriteCounter > 32 && spriteCounter<40){
            spriteNumber = 5;
        }else if (spriteCounter > 40&&spriteCounter<48){
            spriteNumber = 6;
        }else if (spriteCounter > 48 && spriteCounter<56){
            spriteNumber = 7;
        }else if (spriteCounter > 56&&spriteCounter<64){
            spriteNumber = 8;
        }else if (spriteCounter > 64 && spriteCounter<72){
            spriteNumber = 9;
        }else if (spriteCounter > 72&&spriteCounter<80){
            spriteNumber = 10;
        }else if (spriteCounter > 80 && spriteCounter<88){
            spriteNumber = 11;
        }else if (spriteCounter > 88&&spriteCounter<96){
            spriteNumber = 12;
        }else if (spriteCounter > 96 ){
            spriteCounter = 1;
        }




    }else{
            direction="none";
            if(GamePanel.screen_move<0){
                GamePanel.screen_move+=1;
//                screenx+=1;
            } else if (GamePanel.screen_move>0) {
                GamePanel.screen_move-=1;
//                screenx-=1;
            }
        }

    }
    public static void draw(Graphics2D g2d) {

        BufferedImage image=GamePanel.images.get("Player_Right_1");



        switch (direction) {

            case "left":

                if (spriteNumber==1){
                    image=GamePanel.images.get("Player_Left_1");
                }
                if (spriteNumber==2){
                    image=GamePanel.images.get("Player_Left_2");
                }
                if (spriteNumber==3){
                    image=GamePanel.images.get("Player_Left_3");
                }
                if (spriteNumber==4){
                    image=GamePanel.images.get("Player_Left_4");
                }
                if (spriteNumber==5){
                    image=GamePanel.images.get("Player_Left_5");
                }
                if (spriteNumber==6){
                    image=GamePanel.images.get("Player_Left_6");
                }
                if (spriteNumber==7){
                    image=GamePanel.images.get("Player_Left_7");
                }
                if (spriteNumber==8){
                    image=GamePanel.images.get("Player_Left_8");
                }
                if (spriteNumber==9){
                    image=GamePanel.images.get("Player_Left_9");
                }
                if (spriteNumber==10){
                    image=GamePanel.images.get("Player_Left_10");
                }
                if (spriteNumber==11){
                    image=GamePanel.images.get("Player_Left_11");
                }
                if (spriteNumber==12){
                    image=GamePanel.images.get("Player_Left_12");
                }

                break;
            case "right":

            if (spriteNumber==1){
                image=GamePanel.images.get("Player_Right_1");
            }
            if (spriteNumber==2){
                image=GamePanel.images.get("Player_Right_2");
            }
            if (spriteNumber==3){
                image=GamePanel.images.get("Player_Right_3");
            }
            if (spriteNumber==4){
                image=GamePanel.images.get("Player_Right_4");
            }
            if (spriteNumber==5){
                image=GamePanel.images.get("Player_Right_5");
            }
            if (spriteNumber==6){
                image=GamePanel.images.get("Player_Right_6");
            }
            if (spriteNumber==7){
                image=GamePanel.images.get("Player_Right_7");
            }
            if (spriteNumber==8){
                image=GamePanel.images.get("Player_Right_8");
            }
            if (spriteNumber==9){
                image=GamePanel.images.get("Player_Right_9");
            }
            if (spriteNumber==10){
                image=GamePanel.images.get("Player_Right_10");
            }
            if (spriteNumber==11){
                image=GamePanel.images.get("Player_Right_11");
            }
            if (spriteNumber==12){
                image=GamePanel.images.get("Player_Right_12");
            }

                break;
                case "none":
                    if (direction1.equals("right")){
                        image=GamePanel.images.get("Player_Right_1");
                    }else {
                        image=GamePanel.images.get("Player_Left_1");
                    }

                    break;
        }

          hitBox.setLocation(screenx+20+GamePanel.screen_move,screeny+64);
          g2d.drawImage(image,screenx-40+GamePanel.screen_move,screeny+64,playerWidth,playerHeight,null);
          //g2d.drawRect(screenx+20+GamePanel.screen_move,screeny+64,playerWidth-130,playerHeight);



    }
}
