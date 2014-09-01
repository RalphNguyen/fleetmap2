package motorolasolutions.com.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        // check radio serial number
        // if null or left blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "radio_serial_number", "required");
        // if unique
        if(ucm_conf.checkRadioSerialDuplicate()!=0){
        	//ucm_conf.setRadio_serial_number(radio_serial_number);
        	errors.rejectValue("radio_serial_number", "duplicated", new Object[]{ucm_conf.getRadio_serial_number()}, "radio serial number is duplicate");
        	//System.out.println("duplicate:"+ucm_conf.getRadio_serial_number());
        }
        // too long, 1-12 character
        if(ucm_conf.getRadio_serial_number().length()>13){
        	errors.rejectValue("radio_serial_number", "too_long");
        }
        // contain special character
        if(matchPatternRadioSerialNumber(ucm_conf.getRadio_serial_number())){
        	errors.rejectValue("radio_serial_number", "special_character");
        }
         
        // check radio user alias
        //if null or left blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "radio_user_alias", "required");
        // too long, 1-16 character
        if(ucm_conf.getRadio_user_alias().length()>16){
        	errors.rejectValue("radio_user_alias", "too_long");
        }
        // contain special character
        if(matchPatternRadioUserAlias(ucm_conf.getRadio_user_alias())){
        	errors.rejectValue("radio_user_alias", "special_character");
        }
        // if unique
        if(ucm_conf.checkRadioUserAliasDuplicate()!=0){
        	errors.rejectValue("radio_user_alias", "duplicated", new Object[]{ucm_conf.getRadio_user_alias()}, "radio user alias is duplicate");	
        	//System.out.println("duplicate:"+ucm_conf.getRadio_user_alias());
        }
        
        // check remedy id
        // if null or left blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remedy_id", "required");
        // not has more than 14 characters
        if(ucm_conf.getRemedy_id().length()>14){
        	errors.rejectValue("remedy_id","too_long");
        }
        
        // check subentity
        // too long
        if(ucm_conf.getSub_entity().length()>30){
        	errors.rejectValue("sub_entity","too_long");
        }
        
        // check request no
        // null or left blank
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "request_no", "required");
        // too long
        if(ucm_conf.getRequest_no().length()>30){
        	errors.rejectValue("request_no","too_long");
        }
        
        // check ucp
        // too long
        if(ucm_conf.getUcp().length()>100){
        	errors.rejectValue("ucp","too_long");
        }
        
    }
	
	// check pattern radio serial number: whitespace, contain: | @ _ " ? ' % *
	private static boolean matchPatternRadioSerialNumber(String s){
		boolean flag = false;
		String patternString  = "[|@_\"?'%*\\s]";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			flag=true;
		}
		return flag;
	}

	// check pattern radio user alias: whitespace, contain: | @ _ " & ' % or start with the prefix: SZ$ or ZC$
	private static boolean matchPatternRadioUserAlias(String s){
		boolean flag = false;
		String patternString  = "[|@_\"&'%\\s]";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			flag=true;
		}
		if(s.startsWith("SZ$")||s.startsWith("ZC$")) flag=true;
		return flag;
	}
	
}
