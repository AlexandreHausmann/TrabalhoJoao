package model.exception;

public class AutorNotFoundExcption extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorNotFoundExcption(String msg) {
		super(msg);
	}
}
