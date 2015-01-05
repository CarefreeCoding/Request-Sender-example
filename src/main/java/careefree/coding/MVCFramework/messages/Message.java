package careefree.coding.MVCFramework.messages;

import com.google.gson.Gson;

public class Message
{
	public enum Type
	{
		Message,
		Shutdown
	}

	private Object data;
	private Type   type;

	public Message(Type type)
	{
		setType(type);
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	public Type getType()
	{
		return type;
	}

	public void setType(Type type)
	{
		this.type = type;
	}

	public String toString()
	{
		return new Gson().toJson(this);
	}
}
