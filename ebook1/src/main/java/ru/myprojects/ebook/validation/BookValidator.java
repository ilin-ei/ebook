package ru.myprojects.ebook.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookValidator implements ConstraintValidator<ValidBook, String> {

	private Pattern pattern;
	private Matcher matcher;
	private static final String BOOK_PATTERN = "^[A-Za-z0-9- ]{2,}$";

	@Override
	public boolean isValid(final String field, final ConstraintValidatorContext context) {
		pattern = Pattern.compile(BOOK_PATTERN);
		if (field == null) {
			return false;
		}
		matcher = pattern.matcher(field);
		return matcher.matches();
	}
}