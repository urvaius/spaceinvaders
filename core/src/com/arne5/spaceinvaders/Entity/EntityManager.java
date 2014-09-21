package com.arne5.spaceinvaders.Entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Created by urvaius on 9/21/14.
 */
public class EntityManager

	{
		private final Array<Entity> entities = new Array<Entity>();
		private final Player player;

		public EntityManager()
			{   player = new Player(new Vector2(230,15),new Vector2(0,0));

			}

		public void update()
			{
				for (Entity e : entities)
					{
						e.update();
					}

			}
		public void render(SpriteBatch sb)
			{
				for (Entity e : entities)
					{
						e.render(sb);
					}

			}
		public void AddEntity(Entity entity)
			{
				entities.add(entity);
			}

	}
