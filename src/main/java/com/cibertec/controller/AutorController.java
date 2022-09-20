package com.cibertec.controller;

/**

 * @author ANDRES GALLEGOS LUQUE

 * 

 */

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/autor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AutorController {

}
