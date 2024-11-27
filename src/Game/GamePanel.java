package Game;

import entity.Player;
import tile.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;


public class GamePanel extends JPanel implements Runnable {
   static final int originaltitlesize =16;//16x16
   static final int scale =3;
   public static final int titlesize =originaltitlesize*scale;//48x48
   public static final int maxscreencol=28;
   public static final int maxscreenrow=16;
   public static final int screenwith=titlesize*maxscreencol;//768
   public static final int screenheight=maxscreenrow*titlesize;//576

   public static float sun_screenx =0;
   public static int sun_screenx_constant =0;
   public static int screen_move=0;

   public static float sun_screeny =0;
   public static int sun_screeny_constant =0;

   public static int sun_screen_periods=0;
   public static int sun_screen_periods_counter=0;

    
    public static int mountain_screenx =0;
    public static int mountain_screenx_1 =0;
    public static int mountain_screenx_2 =0;
    public static int mountain_screeny =0;
    public static double mountain_screen_counter=0;
    public static double mountain_screen_counter_1=0;
    public static double mountain_screen_counter_2=0;

    public static String sky_bright="Sky_1";
    public static int sky_bright_counter=0;
    public static int sky_bright_counter_1=0;

    public static int sky_height=550;

    public static String ground_bright="ground_1_1.png";

    public static String mountain_bright_1="mountain_1_1.png";
    public static String mountain_bright_2="mountain_2_1.png";
    public static String mountain_bright_3="mountain_3_1.png";
    public static int mountain_bright_counter=0;
    public static int mountain_bright_counter_1=0;


    public static String cloud_species="cloud_special_1.png";
    public static float cloud_appear_time=0;
    public static float cloud_speed=1;


    public static int jumpCooldown=0;


    public static final int maxworldcol=120;

    public static final int maxworldrow=1;

    
    int FPS=60;

    public static HashMap<String,BufferedImage> images;


    upper_tileManager tileM = new upper_tileManager(this);
    Sun_tileManager treeM = new Sun_tileManager(this);
    Mountain_tileManager_1 mountainM = new Mountain_tileManager_1(this);
    Mountain_tileManager_2 mountainM2 = new Mountain_tileManager_2(this);
    Mountain_tileManager_3 mountainM3 = new Mountain_tileManager_3(this);
    Ground_tileManager groundM = new Ground_tileManager(this);
    keyHandler handler = new keyHandler();
    clouds_tilemanager cloudM = new clouds_tilemanager(this);
    Thread gameThread;



    public Player player;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenwith,screenheight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(handler);
        this.setFocusable(true);
        player = new Player(this,handler);
        images= new HashMap<>();
        loadImagesGround();
        loadImagesSunMoon();
        loadImagesMountains();
        loadImagesClouds();
        loadImagesSky();
        loadImagesPlayer();
    }
    void loadImagesGround(){
        try {
            images.put("Ground", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/ground/ground_1_1.png"))));
            images.put("Ground_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/ground/ground_1_2.png"))));
        } catch (IOException e) {
    
            e.printStackTrace();
        }
    }
    void loadImagesSunMoon(){
        try {
            images.put("Sun_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/sun/sun_1_1.png"))));
            images.put("Moon_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/moon/Moon.png"))));
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    void loadImagesMountains(){
        try {
            images.put("Mountain_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/mountain/mountain_1.png"))));
            images.put("Mountain_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/mountain/mountain_1_2.png"))));
            images.put("Mountain_3", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/mountain/mountain_3.png"))));
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    void loadImagesClouds(){
        try {
            images.put("Cloud_1", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/clouds/cloud_empty.png"))));
            images.put("Cloud_2", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/clouds/cloud_special_1.png"))));
            images.put("Cloud_3", ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/clouds/cloud_special_2.png"))));
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    void loadImagesSky(){
        try {
            int count=1;
            int i=0;
            while (i<100) {
                images.put("Sky_"+String.valueOf(count), ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/sky/sky_1_"+String.valueOf(count)+".png"))));
                i++;
                count++;
            }
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    void loadImagesPlayer(){
        try {
            int count=1;
            int i=0;
            while (i<12) {
                images.put("Player_Left_"+String.valueOf(count), ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/left_"+String.valueOf(count)+".png"))));
                images.put("Player_Right_"+String.valueOf(count), ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/right_"+String.valueOf(count)+".png"))));
                i++;
                count++;
            }   
        
        
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override


    public void run() {

       double drawInterval;
       drawInterval = 1000000000/FPS;
       double delta = 0;
       long lastTime = System.nanoTime();
       long currentTime;
       long timer = 0;
       int drawCount = 0;


       while (gameThread!=null) {

           currentTime = System.nanoTime();

           delta += (currentTime-lastTime)/drawInterval;
           timer += (currentTime-lastTime);
           lastTime = currentTime;

           if (delta >= 1) {
               update();
               repaint();
               Toolkit.getDefaultToolkit().sync();
               delta--;
               drawCount++;
               try {
                Thread.sleep(19);
            } catch (InterruptedException e) {
            
                e.printStackTrace();
            }
           }

           if (timer>=1000000000){
               System.out.println("FPS: "+drawCount);
               drawCount=0;
               timer=0;

           }


       }
    }
    public static void update() {
        Player.uptade();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        tileM.draw(g2d);


        treeM.draw(g2d);

        mountainM3.draw(g2d);
        mountainM2.draw(g2d);
        mountainM.draw(g2d);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.70f));

        cloudM.draw(g2d);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));

        groundM.draw(g2d);

        Player.draw(g2d);


        g2d.dispose();

    }









}
