package sn.uadb.shop.util;

public class EntityException extends Exception{
	
	public EntityException(String msg) {
		super(msg);
	}
	
	public EntityException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public EntityException(Throwable cause) {
		super(cause);
	}

}
