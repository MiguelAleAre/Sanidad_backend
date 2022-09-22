package com.cibertec.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.util.AppSettings;
/**

 * @author MIGUEL AREVALO

 * 

 */
@RestController
@RequestMapping("/url/sala")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class SalaController {

}
