package careefree.coding.MVCFramework.model;

import careefree.coding.MVCFramework.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Model<C extends Controller>
{
	protected Logger log = LoggerFactory.getLogger(getClass());

	protected C controller;

	public Model(C controller)
	{
		this.controller = controller;
	}

	public abstract void close();
}