package motorolasolutions.com.Validator;

import java.util.List;

import motorolasolutions.com.DataObject.UCMConfiguration;
import motorolasolutions.com.DataObject.UCMConfigurationForm;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UCMGeneratorListInputValidator implements Validator{
	@Override
    public boolean supports(Class<?> paramClass) {
        return UCMConfigurationForm.class.equals(paramClass);
    }

	@Override
    public void validate(Object obj, Errors errors) {
        // cast validated object
		
        UCMConfigurationForm ucmConfigurationForm = (UCMConfigurationForm) obj;
        List<UCMConfiguration> ucmConfigurationList = ucmConfigurationForm.getUcmConfigurations();
        for(int i=0;i<ucmConfigurationList.size();i++){
        	UCMConfiguration ucm_conf = ucmConfigurationList.get(i);
        	if(ucm_conf.checkRadioSerialDuplicate()!=0){
            	errors.rejectValue("ucmConfigurations["+i+"].radio_serial_number", "duplicated", new Object[]{ucm_conf.getRadio_serial_number()}, "radio serial number is duplicate");	
            	System.out.println("error");
            }
        	if(ucm_conf.checkRadioUserAliasDuplicate()!=0){
        		errors.rejectValue("ucmConfigurations["+i+"].radio_user_alias", "duplicated", new Object[]{ucm_conf.getRadio_user_alias()}, "radio serial number is duplicate");
        	}
        }
    }
}
