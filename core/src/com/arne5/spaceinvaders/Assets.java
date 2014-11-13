package com.arne5.spaceinvaders;

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
		public static Sprite MISSILE;
		//public static Sprite PLAYER_SPRITE;
		//public static Texture PLAYER_TEXTURE;



		public static void Load()
			{
				atlas = new TextureAtlas("pack.atlas");


				PLAYER = atlas.createSprite("playerShip1_green");
				ENEMY = atlas.createSprite("enemyBlue1");
				MISSILE= atlas.createSprite("laserGreen05");
				//PLAYER_TEXTURE= PLAYER.
				//get texture from sprite atlas
				//PLAYER_SPRITE= atlas.createSprite("playerShip1_green");
				//PLAYER_TEXTURE = PLAYER_SPRITE.getTexture();



			}


		//not using textureatlas can't get it to work yet


		//public static Texture PLAYER= new Texture(Gdx.files.internal("playerShip1_green.png"));

		//public static Texture ENEMY= new Texture(Gdx.files.internal("enemyRed1.png"));
		//public static Texture MISSILE = new Texture(Gdx.files.internal("laserGreen05.png"));
		public static Texture GAME_WON = new Texture(Gdx.files.internal("gamewon.png"));
		public static Texture GAME_OVER = new Texture(Gdx.files.internal("gameover.png"));
	}
