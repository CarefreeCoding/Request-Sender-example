package careefree.coding.MVCFramework.controller;

import careefree.coding.MVCFramework.messages.Message;
import careefree.coding.MVCFramework.messages.MessageBus;
import careefree.coding.MVCFramework.model.Model;
import careefree.coding.MVCFramework.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Controller
		<M extends Model, V extends View, C extends Controller>
{
	protected Logger log = LoggerFactory.getLogger(getClass());

	protected V view;
	protected M model;
	protected C controller;

	protected MessageBus messageBus;
	private   boolean    isAlive;

	public Controller(MessageBus messageBus)
	{
		this.messageBus = messageBus;
		isAlive = true;
		init();
	}

	protected abstract void init();

	protected abstract void receive(Message message);

	protected void send(Message message)
	{
		messageBus.broadcast(message);
	}

	public boolean isAlive()
	{
		return isAlive;
	}

	private void die()
	{
		isAlive = false;
	}

	public void broadcast(Message message)
	{
		receive(message);
		if (message.getType().equals(Message.Type.Shutdown))
		{
			if (view != null)
			{
				view.close();
			}
			if (model != null)
			{
				model.close();
			}
			die();
		}
	}
}