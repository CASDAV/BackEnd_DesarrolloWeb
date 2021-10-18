package com.backend.projectodesarrolloweb.laesquinadigital.util;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
		super("Could not find User by id:" + id);
	}
	
	public UserNotFoundException(String identificacion) {
		super("Could not find User by identificacion:" + identificacion);
	}

}
