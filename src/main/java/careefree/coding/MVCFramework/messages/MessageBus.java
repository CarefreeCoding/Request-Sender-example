package careefree.coding.MVCFramework.messages;

import careefree.coding.MVCFramework.controller.Controller;

import java.util.ArrayList;
import java.util.List;

public class MessageBus
{
	private List<Controller> controllers;

	public MessageBus()
	{
		controllers = new ArrayList<Controller>();
	}

	public void register(Controller controller)
	{
		controllers.add(controller);
	}

	public void broadcast(Message message)
	{
		for (Controller controller : controllers)
		{
			controller.broadcast(message);
		}
		if (message.getType().equals(Message.Type.Shutdown))
		{
			for (Controller controller : controllers)
			{
				while (controller.isAlive())
				{
				}
			}
			System.exit(0);
		}
	}
}
