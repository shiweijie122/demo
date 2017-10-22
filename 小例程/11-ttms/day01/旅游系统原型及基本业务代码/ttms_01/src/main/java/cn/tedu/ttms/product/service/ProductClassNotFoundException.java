package cn.tedu.ttms.product.service;

public class ProductClassNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8504176943156067402L;

	public ProductClassNotFoundException() {
	}

	public ProductClassNotFoundException(String message) {
		super(message);
	}

	public ProductClassNotFoundException(Throwable cause) {
		super(cause);
	}

	public ProductClassNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductClassNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
