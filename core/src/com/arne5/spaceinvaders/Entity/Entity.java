package com.arne5.spaceinvaders.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by urvaius on 9/2/14.
 */
public abstract class Entity
	{

		protected  Texture texture;
		protected Sprite sprite;
		protected Vector2 pos,direction;


		public Entity(Texture texture, Vector2 pos, Vector2 direction)
		//public Entity(Sprite sprite,Vector2 pos, Vector2 direction)
			{

				this.texture= texture;
				//this.sprite = sprite;
				//sprite.setX(pos.x);
				//sprite.setY(pos.y);

				this.pos= pos;
				this.direction =direction;

			}

		public Vector2 getPosition()
			{
				return pos;
			}

		public abstract void update();



		public void render(SpriteBatch sb)

			{
				//for texture way
				sb.draw(texture,pos.x,pos.y);
				//for sprite way?
				//sprite.draw(sb);



			}
		public Rectangle getBounds()
			{
				return new Rectangle(pos.x,pos.y-texture.getHeight(),texture.getWidth(),texture.getHeight());


			}


		public void setDirection(float x, float y)
			{
				direction.set(x,y);

				direction.scl(Gdx.graphics.getDeltaTime());
			}

	}
