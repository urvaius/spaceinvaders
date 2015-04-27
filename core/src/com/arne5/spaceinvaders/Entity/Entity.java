package com.arne5.spaceinvaders.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by urvaius on 11/12/14.
 */
public abstract class Entity
	{

		//protected Texture texture;
		protected Sprite sprite;
		protected Vector2 pos,direction;
		protected float width;
		protected float height;




		public Entity(Sprite sprite, Vector2 pos, Vector2 direction,float width, float height)

		{

			//this.texture= texture;
			this.sprite = sprite;
			//trying to set sizes etc probably make a variable




			sprite.setX(pos.x);
			sprite.setY(pos.y);



			this.pos= pos;
			this.direction =direction;
			//trying to use size options
			this.width = width;
			this.height = height;

		}

		public Vector2 getPosition()
			{
				return pos;
			}

		public abstract void update();



		public void render(SpriteBatch sb)

			{
				//for texture way
				//sb.draw(texture,pos.x,pos.y);
				//for sprite way?
				//sb.draw(sprite,pos.x,pos.y,);
				sb.draw(sprite,pos.x,pos.y,width,height);
				//sprite.draw(sb);
				//sprite.draw(sb);



			}
		public Rectangle getBounds()
			{
				//return new Rectangle(pos.x,pos.y-texture.getHeight(),texture.getWidth(),texture.getHeight());
				return new Rectangle(pos.x ,pos.y-sprite.getHeight() *.2f,sprite.getWidth()*0.8f ,sprite.getHeight()*0.8f);

			}


		public void setDirection(float x, float y)
			{
				direction.set(x,y);

				direction.scl(Gdx.graphics.getDeltaTime());
			}

	}
