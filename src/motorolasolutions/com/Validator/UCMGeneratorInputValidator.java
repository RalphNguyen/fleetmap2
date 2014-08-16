package motorolasolutions.com.Validator;

import motorolasolutions.com.DataObject.UCMConfiguration;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UCMGeneratorInputValidator implements Validator {

	@Override
    public boolean supports(Class<?> paramClass) {
        return UCMConfiguration.class.equals(paramClass);
    }

	@Override
    public void validate(Object obj, Errors errors) {
        // cast validated object
		
        UCMConfiguration ucm_conf = (UCMConfiguration) obj;
        if(ucm_conf.checkRadioSerialDuplicate()!=0){
        	errors.rejectValue("radio_serial_number", "duplicated", new Object[]{ucm_conf.getRadio_serial_number()}, "radio serial number is duplicate");
        	System.out.println("duplicate:"+ucm_conf.getRadio_serial_number());
        }
         
        if(ucm_conf.checkRadioUserAliasDuplicate()!=0){
        	errors.rejectValue("radio_user_alias", "duplicated", new Object[]{ucm_conf.getRadio_user_alias()}, "radio user alias is duplicate");	
        	System.out.println("duplicate:"+ucm_conf.getRadio_user_alias());
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remedy_id", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "request_no", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "radio_serial_number", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "radio_user_alias", "required");
    }

}
