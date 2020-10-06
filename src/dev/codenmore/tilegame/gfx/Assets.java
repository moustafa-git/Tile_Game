package dev.codenmore.tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
   
    public static Font font32;
    public static Font font28;
     public static Font font48;
    
    public static BufferedImage[] player_idle,player_run_down,player_run_left,player_run_right,player_run_up,player_slice_down,player_slice_left,
            player_slice_right,player_slice_up;
    public static BufferedImage[] vampire_idle,vampire_run_down,vampire_run_left,vampire_run_right,vampire_run_up,vampire_slice_down,vampire_slice_left,
            vampire_slice_right,vampire_slice_up;
    public static BufferedImage[] btn_play;
    public static BufferedImage[] btn_quit;
    public static BufferedImage[] demon_idle,demon_attack;
    public static BufferedImage[] skeleton_idle,skeleton_attack;
    public static BufferedImage scoreBoardScreen;
    public static BufferedImage[] btn_viking;
    public static BufferedImage[] btn_vampire;
    
    public static BufferedImage grass,grass2,grass3,
            road,road2,road3,road4,road5,road6,road7,road8,road9,road10,road11,
            roof,roof2,roof3,roof4,roof5,roof6,roof7,
            wall,wall2,wall3,wall4,wall5,wall6,wall7,wall8,wall9,wall10,
            window,window2,
            door,door2,door3,
            lake,lake2,lake3,lake4,lake5,lake6,
            stair,
            tree,tree2,tree3,
            bush,
            block,blockW,blockB,
            chair,
            fence,
            fountain,
            box,box2,
            menu,
            dmg1,dmg2,
            heal1,heal2,
            speed1,speed2,
            armor1,armor2,
            a5,
            necklace,
            gameover,
            h100,h83,h67,h50,h33,h17,
            p100,p90,p80,p70,p60,p50,p40,p30,p20,p10,p0,
            dmgIcon,
            viking,vampire; //TILES
    
    public static void init(){ //LOADS EVERY ASSET IN THE GAME AND ONLY CALLED ONCE.
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/magecity.png"));
        
        dmgIcon = ImageLoader.loadImage("/items/dmgIcon.png");
        
        h100 = ImageLoader.loadImage("/health/100.png");
        h83 = ImageLoader.loadImage("/health/83.png");
        h67 = ImageLoader.loadImage("/health/67.png");
        h50 = ImageLoader.loadImage("/health/50.png");
        h33 = ImageLoader.loadImage("/health/33.png");
        h17 = ImageLoader.loadImage("/health/17.png");
        
        p100 = ImageLoader.loadImage("/health/p100.png");
        p90 = ImageLoader.loadImage("/health/p90.png");
        p80 = ImageLoader.loadImage("/health/p80.png");
        p70 = ImageLoader.loadImage("/health/p70.png");
        p60 = ImageLoader.loadImage("/health/p60.png");
        p50 = ImageLoader.loadImage("/health/p50.png");
        p40 = ImageLoader.loadImage("/health/p40.png");
        p30 = ImageLoader.loadImage("/health/p30.png");
        p20 = ImageLoader.loadImage("/health/p20.png");
        p10 = ImageLoader.loadImage("/health/p10.png");
        p0 = ImageLoader.loadImage("/health/p0.png");
        
        font32 = FontLoader.loadFont("res/fonts/Minecraft.ttf", 32);
        font28 = FontLoader.loadFont("res/fonts/Minecraft.ttf", 28);
        font48 = FontLoader.loadFont("res/fonts/Minecraft.ttf", 48);
        
        scoreBoardScreen = ImageLoader.loadImage("/textures/wolf.gif");
        
        a5 = ImageLoader.loadImage("/buttons/a5.png");
        
        dmg1 = ImageLoader.loadImage("/items/dmg1.png");
        dmg2 = ImageLoader.loadImage("/items/dmg2.png");
        
        heal1 = ImageLoader.loadImage("/items/heal1.png");
        heal2 = ImageLoader.loadImage("/items/heal2.png");
        
        speed1 = ImageLoader.loadImage("/items/speed1.png");
        speed2 = ImageLoader.loadImage("/items/speed2.png");
        
        armor1 = ImageLoader.loadImage("/items/armor1.png");
        armor2 = ImageLoader.loadImage("/items/armor2.png");
        
        necklace = ImageLoader.loadImage("/items/necklace.png");
        
        
        
         tree = sheet.crop(0,400,31,80);
         tree2 = sheet.crop(130,400,125,200);
         tree3 = sheet.crop(62,480,75,130);
        
         bush = sheet.crop(8,968,90,80);
         
         block = sheet.crop(160,65,32,64);
         blockW = sheet.crop(32,420,32,64);
         blockB = sheet.crop(64,390,64,90);
         
         chair = sheet.crop(0,480,68,64);
         
         fence = sheet.crop(64,1250,64,60);
         
         fountain = sheet.crop(190,64,64,60);
         
         box = sheet.crop(50,68,112,60);
         box2 = sheet.crop(194,1350,62,60);
         
         menu = ImageLoader.loadImage("/buttons/menu.jpg");
         gameover = ImageLoader.loadImage("/textures/gameover.jpg");
         
         
         viking = ImageLoader.loadImage("/buttons/viking.jpg");
         
        btn_viking = new BufferedImage[2];
        btn_viking[0] = ImageLoader.loadImage("/buttons/viking.jpg");
        btn_viking[1] = ImageLoader.loadImage("/buttons/vikingHover.jpg");
        
        btn_vampire = new BufferedImage[2];
        btn_vampire[0] = ImageLoader.loadImage("/buttons/vampire.jpg");
        btn_vampire[1] = ImageLoader.loadImage("/buttons/vampireHover.jpg");
         
        btn_play = new BufferedImage[2];
        btn_play[0] = ImageLoader.loadImage("/buttons/playB.png");
        btn_play[1] = ImageLoader.loadImage("/buttons/playG.png");
        
        btn_quit = new BufferedImage[2];
        btn_quit[0] = ImageLoader.loadImage("/buttons/quitB.png");
        btn_quit[1] = ImageLoader.loadImage("/buttons/quitG.png");
       
        demon_idle = new BufferedImage[6];
        demon_idle[0] = ImageLoader.loadImage("/demon/demon-idle1.png");
        demon_idle[1] = ImageLoader.loadImage("/demon/demon-idle2.png");
        demon_idle[2] = ImageLoader.loadImage("/demon/demon-idle3.png");
        demon_idle[3] = ImageLoader.loadImage("/demon/demon-idle4.png");
        demon_idle[4] = ImageLoader.loadImage("/demon/demon-idle5.png");
        demon_idle[5] = ImageLoader.loadImage("/demon/demon-idle6.png");
        
        demon_attack = new BufferedImage[11];
        demon_attack[0] = ImageLoader.loadImage("/demon/demon-attack1.png");
        demon_attack[1] = ImageLoader.loadImage("/demon/demon-attack2.png");
        demon_attack[2] = ImageLoader.loadImage("/demon/demon-attack3.png");
        demon_attack[3] = ImageLoader.loadImage("/demon/demon-attack4.png");
        demon_attack[4] = ImageLoader.loadImage("/demon/demon-attack5.png");
        demon_attack[5] = ImageLoader.loadImage("/demon/demon-attack6.png");
        demon_attack[6] = ImageLoader.loadImage("/demon/demon-attack7.png");
        demon_attack[7] = ImageLoader.loadImage("/demon/demon-attack8.png");
        demon_attack[8] = ImageLoader.loadImage("/demon/demon-attack9.png");
        demon_attack[9] = ImageLoader.loadImage("/demon/demon-attack10.png");
        demon_attack[10] = ImageLoader.loadImage("/demon/demon-attack11.png");
         
        
        //SKELETON /////////////
        skeleton_idle = new BufferedImage[11];
        skeleton_idle[0] = ImageLoader.loadImage("/skeleton/SkeletonIdle_1.png");
        skeleton_idle[1] = ImageLoader.loadImage("/skeleton/SkeletonIdle_2.png");
        skeleton_idle[2] = ImageLoader.loadImage("/skeleton/SkeletonIdle_3.png");
        skeleton_idle[3] = ImageLoader.loadImage("/skeleton/SkeletonIdle_4.png");
        skeleton_idle[4] = ImageLoader.loadImage("/skeleton/SkeletonIdle_5.png");
        skeleton_idle[5] = ImageLoader.loadImage("/skeleton/SkeletonIdle_6.png");
        skeleton_idle[6] = ImageLoader.loadImage("/skeleton/SkeletonIdle_7.png");
        skeleton_idle[7] = ImageLoader.loadImage("/skeleton/SkeletonIdle_8.png");
        skeleton_idle[8] = ImageLoader.loadImage("/skeleton/SkeletonIdle_9.png");
        skeleton_idle[9] = ImageLoader.loadImage("/skeleton/SkeletonIdle_10.png");
        skeleton_idle[10] = ImageLoader.loadImage("/skeleton/SkeletonIdle_11.png");
        
        
        skeleton_attack = new BufferedImage[18];
        skeleton_attack[0] = ImageLoader.loadImage("/skeleton/SkeletonAttack_1.png");
        skeleton_attack[1] = ImageLoader.loadImage("/skeleton/SkeletonAttack_2.png");
        skeleton_attack[2] = ImageLoader.loadImage("/skeleton/SkeletonAttack_3.png");
        skeleton_attack[3] = ImageLoader.loadImage("/skeleton/SkeletonAttack_4.png");
        skeleton_attack[4] = ImageLoader.loadImage("/skeleton/SkeletonAttack_5.png");
        skeleton_attack[5] = ImageLoader.loadImage("/skeleton/SkeletonAttack_6.png");
        skeleton_attack[6] = ImageLoader.loadImage("/skeleton/SkeletonAttack_7.png");
        skeleton_attack[7] = ImageLoader.loadImage("/skeleton/SkeletonAttack_8.png");
        skeleton_attack[8] = ImageLoader.loadImage("/skeleton/SkeletonAttack_9.png");
        skeleton_attack[9] = ImageLoader.loadImage("/skeleton/SkeletonAttack_10.png");
        skeleton_attack[10] = ImageLoader.loadImage("/skeleton/SkeletonAttack_11.png");
        skeleton_attack[11] = ImageLoader.loadImage("/skeleton/SkeletonAttack_12.png");
        skeleton_attack[12] = ImageLoader.loadImage("/skeleton/SkeletonAttack_13.png");
        skeleton_attack[13] = ImageLoader.loadImage("/skeleton/SkeletonAttack_14.png");
        skeleton_attack[14] = ImageLoader.loadImage("/skeleton/SkeletonAttack_15.png");
        skeleton_attack[15] = ImageLoader.loadImage("/skeleton/SkeletonAttack_16.png");
        skeleton_attack[16] = ImageLoader.loadImage("/skeleton/SkeletonAttack_17.png");
        skeleton_attack[17] = ImageLoader.loadImage("/skeleton/SkeletonAttack_18.png");
        
        
        ///////////////////////////////////////////////////
        player_idle = new BufferedImage[4];
        player_idle[0] = ImageLoader.loadImage("/viking/knight iso char_idle_0.png");
        player_idle[1] = ImageLoader.loadImage("/viking/knight iso char_idle_1.png");
        player_idle[2] = ImageLoader.loadImage("/viking/knight iso char_idle_2.png");
        player_idle[3] = ImageLoader.loadImage("/viking/knight iso char_idle_3.png");
        
        player_run_down = new BufferedImage[5];
        player_run_down[0] = ImageLoader.loadImage("/viking/knight iso char_run down_0.png");
        player_run_down[1] = ImageLoader.loadImage("/viking/knight iso char_run down_1.png");
        player_run_down[2] = ImageLoader.loadImage("/viking/knight iso char_run down_2.png");
        player_run_down[3] = ImageLoader.loadImage("/viking/knight iso char_run down_3.png");
        player_run_down[4] = ImageLoader.loadImage("/viking/knight iso char_run down_4.png");
        
        player_run_left = new BufferedImage[6];
        player_run_left[0] = ImageLoader.loadImage("/viking/knight iso char_run left_0.png");
        player_run_left[1] = ImageLoader.loadImage("/viking/knight iso char_run left_1.png");
        player_run_left[2] = ImageLoader.loadImage("/viking/knight iso char_run left_2.png");
        player_run_left[3] = ImageLoader.loadImage("/viking/knight iso char_run left_3.png");
        player_run_left[4] = ImageLoader.loadImage("/viking/knight iso char_run left_4.png");
        player_run_left[5] = ImageLoader.loadImage("/viking/knight iso char_run left_5.png");
             
        player_run_right = new BufferedImage[6];
        player_run_right[0] = ImageLoader.loadImage("/viking/knight iso char_run right_0.png");
        player_run_right[1] = ImageLoader.loadImage("/viking/knight iso char_run right_1.png");
        player_run_right[2] = ImageLoader.loadImage("/viking/knight iso char_run right_2.png");
        player_run_right[3] = ImageLoader.loadImage("/viking/knight iso char_run right_3.png");
        player_run_right[4] = ImageLoader.loadImage("/viking/knight iso char_run right_4.png");
        player_run_right[5] = ImageLoader.loadImage("/viking/knight iso char_run right_5.png");
        
        player_run_up = new BufferedImage[5];
        player_run_up[0] = ImageLoader.loadImage("/viking/knight iso char_run up_0.png");
        player_run_up[1] = ImageLoader.loadImage("/viking/knight iso char_run up_1.png");
        player_run_up[2] = ImageLoader.loadImage("/viking/knight iso char_run up_2.png");
        player_run_up[3] = ImageLoader.loadImage("/viking/knight iso char_run up_3.png");
        player_run_up[4] = ImageLoader.loadImage("/viking/knight iso char_run up_4.png");
        
        player_slice_down = new BufferedImage[3];
        player_slice_down[0] = ImageLoader.loadImage("/viking/knight iso char_slice down_0.png");
        player_slice_down[1] = ImageLoader.loadImage("/viking/knight iso char_slice down_1.png");
        player_slice_down[2] = ImageLoader.loadImage("/viking/knight iso char_slice down_2.png");
        
        player_slice_right = new BufferedImage[3];
        player_slice_right[0] = ImageLoader.loadImage("/viking/knight iso char_slice left_0.png");
        player_slice_right[1] = ImageLoader.loadImage("/viking/knight iso char_slice left_1.png");
        player_slice_right[2] = ImageLoader.loadImage("/viking/knight iso char_slice left_2.png");
        
        player_slice_left = new BufferedImage[3];
        player_slice_left[0] = ImageLoader.loadImage("/viking/knight iso char_slice right_0.png");
        player_slice_left[1] = ImageLoader.loadImage("/viking/knight iso char_slice right_2.png");
        player_slice_left[2] = ImageLoader.loadImage("/viking/knight iso char_slice right_1.png");
        
        player_slice_up = new BufferedImage[3];
        player_slice_up[0] = ImageLoader.loadImage("/viking/knight iso char_slice up_0.png");
        player_slice_up[1] = ImageLoader.loadImage("/viking/knight iso char_slice up_1.png");
        player_slice_up[2] = ImageLoader.loadImage("/viking/knight iso char_slice up_2.png");
        
        
        //VAMPIRE///////////////////////////////////////////////////////////////////////////////////////
        vampire_idle = new BufferedImage[28];
        vampire_idle[0] = ImageLoader.loadImage("/vampire/idle_1.png");
        vampire_idle[1] = ImageLoader.loadImage("/vampire/idle_2.png");
        vampire_idle[2] = ImageLoader.loadImage("/vampire/idle_3.png");
        vampire_idle[3] = ImageLoader.loadImage("/vampire/idle_4.png");
        vampire_idle[4] = ImageLoader.loadImage("/vampire/idle_5.png");
        vampire_idle[5] = ImageLoader.loadImage("/vampire/idle_6.png");
        vampire_idle[6] = ImageLoader.loadImage("/vampire/idle_7.png");
        vampire_idle[7] = ImageLoader.loadImage("/vampire/idle_8.png");
        vampire_idle[8] = ImageLoader.loadImage("/vampire/idle_9.png");
        vampire_idle[9] = ImageLoader.loadImage("/vampire/idle_10.png");
        vampire_idle[10] = ImageLoader.loadImage("/vampire/idle_11.png");
        vampire_idle[11] = ImageLoader.loadImage("/vampire/idle_12.png");
        vampire_idle[12] = ImageLoader.loadImage("/vampire/idle_13.png");
        vampire_idle[13] = ImageLoader.loadImage("/vampire/idle_14.png");
        vampire_idle[14] = ImageLoader.loadImage("/vampire/idle_15.png");
        vampire_idle[15] = ImageLoader.loadImage("/vampire/idle_16.png");
        vampire_idle[16] = ImageLoader.loadImage("/vampire/idle_17.png");
        vampire_idle[17] = ImageLoader.loadImage("/vampire/idle_18.png");
        vampire_idle[18] = ImageLoader.loadImage("/vampire/idle_19.png");
        vampire_idle[19] = ImageLoader.loadImage("/vampire/idle_20.png");
        vampire_idle[20] = ImageLoader.loadImage("/vampire/idle_21.png");
        vampire_idle[21] = ImageLoader.loadImage("/vampire/idle_22.png");
        vampire_idle[22] = ImageLoader.loadImage("/vampire/idle_23.png");
        vampire_idle[23] = ImageLoader.loadImage("/vampire/idle_24.png");
        vampire_idle[24] = ImageLoader.loadImage("/vampire/idle_25.png");
        vampire_idle[25] = ImageLoader.loadImage("/vampire/idle_26.png");
        vampire_idle[26] = ImageLoader.loadImage("/vampire/idle_27.png");
        vampire_idle[27] = ImageLoader.loadImage("/vampire/idle_28.png");
        
        
        vampire_run_down = new BufferedImage[19];
        vampire_run_down[0] = ImageLoader.loadImage("/vampire/down_1.png");
        vampire_run_down[1] = ImageLoader.loadImage("/vampire/down_2.png");
        vampire_run_down[2] = ImageLoader.loadImage("/vampire/down_3.png");
        vampire_run_down[3] = ImageLoader.loadImage("/vampire/down_4.png");
        vampire_run_down[4] = ImageLoader.loadImage("/vampire/down_5.png");
        vampire_run_down[5] = ImageLoader.loadImage("/vampire/down_6.png");
        vampire_run_down[6] = ImageLoader.loadImage("/vampire/down_7.png");
        vampire_run_down[7] = ImageLoader.loadImage("/vampire/down_8.png");
        vampire_run_down[8] = ImageLoader.loadImage("/vampire/down_9.png");
        vampire_run_down[9] = ImageLoader.loadImage("/vampire/down_10.png");
        vampire_run_down[10] = ImageLoader.loadImage("/vampire/down_11.png");
        vampire_run_down[11] = ImageLoader.loadImage("/vampire/down_12.png");
        vampire_run_down[12] = ImageLoader.loadImage("/vampire/down_13.png");
        vampire_run_down[13] = ImageLoader.loadImage("/vampire/down_14.png");
        vampire_run_down[14] = ImageLoader.loadImage("/vampire/down_15.png");
        vampire_run_down[15] = ImageLoader.loadImage("/vampire/down_16.png");
        vampire_run_down[16] = ImageLoader.loadImage("/vampire/down_17.png");
        vampire_run_down[17] = ImageLoader.loadImage("/vampire/down_18.png");
        vampire_run_down[18] = ImageLoader.loadImage("/vampire/down_19.png");

        
        vampire_run_left = new BufferedImage[19];
        vampire_run_left[0] = ImageLoader.loadImage("/vampire/left_1.png");
        vampire_run_left[1] = ImageLoader.loadImage("/vampire/left_2.png");
        vampire_run_left[2] = ImageLoader.loadImage("/vampire/left_3.png");
        vampire_run_left[3] = ImageLoader.loadImage("/vampire/left_4.png");
        vampire_run_left[4] = ImageLoader.loadImage("/vampire/left_5.png");
        vampire_run_left[5] = ImageLoader.loadImage("/vampire/left_6.png");
        vampire_run_left[6] = ImageLoader.loadImage("/vampire/left_7.png");
        vampire_run_left[7] = ImageLoader.loadImage("/vampire/left_8.png");
        vampire_run_left[8] = ImageLoader.loadImage("/vampire/left_9.png");
        vampire_run_left[9] = ImageLoader.loadImage("/vampire/left_10.png");
        vampire_run_left[10] = ImageLoader.loadImage("/vampire/left_11.png");
        vampire_run_left[11] = ImageLoader.loadImage("/vampire/left_12.png");
        vampire_run_left[12] = ImageLoader.loadImage("/vampire/left_13.png");
        vampire_run_left[13] = ImageLoader.loadImage("/vampire/left_14.png");
        vampire_run_left[14] = ImageLoader.loadImage("/vampire/left_15.png");
        vampire_run_left[15] = ImageLoader.loadImage("/vampire/left_16.png");
        vampire_run_left[16] = ImageLoader.loadImage("/vampire/left_17.png");
        vampire_run_left[17] = ImageLoader.loadImage("/vampire/left_18.png");
        vampire_run_left[18] = ImageLoader.loadImage("/vampire/left_19.png");
             
        vampire_run_right = new BufferedImage[19];
        vampire_run_right[0] = ImageLoader.loadImage("/vampire/right_1.png");
        vampire_run_right[1] = ImageLoader.loadImage("/vampire/right_2.png");
        vampire_run_right[2] = ImageLoader.loadImage("/vampire/right_3.png");
        vampire_run_right[3] = ImageLoader.loadImage("/vampire/right_4.png");
        vampire_run_right[4] = ImageLoader.loadImage("/vampire/right_5.png");
        vampire_run_right[5] = ImageLoader.loadImage("/vampire/right_6.png");
        vampire_run_right[6] = ImageLoader.loadImage("/vampire/right_7.png");
        vampire_run_right[7] = ImageLoader.loadImage("/vampire/right_8.png");
        vampire_run_right[8] = ImageLoader.loadImage("/vampire/right_9.png");
        vampire_run_right[9] = ImageLoader.loadImage("/vampire/right_10.png");
        vampire_run_right[10] = ImageLoader.loadImage("/vampire/right_11.png");
        vampire_run_right[11] = ImageLoader.loadImage("/vampire/right_12.png");
        vampire_run_right[12] = ImageLoader.loadImage("/vampire/right_13.png");
        vampire_run_right[13] = ImageLoader.loadImage("/vampire/right_14.png");
        vampire_run_right[14] = ImageLoader.loadImage("/vampire/right_15.png");
        vampire_run_right[15] = ImageLoader.loadImage("/vampire/right_16.png");
        vampire_run_right[16] = ImageLoader.loadImage("/vampire/right_17.png");
        vampire_run_right[17] = ImageLoader.loadImage("/vampire/right_18.png");
        vampire_run_right[18] = ImageLoader.loadImage("/vampire/right_19.png");
        
        vampire_run_up = new BufferedImage[19];
        vampire_run_up[0] = ImageLoader.loadImage("/vampire/forward_1.png");
        vampire_run_up[1] = ImageLoader.loadImage("/vampire/forward_2.png");
        vampire_run_up[2] = ImageLoader.loadImage("/vampire/forward_3.png");
        vampire_run_up[3] = ImageLoader.loadImage("/vampire/forward_4.png");
        vampire_run_up[4] = ImageLoader.loadImage("/vampire/forward_5.png");
        vampire_run_up[5] = ImageLoader.loadImage("/vampire/forward_6.png");
        vampire_run_up[6] = ImageLoader.loadImage("/vampire/forward_7.png");
        vampire_run_up[7] = ImageLoader.loadImage("/vampire/forward_8.png");
        vampire_run_up[8] = ImageLoader.loadImage("/vampire/forward_9.png");
        vampire_run_up[9] = ImageLoader.loadImage("/vampire/forward_10.png");
        vampire_run_up[10] = ImageLoader.loadImage("/vampire/forward_11.png");
        vampire_run_up[11] = ImageLoader.loadImage("/vampire/forward_12.png");
        vampire_run_up[12] = ImageLoader.loadImage("/vampire/forward_13.png");
        vampire_run_up[13] = ImageLoader.loadImage("/vampire/forward_14.png");
        vampire_run_up[14] = ImageLoader.loadImage("/vampire/forward_15.png");
        vampire_run_up[15] = ImageLoader.loadImage("/vampire/forward_16.png");
        vampire_run_up[16] = ImageLoader.loadImage("/vampire/forward_17.png");
        vampire_run_up[17] = ImageLoader.loadImage("/vampire/forward_18.png");
        vampire_run_up[18] = ImageLoader.loadImage("/vampire/forward_19.png");
        
        vampire_slice_down = new BufferedImage[26];
        vampire_slice_down[0] = ImageLoader.loadImage("/vampire/attack_down_1.png");
        vampire_slice_down[1] = ImageLoader.loadImage("/vampire/attack_down_2.png");
        vampire_slice_down[2] = ImageLoader.loadImage("/vampire/attack_down_3.png");
        vampire_slice_down[3] = ImageLoader.loadImage("/vampire/attack_down_4.png");
        vampire_slice_down[4] = ImageLoader.loadImage("/vampire/attack_down_5.png");
        vampire_slice_down[5] = ImageLoader.loadImage("/vampire/attack_down_6.png");
        vampire_slice_down[6] = ImageLoader.loadImage("/vampire/attack_down_7.png");
        vampire_slice_down[7] = ImageLoader.loadImage("/vampire/attack_down_8.png");
        vampire_slice_down[8] = ImageLoader.loadImage("/vampire/attack_down_9.png");
        vampire_slice_down[9] = ImageLoader.loadImage("/vampire/attack_down_10.png");
        vampire_slice_down[10] = ImageLoader.loadImage("/vampire/attack_down_11.png");
        vampire_slice_down[11] = ImageLoader.loadImage("/vampire/attack_down_12.png");
        vampire_slice_down[12] = ImageLoader.loadImage("/vampire/attack_down_13.png");
        vampire_slice_down[13] = ImageLoader.loadImage("/vampire/attack_down_14.png");
        vampire_slice_down[14] = ImageLoader.loadImage("/vampire/attack_down_15.png");
        vampire_slice_down[15] = ImageLoader.loadImage("/vampire/attack_down_16.png");
        vampire_slice_down[16] = ImageLoader.loadImage("/vampire/attack_down_17.png");
        vampire_slice_down[17] = ImageLoader.loadImage("/vampire/attack_down_18.png");
        vampire_slice_down[18] = ImageLoader.loadImage("/vampire/attack_down_19.png");
        vampire_slice_down[19] = ImageLoader.loadImage("/vampire/attack_down_20.png");
        vampire_slice_down[20] = ImageLoader.loadImage("/vampire/attack_down_21.png");
        vampire_slice_down[21] = ImageLoader.loadImage("/vampire/attack_down_22.png");
        vampire_slice_down[22] = ImageLoader.loadImage("/vampire/attack_down_23.png");
        vampire_slice_down[23] = ImageLoader.loadImage("/vampire/attack_down_24.png");
        vampire_slice_down[24] = ImageLoader.loadImage("/vampire/attack_down_25.png");
        vampire_slice_down[25] = ImageLoader.loadImage("/vampire/attack_down_26.png");
        
        vampire_slice_right = new BufferedImage[26];
        vampire_slice_right[0] = ImageLoader.loadImage("/vampire/attack_right_1.png");
        vampire_slice_right[1] = ImageLoader.loadImage("/vampire/attack_right_2.png");
        vampire_slice_right[2] = ImageLoader.loadImage("/vampire/attack_right_3.png");
        vampire_slice_right[3] = ImageLoader.loadImage("/vampire/attack_right_4.png");
        vampire_slice_right[4] = ImageLoader.loadImage("/vampire/attack_right_5.png");
        vampire_slice_right[5] = ImageLoader.loadImage("/vampire/attack_right_6.png");
        vampire_slice_right[6] = ImageLoader.loadImage("/vampire/attack_right_7.png");
        vampire_slice_right[7] = ImageLoader.loadImage("/vampire/attack_right_8.png");
        vampire_slice_right[8] = ImageLoader.loadImage("/vampire/attack_right_9.png");
        vampire_slice_right[9] = ImageLoader.loadImage("/vampire/attack_right_10.png");
        vampire_slice_right[10] = ImageLoader.loadImage("/vampire/attack_right_11.png");
        vampire_slice_right[11] = ImageLoader.loadImage("/vampire/attack_right_12.png");
        vampire_slice_right[12] = ImageLoader.loadImage("/vampire/attack_right_13.png");
        vampire_slice_right[13] = ImageLoader.loadImage("/vampire/attack_right_14.png");
        vampire_slice_right[14] = ImageLoader.loadImage("/vampire/attack_right_15.png");
        vampire_slice_right[15] = ImageLoader.loadImage("/vampire/attack_right_16.png");
        vampire_slice_right[16] = ImageLoader.loadImage("/vampire/attack_right_17.png");
        vampire_slice_right[17] = ImageLoader.loadImage("/vampire/attack_right_18.png");
        vampire_slice_right[18] = ImageLoader.loadImage("/vampire/attack_right_19.png");
        vampire_slice_right[19] = ImageLoader.loadImage("/vampire/attack_right_20.png");
        vampire_slice_right[20] = ImageLoader.loadImage("/vampire/attack_right_21.png");
        vampire_slice_right[21] = ImageLoader.loadImage("/vampire/attack_right_22.png");
        vampire_slice_right[22] = ImageLoader.loadImage("/vampire/attack_right_23.png");
        vampire_slice_right[23] = ImageLoader.loadImage("/vampire/attack_right_24.png");
        vampire_slice_right[24] = ImageLoader.loadImage("/vampire/attack_right_25.png");
        vampire_slice_right[25] = ImageLoader.loadImage("/vampire/attack_right_26.png");
        

        
        vampire_slice_left = new BufferedImage[26];
        vampire_slice_left[0] = ImageLoader.loadImage("/vampire/attack_left_1.png");
        vampire_slice_left[1] = ImageLoader.loadImage("/vampire/attack_left_2.png");
        vampire_slice_left[2] = ImageLoader.loadImage("/vampire/attack_left_3.png");
        vampire_slice_left[3] = ImageLoader.loadImage("/vampire/attack_left_4.png");
        vampire_slice_left[4] = ImageLoader.loadImage("/vampire/attack_left_5.png");
        vampire_slice_left[5] = ImageLoader.loadImage("/vampire/attack_left_6.png");
        vampire_slice_left[6] = ImageLoader.loadImage("/vampire/attack_left_7.png");
        vampire_slice_left[7] = ImageLoader.loadImage("/vampire/attack_left_8.png");
        vampire_slice_left[8] = ImageLoader.loadImage("/vampire/attack_left_9.png");
        vampire_slice_left[9] = ImageLoader.loadImage("/vampire/attack_left_10.png");
        vampire_slice_left[10] = ImageLoader.loadImage("/vampire/attack_left_11.png");
        vampire_slice_left[11] = ImageLoader.loadImage("/vampire/attack_left_12.png");
        vampire_slice_left[12] = ImageLoader.loadImage("/vampire/attack_left_13.png");
        vampire_slice_left[13] = ImageLoader.loadImage("/vampire/attack_left_14.png");
        vampire_slice_left[14] = ImageLoader.loadImage("/vampire/attack_left_15.png");
        vampire_slice_left[15] = ImageLoader.loadImage("/vampire/attack_left_16.png");
        vampire_slice_left[16] = ImageLoader.loadImage("/vampire/attack_left_17.png");
        vampire_slice_left[17] = ImageLoader.loadImage("/vampire/attack_left_18.png");
        vampire_slice_left[18] = ImageLoader.loadImage("/vampire/attack_left_19.png");
        vampire_slice_left[19] = ImageLoader.loadImage("/vampire/attack_left_20.png");
        vampire_slice_left[20] = ImageLoader.loadImage("/vampire/attack_left_21.png");
        vampire_slice_left[21] = ImageLoader.loadImage("/vampire/attack_left_22.png");
        vampire_slice_left[22] = ImageLoader.loadImage("/vampire/attack_left_23.png");
        vampire_slice_left[23] = ImageLoader.loadImage("/vampire/attack_left_24.png");
        vampire_slice_left[24] = ImageLoader.loadImage("/vampire/attack_left_25.png");
        vampire_slice_left[25] = ImageLoader.loadImage("/vampire/attack_left_26.png");
        
        vampire_slice_up = new BufferedImage[26];
        vampire_slice_up[0] = ImageLoader.loadImage("/vampire/attack_forward_1.png");
        vampire_slice_up[1] = ImageLoader.loadImage("/vampire/attack_forward_2.png");
        vampire_slice_up[2] = ImageLoader.loadImage("/vampire/attack_forward_3.png");
        vampire_slice_up[3] = ImageLoader.loadImage("/vampire/attack_forward_4.png");
        vampire_slice_up[4] = ImageLoader.loadImage("/vampire/attack_forward_5.png");
        vampire_slice_up[5] = ImageLoader.loadImage("/vampire/attack_forward_6.png");
        vampire_slice_up[6] = ImageLoader.loadImage("/vampire/attack_forward_7.png");
        vampire_slice_up[7] = ImageLoader.loadImage("/vampire/attack_forward_8.png");
        vampire_slice_up[8] = ImageLoader.loadImage("/vampire/attack_forward_9.png");
        vampire_slice_up[9] = ImageLoader.loadImage("/vampire/attack_forward_10.png");
        vampire_slice_up[10] = ImageLoader.loadImage("/vampire/attack_forward_11.png");
        vampire_slice_up[11] = ImageLoader.loadImage("/vampire/attack_forward_12.png");
        vampire_slice_up[12] = ImageLoader.loadImage("/vampire/attack_forward_13.png");
        vampire_slice_up[13] = ImageLoader.loadImage("/vampire/attack_forward_14.png");
        vampire_slice_up[14] = ImageLoader.loadImage("/vampire/attack_forward_15.png");
        vampire_slice_up[15] = ImageLoader.loadImage("/vampire/attack_forward_16.png");
        vampire_slice_up[16] = ImageLoader.loadImage("/vampire/attack_forward_17.png");
        vampire_slice_up[17] = ImageLoader.loadImage("/vampire/attack_forward_18.png");
        vampire_slice_up[18] = ImageLoader.loadImage("/vampire/attack_forward_19.png");
        vampire_slice_up[19] = ImageLoader.loadImage("/vampire/attack_forward_20.png");
        vampire_slice_up[20] = ImageLoader.loadImage("/vampire/attack_forward_21.png");
        vampire_slice_up[21] = ImageLoader.loadImage("/vampire/attack_forward_22.png");
        vampire_slice_up[22] = ImageLoader.loadImage("/vampire/attack_forward_23.png");
        vampire_slice_up[23] = ImageLoader.loadImage("/vampire/attack_forward_24.png");
        vampire_slice_up[24] = ImageLoader.loadImage("/vampire/attack_forward_25.png");
        vampire_slice_up[25] = ImageLoader.loadImage("/vampire/attack_forward_26.png");
        
////////////////////////////////////////////////////////////////////////////////////////////////
        
        grass = sheet.crop(0,1,31,30);
        grass2 = sheet.crop(224,896,31,32);//DARK
        grass3 = sheet.crop(224,876,31,32); //SUPER DARK
        
        roof = sheet.crop(0,762,31,32); //RIGHT
        roof2 = sheet.crop(65,762,32,32); //LEFT
        roof3 = sheet.crop(36,800,31,32); //FRONT
        roof4 = sheet.crop(3,800,31,32); //LEFT CORNER
        roof5 = sheet.crop(63,800,31,32); //RIGHT CORNER
        roof6 = sheet.crop(32,736,32,36); //FLAT TOPEND
        roof7 = sheet.crop(32,740,32,36); //FLAT TOP
        
        
        road = sheet.crop(32,1,30,30);
        road2 = sheet.crop(0,1312, 30, 32); //UP POND
        road3 = sheet.crop(0,1376, 30, 32); //DOWN POMD
        road4 = sheet.crop(96,832, 32, 30); //LEFT
        road5 = sheet.crop(96,864, 32, 30); //RIGHT
        road6 = sheet.crop(96,896, 32, 30); //DOWN
        road7 = sheet.crop(96,926, 32, 34); //UP
        road8 = sheet.crop(126,928, 34, 32); //BOTTOM LEFT CORNER
        road9 = sheet.crop(160,928, 34, 32); //BOTTOM RIGHT CORNER
        road10 = sheet.crop(194,928, 34, 32); //UPPER RIGHT CORNER
        road11 = sheet.crop(220,928, 34, 32); //UPPER LEFT CORNER
        
        wall = sheet.crop(0,128, 34, 32); //LEFT MID
        wall2 = sheet.crop(34,128, 34, 32); //MIDDLE 1
        wall3 = sheet.crop(68,128, 26, 32); //RIGHT MID
        wall4 = sheet.crop(96,128, 34,32); //TOP LEFT
        wall5 = sheet.crop(130,128, 34, 32); //TOP MID
        wall6 = sheet.crop(155,128, 34, 32); //TOP RIGHT
        wall7 = sheet.crop(0,159, 34, 32); //BOT LEFT
        wall8 = sheet.crop(34,159, 34, 32); //BOT MID
        wall9 = sheet.crop(62,159, 34, 32); //BOT RIGHT
        wall10 = sheet.crop(96,160, 34, 32); //MIDDLE 2
        
        window = sheet.crop(143,697, 34, 30);
        window2 = sheet.crop(230,697, 20, 35);
        
        door = sheet.crop(200,1280, 20, 35); //TOP
        door2 = sheet.crop(200,1309, 20, 35); //BOT
        
        lake = sheet.crop(0,192, 34, 32); //TOP LEFT CORNER
        lake2 = sheet.crop(0,210, 34, 32); //LEFT
        lake3 = sheet.crop(37,192, 34, 32); //TOP
        lake4 = sheet.crop(37,220, 34, 32); //middle
        lake5 = sheet.crop(64,192, 34, 32); //TOP RIGHT CORNER
        lake6 = sheet.crop(64,215, 34, 32); //RIGHT
        
        stair = sheet.crop(225,224, 20, 49);
        
    }
}
