package motorolasolutions.com.Validator;

import java.util.HashMap;

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
        /*
        List<UCMConfiguration> ucmConfigurationList = ucmConfigurationForm.getUcmConfigurations();
        for(int i=0;i<ucmConfigurationList.size();i++){
        	UCMConfiguration ucm_conf = ucmConfigurationList.get(i);
        	if(ucm_conf.checkRadioSerialDuplicate()!=0){
            	errors.rejectValue("ucmConfigurations["+i+"].radio_serial_number", "duplicated", new Object[]{ucm_conf.getRadio_serial_number()}, "radio serial number is duplicate");	
            	System.out.println("duplicate: "+ucm_conf.getRadio_serial_number());
            }
        	if(ucm_conf.checkRadioUserAliasDuplicate()!=0){
        		errors.rejectValue("ucmConfigurations["+i+"].radio_user_alias", "duplicated", new Object[]{ucm_conf.getRadio_user_alias()}, "radio user alias is duplicate");
        		System.out.println("duplicate: "+ucm_conf.getRadio_user_alias());
        	}
        }
        */
        UCMGeneratorInputValidator ucmGeneratorInputValidator = new UCMGeneratorInputValidator();
    	HashMap<String, Integer> hashMapRadioSerialNumber=new HashMap<String, Integer>();
    	HashMap<String, Integer> hashMapRadioUserAlias=new HashMap<String, Integer>();
        int idx = 0;
        int flag=0;
        // check whether the input has duplicated in radio serial number or radio user alias
        for(UCMConfiguration ucm_conf:ucmConfigurationForm.getUcmConfigurations()){
        	if(!hashMapRadioSerialNumber.containsKey(ucm_conf.getRadio_serial_number())){
        		hashMapRadioSerialNumber.put(ucm_conf.getRadio_serial_number(), 1);
        	}
        	else{
        		errors.rejectValue("ucmConfigurations["+idx+"].radio_serial_number", "duplicated", new Object[]{ucm_conf.getRadio_serial_number()}, "radio serial number is duplicate");
        		flag++;
        	}
        	if(!hashMapRadioUserAlias.containsKey(ucm_conf.getRadio_user_alias())){
        		hashMapRadioUserAlias.put(ucm_conf.getRadio_user_alias(), 1);
        	}
        	else{
        		errors.rejectValue("ucmConfigurations["+idx+"].radio_user_alias", "duplicated", new Object[]{ucm_conf.getRadio_user_alias()}, "radio user alias is duplicate");
        		flag++;
        	}
        	idx++;
        }
        
        // check whether radio serial number or radio user alias duplicate with the database
        idx=0;
        if(flag==0){
        	for(UCMConfiguration ucm_conf:ucmConfigurationForm.getUcmConfigurations()){
            	errors.pushNestedPath("ucmConfigurations["+idx+"]");
            	ValidationUtils.invokeValidator(ucmGeneratorInputValidator, ucm_conf, errors);
            	errors.popNestedPath();
            	idx++;
        	}
        }
    }
}
