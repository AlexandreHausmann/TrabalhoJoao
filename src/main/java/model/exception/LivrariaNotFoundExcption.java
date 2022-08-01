package model.exception;

public class LivrariaNotFoundExcption extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LivrariaNotFoundExcption(String msg) {
		super(msg);
	}
}
