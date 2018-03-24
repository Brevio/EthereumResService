package com.ethereum.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ethereum.model.UpdatePasswordRequest;
import com.ethereum.model.UpdatePasswordResponse;
import com.ethereum.services.UpdatePassword;

@RestController
@RequestMapping("application.wadl/updatePasswordAccount")
public class UpdatePasswordController {
	UpdatePassword update = new UpdatePassword();
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public UpdatePasswordResponse UpdatePasswordResponse(@RequestBody UpdatePasswordRequest request){
		return update.update(request);
	}

}
