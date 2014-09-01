package motorolasolutions.com.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import motorolasolutions.com.DataObject.UCMConfiguration;
import motorolasolutions.com.DataObject.UCMUpdate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UCMUpdateValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return UCMUpdate.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		UCMUpdate ucmUpdate = (UCMUpdate) obj;
		int idx = 0;
		for (UCMConfiguration ucm_conf : ucmUpdate.getUcmConfigurationForm()
				.getUcmConfigurations()) {
			if (ucm_conf.isUpdated()) {
				// check radio serial number
				// if null or left blank
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,
						"ucmConfigurationForm.ucmConfigurations[" + idx
								+ "].radio_serial_number", "required");

				// too long, 1-12 character
				if (ucm_conf.getRadio_serial_number().length() > 13) {
					errors.rejectValue(
							"ucmConfigurationForm.ucmConfigurations[" + idx
									+ "].radio_serial_number", "too_long");
				}
				// contain special character
				if (matchPatternRadioSerialNumber(ucm_conf
						.getRadio_serial_number())) {
					errors.rejectValue(
							"ucmConfigurationForm.ucmConfigurations[" + idx
									+ "].radio_serial_number",
							"special_character");
				}

				// check radio user alias
				// if null or left blank
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,
						"ucmConfigurationForm.ucmConfigurations[" + idx
								+ "].radio_user_alias", "required");
				// too long, 1-16 character
				if (ucm_conf.getRadio_user_alias().length() > 16) {
					errors.rejectValue(
							"ucmConfigurationForm.ucmConfigurations[" + idx
									+ "].radio_user_alias", "too_long");
				}
				// contain special character
				if (matchPatternRadioUserAlias(ucm_conf.getRadio_user_alias())) {
					errors.rejectValue(
							"ucmConfigurationForm.ucmConfigurations[" + idx
									+ "].radio_user_alias", "special_character");
				}

				// check length of UCP
				if (ucm_conf.getUcp().length() > 100) {
					errors.rejectValue(
							"ucmConfigurationForm.ucmConfigurations[" + idx
									+ "].ucp", "too_long");
				}
			}
			idx++;
		}
	}

	// check pattern radio serial number: whitespace, contain: | @ _ " ? ' % *
	private static boolean matchPatternRadioSerialNumber(String s) {
		boolean flag = false;
		String patternString = "[|@_\"?'%*\\s]";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			flag = true;
		}
		return flag;
	}

	// check pattern radio user alias: whitespace, contain: | @ _ " & ' % or
	// start with the prefix: SZ$ or ZC$
	private static boolean matchPatternRadioUserAlias(String s) {
		boolean flag = false;
		String patternString = "[|@_\"&'%\\s]";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			flag = true;
		}
		if (s.startsWith("SZ$") || s.startsWith("ZC$"))
			flag = true;
		return flag;
	}

}
