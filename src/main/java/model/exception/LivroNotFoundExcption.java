package model.exception;

public class LivroNotFoundExcption extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LivroNotFoundExcption(String msg) {
		super(msg);
	}
}
