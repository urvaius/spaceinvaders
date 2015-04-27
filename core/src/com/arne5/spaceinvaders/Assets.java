package com.arne5.spaceinvaders;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.lang.reflect.GenericDeclaration;

/**
 * Created by urvaius on 9/2/14.
 */
public class Assets


	{

		//fix all this using texture atlas after
		public static TextureAtlas atlas;
		public static Sprite PLAYER;
		public static Sprite ENEMY;
		public static Sprite greenEnemy;
		public static Sprite MISSILE;
		public static Sprite shootButton;
		public static Sprite startScreen;
		public static Sprite gameBack;
		public static Sprite gameWon;
		public static Sprite gameOver;
		public static Sound laser;
		public static Music gameMusic;
		//public static Sprite paused;
		//public static Sprite PLAYER_SPRITE;
		//public static Texture PLAYER_TEXTURE;



		public static void Load()
			{
				atlas = new TextureAtlas("pack.atlas");


				PLAYER = atlas.createSprite("playerShip1_green");


				PLAYER.setSize(PLAYER.getWidth()/2,PLAYER.getHeight()/2);


				shootButton = atlas.createSprite("powerupBlue");
				startScreen = atlas.createSprite("startscreen2");

				ENEMY = atlas.createSprite("enemyBlue1");
				ENEMY.setSize(ENEMY.getWidth()/2,ENEMY.getHeight()/2);

				greenEnemy = atlas.createSprite("enemyGreen2");
				greenEnemy.setSize(greenEnemy.getWidth()/2,greenEnemy.getHeight()/2);


				MISSILE= atlas.createSprite("laserGreen05");
				MISSILE.setSize(MISSILE.getWidth()/2,MISSILE.getHeight()/2);
				gameBack = atlas.createSprite("PrimaryStar520");


				gameWon = atlas.createSprite("gamewon");
				gameOver = atlas.createSprite("gameover");

				//sounds  TODO: should create a audio manager for this would not be hard.
				laser = Gdx.audio.newSound(Gdx.files.internal("laser1.wav"));
				gameMusic= Gdx.audio.newMusic(Gdx.files.internal("gameMusic.mp3"));

				//ENEMY.setSize(.1f,.1f);

				//paused = atlas.createSprite("paused");
				//PLAYER_TEXTURE= PLAYER.
				//get texture from sprite atlas
				//PLAYER_SPRITE= atlas.createSprite("playerShip1_green");
				//PLAYER_TEXTURE = PLAYER_SPRITE.getTexture();



			}


		//not using textureatlas can't get it to work yet


		//public static Texture PLAYER= new Texture(Gdx.files.internal("playerShip1_green.png"));

		//public static Texture ENEMY= new Texture(Gdx.files.internal("enemyRed1.png"));
		//public static Texture MISSILE = new Texture(Gdx.files.internal("laserGreen05.png"));

		//try to cut these out now
		//public static Texture GAME_WON = new Texture(Gdx.files.internal("gamewon.png"));
		//public static Texture GAME_OVER = new Texture(Gdx.files.internal("gameover.png"));
	}
