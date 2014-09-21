package com.arne5.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by urvaius on 9/2/14.
 */
public class Assets


	{

		//fix all this using texture atlas after
		public static TextureAtlas atlas;
		//public static Texture PLAYER;
		//public static Sprite PLAYER_SPRITE;
		//public static Texture PLAYER_TEXTURE;



		public static void Load()
			{
				atlas = new TextureAtlas("pack.atlas");


				//PLAYER = atlas.createSprite("playerShip1_green");
				//PLAYER_TEXTURE= PLAYER.
				//get texture from sprite atlas
				//PLAYER_SPRITE= atlas.createSprite("playerShip1_green");
				//PLAYER_TEXTURE = PLAYER_SPRITE.getTexture();



			}


		//not using textureatlas can't get it to work yet
		public static Texture PLAYER= new Texture(Gdx.files.internal("playerShip1_green.png"));

	}
