/**
 * @author Behrooz Mohamadi
 * @email behroooz.mohamadi@gmail.com
 * @date 3/27/2018 11:42 AM
 */

package com.bakery.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Messages {
	@Autowired
	private MessageSource messageSource;

	public String get(String code,String... args) {
		return messageSource.getMessage(code,args, Locale.getDefault());
	}

}
