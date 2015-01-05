package careefree.coding.MVCFramework.view;

import careefree.coding.MVCFramework.controller.Controller;
import careefree.coding.MVCFramework.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class View<M extends Model, C extends Controller>
{
	protected Logger log = LoggerFactory.getLogger(getClass());

	protected C controller;

	public View(M model, C controller)
	{
		this.controller = controller;

		loadComponents();
		assignListeners();
		registerModel(model);
	}

	protected abstract void loadComponents();

	protected abstract void assignListeners();

	protected abstract void registerModel(M model);

	public abstract void refresh();

	public abstract void close();
}
