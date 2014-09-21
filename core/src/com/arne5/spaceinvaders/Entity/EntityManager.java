package com.arne5.spaceinvaders.Entity;

import com.arne5.spaceinvaders.Assets;
import com.arne5.spaceinvaders.SpaceInvaders;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by urvaius on 9/21/14.
 */
public class EntityManager

	{
		private final Array<Entity> entities = new Array<Entity>();
		private final Player player;

		public EntityManager(int amount)
			{   player = new Player(new Vector2(230,15),new Vector2(0,0));
				for(int i=0;i <amount;i++)
				{
					float x = MathUtils.random(0, SpaceInvaders.WIDTH- Assets.ENEMY.getWidth());
					float y = MathUtils.random(SpaceInvaders.HEIGHT, SpaceInvaders.HEIGHT *2);
					float speed = MathUtils.random(2,5);
					AddEntity(new Enemy(new Vector2(x,y),new Vector2(0,-speed)));

				}

			}

		public void update()
			{
				for (Entity e : entities)
					{
						e.update();
					}
				player.update();

			}
		public void render(SpriteBatch sb)
			{
				for (Entity e : entities)
					{
						e.render(sb);

					}
				player.render(sb);
			}
		public void AddEntity(Entity entity)
			{
				entities.add(entity);
			}

	}
